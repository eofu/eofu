package com.example.eofu.mybatisplus.service;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import com.baomidou.mybatisplus.extension.toolkit.ChainWrappers;

import java.util.List;

public interface MyBaseMapper<T> extends BaseMapper<T> {
    default LambdaQueryChainWrapper<T> lambdaQuery() {
        return ChainWrappers.lambdaQueryChain(this);
    }
    
    default QueryChainWrapper<T> query() {
        return ChainWrappers.queryChain(this);
    }
    
    default List<T> getList2(){
        return query().list();
    }
    
    List<T> getList3();
}
