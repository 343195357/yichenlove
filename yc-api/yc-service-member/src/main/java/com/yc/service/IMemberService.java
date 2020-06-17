package com.yc.service;

import com.yc.entity.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author HHT
 * @version 1.0
 * @date 2020/6/14 0014 18:17
 */
public interface IMemberService {

    /**
     * 当使用feign传参数的时候,需要加上@RequestParam注解,否则对方服务无法识别参数;
     * @param name
     * @return
     */
    @RequestMapping("/getMemberByFeign")
    User getMemberByFeign(@RequestParam(value = "name") String name);
}
