package com.xy.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.xy.annotation.Signature;
import com.xy.model.Order;
import com.xy.service.OrderService;

@RestController
@RequestMapping("/api")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	//@Resource(name="mongoTemplateOne")
	private MongoTemplate mongoTemplateOne;
	
	//@Resource(name="mongoTemplateTwo")
	private MongoTemplate mongoTemplateTwo;
	
	//@Resource(name="mongoTemplateThree")
	private MongoTemplate mongoTemplateThree;
	
	@RequestMapping(value = "/order/save", method = RequestMethod.GET)
	@Signature(signKey="xxx")
	public Map<String, Object> getOrder(@ModelAttribute Order order) {
		Map<String, Object> map = new HashMap<>();
		try {
			orderService.save(order);
			map.put("code", 0); 
			map.put("msg", "保存成功"); 
		} catch (Exception e) {
			map.put("code", -1); 
			map.put("msg", "保存失败"); 
		}
		return map;
	}

	@RequestMapping(value = "/order/{orderId}", method = RequestMethod.GET)
	public Order getOrder(@PathVariable Integer orderId) {
		/*List<User> users = new ArrayList<>();
		for (int i=1; i<=100; i++) {
			User user = new User();
			user.setId(i);
			user.setName("熊焱"+i);
			user.setMax(30);
			user.setSex(0);
			users.add(user);
		}
		mongoTemplateOne.insertAll(users);*/
		
		
		Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(2));
		User user = mongoTemplateOne.findOne(query, User.class, "user");
		System.out.println(user.getName());
		
		query = new Query();
		query.addCriteria(Criteria.where("_id").is(109277537));
		ArticleInfo articleInfo = mongoTemplateTwo.findOne(query, ArticleInfo.class, "ArticleInfo");
		if (null != articleInfo) {
			System.out.println("----->"+articleInfo.getTitle());
		}

		query = new Query();
		query.addCriteria(Criteria.where("_id").is(5));
		user = mongoTemplateThree.findOne(query, User.class, "user");
		System.out.println(user.getName());
		
		return orderService.getOrderByOrderId(orderId);
	}
	
	@RequestMapping(value = "/order/{userId}/{pageNum}/{pageSize}", method = RequestMethod.GET)
	public List<Order> listOrder(@PathVariable Integer userId, @PathVariable Integer pageNum, @PathVariable Integer pageSize) {
		Map<String, Object> map = new HashMap<>();
		map.put("userId", userId);
		PageHelper.startPage(pageNum, pageSize);
		return orderService.listOrderByMap(map);
	}
}
