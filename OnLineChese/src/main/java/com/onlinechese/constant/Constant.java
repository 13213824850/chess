package com.onlinechese.constant;

public class Constant {

	//存入用户信息到 redis中的前缀
	public static final String PRE_USER_REDIS = "user:";
	//存入客户端cookie 对应redis用户信息key
	public static final String USER_COOKIE = "usercookie";
	//棋盘存入redis的key
	public static final String CHECKERBOARD_REDIS_ID = "checkerboardID:";
	//棋盘 用户信息
	public static final String CHECKBOARD_INFO = "CheckerBoardInfo:";
	public static final int PageSize = 5;
	//游戏用户在线
	public static final String ONLINE = "online:";
	//游戏对局列表
	public static final String GameList = "GameList:";
}
