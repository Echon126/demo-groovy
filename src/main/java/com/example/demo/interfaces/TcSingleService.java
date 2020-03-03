package com.example.demo.interfaces;

import java.util.List;

public interface TcSingleService {

    //单指令加载
    List<String> loadSingleCommand();

    //单指令发送
    void sendSingleCommand();

    //生成单个指令
    void createSingleCommand();

}
