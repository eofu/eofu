package com.example.eofu;

import com.example.eofu.mybatisplus.entity.Countrylanguage;
import com.example.eofu.mybatisplus.mapper.CountrylanguageMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class EofuApplicationTests {
    @Autowired
    private CountrylanguageMapper countrylanguageMapper;
    
    @Test
    public void test2() {
        List<Countrylanguage> list3 = countrylanguageMapper.getList3();
        System.out.println(list3);
        for (Countrylanguage countrylanguage : list3) {
            System.out.println(countrylanguage);
        }
        Countrylanguage countrylanguage = new Countrylanguage();
        countrylanguageMapper.insert(countrylanguage);
        // Countrylanguage countrylanguage = new Countrylanguage();
        // countrylanguage.setCountryCode("1");
        // Countrylanguage countrylanguages = countrylanguageMapper.selectOne(new QueryWrapper<>(countrylanguage));
        // System.out.println(countrylanguages);
    
        // List<Countrylanguage> list = new LambdaQueryChainWrapper<>(countrylanguageMapper).list();
        // System.out.println(list);
    }
    
}
