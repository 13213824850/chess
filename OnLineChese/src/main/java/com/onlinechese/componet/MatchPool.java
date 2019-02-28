package com.onlinechese.componet;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;

import com.onlinechese.constant.RankMessage;
import com.onlinechese.entys.Rank;

@Component
public class MatchPool {
	// 青铜 白银
	/*public static Map<String, Rank> brozeSilverMap = new ConcurrentHashMap<>();
	// 黄金3-4
	//public static Map<String, Rank> goldMapThreeMap = new ConcurrentHashMap<>();
	// 黄金1-2
	public static Map<String, Rank> goldMap = new ConcurrentHashMap<>();
	//黄金 白银 青铜
	public static Map<String, Rank> brozeSilverGoldMap = new ConcurrentHashMap<>();
	// 铂金3-4
	//public static Map<String, Rank> platinumThreeMap = new ConcurrentHashMap<>();
	// 铂金1-2
	public static Map<String, Rank> platinumMap = new ConcurrentHashMap<>();
	//铂晶 黄金
	public static Map<String, Rank> platinumGoldMap = new ConcurrentHashMap<>();
	// 砖石4-5
	//public static Map<String, Rank> diamondFourthMap = new ConcurrentHashMap<>();
	// 砖石1-3
	public static Map<String, Rank> diamondMap = new ConcurrentHashMap<>();
	//砖石 铂金
	public static Map<String, Rank> diamondPlatinumMap = new ConcurrentHashMap<>();
	// 大师4-5
	public static Map<String, Rank> masterMap = new ConcurrentHashMap<>();
	//大师 砖石
	public static Map<String, Rank> masterDiamondMap = new ConcurrentHashMap<>();
	// 大师1-3
	//public static Map<String, Rank> masterFirstMap = new ConcurrentHashMap<>();
	// 最强王者
	public static Map<String, Rank> theKingMap = new ConcurrentHashMap<>();
	
	//大师以上
	public static Map<String, Rank> theKingMasterMap = new ConcurrentHashMap<>();
	
	
	public static void addMatchPool(String sessionId, Rank rank) {
		RankMessage rk = RankMessage.matchRankMessage(rank.getRankGrade());
		switch(rk) {
		case Broze: brozeSilverMap.put(sessionId, rank);break;
		case Silver:brozeSilverMap.put(sessionId, rank);break;
		case Gold : goldMap.put(sessionId, rank);break;
		case BrozeSilverGold : brozeSilverGoldMap.put(sessionId, rank); break;
		case Platinum : platinumMap.put(sessionId, rank);break;
		case GoldPlatinum: platinumGoldMap.put(sessionId, rank);break;
		case Diamond : diamondMap.put(sessionId, rank);break;
		case PlatinumDiamond : diamondPlatinumMap.put(sessionId, rank);break;
		case Master : masterMap.put(sessionId, rank);break;
		case DiamondMaster : masterDiamondMap.put(sessionId, rank);break;
		case TheKing : theKingMap.put(sessionId, rank);break;
		case MasterTheKin: theKingMasterMap.put(sessionId, rank);break;
		}
	}*/
	
}
