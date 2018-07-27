package com.dsef.gjp.gjpdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class GjpdemoApplication {
    public static void main(String[] args) {
//        new mainview().run();
        SpringApplication.run(GjpdemoApplication.class,args);
    }
}
