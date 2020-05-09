package com.txserver;

import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@MapperScan(value = "com.common.dao*")
@EnableDistributedTransaction
public class TxServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(TxServerApplication.class, args);
    }

}
