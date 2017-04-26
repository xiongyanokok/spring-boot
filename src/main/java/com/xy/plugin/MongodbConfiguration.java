package com.xy.plugin;

import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.MongoClient;

/**
 * mongodb 配置
 * 
 * @author xiongyan
 * @date 2017年3月28日 下午5:55:53
 */
@Configuration
public class MongodbConfiguration {
	
	@Autowired
	private MongoPropertiesOne mongoPropertiesOne;

	@Autowired
	private MongoPropertiesTwo mongoPropertiesTwo;

	@Autowired
	private MongoPropertiesThree mongoPropertiesThree;
	
	
	@Primary
	@Bean(name = "mongoTemplateOne")
	public MongoTemplate mongoTemplateOne() throws UnknownHostException {
		MongoClient mongoClient = mongoPropertiesOne.createMongoClient(null, null);
	    return new MongoTemplate(mongoClient, mongoPropertiesOne.getMongoClientDatabase());
	}
	
	@Bean(name = "mongoTemplateTwo")
	public MongoTemplate mongoTemplateTwo() throws UnknownHostException {
		MongoClient mongoClient = mongoPropertiesTwo.createMongoClient(null, null);
	    return new MongoTemplate(mongoClient, mongoPropertiesTwo.getMongoClientDatabase());
	}
	
	@Bean(name = "mongoTemplateThree")
	public MongoTemplate mongoTemplateThree() throws UnknownHostException {
		MongoClient mongoClient = mongoPropertiesThree.createMongoClient(null, null);
	    return new MongoTemplate(mongoClient, mongoPropertiesThree.getMongoClientDatabase());
	}
	
}
