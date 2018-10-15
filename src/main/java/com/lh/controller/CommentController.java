package com.lh.controller;

import com.alibaba.fastjson.JSONObject;
import com.lh.bean.Comment;
import com.lh.bean.CommentWithBLOBs;
import com.lh.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/admin/comments")
public class CommentController {
    @Autowired
    CommentService commentService;

    @RequestMapping(value = "",method = RequestMethod.GET)
    public ModelAndView listComment()
    {
        ModelAndView modelAndView = new ModelAndView("back/listComment");
        List<CommentWithBLOBs> comments = commentService.listBLOB();
        commentService.fillComment(comments);
        List<CommentWithBLOBs> waitComments = commentService.listBLOBByStatus(1);
        commentService.fillComment(waitComments);
        modelAndView.addObject("comments",comments);
        modelAndView.addObject("waitComments",waitComments);
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public String deleteComment(@PathVariable("id")int id)
    {
        JSONObject jsonObject = new JSONObject();
        try {
            commentService.delete(id);
            jsonObject.put("result","success");
        }
        catch (Exception e)
        {
            jsonObject.put("result","fail");
        }
        return jsonObject.toJSONString();
    }

    @ResponseBody
    @RequestMapping(value = "/{edit}/{id}",method = RequestMethod.PUT)
    public String updateComment(@PathVariable("id")int id,@PathVariable("edit")String edit)
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

    @RequestMapping(value = "/refuse/{id}",method = RequestMethod.GET)
    public ModelAndView refuseComment(@PathVariable("id")int id)
    {
        Comment comment = commentService.get(id);
        ModelAndView modelAndView = new ModelAndView("redirect:/home/articles/"+comment.getAid()+"#"+id);
        return modelAndView;
    }




}
