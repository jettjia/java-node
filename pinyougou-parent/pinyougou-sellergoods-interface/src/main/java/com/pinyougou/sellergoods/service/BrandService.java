package com.pinyougou.sellergoods.service;

import java.util.List;
import java.util.Map;

import com.pinyougou.pojo.TbBrand;

import entity.PageResult;

/**
 * 品牌接口
 * @author ThinkPad
 */
public interface BrandService {

    public List<TbBrand> findAll();
    
    /**
     * 品牌分页
     * @param pageNum 当前分页
     * @param pageSize 每页条数
     * @return
     */
    public PageResult findPage(int pageNum, int pageSize);
    
    /**
     * 添加
     * @param brand
     */
    public void add(TbBrand brand);
    
    /**
     * 修改
     * @param brand
     */
    public void update(TbBrand brand);
    
    /**
     * 根据ID获取实体
     * @param id
     * @return
     */
    public TbBrand findOne(Long id);
    
    /**
     * 批量删除
     * @param ids
     */
    public void delete(Long[] ids);
    
    /**
     * 分页查询
     * @param brand
     * @param pageNum
     * @param pageSize
     * @return
     */
    public PageResult findPage(TbBrand brand, int pageNum, int pageSize);
    
    public List<Map> selectOptionList();
}
