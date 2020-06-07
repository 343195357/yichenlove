package com.yc;

import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author HHT
 * @version 1.0
 * @date 2020/6/6 0006 13:52
 */
@SpringBootApplication
@EnableSwagger2
@EnableSwaggerBootstrapUI
@MapperScan("com.yc.dao.*")
public class mybatisplusApplication {
    public static void main(String[] args) {
        SpringApplication.run(mybatisplusApplication.class, args);
    }
}

