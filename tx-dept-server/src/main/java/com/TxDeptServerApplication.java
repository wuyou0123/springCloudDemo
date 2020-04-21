package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@MapperScan(value = "com.common.dao.mapper")
public class TxDeptServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(TxDeptServerApplication.class, args);
    }

}
