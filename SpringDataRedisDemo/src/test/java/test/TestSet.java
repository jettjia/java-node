package test;

import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring/applicationContext-redis.xml")
public class TestSet {
    
    @Autowired
    private RedisTemplate redisTemplate;
    
    /**
     * 添加
     */
    @Test
    public void setValue() {
        redisTemplate.boundSetOps("nameset").add("张三");
        redisTemplate.boundSetOps("nameset").add("李四");
        redisTemplate.boundSetOps("nameset").add("王五");
    }
    
    /**
     * 提取集合中所有的值
     */
    @Test
    public void getValue() {
        Set members = redisTemplate.boundSetOps("nameset").members();
        System.out.println(members);
    }
    
    /**
     * 删除集合中指定的一个值
     */
    @Test
    public void deleteValue() {
        redisTemplate.boundSetOps("nameset").remove("张三");
    }
    
    /**
     * 删除整个集合
     */
    @Test
    public void deleteAllValue() {
        redisTemplate.delete("nameset");
    }
}
