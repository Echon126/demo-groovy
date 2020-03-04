package com.example.demo.interfaces;

import com.example.demo.entity.MonitorInfo;
import com.example.demo.entity.TcCommandData;
import com.example.demo.entity.dto.TcSendDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

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
public abstract class AbstractControl {
    public final static String leadCode = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
    public boolean isInterrupt;
    public boolean isStop;
    public boolean isPause;

    @Autowired
    private MonitoringService monitoringService;

    //指令发送
    public boolean sendTcCommand(TcSendDto dto) {
        log.info("遥控数据发送,发送的数据为:{}", dto);
        monitoringService.submitMonitorInfo(MonitorInfo.builder().uuid("1111").build());
        return true;
    }

    //创建遥控数据
    public abstract String createTcData(TcCommandData tcData);

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

    public class initConfig {
        private String configName;
        private String configRules;
        private String rulesExpress;

        public String getConfigName() {
            return configName;
        }

        public void setConfigName(String configName) {
            this.configName = configName;
        }

        public String getConfigRules() {
            return configRules;
        }

        public void setConfigRules(String configRules) {
            this.configRules = configRules;
        }

        public String getRulesExpress() {
            return rulesExpress;
        }

        public void setRulesExpress(String rulesExpress) {
            this.rulesExpress = rulesExpress;
        }
    }

}
