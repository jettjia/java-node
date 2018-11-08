package com.imooc.service;

import com.imooc.entity.User;

/**
 * 用户服务
 */
public interface IUserService {
    User findUserByName(String userName);
}
