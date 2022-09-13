package com.kafka.third;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@MapperScan(basePackages = {"com.kafka.third.dao"})
public class ThirdApplication {

    public static void main(String[] args) {
        SpringApplication.run(ThirdApplication.class, args);
    }

}
