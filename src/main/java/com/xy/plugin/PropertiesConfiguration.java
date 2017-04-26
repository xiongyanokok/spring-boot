package com.xy.plugin;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

/**
 * Properties 配置
 * 
 * @author xiongyan
 * @date 2017年3月28日 下午5:55:53
 */
@Configuration
public class PropertiesConfiguration {
	
	/**
	 * 加载common.properties文件内容到内存中
	 * 
	 * @return
	 */
	@Bean
    public PropertySourcesPlaceholderConfigurer createPropertySourcesPlaceholderConfigurer() {
        ClassPathResource resource = new ClassPathResource("common.properties");
        PropertySourcesPlaceholderConfigurer propertyPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
        propertyPlaceholderConfigurer.setLocation(resource);
        return propertyPlaceholderConfigurer;
    }
	
}
