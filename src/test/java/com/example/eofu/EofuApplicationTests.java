package com.example.eofu;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.listener.PageReadListener;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.eofu.easyexcel.entity.NationalHazardousWasteInventory;
import com.example.eofu.easyexcel.entity.QyInfo;
import com.example.eofu.easyexcel.importfile.listener.NoModelDataListener;
import com.example.eofu.easyexcel.mapper.NationalHazardousWasteInventoryMapper;
import com.example.eofu.easyexcel.mapper.QyInfoMapper;
import com.example.eofu.mybatisplus.entity.Countrylanguage;
import com.example.eofu.mybatisplus.mapper.CountrylanguageMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest
@Slf4j
class EofuApplicationTests {
    @Autowired
    private CountrylanguageMapper countrylanguageMapper;
    @Autowired
    private NationalHazardousWasteInventoryMapper nationalHazardousWasteInventoryMapper;
    @Autowired
    private QyInfoMapper qyInfoMapper;

    public static void main(String[] args) {

    }

    @Test
    public void test4() {
        String fileName = "C:\\Users\\yangs\\Documents\\Tencent Files\\1352409689\\FileRecv\\亚运会环境保障大气污染源调度清单填报-汇总 全市截止2022.3.25.xlsx";
        // 这里 只要，然后读取第一个sheet 同步读取会自动finish
        EasyExcel.read(fileName, new NoModelDataListener()).sheet().doRead();

        List<Map<Integer, String>> cachedDataList = NoModelDataListener.cachedDataList;
        for (Map<Integer, String> map : cachedDataList) {
            if (map.get(0) != null) {
                QyInfo qyInfo = new QyInfo();
                qyInfo.setYqsybz(map.get(12));
                qyInfo.setQylxr(map.get(8));
                qyInfo.setQylxdh(map.get(9));
                try {

                    qyInfo.setJd(Double.parseDouble(map.get(10)));
                } catch (Exception e) {
                }
                try {
                    qyInfo.setWd(Double.parseDouble(map.get(11)));
                } catch (Exception e) {
                }

                map.entrySet().forEach(System.out::println);
                qyInfoMapper.update(qyInfo, Wrappers.lambdaQuery(QyInfo.class).eq(QyInfo::getQymc, map.get(2)));
            }
        }
    }

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

    @Test
    public void test3() {
        LambdaQueryWrapper<Countrylanguage> queryWrapper = Wrappers.lambdaQuery(Countrylanguage.class);
        queryWrapper.inSql(Countrylanguage::getCountryCode, "123");
        List<Countrylanguage> countrylanguages = countrylanguageMapper.selectList(queryWrapper);
        System.out.println(countrylanguages);
    }

    @Test
    public void nationalHazardousWasteInventoryInsert() {
        String fileName = "C:\\Users\\yangs\\Desktop\\工作簿1.xlsx";
        EasyExcel.read(fileName, NationalHazardousWasteInventory.class, new PageReadListener<NationalHazardousWasteInventory>(dataList -> {
            for (NationalHazardousWasteInventory demoData : dataList) {
                if (demoData.getName() != null) {
                    log.info(demoData.toString());
                    nationalHazardousWasteInventoryMapper.insert(demoData);
                }
            }
        })).sheet().doRead();
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
