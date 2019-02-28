package com.onlinechese.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FriendInfo {

	private String friendUserName;
	private String friendNickName;
	private Byte sex;
	//状态0 离线 1在线 2游戏中
	private int state;
	private String lastLoginTime;
}
