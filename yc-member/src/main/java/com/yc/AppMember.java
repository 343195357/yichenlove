package com.yc;

import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author HHT
 * @version 1.0
 * @date 2020/6/11 0011 22:24
 */
@EnableEurekaClient
@SpringBootApplication
@EnableSwagger2
@EnableSwaggerBootstrapUI
public class AppMember {
    public static void main(String[] args) {
        SpringApplication.run(AppMember.class, args);
    }
}
