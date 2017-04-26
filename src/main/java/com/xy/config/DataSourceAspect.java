package com.xy.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.PatternMatchUtils;

/**
 * 读写分离，切换数据源切面
 * 
 * @author xiongyan
 * @date 2017年3月10日 下午4:16:58
 */
@Aspect
@Configuration
public class DataSourceAspect {
	
	@Autowired
	private TransactionConfiguration transactionConfiguration;

	/**
	 * 使用空方法定义切点表达式
	 */
	@Pointcut("execution(* com.xy.service..*.*(..))")
	public void aspect() {
		
	}

	/**
	 * 切换数据源
	 * @param joinPoint
	 */
	@Before("aspect()")
	public void dataSourceSwitch(JoinPoint joinPoint) {
		// 如果之前选择了写库 现在还选择 写库
		if (DataSourceContextHolder.isWriteDB()) {
			return;
		}
		// 方法名
		String methodName = joinPoint.getSignature().getName();
		// 事物方法必须切换到写库
		for (String writeMethod : transactionConfiguration.getTransactionMethods()) {
			if (!"*".equals(writeMethod) && PatternMatchUtils.simpleMatch(writeMethod, methodName)) {
				// 读写数据源
				DataSourceContextHolder.write();
				return;
			}
		}

		// 只读数据源
		DataSourceContextHolder.read();
	}

}
