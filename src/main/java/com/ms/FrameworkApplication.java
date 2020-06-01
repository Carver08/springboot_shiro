package com.ms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ms_miao
 * @createTime 2020-05-31 21:09
 */
@SpringBootApplication
@MapperScan("com.ms.mapper")
public class FrameworkApplication {

    public static void main(String[] args) {

        SpringApplication.run(FrameworkApplication.class,args);

    }
}
