/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jd.jaffee.gmm.dao;

/**
 *
 * @author Jaffee
 */
public interface BaseDao {

    public int doUpdate(String sql);
    public int getMaxId(String table);
    public int doInsertAndReturnId(String sql, String table);
    public Object doSelect(String sql, ResultSetMapper mapper);

}
