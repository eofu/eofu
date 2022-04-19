package com.example.eofu.easyexcel.importfile;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.listener.PageReadListener;
import com.alibaba.fastjson.JSON;
import com.example.eofu.easyexcel.entity.QyInfo;
import com.example.eofu.easyexcel.importfile.listener.NoModelDataListener;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Read {
    public static void main(String[] args) {
//        String fileName = "C:\\Users\\yangs\\Documents\\Tencent Files\\1352409689\\FileRecv\\亚运会环境保障大气污染源调度清单填报-汇总 全市截止2022.3.25.xlsx";
//        System.out.println(fileName);
//        Read read = new Read();
//        read.simpleReader(fileName);

        String fileName = "C:\\Users\\yangs\\Documents\\Tencent Files\\1352409689\\FileRecv\\亚运会环境保障大气污染源调度清单填报-汇总 全市截止2022.3.25.xlsx";
        // 这里 只要，然后读取第一个sheet 同步读取会自动finish
        EasyExcel.read(fileName, new NoModelDataListener()).sheet().doRead();
    }

    public void simpleReader(String fileName) {
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
        EasyExcel.read(fileName, QyInfo.class, new PageReadListener<QyInfo>(dataList -> {
            for (QyInfo demoData : dataList) {
                log.info("读取到一条数据{}", JSON.toJSONString(demoData));
            }
        })).sheet().doRead();
    }
}
