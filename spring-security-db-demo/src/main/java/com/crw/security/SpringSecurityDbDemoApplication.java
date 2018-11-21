package com.crw.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.crw.security"})
public class SpringSecurityDbDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityDbDemoApplication.class, args);
    }
}
