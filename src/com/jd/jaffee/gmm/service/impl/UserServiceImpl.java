/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jd.jaffee.gmm.service.impl;

import com.jd.jaffee.gmm.dao.UserDao;
import com.jd.jaffee.gmm.dao.impl.UserDaoImpl;
import com.jd.jaffee.gmm.domain.User;
import com.jd.jaffee.gmm.service.UserService;
import java.util.List;

/**
 *
 * @author Jaffee
 */
public class UserServiceImpl implements UserService{

    private UserDao userDaoImpl = new UserDaoImpl();

    public boolean addUser(User user) {
        return this.userDaoImpl.addUser(user) > 0;
    }

    public List<User> queryAllUser() {
        return this.userDaoImpl.queryAllUser();
    }

}
