package com.zillionchu.server.zilionchuserverhttp01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class ZilionchuServerHttp01Application {

	public static void main(String[] args) {
		SpringApplication.run(ZilionchuServerHttp01Application.class, args);
	}

}
