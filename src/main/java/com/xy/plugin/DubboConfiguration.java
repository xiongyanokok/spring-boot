package com.xy.plugin;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * dubbo 配置
 * 
 * @author xiongyan
 * @date 2017年3月28日 下午5:55:53
 */
@Configuration
@ImportResource("classpath:/spring/applicationContext-dubbo.xml")
public class DubboConfiguration {
		
}
