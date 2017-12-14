<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>研究jsp如何利用jsp:setProperty方法获取jsp控件上的参数与javabean结合的</title>
</head>
<body style="text-align: center;">
	<br />
	<br />
	<jsp:useBean id="calculator" class="yy.yjbo.Calculator" scope="page"></jsp:useBean>
	<!-- 这个就相当于将jsp与javabean结合起来，jsp:setProperty将jsp控件上的值取出来赋值到javabean中。 -->
	<jsp:setProperty name="calculator" property="*"></jsp:setProperty>
	<!-- 查看jsp控件上的值是否设置上去 -->
	<%
		double firstDouble = calculator.getFirstNum();
		System.out.println(firstDouble);
	%>
	<td>当前值控件上的值：<%=firstDouble%></td>
	<br />
	<br />
	<form action="/day09/testSetProperty.jsp" method="post">
		<table border="1" align="center" width="35%">
			<tr>
				<td>输入参数：</td>
				<td><input type="text" name="firstNum" value="<%=firstDouble%>"></td>
				<td colspan="2" align="center"><input type="submit"
					name="calculator"></td>
			</tr>
		</table>
	</form>
</body>
</html>