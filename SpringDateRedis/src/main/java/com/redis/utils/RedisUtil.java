package com.redis.utils;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisUtil {
	@Autowired
	private RedisTemplate<String, String> template;

	public boolean set(String key, String value) {
		try {
			template.opsForValue().set(key, value);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public boolean expireKey(String key, long time, TimeUnit timeType) {
		try {
			template.expire(key, time, timeType);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public String get(String key) {
		String string = template.opsForValue().get(key);
		return string;
	}

	public boolean del(String key) {
		try {
			template.delete(key);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public boolean lpush(String key, String... values) {
		try {
			template.opsForList().leftPushAll(key, values);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public List<String> lgetAll(String key) {
		List<String> list = template.opsForList().range(key, 0, template.opsForList().size(key));
		return list;
	}
}
