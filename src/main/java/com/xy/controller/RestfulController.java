package com.xy.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xy.model.Order;
import com.xy.pojo.Result;
import com.xy.service.OrderService;

/**
 * rest 
 * 
 * @author xiongyan
 * @date 2017年6月5日 上午11:24:51
 */
@RestController
@RequestMapping("/restful")
public class RestfulController extends BaseController {
	
	@Autowired
	private OrderService orderService;

	/**
	 * logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(RestfulController.class);
	
	@RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
	public Result<Map<String, Object>> user(@PathVariable Integer userId) {
		Map<String, Object> map = new HashMap<>();
		map.put("userId", "111");
		map.put("name", "熊焱");

		List<Order> orders = orderService.listOrderByMap(null);
		Order order = orderService.getOrderByOrderId(0);
		return Result.success(map);
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public Result<List<Map<String, String>>> list() {
		System.out.println(request.getParameter("name"));
		Map<String, String> map1 = new HashMap<>();
		map1.put("id", "111");
		map1.put("name", "熊焱1");
		Map<String, String> map2 = new HashMap<>();
		map2.put("id", "222");
		map2.put("name", "熊焱2");
		Map<String, String> map3 = new HashMap<>();
		map3.put("id", "333");
		map3.put("name", "熊焱3");
		return Result.success(Arrays.asList(map1, map2, map3));
	}
}
