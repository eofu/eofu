package com.example.eofu.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class Countrylanguage implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @TableField(value = "countryCode")
    private String countryCode;
    
    @TableField(value = "language")
    private String language;
    
    @TableField(value = "isOfficial")
    private String isOfficial;
    
    @TableField(value = "percentage")
    private Float percentage;
}
