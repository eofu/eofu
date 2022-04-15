package com.example.eofu.easyexcel.importfile;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.listener.PageReadListener;
import com.alibaba.fastjson.JSON;
import com.example.eofu.easyexcel.entity.NationalHazardousWasteInventory;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Read {
    public static void main(String[] args) {
        String fileName = "C:\\Users\\yangs\\Desktop\\工作簿1.xlsx";
        System.out.println(fileName);
        Read read = new Read();
        read.simpleReader(fileName);
    }

    public void simpleReader(String fileName) {
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
        EasyExcel.read(fileName, NationalHazardousWasteInventory.class, new PageReadListener<NationalHazardousWasteInventory>(dataList -> {
            for (NationalHazardousWasteInventory demoData : dataList) {
                log.info("读取到一条数据{}", JSON.toJSONString(demoData));
            }
        })).sheet().doRead();
    }
}
