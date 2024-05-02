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
<%
if(u==null)
{
	request.setAttribute("msg", "請先登入會員");
	request.getRequestDispatcher("Error.jsp").forward(request, response);
}
%>

<h1>會員資料</h1><br>
<hr width="40%" size="5">
<br><br>
<table width="50%" height="100" border="0">
<tr align="left">
<td>會員帳號 :</td>
<td><%=u.getUsername() %></td>
</tr>
<tr align="left">
<td>會員密碼 :</td>
<td><%=u.getPassword() %></td>
</tr>
<tr align="left">
<td>會員姓名 :</td>
<td><%=u.getName() %></td>
</tr>
<tr align="left">
<td>會員電話 :</td>
<td><%=u.getPhone() %></td>
</tr>

<a href="<%=request.getContextPath() %>/JSP/Updateuser.jsp">編輯會員資料</a>

</body>
</html>