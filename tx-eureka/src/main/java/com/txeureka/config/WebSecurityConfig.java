package com.txeureka.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 新版（Spring Cloud 2.0 以上）的security默认启用了csrf检验，要在eurekaServer端配置security的csrf检验为false
     *它将要求在每次向应用程序发送请求时都发送有效的CSRF令牌。
     * Eureka客户通常不会拥有有效的跨站点请求伪造（CSRF）令牌，您需要为/eureka/**端点禁用此要求
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        super.configure(http);
    }
}
