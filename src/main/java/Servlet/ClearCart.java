package Servlet;

import java.io.IOException;
import java.util.HashMap;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.ServletException;
import service.ShoppingCart;
import Dao.UserDao;
import Dao.CartDao;
import Dao.OrderDao;
import bean.product;
import bean.user;
import bean.order;

public class ClearCart extends HttpServlet{

	public void doGet(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{

		this.doPost(request,response);
	}

	public void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text.html;charset=UTF-8");
		UserDao ud=new UserDao();
		CartDao cd=new CartDao();
		OrderDao od=new OrderDao();
		ShoppingCart sc=new ShoppingCart();
		Cookie[] cookies=request.getCookies();
		HttpSession session=request.getSession();
		//String user=null;
		if(cookies!=null)
		{
			System.out.println("cookie is no null");
			for(Cookie cookie : cookies)
			{
				System.out.println(cookie.getName()+" in for");
				/*if(cookie.getName().equals("JSESSIONID"))
				{
					user=cookie.getValue();
					System.out.println(user +" in cookie");
					break;
				}*/
			}
		}
		else
		{
			System.out.println("cookie is null");
		}
		user u=(user)session.getAttribute("user");
		//user u=ud.findByUsername(user);
		order o=(order)session.getAttribute("order");
		System.out.println("訂單編號:"+o.getTradeno()+"日期:"+o.getDate()+"總價:"+o.getTotal());
		od.addOrder(o);
		HashMap<product,Integer> cart=(HashMap<product,Integer>)session.getAttribute("cart");
		//session.setAttribute("user", u);
		//String username=u.getUsername();
		//HashMap<product,Integer> cart=cd.findAll(username);
		sc.clear(cart,u.getUsername());
		session.setAttribute("cart",cart);
		request.getRequestDispatcher("/JSP/checkout.jsp").forward(request,response);
	}
	
}