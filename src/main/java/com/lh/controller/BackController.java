package com.lh.controller;

import com.lh.bean.Article;
import com.lh.bean.Comment;
import com.lh.bean.CommentWithBLOBs;
import com.lh.bean.User;
import com.lh.service.ArticleService;
import com.lh.service.CommentService;
import com.lh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class BackController {
    @Autowired
    ArticleService articleService;
    @Autowired
    CommentService commentService;
    @Autowired
    UserService userService;

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public ModelAndView index(HttpSession session)
    {
        ModelAndView modelAndView = new ModelAndView("back/index");
        User user = userService.get(1);
        session.setAttribute("user",user);
        List<Article> articles = articleService.listByUser(1);
        List<CommentWithBLOBs> comments = commentService.listBLOB();
        commentService.fillComment(comments);
        modelAndView.addObject("articles",articles);
        modelAndView.addObject("comments",comments);
        return modelAndView;
    }

    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public ModelAndView logout()
    {
        ModelAndView modelAndView = new ModelAndView();
        return modelAndView;
    }

}
