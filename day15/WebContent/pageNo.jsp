<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>分页</title>
</head>
<script type="text/javascript">
function skipPage(input) {
	var pageNo = input.value;
	alert(input.value);
	window.location.href="${pageContext.request.getScheme()}://${pageContext.request.getServerName()}:${pageContext.request.getServerPort()}${pageContext.request.contextPath}"
		+"/ReadCustomerServlet?pageNo="+pageNo;
}
</script>
<body>
	<table >
		<tr style="width: 50%;text-align: center;"  > 
			<c:forEach begin="0" end="12" step="1" varStatus="k" >
				<td>
					<input type="button" value="${k.count }" width="40px" style="width: 40px;" onclick="skipPage(this)">
				</td>
			</c:forEach>
		</tr> 
	 	</tr>
	</table>
</body>
</html>