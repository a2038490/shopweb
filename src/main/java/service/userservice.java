package service;

import bean.user;
import Dao.UserDao;

public class userservice {
	
	private UserDao userdao=new UserDao();
	
	public static class LoginStatus
	{
		public static final int success=1;
		public static final int invalid_password=2;
		public static final int user_not_found=3;
	}
	
	public boolean Register(user user1)
	{
		boolean bo1=false;
		user u1=userdao.findByUsername(user1.getUsername());
		if(u1==null)
		{
			userdao.add(user1);
			bo1=true;
		}
		return bo1;
	}
	
	public int Login(user user2)
	{
		int loginstatus;
		user u2=userdao.findByUsername(user2.getUsername());
		if(u2!=null)
		{
			String password=user2.getPassword();
			if(password.equals(u2.getPassword()))
			{
				loginstatus=LoginStatus.success;
			}
			else
			{
				loginstatus=LoginStatus.invalid_password;
			}
		}
		else
		{
			loginstatus=LoginStatus.user_not_found;
		}
		
		return loginstatus;
	}
	
	public void update(user user)
	{
			userdao.update(user);;
	}
	
}

