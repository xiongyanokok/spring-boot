package com.xy.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xy.mapper.OrderMapper;
import com.xy.model.Order;
import com.xy.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderMapper orderMapper;
	
	@Resource(name="orderServiceImpl")
    private OrderService orderService;
	
	@Override
	@Transactional
	public void save(Order order) {
		orderMapper.insert(order);
	}
	
	@Override
	@Cacheable(value = "boot:order", key = "'orderId_'+#orderId")
	public Order getOrderByOrderId(Integer orderId) {
		Map<String, Object> map = new HashMap<>();
		map.put("orderId", orderId);
		
		/*Order order = new Order();
		order.setOrderId(100);
		order.setUserId(100);
		orderService.save(order);*/
		
		
		return orderMapper.getOrder(map);
	}

	@Override
	public List<Order> listOrderByMap(Map<String, Object> map) {
		return orderMapper.listOrderByMap(map);
	}
}
