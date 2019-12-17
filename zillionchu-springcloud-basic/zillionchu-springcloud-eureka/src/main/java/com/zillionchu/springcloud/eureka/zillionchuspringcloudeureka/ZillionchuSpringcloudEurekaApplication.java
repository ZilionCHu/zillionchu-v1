package com.zillionchu.springcloud.eureka.zillionchuspringcloudeureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


@SpringBootApplication
@EnableEurekaServer
public class ZillionchuSpringcloudEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZillionchuSpringcloudEurekaApplication.class, args);

    }

}
