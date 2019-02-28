package com.onlinechese.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import com.onlinechese.constant.Constant;
import com.onlinechese.entys.Rank;
import com.onlinechese.entys.UserInfo;
import com.onlinechese.entys.UserInfoExample;
import com.onlinechese.entys.UserInfoExample.Criteria;
import com.onlinechese.mapper.UserInfoMapper;
import com.onlinechese.service.RankService;
import com.onlinechese.service.UserInfoService;
import com.onlinechese.util.CookieUtils;
import com.onlinechese.util.Msg;
import com.onlinechese.vo.UserLogin;

import lombok.extern.slf4j.Slf4j;

@Service
public class UserInfoServiceimpl implements UserInfoService {

	@Autowired
	private RedisTemplate redisTemplate;
	@Autowired
	private RankService rankService;
	@Autowired
	private UserInfoMapper userInfoMapper;
	@Override
	public void addUser(UserInfo userInfo) {
		userInfoMapper.insert(userInfo);
		Rank rank = new Rank(null, userInfo.getUserName(), 0, 0, 0, 0, 0, 0, 0, 0, new Date(), new Date());
		rankService.addRank(rank);
	}
	@Override
	public Msg login(UserLogin userLogin,HttpServletResponse response) {
		UserInfo userInfo = getUserInfo(userLogin.getUserName());
		if(userInfo != null) {
			if(userInfo.getPassword().equals(userLogin.getPassword())) {
				//登录成功，写入cookie
				String uuid = Constant.PRE_USER_REDIS + UUID.randomUUID().toString();
				redisTemplate.opsForValue().set(uuid, userInfo);
				//写入cookie
				//CookieUtils.writeCookie(Constant.USER_COOKIE, uuid, response, 60*30*24);
				
				return Msg.success().add(Constant.USER_COOKIE, uuid);
			}else {
				return Msg.failLoginPassword();
			}
		}
		return Msg.failLoginNotUser();
	}
	
	@Override
	public UserInfo getUserInfo(String userName) {
		UserInfoExample example = new UserInfoExample();
		Criteria criteria = example.createCriteria();
		criteria.andUserNameEqualTo(userName);
		List<UserInfo> selectByExample = userInfoMapper.selectByExample(example);
		if(selectByExample.size() == 0)return null;
		return selectByExample.get(0);
	}
	@Override
	public Msg getUserByUserName(String userName) {
		UserInfoExample example = new UserInfoExample();
		Criteria criteria = example.createCriteria();
		criteria.andUserNameEqualTo(userName);
		List<UserInfo> userinfo = userInfoMapper.selectByExample(example);
		if(userinfo.size() != 0) {
			return Msg.success().add("userInfo", userinfo.get(0));
		}
		return Msg.fail();
	}
	@Override
	public UserInfo getUserOwn(String cookie) {
		UserInfo userInfo = (UserInfo) redisTemplate.opsForValue().get(cookie);
		return userInfo;
	}
	@Override
	public Msg getUser(String cookie) {
		return Msg.success().add("user", getUserOwn(cookie));
	}



}
