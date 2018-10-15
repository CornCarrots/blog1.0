package com.lh.controller;

import com.lh.bean.User;
import com.lh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/admin/users")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "",method = RequestMethod.GET)
    public ModelAndView listUser()
    {
        ModelAndView modelAndView = new ModelAndView("back/listUser");
        List<User> users = userService.list();
        userService.fillUser(users);
        modelAndView.addObject("users",users);
        return modelAndView;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public ModelAndView updateUser(@PathVariable("id")int id,User user)
    {
        User user1 = userService.get(id);
        user1.setUserName(user.getUserName());
        user1.setUserPassword(user.getUserPassword());
        user1.setUserNickName(user.getUserNickName());
        user1.setUserPhoto(user.getUserPhoto());
        user1.setUserEmail(user.getUserEmail());
        userService.update(user1);
        ModelAndView modelAndView = new ModelAndView("redirect:/admin/users");
        return modelAndView;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public ModelAndView deleteUser(@PathVariable("id")int id)
    {
        User user = userService.get(id);
        user.setUserStatus(2);
        userService.update(user);
        ModelAndView modelAndView = new ModelAndView("redirect:/admin/users");
        return modelAndView;
    }



}
