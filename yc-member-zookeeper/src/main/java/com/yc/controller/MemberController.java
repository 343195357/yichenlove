package com.yc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author HHT
 * @version 1.0
 * @date 2020/6/14 0014 10:13
 */
@RestController
public class MemberController {
    @GetMapping("/getMember")
    public String getMember(){
        return "调用zookeeper会员服务";
    }
}
