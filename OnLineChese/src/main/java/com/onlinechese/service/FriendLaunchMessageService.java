package com.onlinechese.service;

import com.onlinechese.util.Msg;

public interface FriendLaunchMessageService {

	/*
	 * @param launchUserNAme 发起者  userName接收者
	 */
	public Msg addMessage(String launchUserName, String userName);
	//改变消息状态 state 1同意 2拒绝
	public Msg updateFriendMessage(int state, String launchUserName, String cookie);
}
