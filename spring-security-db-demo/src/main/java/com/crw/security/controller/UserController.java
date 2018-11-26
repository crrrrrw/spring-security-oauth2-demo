package com.crw.security.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class UserController {

    /**
     * 用户中心
     *
     * @param principal
     * @param model
     * @return
     */
    @GetMapping("/user")
    public String user(@AuthenticationPrincipal Principal principal, Model model) {
        model.addAttribute("username", principal.getName());
        return "user/user";
    }

}
