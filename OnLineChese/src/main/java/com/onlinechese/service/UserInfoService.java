package com.onlinechese.service;

import javax.servlet.http.HttpServletResponse;

import com.onlinechese.entys.UserInfo;
import com.onlinechese.util.Msg;
import com.onlinechese.vo.UserLogin;

public interface UserInfoService {
	void addUser(UserInfo userInfo);

	Msg login(UserLogin userLogin, HttpServletResponse response);
	
	UserInfo getUserInfo(String userName);

	Msg getUserByUserName(String userName);
	UserInfo getUserOwn(String cookie);
	Msg getUser(String cookie);
}
