<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- 访问链接：http://localhost:8080/day15/login.html -->
<title>客户关系管理（CRM）</title>
</head>
<script type="text/javascript">
	function back() {
		window.location.href="${pageContext.request.getScheme()}://${pageContext.request.getServerName()}:${pageContext.request.getServerPort()}${pageContext.request.contextPath}"
			+"/ReadCustomerServlet";
	}
	function update(id,name) {
	 if(confirm("确定修改"+name+"的信息吗？"))
	    {
	       btn(id);
	     }
	}
	function btn(id) {//不能用submit()
		var name = window.document.getElementById("name");
		var nameStr = name.value;
		if (nameStr.replace(/(^\s+)|(\s+$)/g, '').length == 0) {//去除空格
			alert("请输入客户姓名");
			name.value = "";
			return;
		} else {
			name.value = nameStr.replace(/(^\s+)|(\s+$)/g, '');
			nameStr=name.value;
		}
		var phone = window.document.getElementById("phone");
		var phoneStr = phone.value;
		if (phoneStr.replace(/(^\s+)|(\s+$)/g, '').length == 0) {//去除空格
			alert("请输入手机号");
			phone.value = "";
			return;
		} else {
			phone.value = phoneStr.replace(/(^\s+)|(\s+$)/g, '');
			phoneStr =phone.value;
		}
		var email = window.document.getElementById("email");
		var emailStr = email.value;
		if (emailStr.replace(/(^\s+)|(\s+$)/g, '').length == 0) {//去除空格
			alert("请输入邮箱号");
			email.value = "";
			return;
		} else {
			email.value = emailStr.replace(/(^\s+)|(\s+$)/g, '');
			emailStr=email.value ;
		}
		var remarks = window.document.getElementById("remarks");
		var remarksStr = remarks.value;
		if (remarksStr.replace(/(^\s+)|(\s+$)/g, '').length == 0) {//去除空格
			alert("请输入备注号");
			remarks.value = "";
			return;
		} else {
			remarks.value = remarksStr.replace(/(^\s+)|(\s+$)/g, '');
			remarksStr = remarks.value;
		}
		
		var sex = window.document.getElementById("sex");
		var sexStr = sex.value;
		var year = window.document.getElementById("year");
		var yearStr = year.value;
		var month = window.document.getElementById("month");
		var monthStr = month.value;
		var day = window.document.getElementById("day");
		var dayStr = day.value;
		var hobby = document.getElementsByName("hobby");
		var check_val = [];//兴趣点的集合，打印出来时时以","分隔的。
		for(i=0;i<hobby.length;i++){
	        if(hobby[i].checked)
	            check_val.push(hobby[i].value);
		}
		var kind = window.document.getElementById("kind");
		var kindStr = kind.value.replace(/(^\s+)|(\s+$)/g, '');

		window.location.href = "${pageContext.request.getScheme()}://${pageContext.request.getServerName()}:${pageContext.request.getServerPort()}${pageContext.request.contextPath}"
				+ "/UpdateCustomerServlet2?name="
				+ encodeURI(nameStr)
				+ "&phone="
				+ encodeURI(phoneStr)
				+"&id="
				+encodeURI(id)
				+ "&email="
				+ encodeURI(emailStr)
				+ "&remarks="
				+ encodeURI(remarksStr)
				+ "&sex="
				+ encodeURI(sexStr)
				+ "&year="
				+ encodeURI(yearStr)
				+ "&month="
				+ encodeURI(monthStr)
				+ "&day="
				+ encodeURI(dayStr)
				+ "&hobby="
				+ encodeURI(check_val)
				+ "&kind="
				+ encodeURI(kindStr);
	}
</script>
<body>
	<form style="text-align: left;">
		<table align="center" width="50%" border="1" bordercolor="#0066FF">
			<tr>
				<td style="padding-left: 10px;">客户名称</td>
				<td><input id="name" name="name" value="${customer.name }"></td>
			</tr>
			<tr>
				<td style="padding-left: 10px;">性别</td>
				<td><input type="radio" id="sex" name="sex" value="男" ${customer.sex == '男'?'checked':''}>男
					<input type="radio" id="sex" name="sex" value="女" ${customer.sex == '女'?'checked':''}>女</td>
			</tr>
			<tr>
				<td style="padding-left: 10px;">生日</td>
				<td><select id="year" name="year"><!-- 此处选中是selected，与radio选中不同 -->
						<c:forEach begin="1900" end="2050" var="yc">
							<option value="${yc }" ${fn:split(customer.birthday,'-')[0] == yc?'selected':''}>${yc }</option>
						</c:forEach>
				</select>年 <select id="month" name="month">
						<c:forEach begin="01" end="12" var="mc">
							<option value="${mc }" ${fn:split(customer.birthday,'-')[1] == mc?'selected':''}>${mc }</option>
						</c:forEach>
				</select>月 <select id="day" name="day">
						<c:forEach begin="01" end="31" var="dc">
							<option value="${dc }" ${fn:split(customer.birthday,'-')[2] == dc?'selected':''}>${dc }</option>
						</c:forEach>
				</select>日</td>
			</tr>
			<tr>
				<td style="padding-left: 10px;">手机</td>
				<td><input type="text" name="phone" id="phone" value="${customer.phone }"></td>
			</tr>
			<tr>
				<td style="padding-left: 10px;">邮箱</td>
				<td><input type="text" name="email" id="email" value="${customer.email }"></td>
			</tr>
			<tr>
				<td style="padding-left: 10px;">爱好</td>
				<td>
				<c:forEach items="${hobbylist}" var="item"><!-- items="${hobbylist}  "(不能有空格，有空格就报错)  -->
						<input type="checkbox" id="hobby" name="hobby" value="${item.name}"  ${fn:indexOf(customer.hobby,item.name)!= -1 ?'checked':''}>${item.name}
					</c:forEach></td>
			</tr>
			<tr>
				<td style="padding-left: 10px;">客户类型 ${customer.kind}</td>
				<td><input type="radio" id="kind" name="kind" value="非客户"
					 ${customer.kind == '非客户'?'checked':''}>非客户 <input type="radio" id="kind" name="kind"
					value="普通客户"  ${customer.kind == '普通客户'?'checked':''}>普通客户 <input type="radio" id="kind" name="kind"
					value="重要客户"  ${customer.kind == '重要客户'?'checked':''}>重要客户</td>
			</tr>
			<tr>
				<td style="padding-left: 10px;">客户备注</td>
				<td><textarea id="remarks" name="remarks" cols="50" rows="10"
							> ${customer.remarks }</textarea>
				</td>
			</tr>
			<tr>
				<td><input type="button" value="返回" onclick="back()"></td>
				<td><input type="button" value="确定修改" onclick="update('${customer.id}','${customer.name }')"></td>
			</tr>
		</table>
	</form>
</body>
</html>