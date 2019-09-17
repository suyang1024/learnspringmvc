package com.monkey1024.controller;

import com.monkey1024.myexception.MyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExceptionController {

    @RequestMapping("/myexception.do")
    public ModelAndView myexception(String name) throws Exception {

        ModelAndView mv = new ModelAndView();

        if("jack".equals(name)) {
            throw new MyException("我的自定义异常");
        }

        if(!"jack".equals(name)) {
            throw new Exception("异常");
        }

        return mv;
    }
}
