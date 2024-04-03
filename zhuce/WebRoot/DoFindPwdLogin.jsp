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
			String JicqNumbers = request.getParameter("JICQNum");
			session.putValue("JicqNumbers", JicqNumbers);
			Connection conn = null;
			Statement st = null;
			PreparedStatement ps;

			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				conn = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1\\SQLEXPRESS:1433;databaseName=JICQ",
			"sa", "123456");

				String sqlStr = "select JProtectPwdQuestion,JShowName from JUsers where JICQ=?";
				ps = conn.prepareStatement(sqlStr);
				ps.setString(1, JicqNumbers);
				ResultSet rs = ps.executeQuery();

				rs.next();
				String JProtectPwdQuestion = rs.getString(1);
				session.putValue("JProtectPwdQuestion", JProtectPwdQuestion);
				String JShowName = rs.getString(2);
				session.putValue("JShowName", JShowName);

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
			response.sendRedirect("JICQFindPwd.jsp");
		%>
	</body>
</html>
