package com.onlinechese.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class PlayInfo {
	//
	private String sessionId;
	//段位分数
	private int sorce;
	//开始等待的时间
	private long seconds;
	//浮动分数初始值为一个段位
	private int floatSorce;
}
