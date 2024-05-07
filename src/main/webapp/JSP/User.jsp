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
<br>
<p>會員帳號 :  <%=u.getUsername() %></p>
<p>會員密碼 :  <%=u.getPassword() %></p>
<p>會員姓名 :  <%=u.getName() %></p>
<p>會員電話 :  <%=u.getPhone() %></p>
<br>
<a href="<%=request.getContextPath() %>/JSP/Updateuser.jsp">編輯會員資料</a>
</body>
</html>