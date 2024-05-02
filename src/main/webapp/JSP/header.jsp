<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import= "bean.user"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/JSP/style.css" type="text/css">
</head>
<body>
<div id="header">
<% 
user u=(user)session.getAttribute("user");
if(u==null)
{%>
	<a href="<%=request.getContextPath() %>/JSP/Register.jsp">註冊</a>
	<a href="<%=request.getContextPath() %>/JSP/Login.jsp">登入</a>
<%
}
else{
	String name=u.getName();
	out.print(name); 
%>
	<a href="<%=request.getContextPath() %>/logoutservlet">登出</a>
<%
}
%>
</div>	
<br>
<br>	
<div id="menu">
<ul>
<li><a href="<%=request.getContextPath() %>/JSP/Main.jsp">首頁</a>
<li><a href="<%=request.getContextPath() %>/productservlet">商品列表</a>
<li><a href="<%=request.getContextPath() %>/JSP/User.jsp">用戶資料</a>
<li><a href="<%=request.getContextPath() %>/CartServlet">購物車</a>
<li><a href="<%=request.getContextPath() %>/JSP/Orderview.jsp">歷史訂單</a>
</ul>
</div>
</body>
</html>