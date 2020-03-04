package com.example.demo.interfaces;

import com.example.demo.entity.TcData;
import com.example.demo.entity.dto.TcSendDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ProcessControlService extends AbstractControl {

    public static String createTcData(TcData tcData) {
        return null;
    }

    public void tmArgumentCompare(TcSendDto dto) {
        log.info("遥控数据发送,遥测参数比判");
    }

    public void largeLoopCompare(TcSendDto dto) {
        log.info("遥控数据发送,大环路比对");
        boolean b1 = this.sendTcCommand(TcSendDto.builder().commandCode("xxx").commandData("xxxx").build());
        if (b1) {
            log.info("发送成功，记录日志");
        }
    }


}
