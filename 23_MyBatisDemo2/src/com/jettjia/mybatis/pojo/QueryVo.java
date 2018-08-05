package com.jettjia.mybatis.pojo;

import java.util.List;

public class QueryVo {
    
    // 用户对象
    private User user;
    
    // 用户id list集合
    private List<Integer> ids;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }
    
}
