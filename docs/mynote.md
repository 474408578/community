登录的逻辑过程：
```
https://www.processon.com/view/link/5c90a8f3e4b0afc744179184
```
这个逻辑是用户每次请求都需要处理的，所以这个逻辑可以使用拦截器来实现。

@ControllerAdvice:
    - 用于修饰类，表示该类时Controller的全局配置类。
    - 在此类中，可以付Controller进行如下三种配置：异常处理方案、绑定数据方案、绑定参数方案

@ExceptionHandler：
    - 用于修饰方法，该方法会在Controller出现异常后被调用，用于处理捕获到的异常

@ModelAttribute：
    - 用于修饰方法，该方法会在Controller方法执行前被调用，用于为Model对象绑定参数

@DataBinder
    - 用于修饰方法，该方法会在Controller方法执行前被调用，用于绑定参数的转换器。