package org.binknight.generator;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

@Component
public class IdGenerator {
    private static final long BEGIN_TIMESTAMP= 1681298282L;
    private static final int BIT_COUNT = 32;

    private StringRedisTemplate stringRedisTemplate;

    public IdGenerator(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    public long nextId(String kryPrefix){
        // 生成时间戳
        LocalDateTime now = LocalDateTime.now();
        long nowSecond = now.toEpochSecond(ZoneOffset.UTC);
        long timestamp = nowSecond - BEGIN_TIMESTAMP;
        System.out.println("timestamp = "+timestamp);
        // 生成序列号
        String date = now.format(DateTimeFormatter.ofPattern("yyyy:MM:dd"));
        //从redis获取自增value
        Long count = stringRedisTemplate.opsForValue().increment("icr:" + kryPrefix + ":" + date);
        System.out.println("count = "+count);
        return timestamp << BIT_COUNT | count;
    }

}
