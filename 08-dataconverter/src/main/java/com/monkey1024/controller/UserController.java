package com.monkey1024.controller;

import com.monkey1024.bean.User;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.Date;

@Controller
public class UserController {

    @RequestMapping("/user/addUser.do")
    public ModelAndView addUser(User user) throws Exception {

        ModelAndView mv = new ModelAndView();

        mv.addObject("name", user.getName());
        mv.addObject("age", user.getAge());
        mv.addObject("birthday", user.getBirthday());

        mv.setViewName("user");

        return mv;
    }
}
