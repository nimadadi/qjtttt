package com.qjt.qjtttt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.qjt.qjtttt.common.dao")
public class QjttttApplication {

    public static void main(String[] args) {
        SpringApplication.run(QjttttApplication.class, args);
    }

}
