package Dao;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import bean.user;

public class UserDao {
	
	private SimpleDBSource db=null;
	private Connection con=null;
	private PreparedStatement stmt=null;
	
	
	public void add(user user)
	{
		try {
			db= new SimpleDBSource();
			con=db.getConnection();
			String sql="insert into user values(?,?,?,?)";
			stmt=con.prepareStatement(sql);
			stmt.setString(1, user.getUsername());
			stmt.setString(2, user.getPassword());
			stmt.setString(3, user.getName());
			stmt.setString(4, user.getPhone());
			stmt.executeUpdate();
		}
		catch(IOException|ClassNotFoundException|SQLException e)
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
	
	public user findByUsername(String username)
	{
		user u=null;
		try {
			db= new SimpleDBSource();
			con=db.getConnection();
			String sql="select * from user where username=?";
			stmt=con.prepareStatement(sql);
			stmt.setString(1, username);
			ResultSet rs=stmt.executeQuery();
			if(rs.next())
			{
				u=new user(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
			}
			
		}
		catch(IOException|ClassNotFoundException|SQLException e)
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
		return u;
	}
	
	public void update(user user)
	{
		try {
			db= new SimpleDBSource();
			con=db.getConnection();
			String sql="update user set name=?,phone=? where username=?";
			stmt=con.prepareStatement(sql);
			stmt.setString(1, user.getName());
			stmt.setString(2, user.getPhone());
			stmt.setString(3, user.getUsername());
			stmt.executeUpdate();
		}
		catch(IOException|ClassNotFoundException|SQLException e)
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

