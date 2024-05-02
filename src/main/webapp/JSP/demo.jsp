<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<%@page import="bean.product" %>
<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>
<%@page import="java.sql.ResultSet" %>
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
ResultSet rs = (ResultSet)request.getAttribute("rs");
if(rs !=null)
{
	out.println("productList is not null");
	while(rs.next())
	{
		out.print("商品id: "+rs.getInt("id"));
		out.print("商品名稱: "+rs.getString("name"));
		out.print("商品價格: "+rs.getInt("price"));
	}
}
else
{
	out.println("productList is null.");
}

%>
</body>
</html>