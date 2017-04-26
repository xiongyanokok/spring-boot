package com.xy.config;

import java.util.Arrays;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * druid多数据源
 * 
 * @author xiongyan
 * @date 2017年3月9日 上午10:22:26
 */
@Configuration
public class DruidDataSourceConfiguration {
	
	/**
	 * 读写数据源
	 * 
	 * @return
	 */
	@Bean(name = "writeDataSource", destroyMethod = "close", initMethod = "init")
	@ConfigurationProperties(prefix = "spring.mysql.write")
	public DataSource writeDataSource() {
		return new DruidDataSource();
	}

	/**
	 * 读数据源one
	 * 
	 * @return
	 */
	@Bean(name = "readDataSourceOne", destroyMethod = "close", initMethod = "init")
	@ConfigurationProperties(prefix = "spring.mysql.read1")
	public DataSource readDataSourceOne() {
		return new DruidDataSource();
	}

	/**
	 * 读数据源two
	 * 
	 * @return
	 */
	@Bean(name = "readDataSourceTwo", destroyMethod = "close", initMethod = "init")
	@ConfigurationProperties(prefix = "spring.mysql.read2")
	public DataSource readDataSourceTwo() {
		return new DruidDataSource();
	}

	/**
	 * 读数据源
	 * 
	 * @return
	 */
	@Bean(name = "readDataSources")
	public List<DataSource> readDataSources(@Qualifier("readDataSourceOne") DataSource readDataSourceOne, @Qualifier("readDataSourceTwo") DataSource readDataSourceTwo) {
		return Arrays.asList(readDataSourceOne, readDataSourceTwo);
	}
	
}
