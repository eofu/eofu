package com.example.eofu.netty.chatroot.service.impl;

import com.example.eofu.netty.chatroot.dao.UserInfoDao;
import com.example.eofu.netty.chatroot.model.po.UserInfo;
import com.example.eofu.netty.chatroot.model.vo.ResponseJson;
import com.example.eofu.netty.chatroot.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoDao userInfoDao;
    
    @Override
    public ResponseJson getByUserId(String userId) {
        UserInfo userInfo = userInfoDao.getByUserId(userId);
        return new ResponseJson().success()
                .setData("userInfo", userInfo);
    }

}
