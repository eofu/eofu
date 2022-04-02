package com.example.eofu.utils.mybatisplus;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

public class GenerateQuickly {
    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/world?autoReconnect=true&useUnicode=true&characterEncoding=utf-8&wait_timeout=1814400&serverTimezone=Asia/Shanghai", "root", "root").globalConfig(builder -> {
            // 设置作者
            builder.author("baomidou")
                   // 开启 swagger 模式
                   .enableSwagger()
                   // 覆盖已生成文件
                   .fileOverride()
                   // 指定输出目录
                   .outputDir("D:\\projectFiles\\generate");
        }).packageConfig(builder -> {
            // 设置父包名
            builder.parent("com.example.eofu.mybatisplus").moduleName("eofu") // 设置父包模块名
                   // 设置mapperXml生成路径
                   .pathInfo(Collections.singletonMap(OutputFile.mapper, "D:\\projectFiles\\generate"));
        }).strategyConfig(builder -> {
            // 设置需要生成的表名
            builder.addInclude("countrylanguage")
                   // 设置过滤表前缀
                   .addTablePrefix("t_", "c_");
            // 使用Freemarker引擎模板，默认的是Velocity引擎模板
        }).templateEngine(new FreemarkerTemplateEngine()).execute();
    }
}
