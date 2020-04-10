package com.mypro.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jayMamba
 * @date 2020/1/7
 * @time 11:26
 * @desc
 */
@RestController
public class redisTest {

    @Autowired
    RedisTemplate redisTemplate;

    @GetMapping("/getRedisInfo")
    public String getRedisInfo() {
        redisTemplate.opsForValue().set("test", "oh,yeah");
        return redisTemplate.opsForValue().get("test").toString();
    }
}
