package com.crw.security.controller;

import com.crw.security.model.SecUser;
import com.crw.security.service.SecUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    @Autowired
    private SecUserService secUserService;

    /**
     * 首页地址
     *
     * @return
     */
    @GetMapping({"/", "/index", "/home"})
    public String root() {
        return "index";
    }

    /**
     * 登录地址
     *
     * @return
     */
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String doRegister(SecUser secUser) {
        // 简单校验
        if (secUserService.getByUserName(secUser.getUserName()) != null) {
            return "redirect:register?error";
        }
        secUserService.insert(secUser);
        return "redirect:register?success";
    }

}
