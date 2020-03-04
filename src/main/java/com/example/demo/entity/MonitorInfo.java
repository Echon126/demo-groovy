package com.example.demo.entity;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 西安中科天塔科技股份有限公司
 * Copyright (c) 2018-2028, tianta All Rights Reserved.<br/>
 * <b>@description:遥控监控数据体
 *
 * <b>@author: zwj
 *
 * <b>@create: 2020-03-04 14:48
 **/
@Data
@Builder(toBuilder = true)
public class MonitorInfo implements Serializable {
    private static final long serialVersionUID = -1777747214365472435L;
    /**
     * 监控标识
     */
    private String uuid;

    /**
     * 监控信息，为json字符串
     */
    private String jsonMessage;

    /**
     * 监控创建时间
     */
    private Date createTime;

    /**
     * 流程执行人
     */
    private Integer operator;

    /**
     * 标识是否为一个完整的监控流程
     */
    private Boolean status;


}
