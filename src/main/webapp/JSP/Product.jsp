<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<%@page import="bean.product" %>
<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Insert title here</title>

</head>
<body>
<h1>商品項目</h1><br>
<hr width="40%" size="5">
<br><br>

<%
List<product> productList = (List<product>)request.getAttribute("productList");
for (product p : productList)
{
	%>
	<section>
	<figure>
	<img alt="The picture is error." src="<%=request.getContextPath() %>/JSP/sugar juice.jpg">
	<figcaption><%=p.getName() %></figcaption>
	<figcaption><%=p.getPrice() %></figcaption>
	<a href="<%=request.getContextPath() %>/JSP/productdetail.jsp?id=<%=p.getId() %>">商品詳情</a>
	</figure>
	</section>
	<%
}


%>

</body>
</html>