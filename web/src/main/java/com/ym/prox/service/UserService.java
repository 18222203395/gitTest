package com.ym.prox.service;

import com.ym.prox.modules.User;

import java.util.List;
import java.util.Map;

/**
 * Created by y64195 on 2017/6/7.
 */
public interface UserService {


    public void insert(User user);

    public List<User> select(Map<String,Object> param);
}
