package com.onlinechese.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinechese.entys.GameRecord;
import com.onlinechese.mapper.GameRecordMapper;
import com.onlinechese.service.GameRecordService;

@Service
public class GameRecordServiceimpl implements GameRecordService {

	@Autowired
	private GameRecordMapper GameRecordMapper;
	
	@Override
	public void addGameRecord(GameRecord gameRecord) {
		GameRecordMapper.insert(gameRecord);
	}

}
