package com.common.utils;

import com.alibaba.fastjson.JSON;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;


@Component
public class RedisUtil {


    @Resource
    RedisTemplate<String, Object> redisTemplate;
    @Resource
    ValueOperations<String, String> valueOperations;
    @Resource
    HashOperations<String, String, Object> hashOperations;
    @Resource
    ListOperations<String, Object> listOperations;
    @Resource
    SetOperations<String, Object> setOperations;
    @Resource
    ZSetOperations<String, Object> zSetOperations;

    /**
     * 默认过期时长，单位：秒
     */
    public final static long DEFAULT_EXPIRE = 7200;


    //判断redis中是否存在该key
    public boolean exists(String key) {
        return redisTemplate.hasKey(key);
    }

    //在redis中存储token和对象
    public void set(String key, Object value) {
        try {
            valueOperations.set(key, JSON.toJSONString(value));
        } catch (Exception e0) {
            System.out.println(e0.getMessage());
        }
    }

    //存字符串
    public void setString(String key, String value) {
        try {
            valueOperations.set(key, value);
        } catch (Exception e0) {
            System.out.println(e0.getMessage());
        }
    }

    //存字符串
    public void setString(String key, String value, long expire) {
        try {
            valueOperations.set(key, value,expire,TimeUnit.SECONDS);
        } catch (Exception e0) {
            System.out.println(e0.getMessage());
        }
    }
    //根据键获取值
    public String getValue(String key) {
        String s = valueOperations.get(key);
        return s;
    }

    //删除redis中的数据
    public void delete(String key) {
        redisTemplate.delete(key);
    }

    public void set(String key, Object value, long expireL) {
        //存储键和值
        valueOperations.set(key, JSON.toJSONString(value));
        //设置过期时间
        redisTemplate.expire(key, expireL, TimeUnit.SECONDS);
    }

}
