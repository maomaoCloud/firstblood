package com.tiaotiaopoker;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class},scanBasePackages = {"com.tiaotiaopoker"})
@PropertySource(value = {"classpath:application.properties"})
@ComponentScan(basePackages = {"com.tiaotiaopoker.dao"})
public class TiaotiaoApiApplication {

    public static void main(String[] args) {

        SpringApplication.run(TiaotiaoApiApplication.class, args);
        System.out.print("server start");
    }
}
