package com.onlinechese.init;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import com.alibaba.fastjson.JSON;
import com.onlinechese.cheserules.CheseCode;
import com.onlinechese.cheserules.RuleUtil;
import com.onlinechese.componet.WsHandler;
import com.onlinechese.constant.Constant;
import com.onlinechese.constant.GameMessage;
import com.onlinechese.entys.GameList;
import com.onlinechese.vo.CheckerBoardInfo;
import com.onlinechese.vo.CheseIndex;
import com.onlinechese.vo.PlayInfo;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class EndApplicationStart implements CommandLineRunner {

	@Autowired
	WsHandler myHandler;
	@Resource
	RedisTemplate<String, Object> redisTemplate;
	// 匹配线程
	private static ScheduledExecutorService sec = Executors.newSingleThreadScheduledExecutor();
	private int match_Play_againTime = 2;// 间隔几秒匹配一次
	private int overTime = 180000;// 超时时间ms

	@Override
	public void run(String... args) throws Exception {
		log.info("开始匹配中");
		sec.scheduleWithFixedDelay(new Runnable() {

			@Override
			public void run() {
				log.debug("开始匹配");
				matchProcess(matchPool, GameMessage.MatchGame.getMessageCode());
				log.debug("开始rank");
				matchProcess(rankPool, GameMessage.RankGame.getMessageCode());
				log.debug("结束任务");
				//显示列表
				//showGameList();
			}
		}, 1, match_Play_againTime, TimeUnit.SECONDS);
		
		
	}

	protected void showGameList() {
		// TODO Auto-generated method stub
		
	}

	protected void matchProcess(Map<String, PlayInfo> pool, int matchType) {
		// 按照分数分布排序
		List<Map.Entry<String, PlayInfo>> lists = new ArrayList<Map.Entry<String, PlayInfo>>(pool.entrySet());
		lists.sort((pool1, pool2) -> pool1.getValue().getSorce() - pool2.getValue().getSorce());
		int len = lists.size();
		log.debug("匹配人数{}", len);
		long now = System.currentTimeMillis();
		for (int j = 0; j < len && lists.get(j).getValue() != null; j++) {
			PlayInfo playInfo = lists.get(j).getValue();
			if ((now - playInfo.getSeconds() >= overTime)) {
				log.debug("now -user{}", now - playInfo.getSeconds());
				log.warn("匹配超时");
				// 移除玩家
				pool.remove(playInfo.getSessionId());
				CheseIndex cheseIndex = new CheseIndex();
				cheseIndex.setMessageCode(GameMessage.MatchFail.getMessageCode());
				cheseIndex.setMessage(GameMessage.MatchFail.getMessage());
				TextMessage message = new TextMessage(JSON.toJSONString(cheseIndex));
				try {
					myHandler.sessionMap.get(myHandler.sessionIds.get(playInfo.getSessionId())).sendMessage(message);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				continue;
			}
			playInfo = pool.get(lists.get(j).getKey());
			log.debug("第{}playinfo{}", j, playInfo);
			int pre = j - 1, next = j + 1;
			// 由于分数是以低到高 所以按照当前玩家时间匹配
			// 获取等待时间 根据等待时间获取浮动分数
			int waitTime = (int) (now - playInfo.getSeconds());
			int floatSorce = getFloatSorce(waitTime, playInfo.getFloatSorce());
			log.debug("等待时间{}，浮动分数{}", waitTime, floatSorce);
			if (next < len) {
				PlayInfo playInfoNext = pool.get(lists.get(next).getKey());
				if (playInfoNext != null && playInfoNext.getSorce() - playInfo.getSorce() <= floatSorce) {
					// 取出两个玩家 //发送通知
					log.debug("next");
					initGame(playInfo.getSessionId(), playInfoNext.getSessionId(), matchType);
					lists.get(j).setValue(null);
					lists.get(next).setValue(null);
					pool.remove(playInfo.getSessionId());
					pool.remove(playInfoNext.getSessionId());
					log.debug("匹配success next");
				}
			} else if (pre >= 0) {
				PlayInfo playInfoPre = pool.get(lists.get(pre).getKey());
				if (playInfoPre != null && playInfoPre.getSorce() - playInfo.getSorce() <= floatSorce) {
					// 向前匹配
					// 取出两个玩家//发送通知
					log.debug("pre");
					initGame(playInfo.getSessionId(), playInfoPre.getSessionId(), matchType);
					lists.get(j).setValue(null);
					lists.get(pre).setValue(null);
					pool.remove(playInfo.getSessionId());
					pool.remove(playInfoPre.getSessionId());
					log.debug("匹配success");
				}
			}
		}

	}

	private int getFloatSorce(int waitTime, int sorce) {
		if (waitTime <= 10) {
			return sorce;
		} else if (waitTime <= 20) {
			// 增加分数段1.5倍
			return (int) (1.5 * sorce);
		} else if (waitTime <= 40) {
			return 2 * sorce;
		} else if (waitTime <= 80) {
			return 3 * sorce;
		} else {
			return 4 * sorce;
		}
	}

	public void initGame(String sessionidred, String sessionidback, int matchType) {
		log.info("初始化棋盘类型{}", matchType);
		// 初始化棋盘
		int[][] initCheckerboard = RuleUtil.initCheckerboard();
		// 棋盘数据存入redis中
		String checkerboardid = Constant.CHECKERBOARD_REDIS_ID + UUID.randomUUID().toString();
		redisTemplate.opsForValue().set(Constant.CHECKERBOARD_REDIS_ID + checkerboardid, initCheckerboard);
		// 一方执红棋，一方白旗
		CheckerBoardInfo info = new CheckerBoardInfo();
		info.setCheckerBoardID(checkerboardid);
		info.setCode(CheseCode.Red.getCode());
		info.setGameState(GameMessage.PlayIng.getMessageCode());
		info.setName(CheseCode.Red.getCheseName());
		info.setType(matchType);
		info.setOppUserName(myHandler.sessionIds.get(sessionidred));
		CheckerBoardInfo info1 = new CheckerBoardInfo();
		info1.setCheckerBoardID(checkerboardid);
		info1.setGameState(GameMessage.PlayIng.getMessageCode());
		info1.setCode(CheseCode.Back.getCode());
		info1.setName(CheseCode.Back.getCheseName());
		info1.setType(matchType);
		// info1.setOppNickName(oppNickName);
		info1.setOppUserName(myHandler.sessionIds.get(sessionidback));
		redisTemplate.opsForValue().set("turnMe:" + checkerboardid, true);
		redisTemplate.opsForValue().set(Constant.CHECKBOARD_INFO + info1.getOppUserName(), info);
		redisTemplate.opsForValue().set(Constant.CHECKBOARD_INFO + info.getOppUserName(), info1);
		// 向客户端发送数据
		CheseIndex cheseIndex = new CheseIndex();
		cheseIndex.setMessageCode(200);
		TextMessage message = new TextMessage(JSON.toJSONString(cheseIndex));
		try {
			myHandler.sessionMap.get(myHandler.sessionIds.get(sessionidred)).sendMessage(message);
			myHandler.sessionMap.get(myHandler.sessionIds.get(sessionidback)).sendMessage(message);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 添加到游戏gamelist
		//GameList gameList = new GameList();
		//gameList.setBlackNickName(info1.get);
	}

	/*
	 * public static void putQuene(String sessionId) { try {
	 * matchQueue.put(sessionId); } catch (InterruptedException e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); } }
	 */

	public static Map<String, PlayInfo> matchPool = new ConcurrentHashMap<>();
	public static Map<String, PlayInfo> rankPool = new ConcurrentHashMap<>();

	public static void addMatchPlay(String sessionId, PlayInfo playInfo) {
		matchPool.put(sessionId, playInfo);
	}

	public static void removeMatchPlay(String sessionId) {
		matchPool.remove(sessionId);
	}

	public static void addRankPlay(String sessionId, PlayInfo playInfo) {
		rankPool.put(sessionId, playInfo);
	}

	public static void removeRatchPlay(String sessionId) {
		rankPool.remove(sessionId);
	}

	public static boolean getMatchPlay(String sessionId) {
		if (matchPool.get(sessionId) != null) {
			return true;
		} else {
			return false;
		}
	}


	public void sendMessage(WebSocketSession session, Object object) {
		if (session != null && session.isOpen()) {
			String jsonString = JSON.toJSONString(object);
			try {
				session.sendMessage(new TextMessage(jsonString));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
