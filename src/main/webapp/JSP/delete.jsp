<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="bean.product" %>
<%@page import="Dao.ProductDao" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/JSP/style.css" type="text/css">
</head>
<body>
<%
ProductDao pd=new ProductDao();
String id=(String)request.getParameter("id");
product p =pd.findByID(id);
%>
<form action="<%=request.getContextPath() %>/deletecartservlet?id=<%=p.getId()%>" method="post">
<p>商品名稱: <%=p.getName() %></p>
<p>商品價格: <%=p.getPrice() %></p>
請輸入刪除數量: <input type="text" name="number"><br>
<input type="submit" value="確認">
&nbsp&nbsp&nbsp<a href="<%=request.getContextPath() %>/productservlet">取消</a>
</form>
</body>
</html>