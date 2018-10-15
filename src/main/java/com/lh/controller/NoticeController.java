package com.lh.controller;

import com.alibaba.fastjson.JSONObject;
import com.lh.bean.Notice;
import com.lh.bean.NoticeWithBLOBs;
import com.lh.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/admin/notices")
public class NoticeController {
    @Autowired
    NoticeService noticeService;

    @RequestMapping(value = "",method = RequestMethod.GET)
    public ModelAndView listNotice()
    {
        ModelAndView modelAndView = new ModelAndView("back/listNotice");
        List<NoticeWithBLOBs> notices = noticeService.listBLOB();
        modelAndView.addObject("notices",notices);
        return modelAndView;
    }

    @RequestMapping(value = "/page/add",method = RequestMethod.GET)
    public ModelAndView insertNoticePage()
    {
        ModelAndView modelAndView = new ModelAndView("back/addNotice");
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value = "",method = RequestMethod.POST)
    public String addNotice(@RequestBody JSONObject object)
    {
        try {
            NoticeWithBLOBs notice = new NoticeWithBLOBs();
            notice.setNoticeTitle(object.get("noticeTitle").toString());
            notice.setNoticeHtmlText(object.get("noticeHtmlText").toString());
            notice.setNoticeMdText(object.get("noticeMdText").toString());
            notice.setNoticeCreateDate(new Date());
            notice.setNoticeUpdateDate(new Date());
            notice.setStatus(1);
            noticeService.add(notice);
            object.put("result","success");
        }
        catch (Exception e)
        {
            object.put("result","fail");
        }
        return object.toJSONString();
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ModelAndView editNotice(@PathVariable("id")int nid)
    {
        ModelAndView modelAndView = new ModelAndView("back/editNotice");
        NoticeWithBLOBs notice = noticeService.getBLOB(nid);
        modelAndView.addObject("notice",notice);
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public String updateNotice(@PathVariable("id")int nid,@RequestBody JSONObject object)
    {
        try {
            NoticeWithBLOBs notice = noticeService.getBLOB(nid);
            notice.setNoticeTitle(object.get("noticeTitle").toString());
            notice.setNoticeHtmlText(object.get("noticeHtmlText").toString());
            notice.setNoticeMdText(object.get("noticeMdText").toString());
            notice.setNoticeUpdateDate(new Date());
            noticeService.update(notice);
            object.put("result","success");
        }
        catch (Exception e)
        {
            object.put("result","fail");
        }
        return object.toJSONString();
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public ModelAndView deleteNotice(@PathVariable("id")int nid)
    {
        noticeService.delete(nid);
        ModelAndView modelAndView = new ModelAndView("redirect:/admin/notices");
        return modelAndView;
    }

}
