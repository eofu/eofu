package com.example.eofu.netty.chatroot.model.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {
    private String userId;
    private String username;
    private String password;
    private String avatarUrl;
    private List<UserInfo> friendList;
    private List<GroupInfo> groupList;
}
