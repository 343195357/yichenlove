package com.yc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author HHT
 * @version 1.0
 * @date 2020/6/13 0013 22:12
 */
@RestController
public class HealthApiController {

    @GetMapping("/health")
    public String health(){
        return "Ok";
    }
}
