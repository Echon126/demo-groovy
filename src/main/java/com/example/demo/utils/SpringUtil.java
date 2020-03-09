package com.example.demo.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 
 * <b>Description：</b> springUitls <br/>
 * <b>ClassName：</b> SpringUtil <br/>
 * <b>@author：</b> jackyshang <br/>
 * <b>@date：</b> 2019年11月21日 上午10:26:53 <br/>
 * <b>@version: </b>  <br/>
 */
@Component
public class SpringUtil implements ApplicationContextAware {

    private static ApplicationContext applicationContext;
    
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if(SpringUtil.applicationContext == null) {
            SpringUtil.applicationContext = applicationContext;
        }
    }
 
    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }
 
    public static Object getBean(String name){
        return getApplicationContext().getBean(name);
    }
 
    public static <T> T getBean(Class<T> clazz){
        return getApplicationContext().getBean(clazz);
    }
 
    public static <T> T getBean(String name,Class<T> clazz){
        return getApplicationContext().getBean(name, clazz);
    }

}
