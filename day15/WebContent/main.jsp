<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- 访问链接：http://localhost:8080/day15/login.html -->
<title>客户关系管理（CRM）</title>
</head>
<%-- ${pageContext.request.contextPath} 相当于  /day15 --%>
<script type="text/javascript">
	function addCustomer() {
		document.getElementById("change").src = "${pageContext.request.contextPath}/addCustomer.jsp";
	}
	function readCustomer() {
		document.getElementById("change").src = "${pageContext.request.contextPath}/ReadCustomerServlet";
	}
</script>
<body>
	<form style="margin-top: 150px; text-align: center;" >
		<table align="center" width="100%" border="1" bordercolor="#0066FF">
			<tr style="width: 50%">
				<td colspan="3" style="text-align: center;"><h2>客户关系管理（CRM）</h2></td>
			</tr>
			<tr>
				<td><input type="button"  onclick="addCustomer()" value="添加客户">
					<input type="button"  onclick="readCustomer()" value="查看客户" style="margin-left: 100px;"></td>
			</tr>
			<tr>
			<td colspan="3" style="text-align: center; width: 100%;height: 500px;" >
				<iframe id="change" src="/day15/addCustomer.jsp" style="width: 100%;height: 100%"></iframe>
	 		</td>
			</tr>
		</table>
	</form>
		
</body>
</html>