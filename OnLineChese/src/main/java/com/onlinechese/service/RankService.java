package com.onlinechese.service;

import com.onlinechese.entys.Rank;
import com.onlinechese.util.Msg;

public interface RankService {
	public Msg getRankByIdMsg(String userName);
	public Rank getRank(String userName);
	public void addRank(Rank rank);
	//结算
	public void winGameRank(String userName);
	public  void transportGameRank(String userName);
}
