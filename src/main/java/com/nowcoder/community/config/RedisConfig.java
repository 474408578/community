package com.nowcoder.community.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

/**
 * Redis的配置在RedisAutoConfiguration里面，RedisTemplate的配置key为object，
 * 所以将其重写为String
 */
@Configuration
public class RedisConfig {

    // 当定义一个bean的时候，在方法参数中声明一个参数时，Spring会将这个bean自动注入进来
    // 此处Spring会自动将factory注入进来
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        // template有了工厂后，才具备了访问数据库的能力
        template.setConnectionFactory(factory);

        // key的序列化方式
        template.setKeySerializer(RedisSerializer.string());
        // 设置value的序列化方式
        template.setValueSerializer(RedisSerializer.json());
        // 设置hash的key的序列化方式
        template.setHashKeySerializer(RedisSerializer.string());
        // 设置hash的value的序列化方式
        template.setHashValueSerializer(RedisSerializer.json());

        // 触发，使上面的配置生效
        template.afterPropertiesSet();
        return template;
    }
}
