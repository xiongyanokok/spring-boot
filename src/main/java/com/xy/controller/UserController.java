package com.xy.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hexun.px.model.Class;
import com.hexun.px.service.ClassService;
import com.xy.annotation.JsonFilter;
import com.xy.plugin.JsonFilterConfig;
import com.xy.plugin.RedisConfiguration;
import com.xy.pojo.User;

@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	private ClassService classService;
	
	@Autowired
	private RedisConfiguration<String, String> redisConfig;
	
	@RequestMapping(value = "/class/{classId}", method = RequestMethod.GET)
	public Class getClass(@PathVariable Integer classId) {
		return classService.getClassById(classId);
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	@JsonFilter(mixins = { JsonFilterConfig.UserJsonFilter.class }, targets = { User.class })
	public User getUser() {
		User user = new User();
		user.setName("熊焱");
		user.setPwd("xiongyan");
		user.setXxx("xxx");
		
		redisConfig.set("xy", "响应okok");
		
		return user;
	}
	
	
	@RequestMapping(value = "/login/{username}", method = RequestMethod.GET)
	public Map<String, Object> login(@PathVariable String username, @ModelAttribute User user, @RequestParam Map<String, Object> body) {
		Map<String, Object> map = new HashMap<>();
		map.put("username", username);
		map.put("time", new Date());
		map.putAll(body);
		return map;
	}

	@RequestMapping(value = "/user/{username}", method = RequestMethod.GET)
	public Map<String, Object> getUser(@PathVariable String username, @ModelAttribute User user, @RequestParam Map<String, Object> body) {
		Map<String, Object> map = new HashMap<>();
		map.put("username", username);
		map.putAll(body);
		return map;
	}
}
