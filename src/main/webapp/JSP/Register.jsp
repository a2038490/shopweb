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
<h1>歡迎註冊</h1><br>
<hr width="40%" size="5"><br>
<form action="<%=request.getContextPath() %>/registerservlet" method="post">
帳號: <input type="text" name="username"><br><br>
密碼: <input type="password" name="password"><br><br>
名稱: <input type="text" name="name"><br><br>
電話: <input type="text" name="phone"><br><br>
<input type="reset" value="重置">&nbsp &nbsp &nbsp &nbsp
<input type="submit" value="註冊">
</form>
</body>
</html>