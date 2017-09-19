package com.xy.config;

import com.xy.enums.DataSourceType;

/**
 * 数据源上下文
 * 
 * @author xiongyan
 * @date 2017年3月9日 下午2:45:39
 */
public class DataSourceContextHolder {

	private DataSourceContextHolder() {
		
	}
	
	/**
	 * ThreadLocal
	 */
	private static final ThreadLocal<DataSourceType> contextHolder = new ThreadLocal<>();

	/**
	 * 设置读写数据源
	 */
	public static void write() {
		contextHolder.set(DataSourceType.WRITEDATASOURCE);
	}
	
	/**
	 * 设置读数据源
	 */
	public static void read() {
		contextHolder.set(DataSourceType.READDATASOURCE);
	}

	/**
	 * 是否可读写数据源
	 * @return
	 */
	public static boolean isWriteDB() {
		return DataSourceType.WRITEDATASOURCE.equals(getDataSourceType());
	}
	
	/**
	 * 获取数据源
	 * 
	 * @return
	 */
	public static DataSourceType getDataSourceType() {
		return contextHolder.get();
	}

	/**
	 * 删除此线程本地的当前线程的值
	 */
	public static void remove() {
		contextHolder.remove();
	}
}
