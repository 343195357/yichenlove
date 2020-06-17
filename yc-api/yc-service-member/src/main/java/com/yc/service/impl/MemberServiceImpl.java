package com.yc.service.impl;

import com.yc.entity.User;
import com.yc.service.IMemberService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author HHT
 * @version 1.0
 * @date 2020/6/14 0014 18:26
 */
@RestController
public class MemberServiceImpl implements IMemberService {
    /*
    * 使用Feign客户端调用的接口
    * */
    @GetMapping("/getMemberByFeign")
    public User getMemberByFeign(@RequestParam(value = "name")String name) {
        User user = new User();
        user.setUserName(name);
        user.setAge(20);
        return user;
    }
}
