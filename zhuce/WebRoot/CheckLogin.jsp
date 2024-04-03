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
			String rand = (String) session.getAttribute("rand");
			String input = request.getParameter("code");
			String JicqNumberes = request.getParameter("JICQNumber");
			if (JicqNumberes.length() == 0) {
				out
				.print("<script>alert('请输入您的JICQ号码！');location.href='loginIn.jsp';</script>");
			}
			String JICQPwd = request.getParameter("JICQPwd");
			if (JICQPwd.length() == 0) {
				out
				.print("<script>alert('请输入您的JICQ密码！');location.href='loginIn.jsp';</script>");
			}
			if (!rand.equals(input)) {

				out
				.print("<script>alert('请输入正确的验证码！');location.href='loginIn.jsp';</script>");
			}

			try {
				String JicqNumber = request.getParameter("JICQNumber");
				int a = Integer.parseInt(JicqNumber);
			} catch (Exception e) {
				out
				.print("<script>alert('请输入合法的JICQ号码！');location.href='loginIn.jsp';</script>");
			}

			Connection conn = null;
			Statement st = null;
			PreparedStatement ps;
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				conn = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1\\SQLEXPRESS:1433;databaseName=JICQ",
			"sa", "123456");

				String sqlStr = "select JPassword,JShowName,JProtectPwdQuestion from JUsers where JICQ=?";
				ps = conn.prepareStatement(sqlStr);
				ps.setString(1, JicqNumberes);
				ResultSet rs = ps.executeQuery();

				rs.next();
				String JICQPwds = rs.getString(1).trim();
				String JShowName = rs.getString(2);
				String JProtectPwdQuestion = rs.getString(3);
				if (JICQPwds.length() == 0) {
					out
					.print("<script>alert('无此QQ号码，请确认输入！');location.href='seconds.jsp';</script>");
				}
				if (JICQPwd.equals(JICQPwds)) {
					session.putValue("JicqNumbers", JicqNumberes);
					session.putValue("JShowName", JShowName);
					session
					.putValue("JProtectPwdQuestion",
					JProtectPwdQuestion);
					out.print("<script>alert('登陆成功');</script>");
					response.sendRedirect("myJICQ.jsp");
				} else {
					out
					.print("<script>alert('密码错误,登陆失败!');location.href='loginIn.jsp';</script>");
				}

			} catch (Exception e) {
				System.out.println(e);
			} finally {
				try {
					//一定要关闭数据库连接
					st.close();
					conn.close();
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		%>

	</body>
</html>
