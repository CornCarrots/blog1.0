package com.lh.controller;

import com.lh.bean.Link;
import com.lh.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/admin/links")
public class LinkController {
    @Autowired
    LinkService linkService;

    @RequestMapping(value = "",method = RequestMethod.GET)
    public ModelAndView listLink()
    {
        ModelAndView modelAndView = new ModelAndView("back/listLink");
        List<Link> links = linkService.list();
        modelAndView.addObject("links",links);
        return modelAndView;
    }

    @RequestMapping(value = "/page/add",method = RequestMethod.GET)
    public ModelAndView insertLinkPage()
    {
        ModelAndView modelAndView = new ModelAndView("back/addLink");
        return modelAndView;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ModelAndView addLink(Link link)
    {
        ModelAndView modelAndView = new ModelAndView("redirect:/admin/links");
        link.setLinkCreateDate(new Date());
        link.setLinkUpdateDate(new Date());
        link.setStatus(1);
        linkService.add(link);
        return modelAndView;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public ModelAndView updateLink(Link link, @PathVariable("id")int id)
    {
        ModelAndView modelAndView = new ModelAndView("redirect:/admin/links");
        Link link1 = linkService.get(id);
        link1.setLinkName(link.getLinkName());
        link1.setLinkUrl(link.getLinkUrl());
        link1.setLinkDescribe(link.getLinkDescribe());
        link1.setLinkUpdateDate(new Date());
        linkService.update(link);
        return modelAndView;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public ModelAndView deleteLink(@PathVariable("id")int id)
    {
        ModelAndView modelAndView = new ModelAndView("redirect:/admin/links");
        linkService.delete(id);
        return modelAndView;
    }

}
