package com.example.demo.interfaces;

import com.example.demo.entity.MonitorInfo;

import java.util.List;

public interface MonitoringService {

    //提交监控信息
    void submit(String mid, MonitorInfo monitorInfo);

    //获取监控信息列表
    List<MonitorInfo> list(String mid);

    //获取单个监控信息
    MonitorInfo monitorInfo(String mid, String hashKey);

    //删除监控信息
    Long delete(String mid, String key, String hashKey);
}
