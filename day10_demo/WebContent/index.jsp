<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- 访问地址 http://localhost:8080/day10_demo/GoodsListServlet -->
<title>yjbo购物网站</title>
</head>
<body>
	<form
		style="text-align: center; margin-top: 100px; margin-bottom: 100px;">
		<table border="1" width="40%" align="center">
			<tr>
				<td colspan="6"><h2>购物商城--商品列表</h2></td>
			</tr>
			<tr>
				<td>编号</td>
				<td>书名</td>
				<td>作者</td>
				<td>单价</td>
				<td>数量</td>
				<td>操作</td>
			</tr>
			<c:forEach items="${goodsMap }" var="goodMap">
				<tr>
					<td>${goodMap.key}</td>
					<td width="180px;" style="text-align: left; padding-left: 10px;">《${goodMap.value.goodName}》</td>
					<td>${goodMap.value.goodProducer}</td>
					<td>￥ ${goodMap.value.goodPrice}</td>
					<td>${goodMap.value.goodAllowance}</td>
					<td><a href="/day10_demo/BuyGoodsServlet?goodId=${goodMap.value.goodId}">购买</a></td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="6" style="padding-top: 10px; padding-bottom: 10px;">Copyright
					© 2017 yjbo. All rights reserved.</td>
			</tr>
		</table>
	</form>
</body>
</html>