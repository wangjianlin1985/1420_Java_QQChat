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
	
	String JAnswer=request.getParameter("oldKeyAnswer");
	String JAnswers = new String(JAnswer.getBytes("iso-8859-1"), "GBK");// ת��
	
	Connection conn = null;
	Statement st = null;
	PreparedStatement ps;
	
	try{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		conn = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1\\SQLEXPRESS:1433;databaseName=JICQ",
	"sa", "123456");

		String sqlStr="select JProtectPwdAnswer,JPassWord from JUsers where JICQ=?";
		ps=conn.prepareStatement(sqlStr);
		ps.setString(1,JicqNumbers);
		ResultSet rs = ps.executeQuery();
		
		rs.next();	
		String JProtectPwdAnswer=rs.getString(1);
		String JPwd=rs.getString(2);
		
		if(!JAnswers.equals(JProtectPwdAnswer.trim()))
		{
			out.print("<script>alert('�������ԭʼ���뱣���𰸴�����ȷ�����룡');location.href='JICQFindPwd.jsp';</script>");
			String a="�������������뱣�����⣡";
			session.putValue("FindJPwd",a);
		}
		else
		{
			out.print("<script>alert('�����Ѿ��һأ�������ʾ��ԭ��ҳ�棬�����Ʊ��ܣ�');</script>");
			session.putValue("FindJPwd",JPwd);
			response.sendRedirect("JICQFindPwd.jsp");
		}
		
		}catch(Exception e)
		{
			System.out.println(e);
		}
		finally
		{
		try{
			//һ��Ҫ�ر����ݿ�����
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