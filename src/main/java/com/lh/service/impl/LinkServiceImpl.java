package com.lh.service.impl;

import com.lh.bean.Link;
import com.lh.bean.LinkExample;
import com.lh.mapper.LinkMapper;
import com.lh.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LinkServiceImpl implements LinkService {
    @Autowired
    LinkMapper linkMapper;

    @Override
    public void add(Link link) {
        linkMapper.insertSelective(link);
    }

    @Override
    public void delete(int id) {
        linkMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(Link link) {
        linkMapper.updateByPrimaryKeySelective(link);
    }

    @Override
    public Link get(int id) {
        return linkMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Link> list() {
        LinkExample example = new LinkExample();
        example.setOrderByClause("id desc");
        return linkMapper.selectByExample(example);
    }

    @Override
    public List<Link> listByStatus(int status) {
        LinkExample example = new LinkExample();
        example.setOrderByClause("id desc");
        example.createCriteria().andStatusEqualTo(status);
        return linkMapper.selectByExample(example);
    }
}
