package com.zillionchu.server.zillionchuserverhttp03;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ZillionchuServerHttp03Application {

	public static void main(String[] args) {
		SpringApplication.run(ZillionchuServerHttp03Application.class, args);
	}

}
