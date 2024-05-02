package Dao;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import bean.cartitem;
import bean.product;

public class CartDao {

	private SimpleDBSource db=null;
	private Connection con=null;
	private PreparedStatement stmt=null;
	
	public HashMap<product,Integer> findAll(String username)
	{
		HashMap<product,Integer> pm=new HashMap<product,Integer>();
		try {
			db= new SimpleDBSource();
			con=db.getConnection();
			ProductDao pd=new ProductDao();
			String sql="select * from cartitem where username=?";
			stmt=con.prepareStatement(sql);
			stmt.setString(1, username);
			ResultSet rs=stmt.executeQuery();
			while(rs.next())
			{
				product p=pd.findByID(rs.getString("productid"));
				pm.put(p, rs.getInt("num"));
			}
			
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try {
				db.close(con, stmt);
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return pm;
	}
	
	public void addcart(cartitem cartitem)
	{
		try {
			db= new SimpleDBSource();
			con=db.getConnection();
			String sql="insert into cartitem values(?,?,?)";
			stmt=con.prepareStatement(sql);
			stmt.setString(1, cartitem.getUsername());
			stmt.setInt(2, cartitem.getProductid());
			stmt.setInt(3, cartitem.getNum());
			int i=stmt.executeUpdate();
		}
		catch(IOException | ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try {
				db.close(con, stmt);
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}	
		}
	}
	
	public void deletecart(cartitem cartitem)
	{
		try {
			db= new SimpleDBSource();
			con=db.getConnection();
			String sql="delete from cartitem where username=?and productid=?";
			stmt=con.prepareStatement(sql);
			stmt.setString(1, cartitem.getUsername());
			stmt.setInt(2, cartitem.getProductid());
			int i=stmt.executeUpdate();
		}
		catch(IOException | ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try {
				db.close(con, stmt);
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}	
		}
	}
	
	public void updatecart(cartitem cartitem)
	{
		try {
			db= new SimpleDBSource();
			con=db.getConnection();
			String sql="update cartitem set num=? where username=? and productid=?";
			stmt=con.prepareStatement(sql);
			stmt.setInt(1, cartitem.getNum());
			stmt.setString(2, cartitem.getUsername());
			stmt.setInt(3, cartitem.getProductid());
			int i=stmt.executeUpdate();
		}
		catch(IOException | ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try {
				db.close(con, stmt);
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}	
		}
	}
	
	public void clearcart(String username)
	{
		try {
			db= new SimpleDBSource();
			con=db.getConnection();
			String sql="delete from cartitem where username=?";
			stmt=con.prepareStatement(sql);
			stmt.setString(1, username);
			int i=stmt.executeUpdate();
		}
		catch(IOException | ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try {
				db.close(con, stmt);
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}	
		}
	}
	
}
