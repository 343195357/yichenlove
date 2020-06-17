package com.yc;

import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author HHT
 * @version 1.0
 * @date 2020/6/11 0011 22:24
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableSwagger2
@EnableSwaggerBootstrapUI
public class AppMemberConsul {
    public static void main(String[] args) {
        SpringApplication.run(AppMemberConsul.class, args);
    }
}
