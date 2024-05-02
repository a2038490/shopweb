package bean;

public class cartitem {
	private String username;
	private int productid;
	private int num;
	
	public cartitem(String username,int productid,int num)
	{
		this.username=username;
		this.productid=productid;
		this.num=num;
	}
	
	public void setUsername(String username)
	{
		this.username=username;
	}
	
	public String getUsername()
	{
		return username;
	}
	
	public void setProductid(int productid)
	{
		this.productid=productid;
	}
	
	public int getProductid()
	{
		return productid;
	}
	
	public void setNum(int num)
	{
		this.num=num;
	}
	
	public int getNum()
	{
		return num;
	}

}
