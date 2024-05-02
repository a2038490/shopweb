<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/JSP/style.css" type="text/css">
</head>
<body>
<font size="18">
<%=request.getAttribute("msg") %><br><br>
<a href="<%=request.getContextPath() %>/JSP/Main.jsp">Back to home page.</a>
</font>
</body>
</html>