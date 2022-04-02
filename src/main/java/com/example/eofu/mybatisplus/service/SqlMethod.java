package com.example.eofu.mybatisplus.service;

public enum SqlMethod {
    GET_LIST("getList", "获取缓存", "<script>%s SELECT %s FROM %s %s %s\n</script>");
    
    private final String method;
    private final String desc;
    private final String sql;
    
    SqlMethod(String method, String desc, String sql) {
        this.method = method;
        this.desc = desc;
        this.sql = sql;
    }
    
    public String getMethod() {
        return method;
    }
    
    public String getDesc() {
        return desc;
    }
    
    public String getSql() {
        return sql;
    }
}
