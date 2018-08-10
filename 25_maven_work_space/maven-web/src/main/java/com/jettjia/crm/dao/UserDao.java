package com.jettjia.crm.dao;

import com.jettjia.crm.domain.User;

public interface UserDao {
    User findUserById(Integer id);
}
