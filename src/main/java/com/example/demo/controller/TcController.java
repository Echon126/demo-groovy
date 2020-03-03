package com.example.demo.controller;

import com.example.demo.common.RetResponse;
import com.example.demo.common.RetResult;
import com.example.demo.entity.TcSequence;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 25144
 * 遥控相关接口
 */
@RestController
@RequestMapping("v1/tc")
public class TcController {

    @GetMapping("/query")
    public RetResult<String> selectTcInfo() {
        return RetResponse.makeOKRsp("test groovy");
    }

    @GetMapping("/sequence/load/{id}")
    public RetResult<TcSequence> loadSequence() {
        return RetResponse.makeOKRsp(TcSequence.builder().data("ABCDEFG").code("T001").build());
    }
}
