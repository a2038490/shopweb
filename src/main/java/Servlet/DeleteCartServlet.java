package Servlet;

import java.io.IOException;
import java.util.HashMap;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.ServletException;
import service.ShoppingCart;
import Dao.CartDao;
import Dao.ProductDao;
import bean.user;
import bean.product;

public class DeleteCartServlet extends HttpServlet{

	public void doGet(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{

		this.doPost(request,response);
	}

	public void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text.html;charset=UTF-8");
		ProductDao pd=new ProductDao();
		ShoppingCart sc=new ShoppingCart();
		String id=(String)request.getParameter("id");
		product p =pd.findByID(id);
		int num=Integer.parseInt(request.getParameter("number"));
		HttpSession session=request.getSession();
		HashMap<product,Integer> cart=(HashMap<product,Integer>)session.getAttribute("cart");
		if(cart!=null)
		{
			System.out.println("cart is not null");
		}
		user u=(user)session.getAttribute("user");
		String username=u.getUsername();
		cart=sc.removeProduct(cart, p, num,username);
		if(num>0)
		{
			session.setAttribute("cart",cart);
			request.getRequestDispatcher("/JSP/Cart.jsp").forward(request,response);
			return;
		}
		else
		{
			request.setAttribute("msg","數量需大於0");
			request.getRequestDispatcher("/JSP/Error.jsp").forward(request,response);
			return;
		}
	}
	
}