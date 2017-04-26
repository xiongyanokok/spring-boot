package com.xy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
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
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
