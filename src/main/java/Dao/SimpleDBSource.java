package Dao;

import java.util.Properties;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;;

public class SimpleDBSource {
	
	private Properties prop;
	private String url;
	private String user;
	private String password;
	
	public SimpleDBSource() throws IOException,ClassNotFoundException
	{
		this("jdbc.properties");
	}
	
	public SimpleDBSource(String config) throws IOException,ClassNotFoundException
	{
		prop=new Properties();
		InputStream fs=getClass().getClassLoader().getResourceAsStream(config);
		prop.load(fs);
		url=prop.getProperty("url");
		user=prop.getProperty("user");
		password=prop.getProperty("password");
		Class.forName(prop.getProperty("driver"));
	}
	
	public Connection getConnection() throws SQLException
	{
		return DriverManager.getConnection(url,user,password);
	}
	
	public void close(Connection con,PreparedStatement stmt) throws SQLException
	{
		if(stmt!=null)
		{
			stmt.close();
		}
		
		if(con!=null)
		{
			con.close();
		}
		
	}

}
