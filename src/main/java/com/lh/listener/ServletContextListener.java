package com.lh.listener;

import com.lh.bean.Option;
import com.lh.service.OptionService;
import com.lh.util.MyTimer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import java.util.TimerTask;
import java.util.Vector;

public class ServletContextListener implements javax.servlet.ServletContextListener {
    OptionService optionService;
    ServletContext servletContext;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        optionService = WebApplicationContextUtils.getWebApplicationContext(sce.getServletContext()).getBean(OptionService.class);
        servletContext = sce.getServletContext();
        final Option option = optionService.get(5);
        final Vector<Integer> vector = new Vector<>();
        vector.add(Integer.parseInt(option.getOptionValue()));
        servletContext.setAttribute("optionNum", vector.get(0));
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                int num = Integer.parseInt(servletContext.getAttribute("optionNum").toString());
                vector.add(num);
                option.setOptionValue(String.valueOf(vector.get(vector.size()-1)));
                optionService.update(option);
            }
        };
        new MyTimer(2, timerTask);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
