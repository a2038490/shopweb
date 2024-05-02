package Dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import bean.product;
import Dao.SimpleDBSource;

public class ProductDao {
	
	SimpleDBSource db=null;
	Connection con=null;
	PreparedStatement stmt=null;
	
	public List<product> findAll()
	{
		List<product> list=new ArrayList<product>();
		try {
			db= new SimpleDBSource();
			con=db.getConnection();
			String sql="select * from product";
			stmt=con.prepareStatement(sql);
			ResultSet rs=stmt.executeQuery();
			while(rs.next())
			{
				product p=new product(rs.getInt("id"),rs.getString("name"),
						rs.getInt("price"),rs.getString("describe"),rs.getString("picture"));
				list.add(p);
			}
		}
		catch(IOException |ClassNotFoundException |SQLException e)
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
		
		return list;
	}
	
	public product findByID(String id)
	{
		product p=null;
		try {
			db= new SimpleDBSource();
			con=db.getConnection();
			String sql="select * from product where id=?";
			stmt=con.prepareStatement(sql);
			stmt.setString(1, id);
			ResultSet rs=stmt.executeQuery();
			if(rs.next())
			{
				p=new product(rs.getInt("id"),rs.getString("name"),
						rs.getInt("price"),rs.getString("describe"),rs.getString("picture"));
			}
			}
		catch(IOException |ClassNotFoundException |SQLException e)
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
		return p;
	}
	
	public void addProduct(product p)
	{
		try {
			db= new SimpleDBSource();
			con=db.getConnection();
			String sql="insert into product values(?,?,?,?,?)";
			stmt=con.prepareStatement(sql);
			stmt.setInt(1, p.getId());
			stmt.setString(2, p.getName());
			stmt.setInt(3, p.getPrice());
			stmt.setString(4, p.getDescribe());
			stmt.setString(5, p.getPicture());
			int i=stmt.executeUpdate();
		}
		catch(IOException |ClassNotFoundException |SQLException e)
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
