/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jd.jaffee.gmm.service;

import com.jd.jaffee.gmm.domain.User;
import java.util.List;

/**
 *
 * @author Jaffee
 */
public interface UserService {

    public boolean addUser(User user);

    public List<User> queryAllUser();

}
