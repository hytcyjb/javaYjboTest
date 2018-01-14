<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文件的上传与下载</title>
</head>
<body>

	<h2>文件的上传与下载</h2>
	
	<form action="${pageContext.servletContext.contextPath }/UploadServlet" method="post">
		请选择文件：<input type="file" name="fileName"><br>
		<input type="submit" value="提交">
		
		
	</form>

</body>
</html>