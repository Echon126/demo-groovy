package com.example.demo.controller;

import com.example.demo.common.RetResponse;
import com.example.demo.common.RetResult;
import com.example.demo.entity.TcCommandData;
import com.example.demo.interfaces.TcBaseConfigService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author 25144
 * 遥控前段查询个基础操作相应接口
 */
@RestController
@RequestMapping("v1/tc")
public class TcController {

    @Resource
    private TcBaseConfigService configService;

    @GetMapping("/command/{id}")
    public RetResult query(@PathVariable Integer id) {
        return RetResponse.makeOKRsp(this.configService.query(id));
    }

    @GetMapping("/commands")
    public RetResult query(@RequestBody TcCommandData data) {
        return RetResponse.makeOKRsp(this.configService.query(data));
    }

    @PostMapping("/command")
    public RetResult create(@RequestBody TcCommandData data) {
        if (this.configService.create(data)) {
            return RetResponse.makeOKRsp();
        }
        return RetResponse.makeErrRsp("操作异常");
    }

    @PutMapping("/command")
    public RetResult update(@RequestBody TcCommandData data) {
        if (this.configService.update(data)) {
            return RetResponse.makeOKRsp();
        }
        return RetResponse.makeErrRsp("操作异常");
    }

    @DeleteMapping("/command/{id}")
    public RetResult delete(@PathVariable Integer id) {
        if (this.configService.delete(id)) {
            return RetResponse.makeOKRsp();
        }
        return RetResponse.makeErrRsp("操作异常");
    }

}
