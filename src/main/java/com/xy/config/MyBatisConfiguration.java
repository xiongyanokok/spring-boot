package com.xy.config;

import java.util.Properties;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.pagehelper.PageHelper;

/**
 * mybatis配置
 * 
 * @author xiongyan
 * @date 2017年3月9日 上午11:28:40
 */
@Configuration
@MapperScan("com.xy.mapper")
public class MyBatisConfiguration extends MybatisAutoConfiguration {
	
	@Autowired
    private DynamicDataSource dataSource;
	
	/**
	 * SqlSessionFactory
	 * 
	 * @return
	 * @throws Exception
	 */
	@Bean
    public SqlSessionFactory sqlSessionFactorys() throws Exception {
        return super.sqlSessionFactory(dataSource);
    }
	
	/**
	 * 分页
	 * 
	 * @return
	 */
	@Bean
	public PageHelper pageHelper() {
		PageHelper pageHelper = new PageHelper();
		Properties properties = new Properties();
		properties.setProperty("dialect", "mysql");
		properties.setProperty("reasonable", "true");
		pageHelper.setProperties(properties);
		return pageHelper;
	}
	
}
