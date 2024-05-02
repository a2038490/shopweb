package bean;

public class order {
	private String tradeno;
	private String username;
	private String name;
	private String phone;
	private String address;
	private String item;
	private String date;
	private String total;
	
	public order(String no, String un, String n, String p, String a, String i, String d, String t)
	{
		this.tradeno=no;
		this.username=un;
		this.name=n;
		this.phone=p;
		this.address=a;
		this.item=i;
		this.date=d;
		this.total=t;
	}
	
	public void setTradeno(String no)
	{
		this.tradeno=no;
	}
	
	public String getTradeno()
	{
		return tradeno;
	}
	
	public void setUsername(String un)
	{
		this.username=un;
	}
	
	public String getUsername()
	{
		return username;
	}
	
	public void setName(String n)
	{
		this.name=n;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setPhone(String p)
	{
		this.phone=p;
	}
	
	public String getPhone()
	{
		return phone;
	}
	
	public void setAddress(String a)
	{
		this.address=a;
	}
	
	public String getAddress()
	{
		return address;
	}
	
	public void setItem(String i)
	{
		this.item=i;
	}
	
	public String getItem()
	{
		return item;
	}
	
	public void setDate(String d)
	{
		this.date=d;
	}
	
	public String getDate()
	{
		return date;
	}
	
	public void setTotal(String t)
	{
		this.total=t;
	}
	
	public String getTotal()
	{
		return total;
	}

}
