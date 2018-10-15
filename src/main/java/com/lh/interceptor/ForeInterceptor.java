package com.lh.interceptor;

import com.lh.bean.*;
import com.lh.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

public class ForeInterceptor implements HandlerInterceptor {
    @Autowired
    MenuService menuService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    TagService tagService;
    @Autowired
    LinkService linkService;
    @Autowired
    NoticeService noticeService;
    @Autowired
    OptionService optionService;
    @Autowired
    ArticleService articleService;
    @Autowired
    CommentService commentService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        int num = Integer.parseInt(session.getServletContext().getAttribute("optionNum").toString());
        num++;
        session.getServletContext().setAttribute("optionNum",num);
        List<Menu> topMenus = (List<Menu>) session.getAttribute("topMenus");
        if (null == topMenus)
             topMenus = menuService.listByRole(1);
        List<Category> parCategories = (List<Category>) session.getAttribute("parCategories");
        if (null == parCategories)
            parCategories = categoryService.listByParent(0);
        Integer categorySum = (Integer) session.getAttribute("categorySum");
        if (null==categorySum)
            categorySum =  categoryService.list().size();
        List<Tag> tags = (List<Tag>) session.getAttribute("tags");
        if (null==tags)
            tags = tagService.list();
        Integer tagSum = (Integer) session.getAttribute("tagSum");
        if (null==tagSum)
            tagSum =  tags.size();
        Integer linkSum = (Integer) session.getAttribute("linkSum");
        if (null==linkSum)
            linkSum =  linkService.list().size();

        Integer viewSum =  Integer.parseInt(optionService.get(5).getOptionValue());
        Option optionName = optionService.get(1);
        Option optionDescribe = optionService.get(2);
        Option optionPhoto = optionService.get(3);
        Option optionKey = optionService.get(4);

        session.setAttribute("viewSum",viewSum);
        session.setAttribute("tags",tags);
        session.setAttribute("linkSum",linkSum);
        session.setAttribute("tagSum",tagSum);
        session.setAttribute("categorySum",categorySum);
        session.setAttribute("optionName",optionName);
        session.setAttribute("optionDescribe",optionDescribe);
        session.setAttribute("optionPhoto",optionPhoto);
        session.setAttribute("optionKey",optionKey);
        session.setAttribute("menus",topMenus);
        session.setAttribute("parCategories",parCategories);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
