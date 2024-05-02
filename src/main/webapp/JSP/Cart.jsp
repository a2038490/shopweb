<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>
<%@page import="java.util.HashMap" %>
<%@page import="bean.product" %>
<%@page import="Dao.CartDao" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
<h1>購物車清單</h1><br>
<hr width="40%" size="5">
<br><br>
<table width="60%" height="100" border="0">
<%
	int total=0;
	HashMap<product,Integer> cart=(HashMap<product,Integer>)session.getAttribute("cart");
	if(cart==null)
	{
		String username=u.getUsername();
		cart=new CartDao().findAll(username);
	}
	if(cart.size() <= 0)
	{
		out.println("目前購物車並沒有商品");
	}
	else
	{%>
		<tr><th>Id</th><th>名稱</th><th>價格</th><th>數量</th></tr>
		<%
		for(product p:cart.keySet())
		{%>
			<tr>
			<td><%=p.getId() %></td>
			<td><%=p.getName() %></td>
			<td><%=p.getPrice() %></td>
			<td><%=cart.get(p) %></td>
			<td><a href="<%=request.getContextPath() %>/JSP/addCart.jsp?id=<%= p.getId() %>">新增</a></td>
			<td><a href="<%=request.getContextPath() %>/JSP/delete.jsp?id=<%= p.getId() %>">刪除</a></td>
			<td><a href="<%=request.getContextPath() %>/JSP/productdetail.jsp?id=<%= p.getId() %>">商品詳情</a></td>
			</tr>
			<%
			total=total+(p.getPrice()*cart.get(p));
		 }
		session.setAttribute("total", total);
	}
%>
</table>
<br><br>
<p><font size="5">總計 :<%=total %></font></p>
<a href="<%=request.getContextPath() %>/JSP/order.jsp">結帳</a>
</body>
</html>