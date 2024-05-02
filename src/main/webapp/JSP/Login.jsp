<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
<h1>登入</h1><br>
<hr width="40%" size="5"><br>
<form action="<%=request.getContextPath() %>/loginservlet" method="post">
帳號: <input type="text" name="username"><br>
<br>
密碼: <input type="password" name="password"><br>
<br>
<input type="submit" value="登入">
</form>
</body>
</html>