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
<%-- <script src="<%=request.getContextPath()%> /js/yearmonthday.js"></script> --%>
<script type="text/javascript">
	function empty() {
		var name = window.document.getElementById("name");
		name.value = "";
		var phone = window.document.getElementById("phone");
		phone.value = "";
		var email = window.document.getElementById("email");
		email.value = "";
		var remarks = window.document.getElementById("remarks");
		remarks.value = "";
		var year = window.document.getElementById("year");
		year.value = "1900";
		var month = window.document.getElementById("month");
		month.value = "1";
		var day = window.document.getElementById("day");
		day.value = "1";
	}
	function btn() {//不能用submit()
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

		window.location.href="${pageContext.request.getScheme()}://${pageContext.request.getServerName()}:${pageContext.request.getServerPort()}${pageContext.request.contextPath}"+"/MainServlet?name="+encodeURI(nameStr)+"&phone="+encodeURI(phoneStr)
				+"&email="+encodeURI(emailStr)+"&remarks="+encodeURI(remarksStr)+"&sex="+encodeURI(sexStr)
				+"&year="+encodeURI(yearStr)+"&month="+encodeURI(monthStr)+"&day="+encodeURI(dayStr)
								+"&hobby="+encodeURI(check_val)+"&kind="+encodeURI(kindStr);
	}
</script>
<body>
	<form style=" text-align: left;" >
		<table align="center" width="50%" border="1" bordercolor="#0066FF">
			<tr>
				<td style="padding-left: 10px;">客户名称</td>
				<td><input id="name" name="name" value=""></td>
			</tr>
			<tr>
				<td style="padding-left: 10px;">性别</td>
				<td><input type="radio" id= "sex" name="sex" value="男">男 <input
					type="radio" id= "sex"  name="sex" value="女" checked>女</td>
			</tr>
			<tr>
				<td style="padding-left: 10px;">生日</td>
				<td><select id="year" name="year">
						<c:forEach begin="1800" end="2050" var="yc">
							<option value="${yc }">${yc }</option>
						</c:forEach>
				</select>年 <select id="month" name="month">
						<c:forEach begin="01" end="12" var="mc">
							<option value="${mc }">${mc }</option>
						</c:forEach>
				</select>月 <select id="day" name="day">
						<c:forEach begin="01" end="31" var="dc">
							<option value="${dc }">${dc }</option>
						</c:forEach>
				</select>日</td>
			</tr>
			<tr>
				<td style="padding-left: 10px;">手机</td>
				<td><input type="text" name="phone" id="phone"></td>
			</tr>
			<tr>
				<td style="padding-left: 10px;">邮箱</td>
				<td><input type="text" name="email" id="email"></td>
			</tr>
			<tr>
				<td style="padding-left: 10px;">爱好</td>
				<td><c:forEach items="${items }" var="ghobby">
						<input type="checkbox" id="hobby" name="hobby" value="${ghobby.name }">${ghobby.name }
					</c:forEach></td>
			</tr>
			<tr>
				<td style="padding-left: 10px;">客户类型</td>
				<td><input type="radio" id="kind" name="kind" value="非客户" checked>非客户
					<input type="radio" id="kind" name="kind" value="普通客户">普通客户
					<input type="radio" id="kind" name="kind" value="重要客户">重要客户
				</td>
			</tr>
			<tr>
				<td style="padding-left: 10px;">客户备注</td>
				<td><textarea id="remarks" name="remarks" cols="50" rows="10"></textarea>
				</td>
			</tr>
			<tr>
				<td><input type="button" value="清空" onclick="empty()"></td>
				<td><input type="button" value="添加用户" onclick="btn()"></td>
			</tr>
		</table>
	</form>
</body>
</html>