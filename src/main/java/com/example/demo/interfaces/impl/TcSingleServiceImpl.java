package com.example.demo.interfaces.impl;

import com.example.demo.interfaces.TcSingleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 遥控单个指令的操作过程
 *
 * @author 25144
 */
@Service
public class TcSingleServiceImpl implements TcSingleService {
    private final static Logger logger = LoggerFactory.getLogger(TcSingleService.class);


    @Override
    public List<String> loadSingleCommand() {
        logger.info("load single command");
        return null;
    }

    @Override
    public void sendSingleCommand() {
        logger.info("send single command");
    }

    @Override
    public void createSingleCommand() {
        logger.info("create single command");
    }
}
