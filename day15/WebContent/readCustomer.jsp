<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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
	        			+"/DeleteCustomerServlet?id="+encodeURI(id);
	     }
	}
	function skipPage0(pageNo) {
		window.location.href="${pageContext.request.getScheme()}://${pageContext.request.getServerName()}:${pageContext.request.getServerPort()}${pageContext.request.contextPath}"
			+"/ReadCustomerServlet?pageNo="+pageNo;
	}
	function skipPage(input) {
		var pageNo = input.value;
		window.location.href="${pageContext.request.getScheme()}://${pageContext.request.getServerName()}:${pageContext.request.getServerPort()}${pageContext.request.contextPath}"
			+"/ReadCustomerServlet?pageNo="+pageNo;
	}
	function skipPage3(pageNo) {
		window.location.href="${pageContext.request.getScheme()}://${pageContext.request.getServerName()}:${pageContext.request.getServerPort()}${pageContext.request.contextPath}"
			+"/ReadCustomerServlet?pageNo="+pageNo;
	}
	function skipPage2(maxPageNo) {
		var pageNoInput = document.getElementById("writeNo");
		var pageNoInt = pageNoInput.value;
		 var re = /^[1-9]+[0-9]*]*$/;   //判断字符串是否为数字     //判断正整数 /^[1-9]+[0-9]*]*$/  
	     if (!re.test(pageNoInt))
	    {
	        alert("请输入数字(例:1,2,3)");
	        pageNoInput.focus();
	        pageNoInput.value = "";
	        return false;
	     }
		 if(pageNoInt > maxPageNo || pageNoInt<1){
			alert("请输入的页码在当前范围内");
			pageNoInput.focus();
			pageNoInput.value = "";
	        return false;
		 }
		window.location.href="${pageContext.request.getScheme()}://${pageContext.request.getServerName()}:${pageContext.request.getServerPort()}${pageContext.request.contextPath}"
			+"/ReadCustomerServlet?pageNo="+pageNoInt;
	}
</script>
<body>
	<table align="center" width="100%" border="1" bordercolor="#0066FF"
		style="text-align: center; margin-bottom: 50px;">
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
			<tr <c:if test="${k.count % 2 ==0  }">style="background: #DCDCDC"</c:if> >
				<td>${k.count +pageNo*pageNum-pageNum}</td>
				<!-- 通过varStatus="k"获取循环的次数 -->
				<td>${customer.name }</td>
				<td>${customer.sex }</td>
				<td>${customer.birthday }</td>
				<td>${customer.phone }</td>
				<td>${customer.email }</td>
				<td>${customer.hobby }</td>
				<td>${customer.kind }</td>
				<td width="600" >${customer.remarks }</td>
				<td><input type="button" value="修改"
					onclick="onUpdate('${customer.id }')"></td>
				<td><input type="button" value="删除"
					onclick="onDelete('${customer.id }','${customer.name }')"></td>
			</tr>
		</c:forEach>
		<table >
		<tr style="width: 100%;text-align: center;position: fixed;bottom: 0;background: #fff;margin-left:auto;margin-right:auto;" > 
			<td>
				<input type="button" value="第一页"  style="width: 60px; margin-left: 100px;margin-right: 40px;" onclick="skipPage0(1)">
			</td>
			<!-- 是否是当前页，是则标红 --><!-- 如果总数小于8个 --><!-- 如果总数大于7个 -->
			<c:forEach begin="1" end="${totalPage}" step="1" varStatus="k" >
				<td>
					<c:if test="${k.count == pageNo }">
						<input type="button" value="${k.count }" style="width: 40px; background: #ff0000" onclick="skipPage(this)">
					</c:if>
					<c:if test="${k.count != pageNo}">
						<c:if test="${totalPage < 8}">
							<input type="button" value="${k.count }"  style="width: 40px;" onclick="skipPage(this)">
						</c:if>
						<c:if test="${totalPage > 7}">
							<c:if test="${k.count >= (pageNo - 2) && k.count <= (pageNo + 2)}">
							<input type="button" value="${k.count }"  style="width: 40px;" onclick="skipPage(this)">
							</c:if>
						</c:if>
					</c:if>
					</td>
			</c:forEach>
			<td>
				<input type="button" value="末页"  style="width: 60px; margin-left: 40px;" onclick="skipPage3('${totalPage}')">
			</td>
			<td style="padding-left: 40px;">
				 第
				<input type="text" value="${pageNo }"  style="width: 30px;" id="writeNo">
				页
				<input type="button" value="跳转"  style="width: 60px;" onclick="skipPage2('${totalPage}')">
			</td>
		</tr> 
		</table>
	</table>
</body>
</html>