package com.crw.security.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

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

}
