package com.ssm.qmxm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

/**
 * * springboot 2.2.1版本，启动之后访问http://localhost:8888 会直接跳转到默认登录页，是由于springboot默认配置了安全策略，在启动类中忽略该配置即可
 */
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class GoodssysApplication {

    public static void main(String[] args) {
        SpringApplication.run(GoodssysApplication.class, args);
    }

}
