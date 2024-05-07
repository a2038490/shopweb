package Servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import Dao.UserDao;
import Dao.OrderDao;
import bean.order;
import bean.user;
import bean.product;
import java.util.HashMap;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Cookie;
import service.userservice;
import jakarta.servlet.ServletException;
import java.util.UUID;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import ecpay.payment.integration.domain.AioCheckOutOneTime;
import ecpay.payment.integration.AllInOne;
import ecpay.payment.integration.domain.InvoiceObj;


public class checkoutservlet extends HttpServlet{
	
	public static AllInOne all;
	public String total;
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) 
			throws ServletException,IOException{
		
		this.doPost(request,response);
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
		
		HttpSession session=request.getSession();
		HashMap<product,Integer> cart=(HashMap<product,Integer>)session.getAttribute("cart");
		int total=(Integer)session.getAttribute("total");
		String stotal=Integer.toString(total);
		//String desc="名字: "+request.getParameter("name")+"   電話: "+request.getParameter("phone")+"   地址: "+request.getParameter("address");
		String name=request.getParameter("name");
		String phone=request.getParameter("phone");
		String address=request.getParameter("address");
		String item="";
		for(product p : cart.keySet())
		{
			item="#"+item+p.getName()+cart.get(p);
		}
		all=new AllInOne("");
		AioCheckOutOneTime obj=new AioCheckOutOneTime();
		UUID uid=UUID.randomUUID();
		String tradeno=uid.toString().replaceAll("-", "").substring(0,20);
		obj.setMerchantTradeNo(tradeno);
		String date=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date());
		obj.setMerchantTradeDate(date);
		obj.setTotalAmount(stotal);
		obj.setItemName("test");
		obj.setTradeDesc("test");
		obj.setReturnURL("a");
		obj.setOrderResultURL("http://localhost:8080/shopweb/clearcartservlet");
		obj.setNeedExtraPaidInfo("N");
		user u=(user)session.getAttribute("user");
		order o=new order(tradeno,u.getUsername(),name,phone,address,item,date,stotal);
		session.setAttribute("order", o);
		String sessionid=session.getId();
		Cookie cookie=new Cookie("JSESSIONID",sessionid);
		cookie.setMaxAge(3600);
		//cookie.setHttpOnly(false);
		response.addCookie(cookie);
		String form=all.aioCheckOut(obj, null);
		System.out.println("cookie: "+cookie);
		System.out.println(form);
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print("<html><body>"+form+"</body></html>");
		
		
	}
	
	
	

}
