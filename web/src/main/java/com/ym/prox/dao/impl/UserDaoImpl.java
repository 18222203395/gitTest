package com.ym.prox.dao.impl;

import com.ym.prox.dao.UserDao;
import com.ym.prox.modules.User;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by y64195 on 2017/6/7.
 */
@Repository("UserDao")
public class UserDaoImpl implements UserDao{

    private SqlSessionTemplate sqlSession;

    public SqlSessionTemplate getSqlSession() {
        return sqlSession;
    }

    public void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

    public void insert(User user) {
        sqlSession.insert(user.getClass().getName()+".insert", user);
    }

    public List<User> select(Map<String,Object> param) {
        return sqlSession.selectList(User.class.getName()+".find",param);
    }
}
