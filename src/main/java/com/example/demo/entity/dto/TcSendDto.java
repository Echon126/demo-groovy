package com.example.demo.entity.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * 西安中科天塔科技股份有限公司
 * Copyright (c) 2018-2028, tianta All Rights Reserved.<br/>
 * <b>@description:
 *
 * <b>@author: zwj
 *
 * <b>@create: 2020-03-04 11:41
 **/
@Data
@Builder(toBuilder = true)
public class TcSendDto implements Serializable {
    private static final long serialVersionUID = 1914377889357234484L;

    private String sid;
    private String mid;
    private String commandCode;
    private String commandData;
    private Boolean isJudge;
    private Integer sendMode;
    private Integer creator;

}
