package com.example.demo.entity;

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
 * <b>@create: 2020-03-04 17:07
 **/
@Data
@Builder(toBuilder = true)
public class TcDataType implements Serializable {
    private static final long serialVersionUID = 8717014477816505248L;

    private Integer id;
    private Integer pid;
    private String mid;
    private String typeCode;
    private String typeName;
    private String typeDesc;
    private Integer status;
}
