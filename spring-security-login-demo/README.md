## 前言
基于spring-security实现的登录授权验证demo

## HttpSecurity 常用方法及说明
| 方法 | 说明 |
| ---- | ---- |
| `openidLogin()` | 用于基于 OpenId 的验证 |
| `headers()`| 将安全标头添加到响应 |
| `cors()` | 配置跨域资源共享（ CORS ） |
| `sessionManagement()` | 允许配置会话管理 |
| `portMapper()` | 允许配置一个`PortMapper`(`HttpSecurity#(getSharedObject(class))`)，其他提供`SecurityConfigurer`的对象使用 `PortMapper` 从 HTTP 重定向到 HTTPS 或者从 HTTPS 重定向到 HTTP。默认情况下，Spring Security使用一个`PortMapperImpl`映射 HTTP 端口8080到 HTTPS 端口8443，HTTP 端口80到 HTTPS 端口443 |
| `jee()` | 配置基于容器的预认证。 在这种情况下，认证由Servlet容器管理 |
| `x509()` | 配置基于x509的认证 |
| `rememberMe` | 允许配置“记住我”的验证 |
| `authorizeRequests()` | 允许基于使用`HttpServletRequest`限制访问 | 
| `requestCache()` | 允许配置请求缓存 |
| `exceptionHandling()` | 允许配置错误处理 |
| `securityContext()` |  在`HttpServletRequests`之间的`SecurityContextHolder`上设置`SecurityContext`的管理。 当使用`WebSecurityConfigurerAdapter`时，这将自动应用 | 
| `servletApi()` | 将`HttpServletRequest`方法与在其上找到的值集成到`SecurityContext`中。 当使用`WebSecurityConfigurerAdapter`时，这将自动应用 |
| `csrf()` | 添加 CSRF 支持，使用`WebSecurityConfigurerAdapter`时，默认启用 |
| `logout()` | 添加退出登录支持。当使用`WebSecurityConfigurerAdapter`时，这将自动应用。默认情况是，访问URL"/ logout"，使HTTP Session无效来清除用户，清除已配置的任何`#rememberMe()`身份验证，清除`SecurityContextHolder`，然后重定向到"/login?success" |
| `anonymous()` | 允许配置匿名用户的表示方法。 当与`WebSecurityConfigurerAdapter`结合使用时，这将自动应用。 默认情况下，匿名用户将使用`org.springframework.security.authentication.AnonymousAuthenticationToken`表示，并包含角色 "ROLE_ANONYMOUS" |
| `formLogin()` | 指定支持基于表单的身份验证。如果未指定`FormLoginConfigurer#loginPage(String)`，则将生成默认登录页面 |
| `oauth2Login()` | 根据外部OAuth 2.0或OpenID Connect 1.0提供程序配置身份验证 |
| `requiresChannel()` | 配置通道安全。为了使该配置有用，必须提供至少一个到所需信道的映射 |
| `httpBasic()` | 配置 Http Basic 验证 |
| `addFilterAt()`  | 在指定的Filter类的位置添加过滤器 |