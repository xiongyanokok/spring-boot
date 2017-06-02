package com.xy.disconf;

import com.baidu.disconf.client.common.annotations.DisconfFile;
import com.baidu.disconf.client.common.annotations.DisconfFileItem;

/**
 * 统一配置 修改disconf控制台数据，不用重启服务器，可立即生效
 * 
 * @author xiongyan
 * @date 2016年4月14日 上午10:02:35
 */
@DisconfFile(filename = "common.properties")
public final class CommonDisconf {

	private static String zookeeperAddress;

	@DisconfFileItem(name = "spring.zookeeper.address")
	public static String getZookeeperAddress() {
		return zookeeperAddress;
	}

	public static void setZookeeperAddress(String zookeeperAddress) {
		CommonDisconf.zookeeperAddress = zookeeperAddress;
	}
	
}
