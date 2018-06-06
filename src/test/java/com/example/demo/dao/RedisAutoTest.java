package com.example.demo.dao;

import com.example.demo.entity.Account;
import com.example.demo.handler.util.RedisUtil;
import com.example.demo.web.AreaController;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoaderUtils;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * Created by PengHongfu 2018-06-05 10:15
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)

public class RedisAutoTest {
    private final static Logger logger = LoggerFactory.getLogger(RedisAutoTest.class);

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private RedisTemplate<String, Object> redisTemplate;
    @Test
    public void save() {
        stringRedisTemplate.opsForValue().set("zzp", "big z");
        Assert.assertEquals("big z", stringRedisTemplate.opsForValue().get("zzp"));
    }

    @Test
    public void saveObj() {
        ValueOperations<String, Object> operations = redisTemplate.opsForValue();
        Account account = new Account();
        account.setUsername("jsarry");
        account.setPassword("jsjfiAd33");
        // 插入缓存
        operations.set("account3", account,20,TimeUnit.SECONDS);
        Assert.assertEquals(true
                , redisTemplate.hasKey("account1"));

    }
    @Test
    public void saveString() {
        redisUtil.set("stringkey","HELLOWORLD!");
        long time = redisUtil.getExpire("stringkey");
        logger.info("expire time :{}",time);
        Assert.assertEquals("HELLOWORLD!"
                , redisUtil.get("stringkey"));

    }
    @Test
    public void delString() {
        redisUtil.del("stringkey");
        Assert.assertEquals(false
                , redisUtil.hasKey("stringkey"));

    }
}
