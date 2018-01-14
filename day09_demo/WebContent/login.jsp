<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- http://localhost:8080/day09_demo/login.jsp -->
<title>登录界面</title>
</head>
<body style="margin-top: 150px; text-align: center;">

	<jsp:useBean id="person" class="user.bean.Person" scope="page"></jsp:useBean>
	<jsp:setProperty name="person" property="*" />
	<form action="/day09_demo/LoginServlet" method="post">
		<table align="center" border="1" bordercolor="#0066FF" width="25%">
			<tr>
				<td colspan="2"><h2>管理员登录界面</h2></td>
			</tr>
			<tr>
				<td>用户名：</td>
				<td><input type="text" name="name" id="name"></td>
			</tr>
			<tr>
			<td colspan="2" style="padding-top: 20px; padding-bottom: 20px; text-align: center;"><input
					type="button" name="register" value="注册" style="margin-right: 100px" 
					onclick="window.location.href='/day09_demo/register.jsp';"><input
					type="submit" name="submit" value="登录"></td>
			</tr>
			<tr>
				<td colspan="2" style="padding-top: 10px; padding-bottom: 10px;">Copyright
					© 2017 yjbo. All rights reserved.</td>
			</tr>
		</table>
	</form>
</body>
</html>