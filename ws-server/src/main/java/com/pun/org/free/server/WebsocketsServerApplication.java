package com.pun.org.free.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication(exclude = UserDetailsServiceAutoConfiguration.class)
public class WebsocketsServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebsocketsServerApplication.class, args);
	}

}
