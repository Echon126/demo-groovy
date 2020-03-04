package com.example.demo.entity;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 25144
 */
@Data
@Builder(toBuilder = true)
public class TcSequenceData implements Serializable {

    private static final long serialVersionUID = 4901776372793079035L;

    private Integer id;
    private String mid;
    private String satelliteName;
    private String sequenceName;
    private String sequenceCode;
    private String sequenceOrder;
    private Integer creator;
    private Integer status;
    private Date createTime;
}
