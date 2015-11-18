/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jd.jaffee.gmm.dao.impl;

import com.jd.jaffee.gmm.dao.BaseDao;
import com.jd.jaffee.gmm.dao.ResultSetMapper;
import com.jd.jaffee.gmm.utils.JdbcUtil;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Jaffee
 */
public class BaseDaoImpl implements BaseDao {

    private Connection conn;
    private Statement stmt;
    private ResultSet rs;

    public int doUpdate(String sql){
        int result = 1;
        try{
            conn = JdbcUtil.getConnection();
            stmt = conn.createStatement();
            result = stmt.executeUpdate(sql);
        }catch(Exception e){
            e.printStackTrace();
            result = 0;
        }finally{
            JdbcUtil.free(null, stmt, conn);
        }
        return result;
    }

    public int getMaxId(String table){
        int maxId = 0;
        String sql = "select max(ID) from " + table;
        try{
            conn = JdbcUtil.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            if(rs != null && rs.next()){
                maxId = rs.getInt(1);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            JdbcUtil.free(rs, stmt, conn);
        }
        return maxId;
    }

    public int doInsertAndReturnId(String sql, String table) {
        int maxId = 0;
        int result = 0;
        try{
            conn = JdbcUtil.getConnection();
            stmt = conn.createStatement();
            result = stmt.executeUpdate(sql);
            if(result > 0){
                sql = "select max(ID) from " + table;
                rs = stmt.executeQuery(sql);
                if(rs != null && rs.next()){
                    maxId = rs.getInt(1);
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            JdbcUtil.free(rs, stmt, conn);
        }
        return maxId;
    }

    public Object doSelect(String sql, ResultSetMapper mapper) {
        Object obj = null;
        try{
            conn = JdbcUtil.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            obj = mapper.mapper(rs);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            JdbcUtil.free(rs, stmt, conn);
        }
        return obj;
    }
    
}
