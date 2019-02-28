package com.onlinechese.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/*
 * 段位的一些基本信息
 */
@Getter
@AllArgsConstructor
public enum RankMessage {
	Zero("无段位",0,0,0,30),
	Broze("青铜",1,3,3,30),
	Silver("白银",2,3,3,90+30),
	Gold("黄金",3,4,4,30+90),
	Platinum("铂金",4,4,4,40+160),
	Diamond("钻石",5,5,5,40+160),
	Master("大师",6,5,5,50+250),
	TheKing("最强王者",7,0,0,50+250);
	/*BrozeSilverGold("请白黄",8,0,0,0),
	GoldPlatinum("黄 铂晶",9,0,0,0),
	PlatinumDiamond("铂金钻石",10,0,0,0),
	DiamondMaster("钻石 大师",11,0,0,0),
	MasterTheKin("大师王者",12,0,0,0);*/
	//段位名称
	private String rankName;
	private int rankGrade;
	//段位有几小阶
	private int stage;
	//段位进阶所需几颗星
	private int star;
	//rank分时需要额外加多少分
	private int gradeSorce;
	public static RankMessage matchRankMessage(int rankGrade) {
		for(RankMessage rk : RankMessage.values()) {
			if(rk.getRankGrade() == rankGrade) {
				return rk;
			}
		}
		return null;
	}
}
