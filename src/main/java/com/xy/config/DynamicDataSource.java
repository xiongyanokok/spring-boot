package com.xy.config;

import java.util.Random;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import com.xy.enums.DataSourceType;

/**
 * 动态数据源
 * 
 * @author xiongyan
 * @date 2017年3月9日 下午2:45:12
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

	/**
	 * 读数据源个数
	 */
	private Integer dataSourceNum;
	
	/**
	 * 随机函数
	 */
	private Random random;

	/**
	 * 构造方法
	 * 
	 * @param dataSourceNum
	 */
	public DynamicDataSource(Integer dataSourceNum) {
		this.dataSourceNum = dataSourceNum;
		this.random = new Random();
	}

	/**
	 * 确定当前数据源
	 */
	@Override
	protected Object determineCurrentLookupKey() {
		DataSourceType dataSourceType = DataSourceContextHolder.getDataSourceType();
		if (null == dataSourceType || DataSourceType.WRITEDATASOURCE.equals(dataSourceType)) {
			// 读写数据源
			return dataSourceType;
		}
		
		// 读数据源随机分配
		return random.nextInt(dataSourceNum);
	}

}
