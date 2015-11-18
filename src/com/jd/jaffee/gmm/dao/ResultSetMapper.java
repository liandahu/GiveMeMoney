/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jd.jaffee.gmm.dao;

import java.sql.ResultSet;

/**
 *
 * @author Jaffee
 */
public interface ResultSetMapper<T> {

    public T mapper(ResultSet rs);
    
}
