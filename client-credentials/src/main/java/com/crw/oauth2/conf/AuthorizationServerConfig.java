package com.crw.oauth2.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

/**
 * 授权服务
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    // 资源id
    private static final String RESOURCE_ID = "user-resource";

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserDetailsService userDetailsService;


    /**
     * 配置客户端详情
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {

        String finalSecret = "123456";
        clients
                .inMemory() // 内存中存储客户端信息
                .withClient("client-1") // 客户端id
                .resourceIds(RESOURCE_ID) // 资源id
                // 授权类型:每一个客户端（Client）都能够通过明确的配置以及权限来实现不同的授权访问机制
                .authorizedGrantTypes("client_credentials", "refresh_token") // 客户端模式,更新令牌
                .scopes("read") // 访问范围，默认为空则拥有全部范围
                .authorities("oauth2") // 可使用的权限
                .secret(finalSecret) // 客户端安全码
                .and()
                .withClient("client-2")
                .resourceIds(RESOURCE_ID)
                .authorizedGrantTypes("password", "refresh_token") // 密码模式,更新令牌
                .scopes("read")
                .authorities("oauth2")
                .secret(finalSecret);
    }

    /**
     * 配置授权端点 URL
     * <p>
     * 默认授权断点URL：
     * /oauth/authorize：授权端点
     * /oauth/token：令牌端点
     * /oauth/confirm_access：用户确认授权提交端点
     * /oauth/error：授权服务错误信息端点
     * /oauth/check_token：用于资源服务访问的令牌解析端点
     * /oauth/token_key：提供公有密匙的端点，如果你使用JWT令牌的话
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
        endpoints
                //.pathMapping("/oauth/authorize", "/api/oauth") // 参数: 默认端点url，替代端点url
                .tokenStore(InMemoryTokenStore()) // 内存存储token
                .authenticationManager(authenticationManager)
                .userDetailsService(userDetailsService)
                .allowedTokenEndpointRequestMethods(HttpMethod.GET, HttpMethod.POST);
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer oauthServer) {
        //允许表单认证
        //enable client to get the authenticated when using the /oauth/token to get a access token
        //there is a 401 authentication is required if it doesn't allow form authentication for clients when access /oauth/token
        oauthServer.allowFormAuthenticationForClients();
    }

    @Bean
    public TokenStore InMemoryTokenStore() {
        return new InMemoryTokenStore();
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
