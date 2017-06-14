package com.ym.prox.common.service;

import com.ym.prox.common.entity.BaseEntity;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by y64195 on 2017/6/12.
 */
public interface BaseService<T extends BaseEntity> extends Serializable {

    public static final String PRE_INSERT = "insert";

    public static final String PRE_UPDATE = "update";

    public static final String PRE_DELETE = "delete";

    public static final String PRE_FIND = "find";

    public static final String PRE_FIND_ALL = "findAll";


    public int insert(T entity);

    public int update(T entity);

    public int delete(T entity);

    public T findOne(Map<String, Object> params);

    public List<T> findAll();

    public List<T> findByParams(Map<String, Object> params);
}
