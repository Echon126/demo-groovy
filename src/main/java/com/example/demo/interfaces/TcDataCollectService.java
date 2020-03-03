package com.example.demo.interfaces;

import java.util.List;
import java.util.Map;

/**
 * 数据采集
 */
public interface TcDataCollectService<T> {


    //采集单个数据
    T dataCollect();

    //采集多个数据
    List<T> dataCollectList();
    

    //key-value的方式采集
    Map<String, T> dataCollectMap();

}
