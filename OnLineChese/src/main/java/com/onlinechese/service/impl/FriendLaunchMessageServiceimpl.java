package com.onlinechese.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinechese.entys.Friend;
import com.onlinechese.entys.FriendLaunchMessage;
import com.onlinechese.entys.FriendLaunchMessageExample;
import com.onlinechese.entys.FriendLaunchMessageExample.Criteria;
import com.onlinechese.entys.UserInfo;
import com.onlinechese.mapper.FriendLaunchMessageMapper;
import com.onlinechese.service.FriendLaunchMessageService;
import com.onlinechese.service.FriendService;
import com.onlinechese.service.UserInfoService;
import com.onlinechese.util.Msg;
@Service
public class FriendLaunchMessageServiceimpl implements FriendLaunchMessageService{

	@Autowired
	private FriendLaunchMessageMapper friendLaunchMessageMapper;

	@Autowired
	private UserInfoService userInfoService;
	
	@Autowired
	private FriendService friendService;
	@SuppressWarnings("unused")
	@Override
	public Msg addMessage(String launchUserName, String userName) {
		//查询是否已存在
		FriendLaunchMessageExample example = new FriendLaunchMessageExample();
		Criteria criteria = example.createCriteria();
		criteria.andLaunchUserNameEqualTo(userName);
		criteria.andUserNameEqualTo(userName);
		List<FriendLaunchMessage> selectByExample = friendLaunchMessageMapper.selectByExample(example);
		if(selectByExample.size() != 0) {
			return Msg.fail().add("message", "请求已发送过");
		}
		//判断是否已经是好友
		Friend friend = friendService.getFriend(launchUserName, userName);
		if(friend != null) {
			return Msg.fail().add("message", "你俩已经是好友了，请勿添加");
		}
		UserInfo userInfo = userInfoService.getUserInfo(userName);
		userInfo.setPassword(null);
		if(userInfo == null) {
			return Msg.fail().add("message", "添加的好友不存在");
		}
		UserInfo launchUser = userInfoService.getUserInfo(launchUserName);
		FriendLaunchMessage launchMessage = new FriendLaunchMessage();
		launchMessage.setLaunchUserName(launchUser.getUserName());
		launchMessage.setUserName(userInfo.getUserName());
		launchMessage.setSex(userInfo.getSex());
		launchMessage.setLaunchNickName(launchUser.getNickName());
		launchMessage.setNickName(userInfo.getNickName());
		launchMessage.setLaunchSex(launchUser.getSex());
		launchMessage.setState(0);
		launchMessage.setCreated(new Date());
		launchMessage.setUpdated(new Date());
		friendLaunchMessageMapper.insert(launchMessage);
		return Msg.success().add("launchUserInfo", launchUser).add("userInfo", userInfo);
		
	}
	@Override
	public Msg updateFriendMessage(int state, String launchUserName, String cookie) {
		UserInfo userInfo = userInfoService.getUserOwn(cookie);
		String userName = userInfo.getUserName();
		FriendLaunchMessageExample friendLaunchMessageExample = new FriendLaunchMessageExample();
		Criteria criteria = friendLaunchMessageExample.createCriteria();
		criteria.andUserNameEqualTo(userName);
		criteria.andLaunchUserNameEqualTo(launchUserName);
		criteria.andStateEqualTo(0);
		List<FriendLaunchMessage> friendLaunchMessages = friendLaunchMessageMapper.selectByExample(friendLaunchMessageExample);
		if(friendLaunchMessages.size() == 0) {
			return Msg.fail().add("message", "不存在的记录");
		}
		FriendLaunchMessage friendLaunchMessage = friendLaunchMessages.get(0);
		friendLaunchMessage.setState(state);
		if(state == 1) {
			//同意添加好友关系
			friendService.addFriend(friendLaunchMessage);
		}
		friendLaunchMessageMapper.updateByPrimaryKeySelective(friendLaunchMessage);
		return Msg.success();
	}


}
