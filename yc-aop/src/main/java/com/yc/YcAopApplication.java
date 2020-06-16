package com.yc;

import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Description: AOP+注解实现自定义日志
 * @Author YiChenLove
 * @Date 2020/6/16
 **/
@SpringBootApplication
@EnableSwagger2
@EnableSwaggerBootstrapUI
public class YcAopApplication {
    public static void main(String[] args) {
        SpringApplication.run(YcAopApplication.class, args);
    }
}
