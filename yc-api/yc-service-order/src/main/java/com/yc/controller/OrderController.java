package com.yc.controller;

import com.yc.feign.MemberServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author HHT
 * @version 1.0
 * @date 2020/6/14 0014 18:34
 */
@RestController
public class OrderController {
    @Autowired
    private MemberServiceFeign memberServiceFeign;

    @GetMapping("/getOrderByFeign")
    public String getOrderByFeign(@RequestParam("name")String name){
        return memberServiceFeign.getMemberByFeign(name).toString();
    }
}
