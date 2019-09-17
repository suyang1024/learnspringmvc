package com.monkey1024.myexception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {

        ModelAndView mv = new ModelAndView();
        mv.addObject("ex",e);

        mv.setViewName("error/error");

        if(e instanceof MyException) {
            mv.setViewName("error/myerror");
        }

        return mv;
    }
}
