package com.roncoo.eshop.inventory.service;

import com.roncoo.eshop.inventory.model.User;

/**
 * 用户Service
 * @author ThinkPad
 *
 */
public interface UserService {

    /**
     * 查询用户信息
     * @return
     */
    public User findUserInfo();
    
    /**
     * 查询redis中缓存的用户信息
     * @return
     */
    public User getCachedUserInfo();
}
