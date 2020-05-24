package com.example.demo.interfaces.impl;

import com.example.demo.entity.MonitorInfo;
import com.example.demo.interfaces.MonitoringService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class MonitoringServiceImpl implements MonitoringService {
    private final static String MONITOR_KEY = "tc_monitor_key:";


    @Autowired
    private RedisTemplate redisTemplate;

    @SuppressWarnings("unchecked")
    @Override
    public void submit(String mid, MonitorInfo monitorInfo) {
        this.redisTemplate.opsForHash().put(MONITOR_KEY + mid, monitorInfo.getUUID(), monitorInfo);
    }


    @SuppressWarnings("unchecked")
    @Override
    public List<MonitorInfo> list(String mid) {
        return this.redisTemplate.opsForHash().values(MONITOR_KEY + mid);
    }

    @SuppressWarnings("unchecked")
    @Override
    public MonitorInfo monitorInfo(String mid, String hashKey) {
        return (MonitorInfo) this.redisTemplate.opsForHash().get(MONITOR_KEY + mid, hashKey);
    }


    @SuppressWarnings("unchecked")
    @Override
    public Long delete(String mid, String key, String hashKey) {
        return this.redisTemplate.opsForHash().delete(MONITOR_KEY + mid, hashKey);
    }

}
