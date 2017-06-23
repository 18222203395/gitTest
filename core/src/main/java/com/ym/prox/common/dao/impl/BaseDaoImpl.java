package com.ym.prox.common.dao.impl;

import com.ym.prox.common.dao.BaseDao;
import com.ym.prox.common.entity.BaseEntity;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

/**
 * Created by y64195 on 2017/6/9.
 */
public class BaseDaoImpl<T extends BaseEntity> implements BaseDao<T>{

    protected Class<T> entityClass;

    @Autowired
    protected SqlSessionTemplate sessionTemplate;

    public BaseDaoImpl(){
       this.entityClass = (Class <T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public int insert(T entity) {
        return sessionTemplate.insert(entityClass.getName() + PRE_INSERT, entity);
    }

    public int update(T entity) {
        return sessionTemplate.insert(entityClass.getName() + PRE_UPDATE, entity);
    }

    public int delete(T entity) {
        return sessionTemplate.insert(entityClass.getName() + PRE_DELETE, entity);
    }

    public T findOne(Map<String, Object> params) {
        return sessionTemplate.selectOne(entityClass.getName()  + PRE_FIND, params);
    }

    public List<T> findAll() {
        return sessionTemplate.selectList(entityClass.getName() + PRE_FIND_ALL);
    }

    public List<T> findByParams(Map<String, Object> params) {
        return sessionTemplate.selectOne(entityClass.getName() + PRE_FIND,params);
    }
}
