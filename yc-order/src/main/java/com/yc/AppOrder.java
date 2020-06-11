package com.yc;

import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author HHT
 * @version 1.0
 * @date 2020/6/11 0011 22:29
 */
@EnableEurekaClient
@SpringBootApplication
@EnableSwagger2
@EnableSwaggerBootstrapUI
public class AppOrder {
    public static void main(String[] args) {
        SpringApplication.run(AppOrder.class, args);
    }

    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
