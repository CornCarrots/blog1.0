package com.lh.controller;

import com.lh.bean.Menu;
import com.lh.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/admin/menus")
public class MenuController {
    @Autowired
    MenuService menuService;

    @RequestMapping(value = "",method = RequestMethod.GET)
    public ModelAndView listMenu()
    {
        ModelAndView modelAndView = new ModelAndView("back/listMenu");
        List<Menu> menus = menuService.list();
        modelAndView.addObject("menus",menus);
        return modelAndView;
    }

    @RequestMapping(value = "/page/add",method = RequestMethod.GET)
    public ModelAndView insertMenuPage()
    {
        ModelAndView modelAndView = new ModelAndView("back/addMenu");
        return modelAndView;
    }

    @RequestMapping(value = "",method = RequestMethod.POST)
    public ModelAndView addMenu(Menu menu)
    {
        menu.setMenuStatus(1);
        menuService.add(menu);
        ModelAndView modelAndView = new ModelAndView("redirect:/admin/menus");
        return modelAndView;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public ModelAndView updateMenu(Menu menu, @PathVariable("id")int id)
    {
        Menu menu1 = menuService.get(id);
        menu1.setMenuName(menu.getMenuName());
        menu1.setMenuLink(menu.getMenuLink());
        menu1.setMenuIcon(menu.getMenuIcon());
        menu1.setMenuRole(menu.getMenuRole());
        menuService.update(menu);
        ModelAndView modelAndView = new ModelAndView("redirect:/admin/menus");
        return modelAndView;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public ModelAndView deleteMenu(@PathVariable("id")int id)
    {
        menuService.delete(id);
        ModelAndView modelAndView = new ModelAndView("redirect:/admin/menus");
        return modelAndView;
    }

}
