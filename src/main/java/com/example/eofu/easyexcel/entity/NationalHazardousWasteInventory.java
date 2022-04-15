package com.example.eofu.easyexcel.entity;

import com.alibaba.excel.annotation.ExcelIgnore;
import lombok.Data;

import java.io.Serializable;

@Data
public class NationalHazardousWasteInventory  implements Serializable {
    @ExcelIgnore
    private long id;
    private String type;
    private String source;
    private String code;
    private String name;
    private String properties1;
}
