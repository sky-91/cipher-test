package com.example.ciphertest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@SpringBootApplication
@EnableAspectJAutoProxy(exposeProxy = true)
public class CipherTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(CipherTestApplication.class, args);
    }

}
