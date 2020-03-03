package com.example.demo.interfaces;

import java.util.List;

public interface TcSequenceService<T> {

    //加载遥控序列
    List<T> loadSequence();

    //发送序列
    void sendSequence();

    //创建序列
    void createSequence();

    //
}
