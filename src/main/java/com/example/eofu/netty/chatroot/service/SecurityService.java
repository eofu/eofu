package com.example.eofu.netty.chatroot.service;


import com.example.eofu.netty.chatroot.model.vo.ResponseJson;

import javax.servlet.http.HttpSession;

public interface SecurityService {

    ResponseJson login(String username, String password, HttpSession session);
    
    ResponseJson logout(HttpSession session);
}
