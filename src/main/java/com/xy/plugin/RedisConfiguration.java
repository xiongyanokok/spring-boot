package com.xy.plugin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * redis 配置
 * 
 * @author xiongyan
 * @date 2017年3月28日 下午5:55:53
 */
@Configuration
@EnableCaching
public class RedisConfiguration<K, T> {

	@Autowired
	private RedisTemplate<K, T> redisTemplate;

	@Bean
	public CacheManager cacheManager() {
		return new RedisCacheManager(redisTemplate);
	}

	public void set(K k, T t) {
		this.redisTemplate.opsForValue().set(k, t);
	}
	
	public void set(K k, T t, long offset) {
		this.redisTemplate.opsForValue().set(k, t, offset);
	}

	public T get(K k) {
		return this.redisTemplate.opsForValue().get(k);
	}
	
	public void delete(K k) {
		this.redisTemplate.delete(k);
	}
	
	public Boolean exists(K k) {
		return this.redisTemplate.hasKey(k);
	}
}
