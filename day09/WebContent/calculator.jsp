<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/day09/calculator.jsp" method="post">
		<!-- colspan占的列属性
	 rowspan占的行属性-->
		<table border="1">

			<tr>
				<td colspan="2">你好</td>
				<td rowspan = "2">你好</td>
			<tr>
			</tr>
			<tr>
				<td>你好</td>
				<td >你好</td>
				<!-- <td rowspan = "2">你好</td> -->
			</tr>

		</table>
	</form>
</body>
</html>