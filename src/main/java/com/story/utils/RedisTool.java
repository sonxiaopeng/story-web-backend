package com.story.utils;

import jakarta.annotation.Resource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * ClassName: RedisTool
 * Package:story-server-java
 * Description:
 *
 * @Auther:songxiaopeng
 * @Create:9/14/23-12:49 PM
 * @Version:1.0
 */

@Service
public class RedisTool {

    @Resource
    private RedisTemplate<String , String> redisTemplate;

    public void setKey(String key , String value){
        redisTemplate.opsForValue().set(key , value);
    }

    public String getKey(String key){
        return redisTemplate.opsForValue().get(key);
    }

    public void deleteKey(String key){
        redisTemplate.delete(key);
    }
}
