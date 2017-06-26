package com.ym.prox.common.util;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.util.StringUtils;

/**
 * Created by y64195 on 2017/6/12.
 */

public class ApplicationContextGet implements ApplicationContextAware{

    private static ApplicationContext applicationContext = null;

    public void setApplicationContext(ApplicationContext applicationContext) {
        ApplicationContextGet.applicationContext = applicationContext;
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public static Object findBean(String beanId) {
        Object service = null;
        if (applicationContext != null) {
            try {
                if (beanId.indexOf(".") >= -1) {
                    beanId = beanId.substring(beanId.lastIndexOf(".") + 1, beanId.length());
                }
                beanId = StringUtils.uncapitalize(beanId);
                service = applicationContext.getBean(beanId);
            } catch (NoSuchBeanDefinitionException ex) {
                throw ex;
            } catch (BeansException ex) {
                throw ex;
            }
        }
        return service;
    }

}
