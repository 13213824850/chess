package com.onlinechese.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.onlinechese.constant.Constant;
import com.onlinechese.entys.UserInfo;
import com.onlinechese.service.GameService;
import com.onlinechese.util.Msg;
import com.onlinechese.vo.CheckerBoardInfo;

@Service
public class GameServiceimpl implements GameService {

	@Autowired
	private RedisTemplate redisTemplate;
	@Override
	public Msg getCheckBoardInfo(String cookie) {
		if(StringUtils.isEmpty(cookie)) {
			return Msg.failUnLogin();
		}
		//获取用户信息
		UserInfo userInfo = (UserInfo) redisTemplate.opsForValue().get(cookie);
		if(StringUtils.isEmpty(userInfo)) {
			return Msg.failUnLogin();
		}
		//获取棋盘信息
		Long userId = userInfo.getUserId();
		CheckerBoardInfo checkerBoardInfo = (CheckerBoardInfo) redisTemplate.opsForValue().get(Constant.CHECKBOARD_INFO + userId);
		if(StringUtils.isEmpty(checkerBoardInfo)) {
			return Msg.failUnPlay();
		}
		//checkerBoardInfo.setOppseid(0l);
		return Msg.success().add("checkerBoardInfo", checkerBoardInfo);
	}
	

}
