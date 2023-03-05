package com.wendy.redis.jedis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2022/4/20 20:49
 * @Version 1.0
 */
@RestController
@RequestMapping("/user")
public class JedisDemo {
    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @GetMapping("/inituser")
    public void initSession(){
        Jedis jedis = new Jedis("175.24.68.139",6379);
        jedis.set("name","ma");
    }

    @GetMapping("/getuser")
    public void getUser(){
        Object name = this.redisTemplate.opsForValue().get("name");
        System.out.println(name);
    }
}
