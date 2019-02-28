package com.onlinechese.controler;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinechese.entys.UserInfo;
import com.onlinechese.service.UserInfoService;
import com.onlinechese.util.Msg;
import com.onlinechese.vo.UserLogin;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserInfoControllelr {

	@Autowired
	private UserInfoService userInfoService;
	
	@ApiOperation(value="添加用户",notes="")
	@PostMapping("/register")
	public Msg addUser(UserInfo userInfo) {
		userInfoService.addUser(userInfo);
		return Msg.success();
	}
	
	@PostMapping("/login")
	public Msg login(UserLogin userLogin, HttpServletResponse response) {
		Msg msg = userInfoService.login(userLogin, response);
		return msg;
	}
	@GetMapping("/getUserInfo/{userName}")
	public Msg getUserById(@PathVariable("userName") String userName) {
		return userInfoService.getUserByUserName(userName);
	}
	@GetMapping("/getUser/{cookie}")
	public Msg getUser(@PathVariable("cookie") String cookie) {
		return userInfoService.getUser(cookie);
	}
	
}
