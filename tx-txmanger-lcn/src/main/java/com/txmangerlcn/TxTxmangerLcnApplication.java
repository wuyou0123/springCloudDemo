package com.txmangerlcn;

import com.codingapi.txlcn.tm.config.EnableTransactionManagerServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableTransactionManagerServer
@EnableEurekaClient
public class TxTxmangerLcnApplication {

    public static void main(String[] args) {
        SpringApplication.run(TxTxmangerLcnApplication.class, args);
    }

}
