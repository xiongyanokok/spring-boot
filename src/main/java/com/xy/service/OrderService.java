package com.xy.service;

import java.util.List;
import java.util.Map;

import com.xy.model.Order;

public interface OrderService {
	
	void save(Order order);

	Order getOrderByOrderId(Integer orderId);
	
	List<Order> listOrderByMap(Map<String, Object> map);
}
