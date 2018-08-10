package cn.itcast.crm.web.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import cn.itcast.crm.domain.Customer;
import cn.itcast.crm.service.impl.CustomerService;

public class CustomerAction {
    private CustomerService customerService;

    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }
    
    public String list() {
        List<Customer> list = customerService.findAll();
        System.out.println(list);
        ServletActionContext.getContext().put("list", list);
        return "list";
    }
}
