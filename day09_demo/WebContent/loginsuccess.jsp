<%@page import="sun.net.www.content.text.plain"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="user.bean.Person"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录成功-人员列表</title>
</head>
<body>

	<form action="/day09_demo/LoginServlet" method="post">
		<table align="center" border="1" bordercolor="#0066FF" width="15%"
			style="text-align: center; margin-top: 100px;margin-bottom: 300px;padding-bottom: 50px">
			<tr>
				<td colspan="18"><h2>
						<%=session.getAttribute("login_tip")%>
					</h2>
					<h4><%=request.getAttribute("tip")%></h4></td>
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
					value="<%=person1.getName()%>" disabled="disabled"/></td>
				<!-- input内必须要有id属性，否则不跳转 -->
				<td><input type="button" value="删除"
					id="<%=person1.getPersonid()%>" width="20px"
					onclick="window.location.href='/day09_demo/DeleteServlet?personid=<%=person1.getPersonid()%>&name=<%=person1.getName()%>&tel=<%=person1.getTel()%>&email=<%=person1.getEmail()%>';"></td>
				<td><input type="button" value="修改"
					id="<%=person1.getPersonid()%>" width="20px"
					onclick="window.location.href='/day09_demo/updateperson.jsp?personid=<%=person1.getPersonid()%>&name=<%=person1.getName()%>&tel=<%=person1.getTel()%>&email=<%=person1.getEmail()%>';"></td>
				<%
					if (i % 6 == 5 || i == pList.size() - 1) {
				%>
			</tr>
			<%
				}
				}
			%>
			<tr>
				<td colspan="3" style="font-size: 20px;" bgcolor="#999966"
					onclick="window.location.href='/day09_demo/AddPersonServlet?addnum=1';">添加1个成员</td>
				<td colspan="3" style="font-size: 20px" bgcolor="#FFFF00"
					onclick="window.location.href='/day09_demo/AddPersonServlet?addnum=5';">添加5个成员</td>
				<td colspan="3" style="font-size: 20px" bgcolor="#33FF33"
					onclick="window.location.href='/day09_demo/AddPersonServlet?addnum=10';">添加10个成员</td>
				<td colspan="3" style="font-size: 20px" bgcolor="#CC6600"
					onclick="window.location.href='/day09_demo/AddPersonServlet?addnum=20';">添加20个成员</td>
				<td colspan="3" style="font-size: 20px" bgcolor="#9999CC"
					onclick="window.location.href='/day09_demo/AddPersonServlet?addnum=50';">添加50个成员</td>
				<td colspan="3" style="font-size: 20px" bgcolor="#33FF00"
					onclick="window.location.href='/day09_demo/AddPersonServlet?addnum=100';">添加100个成员</td>
			</tr>
		</table>
	</form>

</body>
</html>