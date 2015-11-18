/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jd.jaffee.gmm.dao;

import com.jd.jaffee.gmm.domain.Admin;

/**
 *
 * @author Jaffee
 */
public interface AdminDao extends BaseDao{
    public boolean adminLogin(Admin admin);
}
