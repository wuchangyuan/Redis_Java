package com.redis.controller;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.redis.utils.RedisUtil;

@Controller
public class RedisController {

	@Autowired
	private RedisUtil rUtil;

	@RequestMapping("/add.do")
	public String add(String key, String value) {
		rUtil.set(key, value);
		return "index.jsp";
	}

	@RequestMapping("/get.do")
	public String get(String key, Map map) {
		String string = rUtil.get(key);
		System.out.println(string);
		map.put("val", string);
		return "index.jsp";
	}

	@RequestMapping("/del.do")
	public String del(String key, Model model) {
		boolean del = rUtil.del(key);
		if (del) {
			model.addAttribute("msg", "删除成功");
		} else {
			model.addAttribute("msg", "删除失败");
		}
		return "index.jsp";
	}

	@RequestMapping("/expire.do")
	public String expire(String key) {
		rUtil.expireKey(key, 10, TimeUnit.MINUTES);
		return "index.jsp";
	}

	@RequestMapping("/lpush.do")
	public String lpush(String key, String... strings) {
		rUtil.lpush(key, strings);
		return "index.jsp";
	}

	@RequestMapping("/lget.do")
	public String lgetAll(String key, Model model) {
		List<String> lgetAll = rUtil.lgetAll(key);
		model.addAttribute("list", lgetAll);
		System.out.println(lgetAll);
		return "index.jsp";
	}

}
