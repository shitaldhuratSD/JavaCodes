package com.dev.services;

import com.dev.bean.User;
import com.testyantra.dev.dob.UserDAOJDBCImpl;
import com.testyantra.dev.dob.UserInfoDAO;

public class UserServiceImpl implements UserServices {

	UserInfoDAO dao = new UserDAOJDBCImpl();

	@Override
	public User getAllInfo() {
		return dao.getAllInfo();
	}

	@Override
	public void createProfile(User user) {
		dao.createProfile(user);
	}

	}


