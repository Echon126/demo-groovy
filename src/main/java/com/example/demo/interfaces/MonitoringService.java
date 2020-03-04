package com.example.demo.interfaces;

import com.example.demo.entity.MonitorInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * 西安中科天塔科技股份有限公司
 * Copyright (c) 2018-2028, tianta All Rights Reserved.<br/>
 * <b>@description:
 *
 * <b>@author: zwj
 *
 * <b>@create: 2020-03-04 14:48
 **/
@Slf4j
@Service
public class MonitoringService {

    @Autowired
    private RedisTemplate redisTemplate;

    public void submitMonitorInfo(MonitorInfo monitorInfo) {
        log.info("监控日志");
        redisTemplate.opsForHash().put("xxx", "xxx", "xxxx");
    }


}
