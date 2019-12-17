package com.github.zillionchu.zillionchugenerator;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = {})
@MapperScan("com.github.zillionchu.zillionchugenerator.generator.mapper")
public class ZillionchuGeneratorApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZillionchuGeneratorApplication.class, args);
    }

}
