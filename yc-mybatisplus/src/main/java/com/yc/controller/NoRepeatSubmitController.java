package com.yc.controller;

import com.yc.annotation.NoRepeatSubmit;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author HHT
 * @version 1.0
 * @date 2020/6/9 0009 22:34
 */
@RestController
@Api(tags = "springBoot防止重复提交")
public class NoRepeatSubmitController {

    @GetMapping("/noRepeat")
    @NoRepeatSubmit
    @ApiOperation("缓存校验重复提交")
    public String test() {
        return ("程序逻辑返回");
    }

}
