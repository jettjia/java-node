package com.roncoo.eshop.inventory.dao.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.roncoo.eshop.inventory.dao.RedisDAO;

import redis.clients.jedis.JedisCluster;

@Repository("redisDAO")
public class RedisDaoImpl implements RedisDAO {
    
    @Resource
    private JedisCluster jedisCluster;

    @Override
    public void set(String key, String value) {
        jedisCluster.set(key, value);
    }

    @Override
    public String get(String key) {
        return jedisCluster.get(key);
    }

}
