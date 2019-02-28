package com.onlinechese.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.socket.WebSocketSession;

import com.onlinechese.entys.Friend;
import com.onlinechese.entys.FriendLaunchMessage;
import com.onlinechese.util.Msg;
import com.onlinechese.vo.FriendInfo;

public interface FriendService {

	Msg getFriends(String userName, Integer pn);
	List<Friend> getFriends(String userName);
	Msg addFriend(FriendLaunchMessage friendLaunchMessage);
	Msg deleteFriend(String userName, String friendUserName);
	Friend getFriend(String userName, String friendUserName);
	public List<FriendInfo> ShowFriends(WebSocketSession session, Map<String, String> map) ;
}
