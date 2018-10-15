package com.lh.mapper;

import com.lh.bean.TagArticleExample;
import com.lh.bean.TagArticleKey;
import java.util.List;

public interface TagArticleMapper {
    int deleteByPrimaryKey(TagArticleKey key);

    int insert(TagArticleKey record);

    int insertSelective(TagArticleKey record);

    List<TagArticleKey> selectByExample(TagArticleExample example);
}