package com.tiaotiaopoker;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.tiaotiaopoker.service","com.tiaotiaopoker.controller"})
@MapperScan("com.tiaotiaopoker.dao")
public class ToutiaoAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(ToutiaoAdminApplication.class, args);
        System.out.print("server start");
    }
}
