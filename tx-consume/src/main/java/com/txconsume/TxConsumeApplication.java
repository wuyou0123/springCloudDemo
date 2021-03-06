package com.txconsume;

import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableEurekaClient
@SpringBootApplication(scanBasePackages = {"com.common", "com.txconsume"})
@EnableFeignClients(basePackages = {"com.common" ,"tx-consume"})
@EnableDistributedTransaction
public class TxConsumeApplication {

    public static void main(String[] args) {
        SpringApplication.run(TxConsumeApplication.class, args);
    }

}
