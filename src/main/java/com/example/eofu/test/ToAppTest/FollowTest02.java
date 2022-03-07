package com.example.eofu.test.ToAppTest;

import com.example.eofu.test.ToAppTest.TestUtil.AppConstance;
import com.example.eofu.test.ToAppTest.TestUtil.DateUtil;
import com.example.eofu.test.ToAppTest.TestUtil.EncryptUtils;
import com.example.eofu.test.ToAppTest.TestUtil.HttpClientUtil;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yangshuai
 */
public class FollowTest02 {
    public static void main(String[] args) throws InvalidAlgorithmParameterException, NoSuchPaddingException, IOException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        FollowTest02 test01 = new FollowTest02();
        String param = "{\"attributesMap\":{},\"followInfoList\":[{\"followType\":\"2\",\"id\":\"1\"},{\"followType\":\"2\",\"id\":\"112341234\"},{\"followType\":\"2\",\"id\":\"1123412341\"}],\"mobileUserId\":\"3e91b71f28614109a339236dcf4f5a0b\"}\n";
        String number = "FOW0005";
        test01.doPost(param, number);
        
    }
    
    public void doPost(String param, String number) throws InvalidAlgorithmParameterException, NoSuchPaddingException, UnsupportedEncodingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        
        System.out.println(param);
        String aesTimeStamp = DateUtil.formatData(new Date(), "yyyyMMddHHmm");
        String sign = EncryptUtils.md5Encrypt(AppConstance.APP_REQUEST_MD5_KEY, param + aesTimeStamp);
        String timeStamp = DateUtil.formatData(new Date(), "yyyyMMddHHmmss");
        System.out.println(timeStamp);
        System.out.println(sign);
        String paramData = EncryptUtils.encryptGeneralAES(sign + param + aesTimeStamp, AppConstance.APP_REQUEST_ASE_KEY, AppConstance.IV_STRING);
        System.out.println(paramData);
        Map<String, String> map = new HashMap<>();
        map.put("apiCode", number);
        map.put("timeStamp", timeStamp);
        map.put("sign", sign);
        map.put("paramData", paramData);
        map.put("businessType", "APP_TO_TRADDING");
        for (Map.Entry<String, String> stringStringEntry : map.entrySet()) {
            System.out.println(stringStringEntry);
        }
        String result = HttpClientUtil.doPost("http://192.168.1.63:9527/app", map);
        String s = EncryptUtils.decryptGeneralAES(result, AppConstance.APP_REQUEST_ASE_KEY, AppConstance.IV_STRING);
        System.out.println("result: " + s);
    }
}
