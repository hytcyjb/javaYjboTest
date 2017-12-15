<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- http://localhost:8080/day09_demo/register.jsp -->
<title>注册界面</title>
</head>

<body style="margin-top: 150px; text-align: center;">
	<jsp:useBean id="person" class="user.bean.Person" scope="page"></jsp:useBean>
	<jsp:setProperty name="person" property="*" />
	<form action="/day09_demo/RegisterServlet" method="post">
		<!-- 在这里请求才可以在Servlet页面中获取到jsp控件上的值 -->
		<!--只是为了赋值 -->
		<table align="center" border="1" bordercolor="#0066FF" width="30%">
			<tr>
				<td colspan="2"><h2>欢迎您注册我公司账号</h2></td>
			</tr>
			<tr>
				<td>用户名：</td>
				<td><input type="text" name="name" id="name" value='<jsp:getProperty property="name" name="person"/>'> <%
 	if (request.getAttribute("registerError") != null) {
 %> <%=request.getAttribute("registerError")%> <%
 	}
 %></td>
			</tr>
			<tr>
				<td>手机号：</td>
				<td><input type="text" name="tel" id="tel" value='<jsp:getProperty property="tel" name="person"/>'> <%
 	if (request.getAttribute("registerError") != null) {
 %> <%="(**可以使用**)"%> <%
 	}
 %></td>
			</tr>
			<tr>
				<td>邮箱：</td>
				<td><input type="text" name="email" id="email" value='<jsp:getProperty property="email" name="person"/>'> <%
 	if (request.getAttribute("registerError") != null) {
 %> <%="(**可以使用**)"%> <%
 	}
 %></td>
			</tr>
			<tr>
				<td colspan="2" style="padding-top: 20px; padding-bottom: 20px;"><input
					type="submit" name="submit" id="submit" value="注   册"
					style="background-color: #00FF00; font-size: 30px; width: 180px"></td>
			</tr>
			<tr>
				<td colspan="2" style="padding-top: 10px; padding-bottom: 10px;">Copyright
					© 2017 yjbo. All rights reserved.</td>
			</tr>
		</table>
	</form>
</body>
</html>