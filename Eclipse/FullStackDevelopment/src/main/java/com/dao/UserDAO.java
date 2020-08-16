package com.dao;

import com.dto.User;
import com.ts.db.HibernateTemplate;

public class UserDAO {
	
	public int register(User user) {
		System.out.println("Inside User registration");
		return HibernateTemplate.addObject(user);
	}
	public User getUserByMailId(String mailId, String password) {

		return (User)HibernateTemplate.getObjectByUserMail(mailId,password);
	}
	


}
