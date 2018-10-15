package com.lh.mapper;

import com.lh.bean.UserFriend;
import com.lh.bean.UserFriendExample;
import java.util.List;

public interface UserFriendMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserFriend record);

    int insertSelective(UserFriend record);

    List<UserFriend> selectByExample(UserFriendExample example);

    UserFriend selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserFriend record);

    int updateByPrimaryKey(UserFriend record);
}