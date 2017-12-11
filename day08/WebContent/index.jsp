<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 内部集成 -->
	<jsp:include page="/errorpage.jsp"></jsp:include><br>
	内容：你好，你好；<br>
	<jsp:include page="/errorpage2.jsp"></jsp:include><br>
	<%-- <!-- 直接跳转 -->
	<jsp:forward page="/errorpage.jsp"></jsp:forward> --%>
</body>
</html>