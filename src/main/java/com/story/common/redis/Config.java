package com.story.common.redis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * ClassName: Config
 * Package:story-server-java
 * Description:
 *
 * @Auther:songxiaopeng
 * @Create:9/14/23-9:22 AM
 * @Version:1.0
 */
@Configuration
public class Config {

    @Bean
    RedisTemplate<String , String> redisTemplate(RedisConnectionFactory redisConnectionFactory){
        RedisTemplate<String , String> template = new RedisTemplate<>();
        template.setKeySerializer(new StringRedisSerializer());
        template.setHashKeySerializer(new StringRedisSerializer());
        template.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());
        template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        template.setConnectionFactory(redisConnectionFactory);

        return template;
    }

}
