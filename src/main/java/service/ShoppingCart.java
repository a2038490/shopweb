package service;

import java.util.HashMap;
import bean.product;
import bean.cartitem;
import Dao.CartDao;

public class ShoppingCart {
	
	private int num;
	private HashMap<product,Integer> pm=null;
	private CartDao cd=new CartDao();
	
	//添加商品
	public HashMap addProduct(HashMap<product,Integer> m,product p,int n,String u)
	{
		pm=m;
		if(pm.containsKey(p))
		{
			num=pm.get(p)+n;
			pm.put(p, num);
			cartitem cart=new cartitem(u,p.getId(),num);
			cd.updatecart(cart);
		}
		else
		{
			pm.put(p, n);
			cartitem cart=new cartitem(u,p.getId(),n);
			cd.addcart(cart);
		}
		return pm;
	}
	
	//刪除商品
	public HashMap<product,Integer> removeProduct(HashMap<product,Integer> m,product p,int n,String u)
	{
		pm=m;
		if(pm.containsKey(p)){
			num=pm.get(p);
		}
		else {
			System.out.println("找步道對應的product物件: "+p);
		}
		for(product key:pm.keySet()) {
			System.out.println(key);
		}
		if(n>=num)
		{
			pm.remove(p);
			cartitem cart=new cartitem(u,p.getId(),0);
			cd.deletecart(cart);
		}
		else
		{
			num=num-n;
			pm.put(p, num);
			cartitem cart=new cartitem(u,p.getId(),num);
			cd.updatecart(cart);
		}			
		return pm;
	}
	
	//清空購物車
	public HashMap<product,Integer> clear(HashMap<product,Integer> m,String u)
	{
		pm=m;
		pm.clear();
		cd.clearcart(u);
		return pm;
	}
	
	/*檢視清單
	public void print(HashMap<product,Integer> m)
	{
		if(m.size()<=0)
		{
			System.out.println("目前購物車並沒有商品");
			return;
		}
		else
		{
			System.out.println("訂單內容:\n");
			for(product p:m.keySet())
			{
				String id=p.getId();
				String name=p.getName();
				int price=p.getPrice();
				String describe=p.getDescribe();
				int num=m.get(p);
				int subtotal=price*num;
				System.out.println("商品編號: "+id+"\t商品名稱: "+name+"\t商品價格: "+price
									+"\t商品介紹: "+describe+"\t數量: "+num+"\t小計: "+subtotal);
				total=total+subtotal;
			}
			System.out.println("\n總計: "+total);
		}
	}
*/
}

