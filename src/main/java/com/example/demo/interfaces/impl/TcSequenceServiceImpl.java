package com.example.demo.interfaces.impl;

import com.example.demo.interfaces.TcSequenceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 指令序列的操作过程
 *
 * @author 25144
 */

@Service
public class TcSequenceServiceImpl implements TcSequenceService {
    private final static Logger logger = LoggerFactory.getLogger(TcSequenceServiceImpl.class);

    @Override
    public List loadSequence() {
        return null;
    }

    @Override
    public void sendSequence() {
    }

    @Override
    public void createSequence() {
    }
}
