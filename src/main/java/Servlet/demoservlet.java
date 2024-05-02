package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;
import Dao.ProductDao;
import bean.product;
import java.util.List;
import java.sql.ResultSet;

public class demoservlet extends HttpServlet{
	
	public void doGet(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{

		this.doPost(request,response);
	}

	public void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
		ProductDao pd= new ProductDao();
		List rs=pd.findAll();
		response.setContentType("text/html");
		request.setAttribute("rs", rs);
		request.getRequestDispatcher("/JSP/demo.jsp").forward(request,response);
		return;
	}

}
