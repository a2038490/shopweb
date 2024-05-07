<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<%@page import="bean.product" %>
<%@page import="Dao.ProductDao" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
<%
ProductDao pd=new ProductDao();
String id=(String)request.getParameter("id");
product p =pd.findByID(id);
%>
<figure id="product">
	<img alt="The picture is error." src="<%=request.getContextPath()+"/"+p.getPicture() %>">
	<figcaption>商品名稱: <%=p.getName() %></figcaption>
	<figcaption>商品價格: <%=p.getPrice() %></figcaption>
	<figcaption>商品介紹: <%=p.getDescribe() %></figcaption>
	<a href="<%=request.getContextPath() %>/JSP/addCart.jsp?id=<%=p.getId()%>">加入購物車</a>
	</figure>
</body>
</html>