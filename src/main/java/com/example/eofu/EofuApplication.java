package com.example.eofu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource(locations = "classpath:/spring/ApplicationContext-netty.xml")
@MapperScan({
        "com.example.eofu.easyexcel.mapper",
        "com.example.eofu.mybatisplus.mapper.*"
})
public class EofuApplication {

    public static void main(String[] args) {
        SpringApplication.run(EofuApplication.class, args);
    }
}
