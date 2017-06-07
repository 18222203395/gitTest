package com.ym.prox.service.impl;

import com.ym.prox.dao.UserDao;
import com.ym.prox.modules.User;
import com.ym.prox.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by y64195 on 2017/6/7.
 */
@Service("userService")
public class UserServiceImpl  implements UserService{

    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void insert(User user) {
        userDao.insert(user);
    }

    public List<User> select(Map<String,Object> param) {
        return userDao.select(param);
    }
}
