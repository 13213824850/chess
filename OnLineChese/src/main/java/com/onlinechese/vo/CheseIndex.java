package com.onlinechese.vo;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import lombok.Data;

/*
 * 棋子传入服务器的数据
 */
@Data
public class CheseIndex implements Serializable {

	private int messageCode;
	private int startX;
	private int startY;
	private int endX;
	private int endY;
	//棋子code
	private int code;
	private String message;
	private boolean turnMe;//轮到哪方落棋true 红 false黑
	private int gameState;
	private Map<String, Object> map= new HashMap<>(); 
	public  CheseIndex add(String key,Object value) {
		map.put(key, value);
		return this;
	}
		
	
}
