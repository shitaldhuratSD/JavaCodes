package com.dev.operations;

import com.dev.services.UserServiceImpl;
import com.dev.services.UserServices;

public class GetAllInfo {

	public static void main(String[] args) {
		UserServices us = new UserServiceImpl();
		us.getAllInfo();
	}

}
