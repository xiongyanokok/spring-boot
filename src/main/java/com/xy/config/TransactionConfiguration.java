package com.xy.config;

import java.util.Properties;
import java.util.Set;

import org.springframework.aop.framework.autoproxy.BeanNameAutoProxyCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionInterceptor;

/**
 * 事务管理配置
 * 
 * @author xiongyan
 * @date 2017年3月9日 下午2:00:34
 */
@Configuration
@EnableTransactionManagement
public class TransactionConfiguration {

	/**
	 * 事物方法前缀
	 */
	private Set<String> transactionMethods;

	@Autowired
	private DynamicDataSource dataSource;

	/**
	 * 事物管理器
	 * 
	 * @param dataSource
	 * @return
	 */
	@Bean
	public PlatformTransactionManager transactionManager() {
		return new DataSourceTransactionManager(dataSource);
	}

	/**
	 * 事物拦截器
	 * 
	 * @param transactionManager
	 * @return
	 */
	@Bean
	public TransactionInterceptor transactionInterceptor(PlatformTransactionManager transactionManager) {
		TransactionInterceptor transactionInterceptor = new TransactionInterceptor();
		// 事物管理器
		transactionInterceptor.setTransactionManager(transactionManager);
		Properties transactionAttributes = new Properties();

		// save,insert,update,remove,delete,batch,cancel
		// 开头的方法使用PROPAGATION_REQUIRED传播特性
		transactionAttributes.setProperty("save*", "PROPAGATION_REQUIRED,-Throwable");
		transactionAttributes.setProperty("insert*", "PROPAGATION_REQUIRED,-Throwable");
		transactionAttributes.setProperty("update*", "PROPAGATION_REQUIRED,-Throwable");
		transactionAttributes.setProperty("remove*", "PROPAGATION_REQUIRED,-Throwable");
		transactionAttributes.setProperty("delete*", "PROPAGATION_REQUIRED,-Throwable");
		transactionAttributes.setProperty("batch*", "PROPAGATION_REQUIRED,-Throwable");
		transactionAttributes.setProperty("cancel*", "PROPAGATION_REQUIRED,-Throwable");
		// 其他方法都使用PROPAGATION_SUPPORTS传播特性
		transactionAttributes.setProperty("*", "PROPAGATION_SUPPORTS,readOnly");

		// 事物方法前缀
		setTransactionMethods(transactionAttributes.stringPropertyNames());
		transactionInterceptor.setTransactionAttributes(transactionAttributes);
		return transactionInterceptor;
	}

	@Bean
	public BeanNameAutoProxyCreator transactionAutoProxy() {
		BeanNameAutoProxyCreator transactionAutoProxy = new BeanNameAutoProxyCreator();
		transactionAutoProxy.setProxyTargetClass(true);
		transactionAutoProxy.setBeanNames("*ServiceImpl");
		transactionAutoProxy.setInterceptorNames("transactionInterceptor");
		return transactionAutoProxy;
	}

	@Transactional
	public Set<String> getTransactionMethods() {
		return transactionMethods;
	}

	public void setTransactionMethods(Set<String> transactionMethods) {
		this.transactionMethods = transactionMethods;
	}

}
