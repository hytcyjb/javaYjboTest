<%@page import="sun.net.www.content.text.plain"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="user.bean.Person"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录成功</title>
</head>
<body>
	<form action="/day09_demo/LoginServlet" method="post">
		<table align="center" border="1" bordercolor="#0066FF" width="15%"
			style="text-align: center; margin-top: 100px">
			<tr>
				<td colspan="12"><h2>
						<%=session.getAttribute("login_tip")%>
					</h2>
					<h4><%=request.getAttribute("tip") %></h4></td>
			</tr>
			<tr>
				<%
					List<Person> pList = (ArrayList) request.getAttribute("pList");
					for (int i = 0; i < pList.size(); i++) {
						Person person1 = pList.get(i);
				%>
				<%
					if (i % 6 == 0) {
				%>
			
			<tr>
				<%
					}
				%>
				<td><input type="text" name="<%=person1.getName()%>"
					value="<%=person1.getName()%>" /></td>
				<td><input type="button" value="删除"
					id="<%=person1.getPersonid()%>" width="20px" 
 					onclick="window.location.href='/day09_demo/DeleteServlet?personid=<%=person1.getPersonid() %>&name=<%=person1.getName() %>&tel=<%=person1.getTel() %>&email=<%=person1.getEmail() %>';"></td>
				<!-- onclick="window.location.href='http://localhost:8080/day09_demo/DeleteServlet?name=522';"></td> -->
				<%
					if (i % 6 == 5 || i == pList.size() - 1) {
				%>
			</tr>
			<%
				}
				}
			%>
		</table>
	</form>

</body>
</html>