package com.monkey1024.controller;


import com.monkey1024.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/register.do")
    public ModelAndView register(@Validated User user, BindingResult br) throws Exception {

        ModelAndView mv = new ModelAndView();

        List<ObjectError> allErrors = br.getAllErrors();
        System.out.println(allErrors.size());
        if (allErrors != null && allErrors.size() > 0) {

            FieldError nameError = br.getFieldError("name");
            FieldError ageError = br.getFieldError("age");
            FieldError phoneError = br.getFieldError("phone");

            if (nameError!=null) {
                mv.addObject("nameError", nameError.getDefaultMessage());
            }

            if(ageError!=null){
                mv.addObject("ageError", ageError.getDefaultMessage());
            }

            if(phoneError!=null){
                mv.addObject("phoneError", phoneError.getDefaultMessage());
            }

            mv.setViewName("register");
            return mv;
        }

        mv.addObject("name", user.getName());
        mv.setViewName("user");

        return mv;
    }
}
