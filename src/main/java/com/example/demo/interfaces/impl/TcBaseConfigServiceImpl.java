package com.example.demo.interfaces.impl;

import com.example.demo.entity.TcCommandData;
import com.example.demo.interfaces.TcBaseConfigService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 西安中科天塔科技股份有限公司
 * Copyright (c) 2018-2028, tianta All Rights Reserved.<br/>
 * <b>@description:
 *
 * <b>@author: zwj
 *
 * <b>@create: 2020-03-04 17:38
 **/
@Slf4j
@Service
public class TcBaseConfigServiceImpl implements TcBaseConfigService {
    @Override
    public boolean create(TcCommandData data) {
        return false;
    }

    @Override
    public boolean update(TcCommandData data) {
        return false;
    }

    @Override
    public List<TcCommandData> query(TcCommandData data) {
        return null;
    }

    @Override
    public TcCommandData query(Integer id) {
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }
}
