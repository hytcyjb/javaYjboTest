<%@page import="yy.yjbo.Person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>获取Person类内参数</title>
</head>
<body>
	<%
		pageContext.setAttribute("pers", new Person());
	%><!-- 1.这个相当于是实例化的功能 -->
	<jsp:useBean id="pers" class="yy.yjbo.Person" scope="page">
		xxx<!-- 上面实例化了，此处就不执行了 -->
	</jsp:useBean><!-- 2.这个也相当于是实例化的功能 -->
	<%System.out.print(pers.getAge()+"=="+pers.getName()); %>
</body>
</html>