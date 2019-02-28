package com.onlinechese.statecode;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserCode {

	NotFindUser("用户不存在",2),
	FailPassword("密码错误",1),
	UnLogin("未登录",3);
	private String message;
	private int code;
}
