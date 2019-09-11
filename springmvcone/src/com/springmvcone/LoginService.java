package com.springmvcone;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("loginService")
public class LoginService {
	
	@Autowired
	private LoginDAO loginDAO;
	
	public boolean check(String name,String password)
	{
		List<User> u=loginDAO.findAll();
		boolean b=false;
		for (User user : u) {
			System.out.println(user.getName()+user.getPass());
			if(user.getName().equals(name)&&user.getPass().equals(password))
			{
				b=true;
				break;
			}
		}
		return b;
	}

}
