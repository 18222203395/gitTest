package com.ym.prox.common.service.impl;

import com.ym.prox.common.dao.BaseDao;
import com.ym.prox.common.entity.BaseEntity;
import com.ym.prox.common.service.BaseService;
import com.ym.prox.common.util.ApplicationContextGet;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

/**
 * Created by y64195 on 2017/6/12.
 */
public class BaseServiceImpl<T extends BaseEntity> implements BaseService<T> {

    private static final long serialVersionUID = 1L;

    private Class<T> entityClass;

    private String entityName;

    private String baseDaoBeanId;

    private BaseDao<T> baseDao;

    @SuppressWarnings("unchecked")
    public BaseServiceImpl (){
        try{
            this.entityClass = (Class<T>) ((ParameterizedType)getClass().getGenericSuperclass()).
                    getActualTypeArguments()[0];
            entityName = entityClass.getSimpleName();
            if(this.entityClass != null){
                String pname = entityClass.getPackage().getName();
                pname = pname.substring(0, pname.lastIndexOf("."));
                baseDaoBeanId = pname + ".dao." + entityName + "Dao";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public BaseDao<T> getGenericBaseDao(){
        if(baseDao == null){
            if(baseDaoBeanId != null){
                baseDao = (BaseDao<T>) ApplicationContextGet.applicationContext.getBean(baseDaoBeanId);
            }
        }
        return baseDao;
    }


    public int insert(T entity) {
        return getGenericBaseDao().insert(entity);
    }

    public int update(T entity) {
        return getGenericBaseDao().update(entity);
    }

    public int delete(T entity) {
        return getGenericBaseDao().delete(entity);
    }

    public T findOne(Map<String, Object> params) {
        return getGenericBaseDao().findOne(params);
    }

    public List<T> findAll() {
        return getGenericBaseDao().findAll();
    }

    public List<T> findByParams(Map<String, Object> params) {
        return getGenericBaseDao().findByParams(params);
    }
}
