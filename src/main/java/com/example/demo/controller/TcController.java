package com.example.demo.controller;

import com.example.demo.common.RetResponse;
import com.example.demo.common.RetResult;
import com.example.demo.entity.dto.TcSendDto;
import com.example.demo.interfaces.ProcessControlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 25144
 * 遥控相关接口
 */
@RestController
@RequestMapping("v1/tc")
public class TcController {

    @Autowired
    private ProcessControlService processControlService;

    @GetMapping("/processExecute/{id}/{methodName}")
    public RetResult processScheduling(@PathVariable String id, @PathVariable String methodName) {

        this.processControlService.startScheduling(TcSendDto.builder().sid("西安站")
                .mid("卫星一号")
                .commandCode("T001")
                .commandData("ABCDNDHD").isJudge(false).sendMode(1).build());

        return RetResponse.makeOKRsp();
    }

}
