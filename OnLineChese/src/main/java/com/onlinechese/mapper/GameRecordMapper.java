package com.onlinechese.mapper;

import com.onlinechese.entys.GameRecord;
import com.onlinechese.entys.GameRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GameRecordMapper {
    long countByExample(GameRecordExample example);

    int deleteByExample(GameRecordExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GameRecord record);

    int insertSelective(GameRecord record);

    List<GameRecord> selectByExample(GameRecordExample example);

    GameRecord selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GameRecord record, @Param("example") GameRecordExample example);

    int updateByExample(@Param("record") GameRecord record, @Param("example") GameRecordExample example);

    int updateByPrimaryKeySelective(GameRecord record);

    int updateByPrimaryKey(GameRecord record);
}