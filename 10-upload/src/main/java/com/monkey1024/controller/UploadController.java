package com.monkey1024.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.File;

@Controller
public class UploadController {

    @RequestMapping("/upload1.do")
    public ModelAndView upload1(@RequestParam MultipartFile[] photos, HttpSession session) throws Exception {

        ModelAndView mv = new ModelAndView();

        // 获取服务器上传的文件路径
        String path = session.getServletContext().getRealPath("/upload");

        for (MultipartFile photo : photos) {
            if (!photo.isEmpty()) {
                String fileName = photo.getOriginalFilename();
                System.out.println(fileName);

                if ("image/png".equals(photo.getContentType())) {
                    File file = new File(path, fileName);
                    photo.transferTo(file);
                } else {
                    mv.addObject("msg", "请选择png格式的文件上传");
                    mv.setViewName("upload_fail");
                    return mv;
                }
            }
        }

        mv.setViewName("upload_success");
        return mv;
    }
}
