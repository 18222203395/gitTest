package com.ym.prox.dao.impl;

import com.ym.prox.common.dao.impl.BaseDaoImpl;
import com.ym.prox.dao.UserDao;
import com.ym.prox.modules.User;
import org.springframework.stereotype.Repository;

/**
 * Created by y64195 on 2017/6/7.
 */
@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao{
}
