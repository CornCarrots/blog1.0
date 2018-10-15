package com.lh.service;

import com.lh.bean.Option;

import java.util.List;

public interface OptionService {
    void add(Option option);
    void delete(int id);
    void update(Option option);
    Option get(int id);
    List<Option> getByName(String name);
    List<Option> list();
}
