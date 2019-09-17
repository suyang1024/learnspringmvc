package com.monkey1024.controller;

import com.monkey1024.bean.School;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class ForwardRedirectController {

    @RequestMapping("/forwardMAV.do")
    public ModelAndView forwardMAV() throws Exception {

        ModelAndView mv = new ModelAndView();
        mv.addObject("type1","转发返回ModelAndView");

//        mv.setViewName("result");
//        mv.setViewName("forward:/jsp/result.jsp");
        mv.setViewName("forward:/other.do");
        return mv;
    }

    @RequestMapping("/redirectMAV.do")
    public ModelAndView redirectMAV(School school, String name) throws Exception {

        ModelAndView mv = new ModelAndView();
        System.out.println(school.getSchoolName());
        System.out.println(school.getAddress());

        //在重定向中可以使用ModelAndView传递数据，但是只能传递基本数据类型和String类型
        mv.addObject("content", "重定向返回ModelAndView");
        mv.addObject("name", "苏洋");
        mv.addObject("school", school);
        mv.setViewName("redirect:/jsp/result.jsp");

        return mv;
    }

    @RequestMapping("/forwardStr.do")
    public String forwardStr(School school) throws Exception {

        return "forward:/jsp/result.jsp";
    }

    @RequestMapping("/redirectStr.do")
    public String redirectStr(School school, Model model) throws Exception{

        model.addAttribute("schoolName", school.getSchoolName());
        model.addAttribute("address", school.getAddress());

        return "redirect:/jsp/result.jsp";
    }

    @RequestMapping("/forwardVoid.do")
    public void forwardVoid(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
        model.addAttribute("age",23);// 无效
        request.setAttribute("age",24);
        request.getRequestDispatcher("/jsp/result.jsp").forward(request, response);
    }

    @RequestMapping("/redirectVoid.do")
    public void redirectVoid(HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.sendRedirect(request.getContextPath() + "/jsp/result.jsp");
    }
}
