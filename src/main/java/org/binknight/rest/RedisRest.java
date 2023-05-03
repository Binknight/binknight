package org.binknight.rest;

import org.binknight.generator.IdGenerator;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/v1.0/api/")
public class RedisRest {

    @Resource
    private RedisTemplate redisTemplate;

    @Resource
    private IdGenerator idGenerator;

    @RequestMapping(method = RequestMethod.GET, value = "/id")
    public Long genId(){
        long shawn = idGenerator.nextId("shawn");
        return shawn;
    }

    @RequestMapping(method = RequestMethod.PUT,  value = "/cache")
    public Object setValue(@RequestBody Object value){
        redisTemplate.opsForValue().set("cache:test", value);
        return redisTemplate.opsForValue().get("cache:test");
    }
}
