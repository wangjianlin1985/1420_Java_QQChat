<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page import="java.sql.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<title>Insert title here</title>
</head>
<body>
<%
	String JicqNumbers=(String)session.getValue("JicqNumbers");
	String JCardID=request.getParameter("oldCardNo");
	
	String JAnswer=request.getParameter("oldKeyAnswer");
	String JAnswers = new String(JAnswer.getBytes("iso-8859-1"), "GBK");// 转码
	String JEmail=request.getParameter("oldEmail");
	
	String JemailNewAddress=request.getParameter("emailConfirmAddress");
		
	
	Connection conn = null;
	Statement st = null;
	PreparedStatement ps,ps2,ps3;
	int complate=0;
	try{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		conn = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1\\SQLEXPRESS:1433;databaseName=JICQ",
	"sa", "123456");

		String sqlStr="select JUserIDCard,JProtectPwdAnswer,JEmail from JUsers where JICQ=?";
		ps=conn.prepareStatement(sqlStr);
		ps.setString(1,JicqNumbers);
		ResultSet rs = ps.executeQuery();
		
		rs.next();	
		String JUserIDCard=rs.getString(1);
		String JProtectPwdAnswer=rs.getString(2).trim();
		String JEmails=rs.getString(3).trim();
		
		if(!JCardID.equals(JUserIDCard.trim()))
		{
			out.print("<script>alert('您输入的原始证件号码错误，请确认输入！');location.href='JICQProtectPwd.jsp';</script>");
			return;
		}
		if(!JAnswers.equals(JProtectPwdAnswer.trim()))
		{
			out.print("<script>alert('您输入的原始密码保护答案错误，请确认输入！');location.href='JICQPwdEmailProtect.jsp';</script>");
			return;
		}
		if(!JEmail.equals(JEmails.trim()))
		{
			out.print("<script>alert('您输入的原始密码保护邮箱地址错误，请确认输入');location.href='JICQPwdEmailProtect.jsp';</script>");
			return;
		}
		
		String sqlStr2="update JUsers set JEmail=? where JICQ=?";
		ps2=conn.prepareStatement(sqlStr2);
		ps2.setString(1,JemailNewAddress.trim());
		ps2.setString(2,JicqNumbers.trim());
		complate=ps2.executeUpdate();
		
		String sqlStr3="select JProtectPwdQuestion from JUsers where JICQ=?";
		ps3=conn.prepareStatement(sqlStr3);
		ps3.setString(1,JicqNumbers);
		ResultSet rs2 = ps3.executeQuery();
		
		rs2.next();	
		String JProtectPwdQuestiones=rs2.getString(1);
		
		if(complate==0)
		{ 
			out.print("<script>alert('修改失败，请确认是否正确操作！');</script>");
			response.sendRedirect("JICQPwdEmailProtect.jsp");
		}		
		else
		{
			out.print("<script>alert('修改成功');location.href='myJICQ.jsp';</script>");
			session.putValue("JProtectPwdQuestion",JProtectPwdQuestiones);
		}
		
				
	}catch(Exception e)
	{
		System.out.println(e);
	}
	finally
	{
		try{
			//一定要关闭数据库连接
			st.close();
			conn.close();
			}
		catch(Exception e)
		{
			System.out.println(e);	
		}
	}
 
%>

</body>
</html>