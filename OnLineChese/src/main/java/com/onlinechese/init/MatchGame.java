package com.onlinechese.init;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.onlinechese.constant.RankMessage;
import com.onlinechese.entys.Rank;
import com.onlinechese.vo.PlayInfo;

//青铜 白银局
public class MatchGame {

	public static Map<String, PlayInfo> map = new ConcurrentHashMap<>();

	public static void matchGame(String sessionId, Rank rank) {
		// 将玩家放入匹配池中
		PlayInfo playInfo = getPlayInfo(rank);
		playInfo.setSessionId(sessionId);
		EndApplicationStart.addMatchPlay(sessionId, playInfo);
	}

	public static void rankGame(String sessionId, Rank rank) {
		// 将玩家放入匹配池中
		PlayInfo playInfo = getPlayInfo(rank);
		playInfo.setSessionId(sessionId);
		EndApplicationStart.addRankPlay(sessionId, playInfo);
	}

	// 获取分数
	public static PlayInfo getPlayInfo(Rank rank) {
		int sorce = 0;
		RankMessage matchRankMessage = RankMessage.matchRankMessage(rank.getRankGrade());
		// 计算当前段位值
		int gradeSorce = matchRankMessage.getGradeSorce();
		int star = rank.getStar();
		Integer rankGradeStage = rank.getRankGradeStage();
		sorce = rankGradeStage * star * 10 + gradeSorce;
		// 判断当前连胜 输次数
		int winSorce = rank.getContinusWin() * 2;
		// 根据胜率调整分数
		float winRate = 0;
		int gameCount = rank.getWinCount() + rank.getContinusTransport();
		if (gameCount == 0) {
			winRate = 0.5f;
		} else {
			winRate = rank.getWinCount() / gameCount;
		}
		sorce = (int) ((sorce + winSorce) * winRate);
		PlayInfo playInfo = new PlayInfo(null, sorce, System.currentTimeMillis(), gradeSorce);
		return playInfo;
	}

}
