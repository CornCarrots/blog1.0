package com.lh.controller;

import com.alibaba.fastjson.JSONObject;
import com.lh.bean.Option;
import com.lh.service.OptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/admin/options")
public class OptionController {
    @Autowired
    OptionService optionService;

    @RequestMapping(value = "",method = RequestMethod.GET)
    public ModelAndView listOption()
    {
        ModelAndView modelAndView = new ModelAndView("back/settingTools");
        Option name = optionService.get(1);
        Option describe = optionService.get(2);
        Option photo = optionService.get(3);
        Option key = optionService.get(4);
        modelAndView.addObject("name",name);
        modelAndView.addObject("describe",describe);
        modelAndView.addObject("photo",photo);
        modelAndView.addObject("key",key);
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value = "",method = RequestMethod.PUT)
    public String updateOption(@RequestBody JSONObject object)
    {
        try {
            String name = object.get("key").toString();
            String value = object.get("value").toString();
            Option option = optionService.getByName(name).get(0);
            option.setOptionValue(value);
            optionService.update(option);
            object.put("result","success");
        }
        catch (Exception e)
        {
            object.put("result","error");
        }

        return object.toJSONString();
    }
}
