package com.onlinechese.sso.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserService implements UserDetailsService {

	@Autowired
	UserDao userDao;
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		return (UserDetails) userDao.findbyUserName(userName);
	}

}
