<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="/errorpage.jsp"%>
<%@ page import="java.util.Date"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>获取当前时间</title>
</head>
<body>
	<!-- 访问方式：http://localhost:8080/day08/test.jsp -->
	<!-- 它的反编译java地址在G:\android\eclipsecode\.metadata\.plugins
		\org.eclipse.wst.server.core\tmp0\work\Catalina\localhost\day08\org\apache\jsp这个文件夹内
	 -->
	<%
	 java.util.Date date = new java.util.Date();
		out.print(date.toLocaleString()+"==="); 
		int x = 0;
	%>
	<%=x %>
	<% int y =  1/0; %>
</body>
</html>