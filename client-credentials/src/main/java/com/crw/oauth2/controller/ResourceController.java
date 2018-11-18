package com.crw.oauth2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 资源请求处理
 */
@RestController
public class ResourceController {

    /**
     * 模拟获取用户资源
     *
     * @param id
     * @return
     */
    @GetMapping("/user/{id}")
    public String getUser(@PathVariable String id) {
        return "get user id : " + id;
    }

    /**
     * 模拟获取用户资源
     *
     * @param id
     * @return
     */
    @GetMapping("/product/{id}")
    public String getProduct(@PathVariable String id) {
        return "get product id : " + id;
    }

    /**
     * 模拟获取首页
     *
     * @return
     */
    @GetMapping("/")
    public String index() {
        return "index page...";
    }
}
