package com.example.demo.entity;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * 西安中科天塔科技股份有限公司
 * Copyright (c) 2018-2028, tianta All Rights Reserved.<br/>
 * <b>@description:
 *
 * <b>@author: zwj
 *
 * <b>@create: 2020-03-04 17:14
 **/
@Data
@Builder(toBuilder = true)
public class TcSequenceItem {
    private Integer id;
    private Integer sequenceId;
    private String commandName;
    private String commandCode;
    private String commandData;
    private boolean isPause;
    private Integer intervalTime;
    private String typeCode;
    private Integer status;
    private Integer creator;
    private Date createTime;

}
