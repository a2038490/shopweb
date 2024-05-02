package Servlet;

import java.io.IOException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;
import service.userservice;
import bean.user;

public class Update extends HttpServlet{

	public void doGet(HttpServletRequest request,HttpServletResponse response) 
			throws ServletException,IOException{
		
		this.doPost(request,response);
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		userservice us =new userservice();
		user u=(user)request.getSession().getAttribute("user");
		String username=u.getUsername();
		String password=u.getPassword();
		String name=request.getParameter("name");
		String phone=request.getParameter("phone");
		user update=new user(username,password,name,phone);
		us.update(update);
		request.getSession().setAttribute("user",update);
		request.getRequestDispatcher("/JSP/User.jsp").forward(request,response);
		return;
	}
}
