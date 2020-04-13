package com.example.demo.utils;

import com.example.demo.entity.dto.TcSendDto;
import com.example.demo.groovy.GroovyCommonUtil;

/**
 * @author 25144
 */
public class TestGroovy {

    public static void main(String[] args) throws Exception {
        TcSendDto build = TcSendDto.builder().commandCode("xxxx").commandData("ssssss").build();
        Object[] object = {50000,80000};
        Object result3 = (Object) GroovyCommonUtil.invokeMethod("ProcessControl.groovy", "largeCompare",object);
        System.out.println("testGroovy4: " + result3 + "\n");
    }
}
