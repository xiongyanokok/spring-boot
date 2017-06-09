package com.xy.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xy.exception.ErrorCode;
import com.xy.exception.Assert;
import com.xy.exception.BootCustomException;
import com.xy.mapper.OrderMapper;
import com.xy.model.Order;
import com.xy.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderMapper orderMapper;
	
	@Resource(name="orderServiceImpl")
    private OrderService orderService;
	
	/**
	 * 保存订单
	 * 
	 * @param order
	 * @throws BootCustomException
	 */
	@Override
	@Transactional
	public void save(Order order) {
		Assert.notNull(order, "保存订单对象为空");
		try {
			orderMapper.insert(order);
		} catch (Exception e) {
			throw new BootCustomException(ErrorCode.DB_SAVE_ERROR, "保存订单失败", e);
		}
	}
	
	/**
	 * 订单查询
	 * 
	 * @param orderId
	 * @return 
	 * @throws BootCustomException
	 */
	@Override
	@Cacheable(value = "boot:order", key = "'orderId_'+#orderId")
	public Order getOrderByOrderId(Integer orderId) {
		Assert.notNull(orderId, "订单id为空");
		try {
			Map<String, Object> map = new HashMap<>();
			map.put("orderId", orderId);
			return orderMapper.getOrder(map);
		} catch (Exception e) {
			throw new BootCustomException(ErrorCode.DB_QUERY_ERROR, "订单ID【"+orderId+"】查询订单失败", e);
		}
	}

	/**
	 * 订单查询
	 * 
	 * @param map
	 * @return 
	 * @throws BootCustomException
	 */
	@Override
	public List<Order> listOrderByMap(Map<String, Object> map) {
		Assert.notEmpty(map, "查询参数为空");
		try {
			return orderMapper.listOrderByMap(map);
		} catch (Exception e) {
			throw new BootCustomException(ErrorCode.DB_QUERY_ERROR, "参数【"+map+"】查询订单失败", e);
		}
	}
}
