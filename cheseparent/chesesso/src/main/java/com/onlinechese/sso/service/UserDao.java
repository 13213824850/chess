package com.onlinechese.sso.service;

public class UserDao  {
	UserInfo findbyUserName(String userName) {
		UserInfo user = new UserInfo();
		user.setUserId(1l);
		user.setUserName("123456");
		user.setPassword("123456");
		return user;
	}
}
