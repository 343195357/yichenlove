package com.yc.controller;

import com.yc.common.annotation.YcLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: 登录管理
 * @Author YiChenLove
 * @Date 2020/6/16
 **/
@RestController
@Api("登录管理")
public class LoginController {
    @GetMapping("/login")
    @YcLog(modulName = "系统模块",functionName = "登录功能")
    @ApiOperation("登录")
    public String login(String name, String password){
        System.out.println("登录验证");
        return name+"登录成功,登录密码："+password;
    }
}
