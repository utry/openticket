package com.utry.openticket;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@MapperScan(basePackages = "com.utry")
public class OpenticketApplication {

    public static void main(String[] args) {
        SpringApplication.run(OpenticketApplication.class, args);
    }
}
