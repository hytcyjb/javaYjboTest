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
	<jsp:useBean id="pers" class="yy.yjbo.Person" scope="page">
		xxx
	</jsp:useBean>
	<jsp:setProperty name="pers" property="name" value="yyname"/><!-- 给那么属性赋值 -->
	<jsp:setProperty name="pers" property="name" param="name"/><!-- 直接将请求中的name属性赋值上去 -->
	
	<%
	System.out.println(pers.getAge()+"=="+pers.getName());
	 %>
</body>
</html>