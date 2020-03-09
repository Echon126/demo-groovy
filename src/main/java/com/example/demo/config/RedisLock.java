package com.example.demo.config;

import com.example.demo.utils.SpringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Slf4j
public class RedisLock {

    private static final long DEFAULT_EXPIRE = 10;


    public static void lock(String key) {
        lock(key, System.currentTimeMillis() + "", DEFAULT_EXPIRE);
    }

    public static void lock(String key, Long expire) {
        lock(key, System.currentTimeMillis() + "", expire);
    }

    public static void lock(String key, String value) {
        lock(key, value, DEFAULT_EXPIRE);
    }

    public static void lock(String key, String value, Long expire) {
        log.debug("加锁，key{},value{},超时时间:{}s", key, value, expire);
        if (!Objects.requireNonNull(getClient().opsForValue().setIfAbsent(key, value, expire, TimeUnit.SECONDS), "加锁返回异常")) {
            throw new RuntimeException("加锁失败、已经锁定");
        }
    }

    public static void unLock(String key) {
        log.debug("释放锁{}", key);
        getClient().delete(key);
    }


    private static StringRedisTemplate getClient() {
        return SpringUtil.getBean(StringRedisTemplate.class);
    }
}
