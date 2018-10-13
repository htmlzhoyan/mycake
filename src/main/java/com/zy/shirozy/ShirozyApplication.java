package com.zy.shirozy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zy.shirozy.mapper")
public class ShirozyApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShirozyApplication.class, args);
    }
}
