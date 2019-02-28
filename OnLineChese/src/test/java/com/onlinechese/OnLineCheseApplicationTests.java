package com.onlinechese;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.onlinechese.constant.Constant;
import com.onlinechese.entys.UserInfo;
import com.onlinechese.mapper.UserInfoMapper;
import com.onlinechese.vo.CheckerBoardInfo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OnLineCheseApplicationTests {

	@Autowired
	RedisTemplate redisTemplate;
	
	@Test
	public void contextLoads() {
		//CheckerBoardInfo info = new CheckerBoardInfo();
		//info.setCheckerBoardID("3");
		//Long leftPush = redisTemplate.opsForList().leftPush(Constant.GameList,info);
		 Object leftPop = redisTemplate.opsForList().index(Constant.GameList, 3);
		System.out.println("leftPush" + leftPop);
	}

}
