package com.monkey1024.controller;

import com.monkey1024.bean.User;
import com.monkey1024.util.DataUtil;
import com.sun.deploy.net.HttpResponse;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

@Controller
public class UserController {

    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {

        ModelAndView mv = new ModelAndView();
        HashMap<String, User> all = DataUtil.findAll();
        mv.addObject("allUser", all);
        mv.setViewName("user_list");
        return mv;
    }

    @RequestMapping("findById.do")
    public ModelAndView findById(String id) throws Exception {

        ModelAndView mv = new ModelAndView();
        User user = DataUtil.findById(id);
        HashMap<String, User> resultMap = new HashMap<>();
        resultMap.put(id, user);
        mv.addObject("allUser", resultMap);
        mv.addObject("id", id);
        mv.setViewName("user_list");
        return mv;
    }

    @RequestMapping("/create.do")
    public void create(User user, HttpServletResponse response) throws Exception {

        DataUtil.create(user);
        response.sendRedirect("/findAll.do");
    }

    @RequestMapping("/goUpdate.do")
    public ModelAndView goUpdate(String id) throws Exception {
        User user = DataUtil.findById(id);
        ModelAndView mv = new ModelAndView();
        mv.addObject("id", id);
        mv.addObject("user", user);
        mv.setViewName("user_update");
        return mv;
    }

    @RequestMapping("/update.do")
    public void update(String id, User user, HttpServletResponse response) throws Exception {
        DataUtil.update(id, user);
        response.sendRedirect("/findAll.do");
    }

    @RequestMapping("/delete.do")
    public void delete(String id, HttpServletResponse response) throws Exception {
        DataUtil.delete(id);
        response.sendRedirect("/findAll.do");
    }
}
