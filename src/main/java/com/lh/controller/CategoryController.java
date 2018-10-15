package com.lh.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lh.bean.Article;
import com.lh.bean.Category;
import com.lh.service.CategoryService;
import com.lh.util.ImageUtil;
import com.lh.util.Page;
import com.lh.util.UploadFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/admin/categories")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView listCategory(Page page) {
        ModelAndView modelAndView = new ModelAndView("back/addCategory");
        PageHelper.offsetPage(page.getStart(),page.getCount());
        List<Category> categories = categoryService.list();
        int total = (int)new PageInfo<>(categories).getTotal();
        page.setTotal(total);
        categoryService.fillCategory(categories);
        List<Category> categories1 = categoryService.listByParent(0);
        modelAndView.addObject("categories", categories);
        modelAndView.addObject("categories1", categories1);
        return modelAndView;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ModelAndView addCategory(Category category, UploadFile uploadFile, HttpSession session) throws IOException {
        ModelAndView modelAndView = new ModelAndView("redirect:/admin/categories");
        category.setCategoryStatus(1);
        categoryService.add(category);
        String folder = session.getServletContext().getRealPath("img/category");
        String filename = category.getId()+".jpg";
        File file = new File(folder,filename);
        if(!file.getParentFile().exists())
            file.getParentFile().mkdirs();
        uploadFile.getImage().transferTo(file);
        BufferedImage img = ImageUtil.change2jpg(file);
        ImageIO.write(img, "jpg", file);
        return modelAndView;
    }


    @RequestMapping(value = "", method = RequestMethod.PUT)
    public ModelAndView updateCategory(Category category,HttpSession session,UploadFile uploadFile) throws IOException {
        ModelAndView modelAndView = new ModelAndView("redirect:/admin/categories");
        category.setCategoryStatus(1);
        int id = category.getId();
        Category category1 = categoryService.get(id);
        int p1 = category1.getPid();
        int p2 = category.getPid();
        if (p1 == 0 && p2 != 0)
        {
            List<Category> child = categoryService.listByParent(id);
            for (Category category2 :
                    child) {
                category2.setPid(p2);
                categoryService.update(category2);
            }
        }
        categoryService.update(category);
        String folder = session.getServletContext().getRealPath("img/category");
        String filename = category.getId()+".jpg";
        File file = new File(folder,filename);
        if(!file.getParentFile().exists())
            file.getParentFile().mkdirs();
        uploadFile.getImage().transferTo(file);
        BufferedImage img = ImageUtil.change2jpg(file);
        ImageIO.write(img, "jpg", file);
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteCategory(@PathVariable("id") int cid) {
        JSONObject object = new JSONObject();
        try {
            Category category = categoryService.get(cid);
            if(categoryService.hasChild(category))
            {
                object.put("result","child");

            }
            else
            {
                categoryService.delete(cid);
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
