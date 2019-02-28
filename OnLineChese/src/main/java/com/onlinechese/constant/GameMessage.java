package com.onlinechese.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum GameMessage {

	//匹配对局
	MatchGame(101,"匹配对局"),
	ChesesMove(102,"棋子移动"),
	RankGame(103,"排位赛"),
	FriendsGame(104,"好友对战"),
	CheseMoveErr(103,"棋子移动不符规则"),
	InitGame(200,"游戏初始化成功，开始对局"),
	againConnection(201,"掉线重连"),
	MatchFail(202,"匹配失败"),
	UnPlay(301,"未找到匹配对局"),
	RedWin(401,"红方胜利"),
	BackWin(402,"黑色方胜利"),
	PlayIng(400,"游戏进行中"),
	JiangJun(403,"将军"),
	LaunchFriend(501,"添加好友"),
	ResiveLaunchFriend(502,"接收添加好友请求"),
	ShowFriends(503,"显示好友"),
	ShowGameList(504,"显示对局列表");
	
	//状态码
	private int messageCode;
	private String message;
	
	public static GameMessage matchCode(int messageCode) {
		for(GameMessage gm : GameMessage.values()) {
			if(gm.getMessageCode() == messageCode) {
				return gm;
			}
		}
		return null;
	}
}
