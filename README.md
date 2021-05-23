# 试验spring中几个扩展点的顺序

```
in RequestBodyAdvice, supports
in RequestBodyAdvice, beforeBodyRead
in RequestBodyAdvice, supports
in RequestBodyAdvice, afterBodyRead
校验
in around, before
in before
in controller
in around, after
in after
```

发校验不通的请求，还不到```around```的```before```，即校验在切面之前  
校验不同的请求示例：
```
curl -XPOST localhost:8080/hello -d "{"""msg""":null}" -H "Content-Type: application/json"
```
校验在```RequestResponseBodyMethodProcessor#resolveArgument(...)```