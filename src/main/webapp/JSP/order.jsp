<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<%@ page import="java.util.HashMap"%>
<%@ page import="bean.product" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
HashMap<product,Integer> cart=(HashMap<product,Integer>)session.getAttribute("cart");
if(cart==null || cart.isEmpty())
{
	request.setAttribute("msg","購物車沒有商品");
	request.getRequestDispatcher("/JSP/Error.jsp").forward(request,response);
}
%>
<h1>請輸入訂單資料</h1><br>
<hr width="40%" size="5"><br>
<form action="<%=request.getContextPath() %>/checkoutservlet" method="post">
收件人姓名: <input type="text" name="name"><br><br>
收件人電話: <input type="text" name="phone"><br><br>
配送地址:  <input type="text" name="address"><br><br>
<input type="submit" value="送出">
</form>
</body>
</html>