package com.github.zillionchu.zillionchucompanybiz;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableSwagger2Doc
@ComponentScan("com.github.zillionchu")
public class ZillionchuCompanyBizApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZillionchuCompanyBizApplication.class, args);
    }

}
