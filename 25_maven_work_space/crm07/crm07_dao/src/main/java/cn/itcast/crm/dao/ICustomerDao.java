package cn.itcast.crm.dao;

import java.util.List;

import cn.itcast.crm.domain.Customer;

public interface ICustomerDao {
    
    public List<Customer> findAll();
}
