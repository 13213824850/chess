package com.onlinechese.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinechese.constant.GameMessage;
import com.onlinechese.constant.RankMessage;
import com.onlinechese.entys.Rank;
import com.onlinechese.entys.RankExample;
import com.onlinechese.entys.RankExample.Criteria;
import com.onlinechese.mapper.RankMapper;
import com.onlinechese.service.RankService;
import com.onlinechese.util.Msg;

@Service
public class RankServiceimpl implements RankService {

	@Autowired
	private RankMapper rankMapper;

	@Override
	public Rank getRank(String userName) {
		RankExample example = new RankExample();
		Criteria criteria = example.createCriteria();
		criteria.andUserNameEqualTo(userName);
		List<Rank> selectByExample = rankMapper.selectByExample(example);
		if (selectByExample.size() != 0) {
			return selectByExample.get(0);
		}
		return null;
	}

	@Override
	public void addRank(Rank rank) {
		rankMapper.insert(rank);

	}

	@Override
	public Msg getRankByIdMsg(String userName) {
		Rank rank = getRank(userName);
		if (rank != null) {
			return Msg.success().add("rank", rank);
		}
		return Msg.fail();
	}

	@Override
	public void winGameRank(String userName) {
		RankExample example = new RankExample();
		Criteria criteria = example.createCriteria();
		criteria.andUserNameEqualTo(userName);
		List<Rank> ranks = rankMapper.selectByExample(example);
		if (ranks.size() == 0) {
			return;
		}
		Rank rank = ranks.get(0);
		int rankGrade = rank.getRankGrade();
		// 无段位玩家
		if (rankGrade == 0) {
			rank.setRankGrade(1);
			rank.setRankGradeStage(3);
			rank.setStar(1);
		} else if (rankGrade == RankMessage.TheKing.getRankGrade()) {
			// 王者段位星星加1
			rank.setStar(rank.getStar() + 1);
		} else {
			RankMessage rankMessage = RankMessage.matchRankMessage(rankGrade);
			// 若星星相等则进阶
			if (rankMessage.getStar() == rank.getStar()) {
				// 查看小段位是否进阶
				if (rank.getRankGradeStage() == 1) {
					// 进大阶
					rank.setRankGrade(rankGrade + 1);
					RankMessage rankMessageUp = RankMessage.matchRankMessage(rankGrade + 1);
					rank.setRankGradeStage(rankMessageUp.getStage());
				} else {
					// 不进阶
					rank.setRankGradeStage(rank.getRankGradeStage() - 1);
				}
				rank.setStar(1);
				rank.setProtectCount(3);
			} else {
				rank.setStar(rank.getStar() + 1);
			}

		}
		rank.setUpdated(new Date());
		rankMapper.updateByExampleSelective(rank, example);

	}

	@Override
	public void transportGameRank(String userName) {
		RankExample example = new RankExample();
		Criteria criteria = example.createCriteria();
		criteria.andUserNameEqualTo(userName);
		List<Rank> ranks = rankMapper.selectByExample(example);
		if (ranks.size() == 0) {
			return;
		}
		Rank rank = ranks.get(0);
		int rankGrade = rank.getRankGrade();
		// 无段位玩家
		if (rankGrade == 0) {
			rank.setRankGrade(1);
			rank.setRankGradeStage(3);
			rank.setStar(1);
		} else if (rankGrade == RankMessage.TheKing.getRankGrade()) {
			// 王者段位星星减1
			rank.setStar(rank.getStar() - 1);
		} else if (rankGrade == 1 && rank.getRankGradeStage() == 3 && rank.getStar() == 3) {
		} else {
			RankMessage rankMessage = RankMessage.matchRankMessage(rankGrade);
			// 若星星相等则进阶
			if (rank.getStar() == 1) {
				// 查看小段位是否退阶
				if (rankMessage.getStage() == rank.getRankGradeStage()) {
					// 退大阶
					rank.setRankGrade(rankGrade - 1);
					RankMessage rankMessageUp = RankMessage.matchRankMessage(rankGrade - 1);
					rank.setRankGradeStage(1);
				} else {
					// 不退阶
					rank.setRankGradeStage(rank.getRankGradeStage() - 1);
				}
				rank.setStar(rankMessage.getStar());
			} else {
				rank.setStar(rank.getStar() - 1);
			}

		}
		rank.setUpdated(new Date());
		rankMapper.updateByExampleSelective(rank, example);

	}

}
