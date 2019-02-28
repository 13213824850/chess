package com.onlinechese.left;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.Resource;
import javax.websocket.OnClose;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import com.onlinechese.cheserules.CheseCode;
import com.onlinechese.cheserules.RuleUtil;
import com.onlinechese.constant.Constant;

import lombok.extern.slf4j.Slf4j;

@ServerEndpoint(value = "/websocket/{id}",configurator = MyEndpointConfigure.class)
@Component
@Slf4j
public class MyWebSocket {
    //静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
    public static int onlineCount = 0;

    //concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。
    public static Map<Session, String> sessionMap = new ConcurrentHashMap<>();
    //与某个客户端的连接会话，需要通过它来给客户端发送数据
    //private Session session;

    @Autowired
    private RedisTemplate redisTemplate;
    /**
     * 连接建立成功调用的方法*/
    @OnOpen
    public void onOpen(Session session, @PathParam("id") String id) {
    	addOnlineCount(); //在线数加1
    	sessionMap.put(session, id);
    	 log.info("有新连接加入！当前在线人数为" + getOnlineCount());
         log.info("当前接入的id是{}",id);
    	//初始化棋盘
    	if(onlineCount == 2) {
    		int[][] initCheckerboard = RuleUtil.initCheckerboard();
    		//棋盘数据存入redis中
    		String checkerboardid = Constant.CHECKERBOARD_REDIS_ID + UUID.randomUUID().toString();
    		redisTemplate.opsForValue().set(checkerboardid, initCheckerboard);
    		//一方执红棋，一方白旗
    		for(String key : sessionMap.values()) {
    			redisTemplate.opsForValue().set(key, CheseCode.Red.getCode() + ":" + checkerboardid);
    		}

    	}
                  
       
//        try {
//            sendMessage("有新连接加入！当前在线人数为" + getOnlineCount());
//        } catch (IOException e) {
//            System.out.println("IO异常");
//        }
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose(Session session) {
        sessionMap.remove(session);  //从set中删除
        subOnlineCount();           //在线数减1
        log.info("有一连接关闭！当前在线人数为" + getOnlineCount());
    }

    /**
     * 收到客户端消息后调用的方法
     *
     * @param message 客户端发送过来的消息*/
   /* @OnMessage
    public void onMessage(String message, Session session) throws IOException {
        message = "来自客户端的消息:" + message;
        log.info(message);
        try {
            sendMessage( message);
        } catch (IOException e) {
            log.error("onMessage方法异常"+e.toString());
            e.printStackTrace();
        }
        //群发消息
//        sendInfo("群发消息"+message);
    }

    *//**
     * 发生错误时调用
     @OnError
     **//*
     public void onError(Session session, Throwable error) {
         log.error("onMessage方法异常"+error.toString());
         error.printStackTrace();
     }


    *//**
     * 发送消息需注意方法加锁synchronized，避免阻塞报错
     * 注意session.getBasicRemote()与session.getAsyncRemote()的区别
     * @param message
     * @throws IOException
     *//*
     public synchronized void sendMessage(String message) throws IOException {
//         this.session.getBasicRemote().sendText(message);
        this.session.getAsyncRemote().sendText(message);
     }


     *//**
      * 群发自定义消息
      * *//*
    public static void sendInfo(String message) throws IOException {
        for (MyWebSocket item : webSocketSet) {
            try {
                item.sendMessage(message);
            } catch (IOException e) {
                continue;
            }
        }
    }*/

    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    public static synchronized void addOnlineCount() {
        MyWebSocket.onlineCount++;
    }

    public static synchronized void subOnlineCount() {
        MyWebSocket.onlineCount--;
    }
}
