package com.monkey1024.controller;

import com.alibaba.fastjson.JSON;
import com.monkey1024.bean.User;
import com.monkey1024.util.DataUtil;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class UserRestController {

    @GetMapping("/users")
    public String findAll() throws Exception {
        HashMap<String, User> allUser = DataUtil.findAll();
        String s = JSON.toJSONString(allUser);
        return s;
    }

    @GetMapping("/users/{id}")
    public String findById(@PathVariable String id) throws Exception {
        User user = DataUtil.findById(id);
        return JSON.toJSONString(user);
    }

    @PostMapping("/users")
    public String create(@RequestBody User user) {
        try {
            DataUtil.create(user);
        } catch (Exception e) {
            e.printStackTrace();
            return JSON.toJSONString("fail");
        }

        return JSON.toJSONString("success");
    }

    @PutMapping("/users/{id}")
    public String update(@PathVariable String id, @RequestBody User user) {
        try {
            DataUtil.update(id, user);
        } catch (Exception e) {
            e.printStackTrace();
            return JSON.toJSONString("fail");
        }

        return JSON.toJSONString("success");
    }

    @DeleteMapping("/users/{id}")
    public String delete(@PathVariable String id) {
        try {
            DataUtil.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            return JSON.toJSONString("fail");
        }

        return JSON.toJSONString("success");
    }
}
