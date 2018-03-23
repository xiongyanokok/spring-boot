package com.xy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * redis session 
 * 
 * @author xiongyan
 * @date 2018年3月23日 下午5:18:09
 */
@EnableRedisHttpSession(maxInactiveIntervalInSeconds= 86400)
public class SessionConfiguration {

	@Bean
    public JedisConnectionFactory connectionFactory() {
        return new JedisConnectionFactory();
    }
}
