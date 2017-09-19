package com.xy.config;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.xy.enums.DataSourceType;

/**
 * 动态数据源配置
 * 
 * @author xiongyan
 * @date 2017年3月9日 下午6:22:10
 */
@Configuration
public class DynamicDataSourceConfiguration {

	/**
	 * 读写数据源
	 */
	@Resource(name = "writeDataSource")
	private DataSource writeDataSource;

	/**
	 * 读数据源
	 */
	@Resource(name = "readDataSources")
	private List<DataSource> readDataSources;

	/**
	 * 动态数据源
	 * 
	 * @return
	 */
	@Bean
	@Primary
	public DynamicDataSource dynamicDataSource() {
		Map<Object, Object> targetDataSources = new HashMap<>();
		targetDataSources.put(DataSourceType.WRITEDATASOURCE, writeDataSource);
		int i = 0;
		for (DataSource readDataSource : readDataSources) {
			targetDataSources.put(i++, readDataSource);
		}

		// 动态数据源
		DynamicDataSource dataSource = new DynamicDataSource(readDataSources.size());
		dataSource.setTargetDataSources(targetDataSources);// 数据源集合
		dataSource.setDefaultTargetDataSource(writeDataSource);// 默认数据源
		return dataSource;
	}
	
}
