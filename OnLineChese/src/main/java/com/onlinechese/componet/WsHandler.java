package com.onlinechese.componet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.alibaba.fastjson.JSON;
import com.onlinechese.constant.Constant;
import com.onlinechese.constant.GameMessage;
import com.onlinechese.entys.Rank;
import com.onlinechese.entys.UserInfo;
import com.onlinechese.init.EndApplicationStart;
import com.onlinechese.init.MatchGame;
import com.onlinechese.service.FriendService;
import com.onlinechese.service.RankService;
import com.onlinechese.vo.CheseIndex;
import com.onlinechese.vo.FriendInfo;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class WsHandler extends TextWebSocketHandler {

	// 静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
	private static int onlineCount = 0;
	public static Map<String, String> sessionIds = new ConcurrentHashMap<>();
	public static Map<String, WebSocketSession> sessionMap = new ConcurrentHashMap<>();

	@Resource
	private RedisTemplate<String, Object> redisTemplate;

	@Autowired
	private RankService rankService;
	@Autowired
	private FriendService friendService;

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		// 删除在线信息
		redisTemplate.delete(Constant.ONLINE + sessionIds.get(session.getId()));
		sessionMap.remove(sessionIds.get(session.getId()));
		sessionIds.remove(session.getId());
		session.getId();
		subOnlineCount();
		// 判断匹配对局中有没有值
		EndApplicationStart.removeMatchPlay(session.getId());
		log.info("断开连接");
	}

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		String url = session.getUri().toString();
		String cookieId = url.substring(url.lastIndexOf("/") + 1);
		log.info("cookie{}", cookieId);
		if (!StringUtils.isEmpty(cookieId)) {
			UserInfo userInfo = (UserInfo) redisTemplate.opsForValue().get(cookieId);
			if (!StringUtils.isEmpty(userInfo)) {
				String userName = userInfo.getUserName();
				log.info("建立连接");
				addOnlineCount(); // 在线数加1
				sessionIds.put(session.getId(), userName);
				sessionMap.put(userName, session);
				// 显示好友
				List<FriendInfo> showFriends = friendService.ShowFriends(session, sessionIds);
				CheseIndex cheseIndex = new CheseIndex();
				cheseIndex.setMessageCode(GameMessage.ShowFriends.getMessageCode());
				Map<String, Object> friendsMap = new HashMap<>();
				friendsMap.put("showFriends", showFriends);
				cheseIndex.setMap(friendsMap);
				sendMessage(session, cheseIndex);
				// 向缓存中放入在线信息
				redisTemplate.opsForValue().set(Constant.ONLINE + userName, 1);
				log.info("有新连接加入！当前在线人数为" + getOnlineCount());
				log.info("当前接入的id是{} sessionid{}", userName, session.getId());
			}

		}

	}

	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		log.info("接受消息");
		String msg = message.getPayload();
		log.info(msg);
		CheseIndex cheseIndex = JSON.toJavaObject(JSON.parseObject(msg), CheseIndex.class);
		log.info("cheseindex:{}", cheseIndex);
		// 判断消息类型
		GameMessage gm = GameMessage.matchCode(cheseIndex.getMessageCode());
		switch (gm) {
		case MatchGame:
			Rank rank = rankService.getRank(sessionIds.get(session.getId()));
			MatchGame.matchGame(session.getId(), rank);
			break;// 匹配对局
		case RankGame:
			Rank rankGame = rankService.getRank(sessionIds.get(session.getId()));
			MatchGame.rankGame(session.getId(), rankGame);
			break;
		default:
			break;
		}
	}

	@Override
	public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
		super.handleMessage(session, message);
	}

	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
		super.handleTransportError(session, exception);
	}

	public static synchronized int getOnlineCount() {
		return onlineCount;
	}

	public static synchronized void addOnlineCount() {
		WsHandler.onlineCount++;
	}

	public static synchronized void subOnlineCount() {
		WsHandler.onlineCount--;
	}

	public void sendMessage(WebSocketSession session, Object object) {
		String jsonString = JSON.toJSONString(object);
		if (session != null && session.isOpen()) {
			try {
				session.sendMessage(new TextMessage(jsonString));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
