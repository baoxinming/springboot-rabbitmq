package com.itheima.controller;

import com.itheima.service.UserService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    //注入Service
    //@Autowired//本地注入

    /*
        1. 从zookeeper注册中心获取userService的访问url
        2. 进行远程调用
        3. 将结果封装为一个代理对象。给变量赋值

     */

    /**
     * 注意接口的问题：
     * 在实际开发中，服务方和消费方都要定义同样的接口，这样才能在消费方中声明和使用
     */
    @Reference//远程注入
    private UserService userService;

    @RequestMapping("/sayHello")
    public String sayHello(){
        return userService.sayHello();
    }

}

