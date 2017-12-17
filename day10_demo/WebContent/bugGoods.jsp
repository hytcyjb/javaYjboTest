<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="good.bean.Good"%>
<%@ page import="java.util.*"%>
<%@ page import="good.service.GoodService"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>已选购产品页面</title>
<script type="text/javascript"> 
	function chooseGood(input,oldValue,goodId){
		var chooseNum = input.value;
		var b = window.confirm("您确定要购买"+chooseNum+"个商品吗？？");
		if(b){
			input.value = chooseNum;
			/* alert(chooseNum); */
			window.location.href = "${pageContext.request.contextPath}/UpdateGoodsCarServlet?goodId="+goodId+"&chooseNum="+chooseNum+"&oldChooseNum="+oldValue;
		}else{
			input.value = oldValue;
		}
	 } 
	function deleteGood(goodId){
		var b = window.confirm("您确定要删除该商品吗？？");
		if(b){
			window.location.href = "${pageContext.request.contextPath}/DeleteGoodsCarServlet?goodId="+goodId;
		}
	} 
</script>
</head>
<body>
	<c:if test="${!empty(goodsChoosedMap) }">
		<form
			style="text-align: center; margin-top: 100px; margin-bottom: 100px;">
			<table border="1" width="40%" align="center">
				<tr>
					<td colspan="7"><h2>购物商城--商品列表</h2></td>
				</tr>
				<tr>
					<td>编号</td>
					<td>书名</td>
					<td>作者</td>
					<td>单价</td>
					<td>数量</td>
					<td>小计</td>
					<td>操作</td>
				</tr>
				<c:forEach items="${goodsChoosedMap }" var="goodchoosedMap">
					<tr>
						<td>${goodchoosedMap.key}</td>
						<td width="180px;" style="text-align: left; padding-left: 10px;">《${goodchoosedMap.value.goodName}》</td>
						<td>${goodchoosedMap.value.goodProducer}</td>
						<td>￥ ${goodchoosedMap.value.goodPrice}</td>
						<td><input type="text"
							value="${goodchoosedMap.value.goodAllowance}"
							onchange="chooseGood(this,${goodchoosedMap.value.goodAllowance},${goodchoosedMap.value.goodId})"
							style="width: 40px"></td>
						<td>${goodchoosedMap.value.totalPrice}</td>
						<td><input type="button" value="删除"
							onclick="deleteGood(${goodchoosedMap.value.goodId})"></td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="3"><a href="${pageContext.request.contextPath}/DeleteGoodsCarServlet?deleteFlag=true&goodId="+${goodchoosedMap.value.goodId})>清空购物车</a></td>
					<td colspan="2">总计：</td>
					<td colspan="2">${totalMoney }</td><!-- 购物车价格总计 -->
				</tr>
				<tr>
					<td colspan="7" style="padding-top: 10px; padding-bottom: 10px;">Copyright
						© 2017 yjbo. All rights reserved.</td>
				</tr>
			</table>
		</form>
	</c:if>
	<c:if test="${empty(goodsChoosedMap) }">
		<%="<h4 style='text-align: center; margin-top: 300px; margin-bottom: 100px;'>您购物车没有商品，赶快购买吧！！！<a href='/day10_demo/GoodsListServlet'>点我购买</a></h4>"%>
	</c:if>
	
</body>
</html>