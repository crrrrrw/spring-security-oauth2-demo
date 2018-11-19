package com.crw.security.security.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 自定义 HttpSecurity
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/").permitAll() // 匹配 "/" 路径，不需要权限即可访问
                .antMatchers("/user/**").hasRole("USER") // "/user/**"路径全部需要 "USER" 权限
                .and()
                .formLogin().loginPage("/login").defaultSuccessUrl("/user") // 登录地址为 "/login"，登录成功默认跳转到页面 "/user"
                .and()
                .logout().logoutUrl("/logout").logoutSuccessUrl("/login") // 退出登录的地址为 "/logout"，退出成功后跳转到页面 "/login"
                .and().csrf(); // CSRF ，其实默认开启
    }

    /**
     * 创建权限用户
     */
    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager(); // 内存用户管理器
        // 创建名为"crw"d的用户，密码为 "123456"，拥有 "USER" 权限
        manager.createUser(User
                .withUsername("crw")
                .password("123456")
                .roles("USER") // has been append the ROLE_ prefix， 替换 ".authorities("USER")"
                .build());
        return manager;
    }

    /**
     * spring5下
     * 解决 There is no PasswordEncoder mapped for the id “null” 的错误
     */
    @Bean
    public static NoOpPasswordEncoder passwordEncoder() {
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }
}
