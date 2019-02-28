package com.onlinechese.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.WebSocketSession;

import com.github.pagehelper.PageHelper;
import com.onlinechese.constant.Constant;
import com.onlinechese.entys.Friend;
import com.onlinechese.entys.FriendExample;
import com.onlinechese.entys.FriendExample.Criteria;
import com.onlinechese.entys.FriendLaunchMessage;
import com.onlinechese.mapper.FriendMapper;
import com.onlinechese.service.FriendService;
import com.onlinechese.util.Msg;
import com.onlinechese.util.TimeUtil;
import com.onlinechese.vo.FriendInfo;
@Service
public class FriendServiceimpl implements FriendService{

	@Autowired
	FriendMapper friendMapper;
	@Resource
	RedisTemplate<String, Object> redisTemplate;
	@Override
	public Msg getFriends(String userName, Integer pn) {
		PageHelper.startPage(pn, Constant.PageSize);
		FriendExample friendExample = new FriendExample();
		Criteria criteria = friendExample.createCriteria();
		criteria.andUserNameEqualTo(userName);
		List<Friend> friends = friendMapper.selectByExample(friendExample);
		return Msg.success().add("friends", friends);
	}
	@Override
	public Msg addFriend(FriendLaunchMessage friendLaunchMessage) {
		Date date = new Date();
		Friend friend = new Friend();
		friend.setUserName(friendLaunchMessage.getUserName());
		friend.setFriendName(friendLaunchMessage.getLaunchUserName());
		friend.setFriendNickName(friendLaunchMessage.getLaunchNickName());
		friend.setCreated(date);
		friend.setUpdated(date);
		friend.setFriendSex(friendLaunchMessage.getLaunchSex());
		Friend friendopp = new Friend();
		friendopp.setUserName(friendLaunchMessage.getLaunchUserName());
		friendopp.setFriendNickName(friendLaunchMessage.getNickName());
		friendopp.setFriendName(friendLaunchMessage.getUserName());
		friendopp.setCreated(date);
		friendopp.setFriendSex(friendLaunchMessage.getSex());
		friendopp.setUpdated(date);;
		friendMapper.insert(friendopp);
		friendMapper.insert(friend);
		return Msg.success();
	}
	@Override
	public Msg deleteFriend(String userName, String friendUserName) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Friend getFriend(String userName, String friendUserName) {
		FriendExample friendExample = new FriendExample();
		Criteria criteria = friendExample.createCriteria();
		criteria.andUserNameEqualTo(userName);
		criteria.andFriendNameEqualTo(friendUserName);
		List<Friend> friends = friendMapper.selectByExample(friendExample);
		return friends.size() == 0 ? null : friends.get(0);
	}
	@Override
	public List<Friend> getFriends(String userName) {
		FriendExample friendExample = new FriendExample();
		Criteria criteria = friendExample.createCriteria();
		criteria.andUserNameEqualTo(userName);
		friendExample.setOrderByClause("'updated' ASC");
		List<Friend> friends = friendMapper.selectByExample(friendExample);
		return friends;
	}
	
	@Override
	public List<FriendInfo> ShowFriends(WebSocketSession session, Map<String, String> map) {
		//查询好友信息
		String userName = map.get(session.getId());
		List<Friend> friends = getFriends(userName);
		List<FriendInfo> friendLlistInfos = new ArrayList<>();
		Date dateNow =  new Date();
		friends.forEach((friend) -> {
			FriendInfo friendInfo = null;
			String friendUserName = friend.getFriendName();
			int state;
			String differTime = null;
			Object object = redisTemplate.opsForValue().get(Constant.ONLINE + friendUserName);
			//查询是否在线s
			if( object != null  ) {
				state = (int) object;
			}else {
				state = 0;
				//设置最后登录时间距离现在多远
				Date date = friend.getUpdated();
				differTime = TimeUtil.getDifferTime(dateNow, date);
			}
			friendInfo = new FriendInfo(friendUserName, friend.getFriendNickName(),
					friend.getFriendSex(), state, differTime);
			friendLlistInfos.add(friendInfo);
		});
		friendLlistInfos.sort((f1, f2) -> f1.getState() - f2.getState());
		//将信息存入缓存中
		return friendLlistInfos;
	}

}
