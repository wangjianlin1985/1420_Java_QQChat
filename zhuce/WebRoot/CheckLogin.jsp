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
				.print("<script>alert('����������JICQ���룡');location.href='loginIn.jsp';</script>");
			}
			String JICQPwd = request.getParameter("JICQPwd");
			if (JICQPwd.length() == 0) {
				out
				.print("<script>alert('����������JICQ���룡');location.href='loginIn.jsp';</script>");
			}
			if (!rand.equals(input)) {

				out
				.print("<script>alert('��������ȷ����֤�룡');location.href='loginIn.jsp';</script>");
			}

			try {
				String JicqNumber = request.getParameter("JICQNumber");
				int a = Integer.parseInt(JicqNumber);
			} catch (Exception e) {
				out
				.print("<script>alert('������Ϸ���JICQ���룡');location.href='loginIn.jsp';</script>");
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
					.print("<script>alert('�޴�QQ���룬��ȷ�����룡');location.href='seconds.jsp';</script>");
				}
				if (JICQPwd.equals(JICQPwds)) {
					session.putValue("JicqNumbers", JicqNumberes);
					session.putValue("JShowName", JShowName);
					session
					.putValue("JProtectPwdQuestion",
					JProtectPwdQuestion);
					out.print("<script>alert('��½�ɹ�');</script>");
					response.sendRedirect("myJICQ.jsp");
				} else {
					out
					.print("<script>alert('�������,��½ʧ��!');location.href='loginIn.jsp';</script>");
				}

			} catch (Exception e) {
				System.out.println(e);
			} finally {
				try {
					//һ��Ҫ�ر����ݿ�����
					st.close();
					conn.close();
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		%>

	</body>
</html>
