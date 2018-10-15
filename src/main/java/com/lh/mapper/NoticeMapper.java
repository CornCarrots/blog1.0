package com.lh.mapper;

import com.lh.bean.Notice;
import com.lh.bean.NoticeExample;
import com.lh.bean.NoticeWithBLOBs;
import java.util.List;

public interface NoticeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(NoticeWithBLOBs record);

    int insertSelective(NoticeWithBLOBs record);

    List<NoticeWithBLOBs> selectByExampleWithBLOBs(NoticeExample example);

    List<Notice> selectByExample(NoticeExample example);

    NoticeWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(NoticeWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(NoticeWithBLOBs record);

    int updateByPrimaryKey(Notice record);
}