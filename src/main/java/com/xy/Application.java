package com.xy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;

/**
 * 启动服务
 * 
 * @author xiongyan
 * @date 2017年3月9日 上午9:54:50
 */
@ServletComponentScan
@SpringBootApplication
@ImportResource("classpath:/spring/applicationContext-disconf.xml")
public class Application {
	
	@Bean
	public EmbeddedServletContainerCustomizer containerCustomizer() {
		return new EmbeddedServletContainerCustomizer() {
			@Override
			public void customize(ConfigurableEmbeddedServletContainer container) {
				container.setSessionTimeout(86400); // 一天
			}
		};
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
