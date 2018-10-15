package com.lh.controller;

import com.alibaba.fastjson.JSONObject;
import com.lh.bean.Article;
import com.lh.bean.Tag;
import com.lh.bean.TagArticleKey;
import com.lh.service.ArticleService;
import com.lh.service.TagService;
import com.lh.service.Tag_Article_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/admin/tags")
public class TagController {
    @Autowired
    TagService tagService;
    @Autowired
    Tag_Article_Service tag_article_service;
    @Autowired
    ArticleService articleService;

    @RequestMapping(value = "",method = RequestMethod.GET)
    public ModelAndView listTag()
    {
        ModelAndView modelAndView = new ModelAndView("back/addTag");
        List<Tag> tags = tagService.list();
        tagService.fillTag(tags);
        modelAndView.addObject("tags",tags);
        return modelAndView;
    }

    @RequestMapping(value = "/admin/tags/insert",method = RequestMethod.GET)
    public ModelAndView insertTagPage()
    {
        ModelAndView modelAndView = new ModelAndView();
        return modelAndView;
    }

    @RequestMapping(value = "",method = RequestMethod.POST)
    public ModelAndView addTag(Tag tag)
    {
        ModelAndView modelAndView = new ModelAndView("redirect:/admin/tags");
        tag.setTagStatus(1);
        tagService.add(tag);
        return modelAndView;
    }

    @RequestMapping(value = "",method = RequestMethod.PUT)
    public ModelAndView updateTag(Tag tag)
    {
        ModelAndView modelAndView = new ModelAndView("redirect:/admin/tags");
        tag.setTagStatus(1);
        tagService.update(tag);
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteTag(@PathVariable("id") int tid)
    {
        JSONObject object = new JSONObject();
        try {
            List<TagArticleKey> tagArticleKeys ;
            if((tagArticleKeys=tag_article_service.listByTid(tid)).size()!=0)
            {
                object.put("result","child");
//                for (TagArticleKey tagArticleKey:
//                     tagArticleKeys) {
//                    int aid = tagArticleKey.getAid();
//                    Article article = articleService.get(aid);
//                    String name = article.getArticleTitle();
//                    object.put("article",article);
//                }
            }
            else
            {
                tagService.delete(tid);
                object.put("result","success");
            }
        }
        catch (Exception e)
        {
         object.put("result","fail");
        }
        return object.toJSONString();
    }

}
