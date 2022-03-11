package com.pun.org.free;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class WebsocketsGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebsocketsGatewayApplication.class, args);
    }

}
