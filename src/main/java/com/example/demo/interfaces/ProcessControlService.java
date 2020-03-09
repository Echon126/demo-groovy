package com.example.demo.interfaces;

import com.example.demo.entity.TcCommandData;
import com.example.demo.entity.dto.TcSendDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ProcessControlService extends AbstractProcessControl {

    public String createTcData(TcCommandData tcData) {
        return null;
    }

    public boolean tmArgumentCompare(TcSendDto dto) {
        log.info("遥控数据发送,遥测参数比判");
        return false;
    }

    public void largeLoopCompare(TcSendDto dto) {
        log.info("遥控数据发送,大环路比对");
    }


}
