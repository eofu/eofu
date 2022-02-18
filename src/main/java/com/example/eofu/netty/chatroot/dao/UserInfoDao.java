package com.example.eofu.netty.chatroot.dao;


import com.example.eofu.netty.chatroot.model.po.UserInfo;

public interface UserInfoDao {

    void loadUserInfo();
    
    UserInfo getByUsername(String username);
    
    UserInfo getByUserId(String userId);
}
