package com.onlinechese.mapper;

import com.onlinechese.entys.GameList;
import com.onlinechese.entys.GameListExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GameListMapper {
    long countByExample(GameListExample example);

    int deleteByExample(GameListExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GameList record);

    int insertSelective(GameList record);

    List<GameList> selectByExample(GameListExample example);

    GameList selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GameList record, @Param("example") GameListExample example);

    int updateByExample(@Param("record") GameList record, @Param("example") GameListExample example);

    int updateByPrimaryKeySelective(GameList record);

    int updateByPrimaryKey(GameList record);
}