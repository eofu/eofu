package com.example.eofu;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.example.eofu.mybatisplus.service.MySqlInject;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.example.eofu.mybatisplus.mapper")
public class MybatisPlusConfig {
    
    @Bean
    public ISqlInjector sqlInjector() {
        return new MySqlInject();
    }
    
}
