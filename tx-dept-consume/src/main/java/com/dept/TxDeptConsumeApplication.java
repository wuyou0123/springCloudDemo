package com.dept;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableEurekaClient
@SpringBootApplication(scanBasePackages = {"com.common", "com.dept"})
@EnableFeignClients(basePackages = {"com.common" ,"tx-dept-consume"})
public class TxDeptConsumeApplication {

    public static void main(String[] args) {
        SpringApplication.run(TxDeptConsumeApplication.class, args);
    }

}
