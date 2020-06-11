package com.yc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author HHT
 * @version 1.0
 * @date 2020/6/11 0011 22:09
 */
@EnableEurekaServer
@SpringBootApplication
public class AppEureka {
    public static void main(String[] args) {
        SpringApplication.run(AppEureka.class, args);
    }
}
