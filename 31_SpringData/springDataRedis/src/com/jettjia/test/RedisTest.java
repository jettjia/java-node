package com.jettjia.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jettjia.pojo.Users;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class RedisTest {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    
    /**
     * 添加键值对
     */
    @Test
    public void test1() {
        this.redisTemplate.opsForValue().set("key", "test");
    }
    
    /**
     * 获取redis中的数据
     */
    @Test
    public void test2() {
        String string = (String) this.redisTemplate.opsForValue().get("key");
        System.out.println(string);
    }
    
    /**
     * 添加Users
     */
    @Test
    public void test3() {
        Users users = new Users();
        users.setAge(10);
        users.setId(1);
        users.setName("zhangsan");
        // 更換序列化器
        this.redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
        this.redisTemplate.opsForValue().set("users", users);
    }
    
    /**
     * 获取Users
     */
    @Test
    public void test4() {
        this.redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
        Users users = (Users) this.redisTemplate.opsForValue().get("users");
        System.out.println(users);
    }
    
    /**
     * 添加Users Json格式
     */
    @Test
    public void test5() {
        Users users = new Users();
        users.setAge(10);
        users.setId(1);
        users.setName("李四");
        // 更換序列化器
        this.redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(Users.class));
        this.redisTemplate.opsForValue().set("usersjson", users);
    }
    
    /**
     * 获取Users Json格式
     */
    @Test
    public void test6() {
        // 更換序列化器
        this.redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(Users.class));
        Users users = (Users) this.redisTemplate.opsForValue().get("usersjson");
        System.out.println(users);
    }
    
}
