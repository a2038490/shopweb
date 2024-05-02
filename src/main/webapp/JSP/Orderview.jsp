<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<%@ page import="bean.order" %>
<%@ page import="java.util.List" %>
<%@ page import="Dao.OrderDao" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
if(u==null)
{
	request.setAttribute("msg", "請先登入");
	request.getRequestDispatcher("Error.jsp").forward(request, response);
}
%>
<h1>歷史訂單</h1><br>
<hr width="40%" size="5">
<br><br>
<table width="60%" height="100" boarder="0">
<%
OrderDao od=new OrderDao();
List<order> list=od.findAll(u.getUsername());



if(list.isEmpty())
{
	out.println("目前沒有訂單");
}
else
{%>
	<tr><th>訂單編號</th><th>客戶名稱</th><th>客戶電話</th><th>收店地址</th><th>訂單內容</th><th>日期</th><th>總價</th></tr>
	<%
	for(order o: list)
	{%>
		<tr>
		<td><%=o.getTradeno() %></td>
		<td><%=o.getName() %></td>
		<td><%=o.getPhone() %></td>
		<td><%=o.getAddress() %></td>
		<td><%=o.getItem() %></td>
		<td><%=o.getDate() %></td>
		<td><%=o.getTotal() %></td>
		<%
	}
}

%>
</table>
</body>
</html>