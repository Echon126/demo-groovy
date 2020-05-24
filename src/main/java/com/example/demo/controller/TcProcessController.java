package com.example.demo.controller;

import com.example.demo.common.RetResponse;
import com.example.demo.common.RetResult;
import com.example.demo.entity.dto.TcSendDto;
import com.example.demo.interfaces.ProcessControlService;
import com.example.demo.workflow.chain.TestCommand;
import com.example.demo.workflow.rule.DataRuleParse;
import com.example.demo.workflow.rule.DataRuleParseFactory;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;
import org.apache.commons.chain.impl.ContextBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * 西安中科天塔科技股份有限公司
 * Copyright (c) 2018-2028, tianta All Rights Reserved.<br/>
 * <b>@description:遥控业务流程控制
 *
 * <b>@author: zwj
 *
 * <b>@create: 2020-03-04 17:31
 **/
@Slf4j
@RestController
@RequestMapping("v1/tc")
public class TcProcessController extends BaseController {
    @Resource
    private ProcessControlService processControlService;

    @GetMapping("/processExecute/{id}/{methodName}")
    public RetResult processScheduling(@PathVariable String id, @PathVariable String methodName) {

        this.processControlService.startScheduling(TcSendDto.builder().sid("西安站")
                .mid("卫星一号")
                .commandCode("T001")
                .isJudge(false).sendMode(1).build());

        return RetResponse.makeOKRsp();
    }


    //TODO 人机调度  restful接口
    //TODO 自动化模块 rpc接口
    //TODO 工作流调度 rpc接口

    @Autowired
    private TestCommand testCommand;

    @GetMapping("/execute")
    public boolean executeProcess() {
        try {
            Map<String, Object> paramMap = new HashMap<>();
            DataRuleParse myrulebyid1 = DataRuleParseFactory.getTrafficMode("MYRULEBYID1");
            myrulebyid1.getSql(paramMap);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
