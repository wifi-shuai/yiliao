package com.yiliao.health;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan(value = "com.yiliao.health.mapper")
@SpringBootApplication
public class HealthApplication {

    public static void main(String[] args) {
        SpringApplication.run(HealthApplication.class, args);
    }

}
