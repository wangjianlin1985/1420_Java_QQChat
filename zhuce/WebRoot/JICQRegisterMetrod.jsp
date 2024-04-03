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

		<p>
			<%
				String userName = request.getParameter("JicqNickName");
				userName = new String(userName.getBytes("iso-8859-1"), "GBK");// 转码

				String age = request.getParameter("age");
				try {
					int Jage = Integer.parseInt(age);
				} catch (Exception e) {
					out
					.print("<script>alert('输入年龄错误！');location.href='seconds.jsp';</script>");
				}

				String sex = request.getParameter("sex");
				String userSex = new String(sex.getBytes("iso-8859-1"), "GBK");// 转码

				String pwd1 = request.getParameter("JPwd");
				pwd1 = new String(pwd1.getBytes("iso-8859-1"), "GBK");// 转码
				String pwd = request.getParameter("JRePwd");
				pwd = new String(pwd.getBytes("iso-8859-1"), "GBK");// 转码

				String ProvinceId = request.getParameter("sltProvinceId");
				String vProvinceId = new String(ProvinceId.getBytes("iso-8859-1"),
						"GBK");// 转码	

				String city = request.getParameter("sltAllLocId");
				String vCity = new String(city.getBytes("iso-8859-1"), "GBK");// 转码

				String getFace = request.getParameter("sqtx");

				// Session session = request.getSession();

				// session.setAttribute("userName",userName);
				System.out.println(userName);
				session.putValue("userName", userName);
				session.putValue("age", age);
				session.putValue("sex", userSex);
				session.putValue("JRePwd", pwd);
				session.putValue("sltProvinceId", vProvinceId);
				session.putValue("vCity", vCity);
				session.putValue("iFaceNum", getFace);

				String rand = (String) session.getAttribute("rand");
				String input = request.getParameter("rand");

				if (rand.equals(input)) {
					response.sendRedirect("thirds.jsp");
				} else {
					out
					.print("<script>alert('请输入正确的验证码！');location.href='seconds.jsp';</script>");
				}
			%>
		</p>
	</body>
</html>
