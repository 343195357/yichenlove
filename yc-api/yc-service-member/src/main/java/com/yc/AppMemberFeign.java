package com.yc;

import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author HHT
 * @version 1.0
 * @date 2020/6/14 0014 19:02
 */
@EnableEurekaClient
@SpringBootApplication
@EnableSwagger2
@EnableSwaggerBootstrapUI
@EnableFeignClients
public class AppMemberFeign {
    public static void main(String[] args) {
        SpringApplication.run(AppMemberFeign.class, args);
    }
}
