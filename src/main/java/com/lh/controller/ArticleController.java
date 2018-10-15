package com.lh.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.lh.bean.*;
import com.lh.service.*;
import com.lh.util.Page;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import xin.xihc.utils.common.CommonUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/admin/articles")
public class ArticleController {
    Logger logger = Logger.getLogger(ArticleController.class);
    @Autowired
    ArticleService articleService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    TagService tagService;
    @Autowired
    Tag_Article_Service tag_article_service;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView listArticle(HttpSession session) {
        ModelAndView modelAndView = new ModelAndView("back/listArticle");
        User user = (User)session.getAttribute("user");
        List<Article> publishArticles = articleService.listByStatus(1);
        List<Article> draftArticles = articleService.listByStatus(2);
        articleService.fillArticle(publishArticles);
        articleService.fillArticle(draftArticles);
        modelAndView.addObject("publishArticles", publishArticles);
        modelAndView.addObject("publishSum", publishArticles.size());
        modelAndView.addObject("draftArticles", draftArticles);
        modelAndView.addObject("draftSum", draftArticles.size());
        modelAndView.addObject("status", 1);
        return modelAndView;
    }

    @RequestMapping(value = "/page/add", method = RequestMethod.GET)
    public ModelAndView insertArticlePage() {
        ModelAndView modelAndView = new ModelAndView("back/addArticle");
        List<Category> categories1 = categoryService.listByParent(0);
        List<Category> categories2 = categoryService.listChild();
        List<Tag> tags = tagService.list();
        modelAndView.addObject("categories1", categories1);
        modelAndView.addObject("categories2", categories2);
        modelAndView.addObject("tags", tags);
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value = "", method = RequestMethod.POST)
    public String addArticle(@RequestBody JSONObject object, HttpSession session) {
        try {
            ArticleWithBLOBs article = new ArticleWithBLOBs();
            article.setArticleTitle(object.get("articleTitle").toString());
            article.setArticleHtmlText(object.get("articleHtmlText").toString());
            article.setArticleMdText(object.get("articleMdText").toString());
            article.setArticleCreateDate(new Date());
            article.setArticleUpdateDate(new Date());
            User user = (User) session.getAttribute("user");
            article.setArticleUid(user.getId());
            article.setArticleLikes(new Long((long) 0));
            article.setArticleComments(new Long((long) 0));
            article.setArticleViews(new Long((long) 0));
            int type = Integer.parseInt(object.get("type").toString());
            article.setArticleStatus(type);
            article.setArticleCpid(Integer.parseInt(object.get("category1").toString()));
            article.setArticleCcid(Integer.parseInt(object.get("category2").toString()));
            articleService.add(article);
            String s = object.get("tags").toString();
            String[] tids = s.split(",");
            for (String s1 :
                    tids) {
                int tid = Integer.parseInt(s1);
                Tag tag = tagService.get(tid);
                tag_article_service.add(tag, article);
            }
            object.put("result", "success");
        } catch (Exception e) {
            object.put("result", "fail");
        }

        return object.toJSONString();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView editArticlePage(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView("back/editArticle");
        ArticleWithBLOBs article = articleService.getBLOBS(id);
        articleService.fillArticleBLOB(article);
        List<Category> categories1 = categoryService.listByParent(0);
        categories1.remove(article.getParent());
        List<Category> categories2 = categoryService.listChild();
        categories2.remove(article.getChildren());
        List<Tag> tags = tagService.list();
        modelAndView.addObject("categories1", categories1);
        modelAndView.addObject("categories2", categories2);
        modelAndView.addObject("tags", tags);
        modelAndView.addObject("article", article);
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value = "", method = RequestMethod.PUT)
    public String updateArticle(@RequestBody JSONObject object) {
        try {
            int id = Integer.parseInt(object.get("articleId").toString());
            ArticleWithBLOBs article = articleService.getBLOBS(id);
            article.setArticleTitle(object.get("articleTitle").toString());
            article.setArticleHtmlText(object.get("articleHtmlText").toString());
            article.setArticleMdText(object.get("articleMdText").toString());
            article.setArticleUpdateDate(new Date());
            int type = Integer.parseInt(object.get("type").toString());
            article.setArticleStatus(type);
            article.setArticleCpid(Integer.parseInt(object.get("category1").toString()));
            article.setArticleCcid(Integer.parseInt(object.get("category2").toString()));
            articleService.update(article);
            String s = object.get("tags").toString();
            String[] tids = s.split(",");
            List<TagArticleKey> list = tag_article_service.listByAid(article.getId());
            for (int i = 0; i < tids.length; i++) {
                int t1 = Integer.parseInt(tids[i]);
                boolean found =false;
                for (int j = 0; j <  list.size(); j++) {
                    int t2 = list.get(j).getTid();
                    logger.info(t1+" "+t2);
                    if(t1 == t2)
                    {
//                        logger.info("123");
                        found = true;
                        break;
                    }
                }
                logger.info("信息："+found);
                if (!found)
                {
                    Tag tag = tagService.get(t1);
                    tag_article_service.update(tag, article);
                }
            }
            for (int i = 0; i < list.size(); i++) {
                int t1 = list.get(i).getTid();
                boolean found = false;
                for (int j = 0; j < tids.length; j++) {
                    int t2 = Integer.parseInt(tids[j]);

                    if (t1 == t2)
                    {

                        found = true;
                        break;
                    }
                }

                if(!found)
                {
                    tag_article_service.delete(t1,article.getId());
                }
            }
            object.put("result", "success");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            object.put("result", "fail");
        }
        return object.toJSONString();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ModelAndView deleteArticle(@PathVariable("id")String id) {
        ModelAndView modelAndView = new ModelAndView("redirect:/admin/articles");
        if(id.indexOf(",")==-1)
        {
            int aid = Integer.parseInt(id);
            List<TagArticleKey> list = tag_article_service.listByAid(aid);
            for (int i = 0; i < list.size(); i++) {
                    int tid = list.get(i).getTid();
                   tag_article_service.delete(tid,aid);
            }
            articleService.delete(aid);
        }
        else
        {
            String[] ids = id.split(",");
            for (int i = 0; i < ids.length; i++) {
                int aid = Integer.parseInt(ids[i]);
                List<TagArticleKey> list = tag_article_service.listByAid(aid);
                for (int j = 0; j < list.size(); j++) {
                    int tid = list.get(j).getTid();
                    logger.info(aid+" "+tid);
                    tag_article_service.delete(tid,aid);
                }
                articleService.delete(aid);
            }
        }
        return modelAndView;
    }

    @RequestMapping("/editormdPic")
    @ResponseBody
    public JSONObject editormdPic(@RequestParam(value = "editormd-image-file", required = true) MultipartFile file, HttpServletRequest request, HttpServletResponse response) throws Exception {

        String trueFileName = file.getOriginalFilename();

        String suffix = trueFileName.substring(trueFileName.lastIndexOf("."));
        String fileName = System.currentTimeMillis() + "_" + (RandomUtils.nextInt(999) + 100) + suffix;
        String path = request.getSession().getServletContext().getRealPath("/img/upload/article/");
        System.out.println(path);

        File targetFile = new File(path, fileName);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }

        //保存
        try {
            file.transferTo(targetFile);
        } catch (Exception e) {
            e.printStackTrace();
        }


        JSONObject res = new JSONObject();
        res.put("url", request.getSession().getServletContext().getRealPath("/img/upload/article") + "/" + fileName);
        res.put("success", 1);
        res.put("message", "upload success!");

        return res;

    }
}
