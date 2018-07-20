package com.dsef.gjp.gjpdemo;

import com.dsef.gjp.gjpdemo.view.mainview;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GjpdemoApplication {

    public static void main(String[] args) {
        new mainview().run();
    }
}
