package Servlet;

import java.io.IOException;
import java.util.List;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;
import Dao.ProductDao;
import bean.product;

public class ProductServlet extends HttpServlet{
		
	public void doGet(HttpServletRequest request,HttpServletResponse response)
					throws ServletException,IOException{
		try {
			response.setContentType("text.html");
			ProductDao pd=new ProductDao();
			List<product> productList=pd.findAll();
			if(productList!=null)
			{
				request.setAttribute("productList",productList);
				request.getRequestDispatcher("/JSP/Product.jsp").forward(request,response);
			}
			else
			{
				request.getRequestDispatcher("/JSP/Error.jsp").forward(request,response);
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
		

	
}


