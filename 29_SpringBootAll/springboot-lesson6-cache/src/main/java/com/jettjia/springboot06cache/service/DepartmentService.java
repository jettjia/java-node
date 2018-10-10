package com.jettjia.springboot06cache.service;

import com.jettjia.springboot06cache.bean.Department;
import com.jettjia.springboot06cache.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.Cache;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {
    @Autowired
    DepartmentMapper departmentMapper;

    @Qualifier("deptCacheManager")
    @Autowired
    RedisCacheManager deptCacheManager;

    public Department getDeptById(Integer id) {
        System.out.println("查询部门" + id);
        Department department = departmentMapper.getDeptById(id);

        //获取某个缓存
        Cache dept = deptCacheManager.getCache("dept");
        dept.put("dept:1", department);
        return department;
    }
}
