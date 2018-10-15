package com.lh.controller;

import com.alibaba.fastjson.JSONObject;
import com.lh.bean.*;
import com.lh.service.*;
import com.lh.util.IPUtil;
import com.lh.util.ImageUtil;
import com.lh.util.UploadFile;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.List;

@Controller
public class ForeController {
    Logger logger = Logger.getLogger(ForeController.class);
    @Autowired
    CategoryService categoryService;
    @Autowired
    TagService tagService;
    @Autowired
    ArticleService articleService;
    @Autowired
    CommentService commentService;
    @Autowired
    NoticeService noticeService;
    @Autowired
    LinkService linkService;
    @Autowired
    OptionService optionService;
    @Autowired
    UserService userService;
    @Autowired
    Tag_Article_Service tag_article_service;

    @RequestMapping(value = "/home",method = RequestMethod.GET)
    public ModelAndView home(HttpSession session) throws Exception {
        ModelAndView modelAndView = new ModelAndView("fore/home");
//        ModelAndView modelAndView = new ModelAndView("error/404");
//       if (true)
//        throw new Exception();
        List<ArticleWithBLOBs> articles =  articleService.listBLOBByStatus(1);
        articleService.fillArticleBLOB(articles);
        List<CommentWithBLOBs> comments =  commentService.listBLOBByStatus(2);
        commentService.fillComment(comments);
        int articleSum = articles.size();
        String newDate = articles.get(0).updateDateDesc();
        int commentSum = comments.size();
        NoticeWithBLOBs notice = noticeService.listBLOB().get(0);
        session.setAttribute("articles",articles);
        session.setAttribute("comments",comments);
        session.setAttribute("articleSum",articleSum);
        session.setAttribute("newDate",newDate);
        session.setAttribute("commentSum",commentSum);
        session.setAttribute("notice",notice);
        return modelAndView;
    }

    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public ModelAndView logout(HttpSession session)
    {
        ModelAndView modelAndView = new ModelAndView("redirect:/home");
        session.removeAttribute("user");
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(@RequestBody JSONObject jsonObject,HttpSession session)
    {
        User user = userService.get(jsonObject.get("userName").toString(),jsonObject.get("userPassword").toString());
        JSONObject object = new JSONObject();
        if(user==null)
            object.put("result","fail");
        else
        {
            user.setUserLoginTime(new Date());
            userService.update(user);
            session.setAttribute("user",user);
            object.put("result","success");
        }
        return object.toJSONString();
    }

    @RequestMapping(value = "/loginPage",method = RequestMethod.GET)
    public ModelAndView loginPage()
    {
        ModelAndView modelAndView = new ModelAndView("fore/login");
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String register(@RequestBody JSONObject object,HttpSession session)
    {
        String name = object.get("userName").toString();
        if (userService.isExists(name))
            object.put("result","fail");
        else
        {
            String pass = object.get("userPassword").toString();
            String email = object.get("userEmail").toString();
            String nick = object.get("userNickName").toString();
            User user = new User();
            user.setUserName(name);
            user.setUserNickName(nick);
            user.setUserEmail(email);
            user.setUserPassword(pass);
            user.setUserRights(2);
            user.setUserStatus(1);
            user.setUserRegisterDate(new Date());
            user.setUserPhoto("img/upload/profile_photo/default.jpg");
            userService.add(user);
            object.put("result","success");
        }
        return object.toJSONString();
    }

    @ResponseBody
    @RequestMapping(value = "/register/image",method = RequestMethod.POST)
    public String ajaxImage(@RequestParam(value = "uid") int uid,@RequestParam(value = "name") String name, @RequestParam(value="uploadFile") UploadFile uploadFile, HttpSession session)
    {
        //存储图片路径
        String folder = session.getServletContext().getRealPath("img/upload/profile_photo");
        String filename = uid+"_"+System.currentTimeMillis()+"."+name;
        String path = folder+"/"+filename;
        logger.info(folder+"\n"+filename+"\n"+path);
        File file = new File(folder,filename);
        if(!file.getParentFile().exists())
            file.getParentFile().mkdirs();

        //返回信息
        String msg = "";
        String error = "";

        try {
            //存储本地文件夹
            uploadFile.getImage().transferTo(file);
            BufferedImage img = ImageUtil.change2jpg(file);
            ImageIO.write(img, name, file);
            //存储数据库路径

            //限制图片大小
            int ruleHeight = 400;
            int ruleWidth = 750;
            int deviation = 100;//误差

            int imgHeight= img.getHeight();//图片高
            int imgWidth = img.getWidth();//图片宽

            if (Math.abs(ruleWidth - imgWidth) <= deviation && Math.abs(ruleHeight - imgHeight) <= deviation) {
                User user =  userService.get(uid);
                user.setUserPhoto(path);
                msg = "上传成功！";
            }else {
                error = "图片不符合规定误！";
            }

        } catch (Exception e) {
            error = "文件保存本地失败！";
        }

        String res = "{ error:'" + error + "', msg:'" + msg + "',imgurl:'" + path + "'}";
        return res;

    }

    @RequestMapping(value = "/register/page",method = RequestMethod.GET)
    public ModelAndView registerPage()
    {
        ModelAndView modelAndView = new ModelAndView("fore/register");
        modelAndView.addObject("register","注册");
        return modelAndView;
    }

    @RequestMapping(value = "/registerSuccess",method = RequestMethod.GET)
    public ModelAndView registerSuccessPage()
    {
        ModelAndView modelAndView = new ModelAndView("fore/registerSuccess");
        modelAndView.addObject("register","注册");
        return modelAndView;
    }

    @RequestMapping(value = "/search",method = RequestMethod.POST)
    public ModelAndView search(@RequestParam("key")String key)
    {
        ModelAndView modelAndView = new ModelAndView("fore/search");
        List<Article> articles = articleService.listByKey(key,1);
        modelAndView.addObject("articles",articles);
        modelAndView.addObject("search","搜索结果");
        return modelAndView;
    }

    @RequestMapping(value = "/home/articles/{id}",method = RequestMethod.GET)
    public ModelAndView article(@PathVariable("id") int id, HttpSession session)
    {
        ModelAndView modelAndView = new ModelAndView("fore/article");
        ArticleWithBLOBs article = articleService.getBLOBS(id);
        article.setArticleViews(article.getArticleViews()+1);
        Article last = null;
        Article next = null;
        Category category = (Category)session.getAttribute("category");
        if (category!=null)
        {
            List<Article> cats =  articleService.listByCategory(category.getId());
            for (int i = 0; i < cats.size(); i++) {
                if(cats.get(i).getId()==id)
                {
                    if(i>0)
                        last = articleService.get(cats.get(i-1).getId());
                    if(i<cats.size()-1)
                        next = articleService.get(cats.get(i+1).getId());
                }
            }
        }
        else
        {
            List<Article> cats =  articleService.listByStatus(1);
            for (int i = 0; i < cats.size(); i++) {
                if(cats.get(i).getId()==id)
                {
                    if(i>0)
                        last = articleService.get(cats.get(i-1).getId());
                    if(i<cats.size()-1)
                        next = articleService.get(cats.get(i+1).getId());
                }
            }
        }
//        logger.info("---------------"+category);
//        logger.info("---------------"+articleService.listByStatus(1).get(0).getId());
//        logger.info("---------------"+next.getArticleTitle());
        List<CommentWithBLOBs> commentWithBLOBs = commentService.listBLOBByArticleAndParAndStatus(id,0,2);
        articleService.update(article);
        commentService.fillComment(commentWithBLOBs);
//        logger.info("评论："+commentWithBLOBs);
        List<Article> articles1 = articleService.listByCategory(article.getArticleCpid());
        List<Article> articles2 = articleService.listByCategory(article.getArticleCcid());
        articleService.fillArticleBLOB(article);
        modelAndView.addObject("article",article);
        modelAndView.addObject("articles1",articles1);
        modelAndView.addObject("articles2",articles2);
        modelAndView.addObject("last",last);
        modelAndView.addObject("next",next);
        modelAndView.addObject("commentWithBLOBs",commentWithBLOBs);
        return modelAndView;
    }

    @RequestMapping(value = "/home/categories/{id}",method = RequestMethod.GET)
    public ModelAndView category(@PathVariable("id")int id,HttpSession session)
    {
        ModelAndView modelAndView = new ModelAndView("fore/category");
        Category category = categoryService.get(id);
        categoryService.fillCategory(category);
        modelAndView.addObject("category",category);
        return modelAndView;
    }

    @RequestMapping(value = "/home/tags/{id}",method = RequestMethod.GET)
    public ModelAndView tag(@PathVariable("id")int id)
    {
        ModelAndView modelAndView = new ModelAndView("fore/tag");
        Tag tag = tagService.get(id);
        tagService.fillTag(tag);
        List<Article> articles = tag.getArticles();
        modelAndView.addObject("articles",articles);
        modelAndView.addObject("tag",tag);
        return modelAndView;
    }

    @RequestMapping(value = "/home/notices/{id}",method = RequestMethod.GET)
    public ModelAndView getNotice(@PathVariable("id")int id)
    {
        ModelAndView modelAndView = new ModelAndView("fore/notice");
        NoticeWithBLOBs notice = noticeService.getBLOB(id);
        modelAndView.addObject("notice",notice);
        return modelAndView;
    }

    @RequestMapping(value = "/home/notices",method = RequestMethod.GET)
    public ModelAndView notice()
    {
        ModelAndView modelAndView = new ModelAndView("fore/listNotice");
        List<NoticeWithBLOBs> notices = noticeService.listBLOB();
        modelAndView.addObject("notices",notices);
        return modelAndView;
    }

    @RequestMapping(value = "/applyLink",method = RequestMethod.GET)
    public ModelAndView linkPage()
    {
        ModelAndView modelAndView = new ModelAndView("fore/link");
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value = "/home/links",method = RequestMethod.POST)
    public String link(@RequestBody JSONObject object)
    {
        Link link = new Link();
        String name = object.get("name").toString();
        String url = object.get("link").toString();
        String desc = object.get("desc").toString();
        link.setLinkName(name);
        link.setLinkUrl(url);
        link.setLinkDescribe(desc);
        link.setLinkCreateDate(new Date());
        link.setStatus(1);
        linkService.add(link);
        object.put("result","success");
        return object.toJSONString();
    }

    @RequestMapping(value = "/aboutSite",method = RequestMethod.GET)
    public ModelAndView about()
    {
        ModelAndView modelAndView = new ModelAndView("fore/about");
        Option optionName = optionService.get(1);
        Option optionDescribe = optionService.get(2);
        modelAndView.addObject("optionName",optionName);
        modelAndView.addObject("optionDescribe",optionDescribe);
        modelAndView.addObject("option","关于本站");
        return modelAndView;
    }

    @RequestMapping(value = "/articleFile",method = RequestMethod.GET)
    public ModelAndView file()
    {
        ModelAndView modelAndView = new ModelAndView("fore/file");
        modelAndView.addObject("file","文章归档");
        return modelAndView;
    }

    @RequestMapping(value = "/article/like/{id}",method = RequestMethod.GET)
    public ModelAndView likeArticle(@PathVariable("id")int id)
    {
        Article article = articleService.get(id);
        article.setArticleLikes(article.getArticleLikes()+1);
        articleService.update(article);
        ModelAndView modelAndView = new ModelAndView("redirect:/home/articles/"+id);
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value = "/checkLogin",method = RequestMethod.GET)
    public String checkLogin(HttpSession session)
    {
        JSONObject object = new JSONObject();
        User user = (User) session.getAttribute("user");
        if(user==null)
            object.put("result","no");
        else
            object.put("result","yes");
        return object.toJSONString();
    }

    @ResponseBody
    @RequestMapping(value = "/commitComment",method = RequestMethod.POST)
    public String commitComment(@RequestBody JSONObject object,HttpSession session,HttpServletRequest request)
    {
        User user = (User)session.getAttribute("user");
        CommentWithBLOBs comment = new CommentWithBLOBs();
        comment.setAid(Integer.parseInt(object.get("aid").toString()));
        comment.setCommentCreateDate(new Date());
        comment.setUid(user.getId());
        comment.setCommentStatus(2);
        comment.setPid(Integer.parseInt(object.get("pid").toString()));
        comment.setCommentMdText(object.get("comment").toString());
        comment.setCommentIp(IPUtil.getIpAddr(request));
        commentService.add(comment);
        object.put("result","success");
        return object.toJSONString();
    }

    @RequestMapping(value = "/home/users/{id}",method = RequestMethod.GET)
    public ModelAndView user(@PathVariable("id") int id)
    {
        ModelAndView modelAndView = new ModelAndView("fore/user");
        User user = userService.get(id);
        modelAndView.addObject("user",user);
        return modelAndView;
    }

    @RequestMapping(value = "/home/users/{id}",method = RequestMethod.POST)
    public ModelAndView editUser(@PathVariable("id") int id,User user)
    {
        ModelAndView modelAndView = new ModelAndView("redirect:/home/users/"+id);
        userService.update(user);
        return modelAndView;
    }

    @RequestMapping(value = "/home/users/{id}/articles",method = RequestMethod.GET)
    public ModelAndView myArticle(@PathVariable("id") int id)
    {
        ModelAndView modelAndView = new ModelAndView("fore/user_listArticle");
        User user = userService.get(id);
        List<Article> publishArticles = articleService.listByStatusAndUser(1,user.getId());
        List<Article> draftArticles = articleService.listByStatusAndUser(2,user.getId());
        articleService.fillArticle(publishArticles);
        articleService.fillArticle(draftArticles);
        modelAndView.addObject("publishArticles", publishArticles);
        modelAndView.addObject("publishSum", publishArticles.size());
        modelAndView.addObject("draftArticles", draftArticles);
        modelAndView.addObject("draftSum", draftArticles.size());
        modelAndView.addObject("status", 1);
        return modelAndView;
    }

    @RequestMapping(value = "/home/users/{id}/create",method = RequestMethod.GET)
    public ModelAndView createArticlePage(@PathVariable("id") int id)
    {
        ModelAndView modelAndView = new ModelAndView("fore/user_addArticle");
        List<Category> categories1 = categoryService.listByParent(0);
        List<Category> categories2 = categoryService.listChild();
        List<Tag> tags = tagService.list();
        modelAndView.addObject("categories1", categories1);
        modelAndView.addObject("categories2", categories2);
        modelAndView.addObject("tags", tags);
        return modelAndView;
    }

    @RequestMapping(value = "/home/users/{id}/comments",method = RequestMethod.GET)
    public ModelAndView comment(@PathVariable("id") int id)
    {
        ModelAndView modelAndView = new ModelAndView("fore/user_listComment");
        List<CommentWithBLOBs> comments = commentService.listBLOBByUser(id);
        commentService.fillComment(comments);
        modelAndView.addObject("comments",comments);
        return modelAndView;
    }

    @RequestMapping(value = "/home/users/{id}/comments/{cid}",method = RequestMethod.GET)
    public ModelAndView refuseComment(@PathVariable("cid")int id)
    {
        Comment comment = commentService.get(id);
        int aid = comment.getAid();
        ModelAndView modelAndView = new ModelAndView("redirect:/home/articles/"+aid+"#"+id);
        return modelAndView;
    }



    @ResponseBody
    @RequestMapping(value = "/home/users/{id}/comments/{edit}/{cid}",method = RequestMethod.PUT)
    public String updateComment(@PathVariable("cid")int id,@PathVariable("edit")String edit)
    {
        JSONObject jsonObject = new JSONObject();
        try {
            CommentWithBLOBs comment = commentService.getBLOB(id);
            if(edit.equals("shield"))
            {
                comment.setCommentStatus(3);
            }
            else if(edit.equals("allow"))
            {
                comment.setCommentStatus(2);
            }
            commentService.update(comment);
            jsonObject.put("result","success");
        }
        catch (Exception e)
        {
            jsonObject.put("result","error");
        }
        return jsonObject.toJSONString();
    }

    @ResponseBody
    @RequestMapping(value = "/fore/articles", method = RequestMethod.POST)
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

    @RequestMapping(value = "/fore/articles/{id}", method = RequestMethod.GET)
    public ModelAndView editArticlePage(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView("fore/user_editArticle");
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
    @RequestMapping(value = "/fore/articles", method = RequestMethod.PUT)
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
    @RequestMapping(value = "/fore/articles/{id}", method = RequestMethod.DELETE)
    public ModelAndView deleteArticle(@PathVariable("id")String id,HttpSession session) {
        ModelAndView modelAndView = new ModelAndView("redirect:/home/users/"+((User)session.getAttribute("user")).getId()+"/articles");
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
}
