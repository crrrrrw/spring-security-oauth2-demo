# 准备知识

[理解OAuth 2.0](http://www.ruanyifeng.com/blog/2014/05/oauth_2_0.html)

## 客户端授权方式
- 授权码模式（authorization code）
- 简化模式（implicit）
- 密码模式（resource owner password credentials）
- 客户端模式（client credentials）

# 测试
## 访问未被限制资源：
发送请求：
```
curl --request GET \
  --url http://localhost:8081/product/1 \
  --header 'Cache-Control: no-cache' \
  --header 'Postman-Token: 1a014418-45ce-4468-bd69-48bdde14e718'
```
响应：
```
get product id : 1
```

## 访问被限制授权资源
发送请求：
```
curl --request GET \
  --url http://localhost:8081/user/1 \
  --header 'Cache-Control: no-cache' \
  --header 'Postman-Token: 0a546920-4335-4b67-a264-b8fabd45ed9c'
```
响应：
```
{
    "error": "unauthorized",
    "error_description": "Full authentication is required to access this resource"
}
```


## 客户端模式测试
发送请求：
```
curl --request POST \
  --url http://localhost:8081/oauth/token \
  --header 'Cache-Control: no-cache' \
  --header 'Content-Type: application/x-www-form-urlencoded' \
  --header 'Postman-Token: 439d0ea9-f0c8-4665-bb42-6b7775c16284' \
  --data 'username=user-2&password=123456&grant_type=client_credentials&scope=read&client_id=client-1&client_secret=123456'
```

返回响应：
```
{
    "access_token": "3d89ca0e-5fc0-45c6-ba3e-1c38068c4611",
    "token_type": "bearer",
    "expires_in": 43180,
    "scope": "read"
}
```

## 密码模式测试
发送请求：
```
curl --request POST \
  --url http://localhost:8081/oauth/token \
  --header 'Cache-Control: no-cache' \
  --header 'Content-Type: application/x-www-form-urlencoded' \
  --header 'Postman-Token: b3d87f39-03ee-483c-82f0-e80f57c385b6' \
  --data 'username=user-1&password=123456&grant_type=password&scope=read&client_id=client-2&client_secret=123456'
```

返回响应：
```
{
    "access_token": "8a257131-b7f9-4142-9ab5-540f21e04bf6",
    "token_type": "bearer",
    "refresh_token": "8bc3b108-ac32-4f87-bd45-cd957b1f0c4c",
    "expires_in": 42999,
    "scope": "read"
}
```

## 通过token访问被限制资源
发送请求:
```
curl --request GET \
  --url 'http://localhost:8081/user/1?access_token=3d89ca0e-5fc0-45c6-ba3e-1c38068c4611' \
  --header 'Cache-Control: no-cache' \
  --header 'Postman-Token: 0694d77d-24d1-47af-a526-52f91b6342e9'
```

响应：
```
get user id : 1
```

## 错误的token访问被限制资源
发送请求:
```
curl --request GET \
  --url 'http://localhost:8081/user/1?access_token=123123' \
  --header 'Cache-Control: no-cache' \
  --header 'Postman-Token: ba6914fe-efd3-47d5-af3a-f2af89a503cc'
```

响应：
```
{
    "error": "invalid_token",
    "error_description": "Invalid access token: 123123"
}
```
