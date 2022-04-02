package com.example.eofu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource(locations = "classpath:/spring/ApplicationContext-netty.xml")
// @MapperScan("com.example.eofu.mybatisplus.mapper.CountrylanguageMapper")
public class EofuApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(EofuApplication.class, args);
    }
}
