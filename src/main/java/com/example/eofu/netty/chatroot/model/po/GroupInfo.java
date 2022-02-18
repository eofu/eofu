package com.example.eofu.netty.chatroot.model.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GroupInfo {
    
    private String groupId;
    private String groupName;
    private String groupAvatarUrl;
    private List<UserInfo> members;
}
