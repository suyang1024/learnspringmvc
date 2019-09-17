package com.monkey1024.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/test")
public class TestController01 {

    @RequestMapping("/test1.do")
    public ModelAndView test01(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("hello", "helloworld");
        mv.setViewName("test1");
        return mv;
    }

    @RequestMapping(value = "/getParams.do",method = RequestMethod.POST)
    public ModelAndView getParams(String name, int age) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("name", name);
        mv.addObject("age", age);
        mv.setViewName("result");
        return mv;
    }

}
