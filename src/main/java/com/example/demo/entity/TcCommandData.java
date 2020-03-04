package com.example.demo.entity;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 西安中科天塔科技股份有限公司
 * Copyright (c) 2018-2028, tianta All Rights Reserved.<br/>
 * <b>@description:
 *
 * <b>@author: zwj
 *
 * <b>@create: 2020-03-04 11:34
 **/
@Data
@Builder(toBuilder = true)
public class TcCommandData implements Serializable {
    private static final long serialVersionUID = 2240212060914266461L;
    private Integer id;
    private String mid;
    private String commandCode;
    private String commandName;
    private String commandData;
    private String dynamicData;
    private Integer typeCode;
    private Integer status;
    private Integer creator;
    private Date createTime;
}
