package com.example.demo.interfaces;

import com.example.demo.entity.TcCommandData;

import java.util.List;

/**
 * 西安中科天塔科技股份有限公司
 * Copyright (c) 2018-2028, tianta All Rights Reserved.<br/>
 * <b>@description: 遥控基本配置类接口
 *
 * <b>@author: zwj
 *
 * <b>@create: 2020-03-04 17:38
 **/
public interface TcBaseConfigService {

    boolean create(TcCommandData data);

    boolean update(TcCommandData data);

    List<TcCommandData> query(TcCommandData data);

    TcCommandData query(Integer id);

    boolean delete(Integer id);
}
