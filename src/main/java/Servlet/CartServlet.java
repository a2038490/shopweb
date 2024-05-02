package Servlet;

import java.io.IOException;
import java.util.HashMap;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.ServletException;
import Dao.CartDao;
import bean.product;
import bean.user;

public class CartServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{

		this.doPost(request,response);
	}

	public void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		CartDao cd=new CartDao();
		HttpSession session=request.getSession();
		user u=(user)session.getAttribute("user");
		if(u == null)
		{
			System.out.println("u is null");
			request.setAttribute("msg", "請先登入會員");
			request.getRequestDispatcher("/JSP/Error.jsp").forward(request, response);
		}
		else 
		{
			System.out.println("u is not null");
			HashMap<product,Integer> pm=cd.findAll(u.getUsername());
			session.setAttribute("cart",pm);
			request.getRequestDispatcher("/JSP/Cart.jsp").forward(request,response);
		}
	}

}
