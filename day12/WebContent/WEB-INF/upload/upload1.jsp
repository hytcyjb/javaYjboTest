<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>放在WEB-INF/upload/文件夹下面主要原因是为了不让外部访问其内部内容</title>
</head>
<body>

	放在WEB-INF/upload/文件夹下面主要原因是为了不让外部访问其内部内容；
	***主要是防止用户上传的内容如果是jsp文件，内部还有定时关机，或者格式化C盘等操作，那样如果其可以访问就会出现大问题。
	***WEB-INF/内的文件是不可访问的。
</body>
</html>