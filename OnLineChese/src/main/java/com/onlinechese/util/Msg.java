package com.onlinechese.util;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.onlinechese.constant.GameMessage;
import com.onlinechese.statecode.UserCode;

import lombok.Data;

@Data
public class Msg {

	//状态码
	private int code;
	//信息
	private String message;
	private Map<String, Object> data = new ConcurrentHashMap<>();
	
	public static Msg fail() {
		Msg msg = new Msg();
		msg.setCode(400);
		msg.setMessage("失败");
		return msg;
	}
	
	public static Msg success() {
		Msg msg = new Msg();
		msg.setCode(200);
		msg.setMessage("success");
		return msg;
	}
	
	public Msg add(String key,Object value) {
	    data.put(key, value);
		return this;
	}
	public static Msg failLoginPassword() {
		Msg msg = new Msg();
		msg.setCode(UserCode.FailPassword.getCode());
		msg.setMessage(UserCode.FailPassword.getMessage());
		return msg;
	}
	public static Msg failLoginNotUser() {
		Msg msg = new Msg();
		msg.setCode(UserCode.NotFindUser.getCode());
		msg.setMessage(UserCode.NotFindUser.getMessage());
		return msg;
	}
	public static Msg failUnLogin() {
		Msg msg = new Msg();
		msg.setCode(UserCode.UnLogin.getCode());
		msg.setMessage(UserCode.UnLogin.getMessage());
		return msg;
	}
	public static Msg failUnPlay() {
		Msg msg = new Msg();
		msg.setCode(GameMessage.UnPlay.getMessageCode());
		msg.setMessage(GameMessage.UnPlay.getMessage());
		return msg;
	}
	
	
}
