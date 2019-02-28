package com.onlinechese.mapper;

import com.onlinechese.entys.FriendLaunchMessage;
import com.onlinechese.entys.FriendLaunchMessageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FriendLaunchMessageMapper {
    long countByExample(FriendLaunchMessageExample example);

    int deleteByExample(FriendLaunchMessageExample example);

    int deleteByPrimaryKey(Long id);

    int insert(FriendLaunchMessage record);

    int insertSelective(FriendLaunchMessage record);

    List<FriendLaunchMessage> selectByExample(FriendLaunchMessageExample example);

    FriendLaunchMessage selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") FriendLaunchMessage record, @Param("example") FriendLaunchMessageExample example);

    int updateByExample(@Param("record") FriendLaunchMessage record, @Param("example") FriendLaunchMessageExample example);

    int updateByPrimaryKeySelective(FriendLaunchMessage record);

    int updateByPrimaryKey(FriendLaunchMessage record);
}