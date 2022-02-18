package com.example.eofu.netty.chatroot.service;


import com.example.eofu.netty.chatroot.model.vo.ResponseJson;

public interface UserInfoService {

    ResponseJson getByUserId(String userId);
}
