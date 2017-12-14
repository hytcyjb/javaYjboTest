<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录界面</title>
</head>
<body style="margin-top: 150px; text-align: center;">

	<jsp:useBean id="person" class="user.bean.Person" scope="page"></jsp:useBean>
	<jsp:setProperty name="person" property="*" />
	==
	<jsp:getProperty property="name" name="person" />
	<form action="/day09_demo/LoginServlet" method="post">
		<table align="center" border="1" bordercolor="#0066FF" width="15%">
			<tr>
				<td colspan="2"><h2>管理员登录界面</h2></td>
			</tr>
			<tr>
				<td>用户名：</td>
				<td><input type="text" name="name" id="name"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" name="submit" value="登录"></td>
			</tr>
		</table>
	</form>
</body>
</html>