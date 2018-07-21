<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<!-- 访问链接：http://192.168.1.103:8080/day18/testEncoderServler -->
<body>

测试乱码问题<br>
	
	<a href="/day18/testEncoderServler?encodeName=yjbo">点我测试</a><!-- 不能传递中文，不知道为啥，应该是我的问题 -->
	
	<form action="${pageContext.servletContext.contextPath }/testEncoderServler" method="post">
		请输入你所在的省份：<input type="text" name="encodeName"><br>
		<input type="submit" value="提交">
	</form>
</body>
</html>