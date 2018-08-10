package cn.itcast.crm.service.impl;

import java.util.List;

import cn.itcast.crm.dao.ICustomerDao;
import cn.itcast.crm.domain.Customer;
import cn.itcast.crm.service.ICustomerService;

public class CustomerService implements ICustomerService {
    private ICustomerDao customerDao;

    public void setCustomerDao(ICustomerDao customerDao) {
        this.customerDao = customerDao;
    }
    
    public List<Customer> findAll() {
        return customerDao.findAll();
    }
}
