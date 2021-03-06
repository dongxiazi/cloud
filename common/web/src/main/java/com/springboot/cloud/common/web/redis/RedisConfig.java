package com.springboot.cloud.common.web.redis;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;

import java.time.Duration;

/**
 * @description:
 * @author: dongxiazi
 * @create: 2020/12/25 11:07
 */
@Configuration
public class RedisConfig extends CachingConfigurerSupport {
    @Bean
    public CacheManager cacheManager(RedisConnectionFactory factory){
        //对象的序列化
        RedisSerializationContext.SerializationPair<Object> valueSerializationPair = RedisSerializationContext.SerializationPair.fromSerializer(jackson2JsonRedisSerializer());
        //全局redis缓存过期时间
        RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(Duration.ofDays(1))
                .serializeValuesWith(valueSerializationPair);
        return new RedisCacheManager(RedisCacheWriter.nonLockingRedisCacheWriter(factory),redisCacheConfiguration);
    }

    private Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer() {
        Jackson2JsonRedisSerializer<Object> jackson2JsonSerializer = new Jackson2JsonRedisSerializer<>(Object.class);
        jackson2JsonSerializer.setObjectMapper(objectMapper());
        return jackson2JsonSerializer;

    }
    private ObjectMapper objectMapper(){
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        return objectMapper;
    }

}
