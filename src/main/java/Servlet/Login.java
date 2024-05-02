package Servlet;

import java.io.IOException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;
import service.userservice;
import Dao.UserDao;
import bean.user;


public class Login extends HttpServlet{

	public void doGet(HttpServletRequest request,HttpServletResponse response) 
			throws ServletException,IOException{
		
		this.doPost(request,response);
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		userservice us =new userservice();
		UserDao ud =new UserDao();
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		user u=new user(username,password);
		int loginstatus=us.Login(u);
		switch(loginstatus)
		{
		case 1: 
			user user=ud.findByUsername(username);
			request.getSession().setAttribute("user",user);
			request.getRequestDispatcher("/JSP/Main.jsp").forward(request,response);
		case 2:
			request.setAttribute("msg","密碼錯誤");
			request.getRequestDispatcher("/JSP/Error.jsp").forward(request,response);
		case 3:
			request.setAttribute("msg","無此用戶");
			request.getRequestDispatcher("/JSP/Error.jsp").forward(request,response);
		}
	}
}
