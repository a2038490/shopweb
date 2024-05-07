package Dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;
import Dao.SimpleDBSource;
import bean.order;

public class OrderDao {
	 
	private SimpleDBSource db=null;
	private Connection con=null;
	private PreparedStatement ps=null;
	
	public List<order> findAll(String username)
	{
		List<order> list=new ArrayList<order>();
		try
		{
			db=new SimpleDBSource();
			con=db.getConnection();
			String str="select * from `order` where username=? order by date desc";
			ps=con.prepareStatement(str);
			ps.setString(1, username);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				order o=new order(rs.getString("tradeno"),rs.getString("username"),rs.getString("name"),rs.getString("phone"),
									rs.getString("address"),rs.getString("item"),rs.getString("date"),rs.getString("total"));
				list.add(o);
			}
		}
		catch(IOException | SQLException | ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				db.close(con, ps);
			}
			catch(SQLException e )
			{
				e.printStackTrace();
			}
		}
		
		return list;
	}
	
	public void addOrder(order order)
	{
		try
		{
			db=new SimpleDBSource();
			con=db.getConnection();
			String sql="insert into `order` values(?,?,?,?,?,?,?,?)";
			ps=con.prepareStatement(sql);
			ps.setString(1, order.getTradeno());
			ps.setString(2, order.getUsername());
			ps.setString(3, order.getName());
			ps.setString(4, order.getPhone());
			ps.setString(5, order.getAddress());
			ps.setString(6, order.getItem());
			ps.setString(7, order.getDate());
			ps.setString(8, order.getTotal());
			ps.executeUpdate();
		}
		catch(IOException | ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				db.close(con, ps);
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
	}

}
