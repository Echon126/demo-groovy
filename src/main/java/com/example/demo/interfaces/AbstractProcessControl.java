package com.example.demo.interfaces;

import com.example.demo.entity.MonitorInfo;
import com.example.demo.entity.TcCommandData;
import com.example.demo.entity.dto.TcSendDto;
import com.example.demo.interfaces.impl.TcBaseConfigServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.List;

/**
 * 西安中科天塔科技股份有限公司
 * Copyright (c) 2018-2028, tianta All Rights Reserved.<br/>
 * <b>@description:
 *
 * <b>@author: zwj
 *
 * <b>@create: 2020-03-04 11:39
 **/
@Slf4j
public abstract class AbstractProcessControl {
    public final static String leadCode = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
    public boolean isInterrupt;
    public boolean isStop;
    public boolean isPause;

    @Autowired
    private MonitoringService monitoringService;

    //指令发送
    public boolean sendTcCommand(TcSendDto dto) {
        this.monitoringService.submit(dto.getMid(), MonitorInfo.builder().UUID("1111").build());
        return true;
    }

    //创建遥控数据
    public String createTcData(TcCommandData tcData) {
        return null;
    }

    //大环路比对
    public abstract void largeLoopCompare(TcSendDto dto);

    //遥测参数比对
    public abstract boolean tmArgumentCompare(TcSendDto dto);


    //开始流程调度
    public final void startScheduling(TcSendDto dto) {
        boolean send = this.sendTcCommand(dto);
        if (!send) return;

        if (dto.getSendMode() == 1) {
            this.largeLoopCompare(dto);
        }

        if (dto.getIsJudge()) {
            this.tmArgumentCompare(dto);
        }
    }

    //开始序列流程的调度
    public final void startScheduling(List<TcSendDto> dtoList) {
        for (TcSendDto dto : dtoList) {
            startScheduling(dto);
        }
    }
}
