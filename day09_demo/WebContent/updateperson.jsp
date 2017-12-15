<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改成员信息界面</title>
</head>
<body style="margin-top: 150px; text-align: center;">

	<jsp:useBean id="person" class="user.bean.Person" scope="page"></jsp:useBean>
	<jsp:setProperty name="person" property="*" />

	<form action="/day09_demo/UpdatePersonServlet" method="post">
		<!-- 在这里请求才可以在Servlet页面中获取到jsp控件上的值 -->
		<input type="hidden" name="personid"
			value="<jsp:getProperty property="personid" name="person" />">
		<!--只是为了赋值 -->
		<table align="center" border="1" bordercolor="#0066FF" width="30%">
			<tr>
				<td colspan="2"><h2>
						修改<jsp:getProperty property="name" name="person" />信息界面
					</h2></td>
			</tr>
			<tr>
				<td>用户名：</td>
				<td><input type="text" name="name" id="name"
					value="<jsp:getProperty property="name" name="person" />"></td>
			</tr>
			<tr>
				<td>手机号：</td>
				<td><input type="text" name="tel" id="tel"
					value="<jsp:getProperty property="tel" name="person" />"></td>
			</tr>
			<tr>
				<td>邮箱：</td>
				<td><input type="text" name="email" id="email"
					value="<jsp:getProperty property="email" name="person" />"></td>
			</tr>
			<tr>
				<td colspan="2" style="padding-top: 20px; padding-bottom: 20px;"><input
					type="submit" name="submit" id="submit" value="确定修改"></td>
				<!--  onclick="window.location.href='/day09_demo/UpdatePersonServlet';"  -->
				<%-- 				 onclick="window.location.href='/day09_demo/UpdatePersonServlet?personid=<jsp:getProperty property="personid" name="person" />&name=<jsp:getProperty property="name" name="person" />&tel=<jsp:getProperty property="tel" name="person" />&email=<jsp:getProperty property="email" name="person" />';"></td> --%>
			</tr>
		</table>
	</form>
</body>
</html>