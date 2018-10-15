package com.lh.service.impl;

import com.lh.bean.Option;
import com.lh.bean.OptionExample;
import com.lh.mapper.OptionMapper;
import com.lh.service.OptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OptionServiceImpl implements OptionService {
    @Autowired
    OptionMapper optionMapper;

    @Override
    public void add(Option option) {
        optionMapper.insertSelective(option);
    }

    @Override
    public void delete(int id) {
        optionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(Option option) {
        optionMapper.updateByPrimaryKeySelective(option);
    }

    @Override
    public Option get(int id) {
        return optionMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Option> getByName(String name) {
        OptionExample example = new OptionExample();
        example.createCriteria().andOptionKeyEqualTo(name);
        return optionMapper.selectByExample(example);
    }

    @Override
    public List<Option> list() {
        OptionExample example = new OptionExample();
        example.setOrderByClause("id desc");
        return optionMapper.selectByExample(example);
    }
}
