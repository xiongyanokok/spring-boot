package com.xy.plugin;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * json 过滤
 * 
 * @author xiongyan
 * @date 2017年3月20日 下午2:45:39
 */
public class JsonFilterConfig {

	@JsonIgnoreProperties(value = { "xxx" })
	public interface UserJsonFilter {
	}

}
