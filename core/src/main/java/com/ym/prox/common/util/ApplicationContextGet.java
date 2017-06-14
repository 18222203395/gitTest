package com.ym.prox.common.util;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Created by y64195 on 2017/6/12.
 */
public class ApplicationContextGet implements ApplicationContextAware{

    public static ApplicationContext applicationContext = null;

    @Autowired
    public void setApplicationContext(ApplicationContext applicationContext)
            throws BeansException {
        ApplicationContextGet.applicationContext = applicationContext;
    }
}
