package bean;

import java.util.Objects;

public class product {
	private int id;
	private String name;
	private int price;
	private String describe;
	private String picture;
	
	public product(int id,String name,int price,String describe,String picture)
	{
		this.id=id;
		this.name=name;
		this.price=price;
		this.describe=describe;
		this.picture=picture;
	}
	
	public void setId(int id)
	{
		this.id=id;
	}
	
	public int getId()
	{
		return id;
	}
	
	public void setName(String name)
	{
		this.name=name;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setPrice(int price)
	{
		this.price=price;
	}
	
	public int getPrice()
	{
		return price;
	}
	
	public void setDescribe(String describe)
	{
		this.describe=describe;
	}

	public String getDescribe()
	{
		return describe;
	}
	public void setPicture(String picture)
	{
		this.picture=picture;
	}
	public String getPicture()
	{
		return picture;
	}
	@Override
	public int hashCode()
	{
		return Objects.hash(id+name+price+describe+picture);
	}
	@Override
	public boolean equals(Object obj)
	{
		if(this == obj) 
		{
			return true;
		}
		if(obj == null || getClass() != obj.getClass()) 
		{
			return false;
		}
		product other=(product)obj;
		return (id == other.id) 
				&& Objects.equals(name, other.name) 
				&& (price == other.price)
				&& Objects.equals(describe, other.describe)
				&& Objects.equals(picture, other.picture);
	}
}
