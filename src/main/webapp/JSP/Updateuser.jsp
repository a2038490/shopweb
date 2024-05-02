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
<h1>編輯資料</h1><br>
<hr width="40%" size="5"><br>
<form action="<%=request.getContextPath() %>/updateservlet" method="post">
帳號: <%=u.getUsername() %>><br><br>
密碼: <%=u.getPassword() %>><br><br>
名稱: <input type="text" name="name" value=<%=u.getName() %>><br><br>
電話: <input type="text" name="phone" value=<%=u.getPhone() %>><br><br>
<input type="reset">&nbsp &nbsp &nbsp &nbsp
<input type="submit">
</form>
</body>
</html>