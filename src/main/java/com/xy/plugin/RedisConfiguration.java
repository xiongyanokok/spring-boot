package com.xy.plugin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * redis 配置
 * 
 * @author xiongyan
 * @date 2017年3月28日 下午5:55:53
 */
@Configuration
@EnableCaching
public class RedisConfiguration {

	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@Autowired
	private RedisTemplate<Object, Object> redisTemplate;

	@Bean
	public CacheManager cacheManager() {
		return new RedisCacheManager(redisTemplate);
	}

	public void set(String key, String value) {
		this.stringRedisTemplate.opsForValue().set(key, value);
	}
	
	public void set(String key, String value, long offset) {
		this.stringRedisTemplate.opsForValue().set(key, value, offset);
	}

	public String get(String key) {
		return this.stringRedisTemplate.opsForValue().get(key);
	}
	
	public void delete(String key) {
		this.stringRedisTemplate.delete(key);
	}
	
	public Boolean exists(String key) {
		return this.stringRedisTemplate.hasKey(key);
	}
}
