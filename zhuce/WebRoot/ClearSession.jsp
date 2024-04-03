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
			String JShowName = "请输入您要找回的JICQ号码";
			String JicqNumbers = "请输入您要找回的JICQ号码";
			String FindJPwd = "请输入您的密码保护答案！";

			session.putValue("JShowName", JShowName);
			session.putValue("JicqNumbers", JicqNumbers);
			session.putValue("FindJPwd", FindJPwd);
			response.sendRedirect("JICQFindPwdLogin.jsp");
		%>
	</body>
</html>
