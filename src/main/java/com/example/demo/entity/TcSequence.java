package com.example.demo.entity;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 25144
 */
@Data
@Builder(toBuilder = true)
public class TcSequence implements Serializable {

    private String code;
    private String data;
}
