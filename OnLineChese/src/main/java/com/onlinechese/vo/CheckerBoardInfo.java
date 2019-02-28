package com.onlinechese.vo;

import java.io.Serializable;

import org.springframework.web.socket.WebSocketSession;

import lombok.Data;

@Data
public class CheckerBoardInfo implements Serializable{


	//棋颜色
	private int code;
	//棋颜色
	private String name;
	private String checkerBoardID;
	//棋盘另用户userName
	private String oppUserName;
	//棋盘另用户昵称
	//private String oppNickName;
	//棋盘状态
	private int gameState;
	//对局类型
	private int type;
}
