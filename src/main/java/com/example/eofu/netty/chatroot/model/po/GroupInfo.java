package com.example.eofu.netty.chatroot.model.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class GroupInfo {
    
    private String groupId;
    private String groupName;
    private String groupAvatarUrl;
    private List<UserInfo> members;
}
