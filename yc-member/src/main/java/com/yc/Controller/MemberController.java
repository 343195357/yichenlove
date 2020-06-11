package com.yc.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author HHT
 * @version 1.0
 * @date 2020/6/11 0011 22:27
 */
@RestController
public class MemberController {
    /**
     * @return 会员接口
     */
    @RequestMapping("/getMember")
    public String getMember() {
        return "会员接口调用";
    }
}
