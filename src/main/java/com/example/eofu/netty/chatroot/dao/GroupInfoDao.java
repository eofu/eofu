package com.example.eofu.netty.chatroot.dao;


import com.example.eofu.netty.chatroot.model.po.GroupInfo;

public interface GroupInfoDao {

    void loadGroupInfo();
    
    GroupInfo getByGroupId(String groupId);
}
