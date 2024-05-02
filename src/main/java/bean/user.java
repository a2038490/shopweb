package bean;

public class user {
	
	private String username;
	private String password;
	private String name;
	private String phone;
	
	public user(String username,String password,String name,String phone)
	{
		this.username=username;
		this.password=password;
		this.name=name;
		this.phone=phone;
	}
	
	public user(String username,String password)
	{
		this.username=username;
		this.password=password;
	}
	
	public void setUsername(String username)
	{
		this.username=username;
	}
	
	public String getUsername()
	{
		return username;
	}
	
	public void setPassword(String password)
	{
		this.password=password;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	public void setName(String name)
	{
		this.name=name;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setPhone(String phone)
	{
		this.phone=phone;
	}
	
	public String getPhone()
	{
		return phone;
	}

}
