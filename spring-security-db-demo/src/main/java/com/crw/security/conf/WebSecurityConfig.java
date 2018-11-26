package com.crw.security.conf;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@EnableWebSecurity
@MapperScan(basePackages = "com.crw.security.mapper")
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private JdbcUserDetailsService jdbcUserDetailsService;

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

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        /*auth
                .jdbcAuthentication()
                .usersByUsernameQuery("...")//配置UserDetails查询语句
                .authoritiesByUsernameQuery("...")//配置用户直接Authorities查询语句
                .groupAuthoritiesByUsername("...")//配置用户所属组Authorities查询语句
                .passwordEncoder(passwordEncoder())//启用密码加密功能
                .dataSource(dataSource());*/
        auth.userDetailsService(jdbcUserDetailsService)
                .passwordEncoder(passwordEncoder());
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        return new DruidDataSource();
    }

    /**
     * spring5下
     * 解决 There is no PasswordEncoder mapped for the id “null” 的错误
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
