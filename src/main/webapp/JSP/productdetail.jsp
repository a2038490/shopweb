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
<div class="wrap">
	<div class="sitebar">
	<!--  <img border="0" src=<%=p.getPicture() %>>-->
	</div>
	<div class="bodybar">
	<p><font size="5">商品名稱: <%=p.getName() %></font></p>
	<p><font size="5">商品價格: <%=p.getPrice() %></font></p>
	<p><font size="3">商品介紹: <%=p.getDescribe() %></font></p>
	</div>
	<div class="clearfix"></div>
	<div class="footer">
	<a href="<%=request.getContextPath() %>/JSP/addCart.jsp?id=<%=p.getId()%>">加入購物車</a>
	</div>
</div>
</body>
</html>