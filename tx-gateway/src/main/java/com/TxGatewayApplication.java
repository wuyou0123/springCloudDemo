package com;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TxGatewayApplication {

    @Value("${consume.tx-consume.uri}")
    private  String uri;

    public static void main(String[] args) {
        SpringApplication.run(TxGatewayApplication.class, args);
    }

    /***
     * HTTPBin的延迟API，该API在发送响应之前等待一定秒数。由于此API可能需要很长时间才能发送其响应
       因此我们可以将使用此API的路由包装到HystrixCommand
     * @param builder
     * @return
     */
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p.path("/test/**")
                        .filters(f -> f.addRequestHeader("Hello", "World"))
                        .uri(uri)).
               /* .route(p -> p
                        .host("*.hystrix.com")
                        .filters(f -> f.hystrix(config -> config.setName("mycmd")))
                        .uri("http://httpbin.org:80")).*/
                        build();
    }

}
