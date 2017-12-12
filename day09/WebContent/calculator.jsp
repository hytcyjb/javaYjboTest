<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body style="text-align: center;">
	<!-- colspan占的列属性;rowspan占的行属性-->
	<br />
	<br />
	<jsp:useBean id="calculator" class="yy.yjbo.Calculator" scope="page"></jsp:useBean>
	<jsp:setProperty name="calculator" property="*"></jsp:setProperty>
	<%
		calculator.calculatatorData();
	%>
	<tr>
		<td>计算结果：</td>
		<td></td>
	</tr>
	<jsp:getProperty property="result" name="calculator" />
	=
	<jsp:getProperty property="firstNum" name="calculator" />
	<!-- 注意点： property="firstNum"：1是javabean中的一个元素，2是jsp页面的一个子控件 -->
	<jsp:getProperty property="operator" name="calculator" />
	<jsp:getProperty property="secondNum" name="calculator" />

	<br />
	<br />
	<form action="/day09/calculator.jsp" method="post">

		<table border="1" align="center" width="35%">

			<tr>
				<td colspan="2">简单的计算器:</td>
			</tr>
			<tr>
				<td>第一个参数：</td>
				<td><input type="text" name="firstNum"></td>
			</tr>
			<tr>
				<td>运算符：</td>
				<td><select name="operator">
						<option value="+" id="+">+</option>
						<option value="-" id="-">-</option>
						<option value="*" id="*">*</option>
						<option value="/" id="/">/</option>
				</select></td>
			</tr>
			<tr>
				<td>第二个参数：</td>
				<td><input type="text" name="secondNum"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					name="calculator"></td>
			</tr>
		</table>
	</form>
</body>
</html>