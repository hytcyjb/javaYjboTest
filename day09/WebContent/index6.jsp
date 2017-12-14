<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="yy.yjbo.Person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><!-- 来自c.tld -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jst+el示例代码</title>
</head>
<body>
	<!-- jst+el获取list数据 -->
	<%
		List list = new ArrayList();
		list.add(new Person(10));
		list.add(new Person(143));
		request.setAttribute("pList", list);
	%>
	<c:forEach var="pers" items="${pList}">
		${pers.getAge()}<br />
	</c:forEach>
	<!-- jst+el获取map类型的数据 -->
	<%
		HashMap map = new HashMap();
		map.put("key", "222");
		map.put("key2", "233");
		request.setAttribute("map", map);
	%>
	<c:forEach var="map" items="${map }">
		${map.key } = ${map.value }<br />
	</c:forEach>
</body>
</html>