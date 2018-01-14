<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>客户信息页面</title>
</head>
<script type="text/javascript">
	function onUpdate(id) {//传递javabean类不容易传递。
		 window.location.href="${pageContext.request.getScheme()}://${pageContext.request.getServerName()}:${pageContext.request.getServerPort()}${pageContext.request.contextPath}"
 			+"/UpdateCustomerServlet?id="+encodeURI(id);
	}
	function onDelete(id,name) {
		  //利用对话框返回的值 （true 或者 false）
	    if(confirm("确定删除"+name+"吗？"))
	    {
	        //如果是true ，那么就把页面转向thcjp.cnblogs.com
	        window.location.href="${pageContext.request.getScheme()}://${pageContext.request.getServerName()}:${pageContext.request.getServerPort()}${pageContext.request.contextPath}"
	        			+"/DeleteCustomerServlet";
	     }
	    else
	    {//取消
	    }
	}
</script>
<body>
	<table align="center" width="100%" border="1" bordercolor="#0066FF"
		style="text-align: center;">
		<tr>
			<td>序号</td>
			<td>客户名称</td>
			<td>性别</td>
			<td>生日</td>
			<td>手机</td>
			<td>邮箱</td>
			<td>爱好</td>
			<td>客户类型</td>
			<td>客户备注</td>
			<td><font color="#0000ff" style="font-style: oblique;">操作1</font></td>
			<td><font color="#ff0000">操作2</font></td>
		</tr>
		<c:forEach items="${allCustomer }" var="customer" varStatus="k">
			<tr>
				<td>${k.count }</td>
				<!-- 通过varStatus="k"获取循环的次数 -->
				<td>${customer.name }</td>
				<td>${customer.sex }</td>
				<td>${customer.birthday }</td>
				<td>${customer.phone }</td>
				<td>${customer.email }</td>
				<td>${customer.hobby }</td>
				<td>${customer.kind }</td>
				<td>${customer.remarks }</td>
				<td><input type="button" value="修改"
					onclick="onUpdate('${customer.id }')"></td>
				<td><input type="button" value="删除"
					onclick="onDelete('${customer.id }','${customer.name }')"></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>