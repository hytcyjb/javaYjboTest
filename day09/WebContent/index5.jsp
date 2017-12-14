<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ page import="java.util.HashMap" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>EL表达式</title>
</head>
<body>
	<%
		request.setAttribute("name", "杨建波");
	%>
	${name}
	<!-- 相当于以下几种 -->
	<br>
	<%=pageContext.findAttribute("name")%>
	<br>
	<!-- el获取map类型的数据 -->
	<% 
		HashMap map = new HashMap();
		map.put("key", "222");
		request.setAttribute("map", map);
	%>
	${map}<br>
	${map.key}
	
</body>
</html>