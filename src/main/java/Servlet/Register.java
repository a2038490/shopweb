package Servlet;

import java.io.IOException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;
import service.userservice;
import bean.user;

public class Register extends HttpServlet{

	public void doGet(HttpServletRequest request,HttpServletResponse response) 
			throws ServletException,IOException{
		
		this.doPost(request,response);
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
		

		response.setContentType("text/html");
		userservice us =new userservice();
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String name=request.getParameter("name");
		String phone=request.getParameter("phone");
		user u=new user(username,password,name,phone);
		boolean bo=us.Register(u);
		if(bo)
		{
			request.getRequestDispatcher("/JSP/Main.jsp").forward(request,response);
			
		}
		else
		{
			request.setAttribute("msg","註冊失敗，用戶已存在");
			request.getRequestDispatcher("/JSP/Error.jsp").forward(request,response);
			
		}
	}
}
