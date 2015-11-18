/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jd.jaffee.gmm.dao.impl;

import com.jd.jaffee.gmm.dao.UserDao;
import com.jd.jaffee.gmm.domain.User;
import com.jd.jaffee.gmm.utils.JdbcUtil;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jaffee
 */
public class UserDaoImpl extends BaseDaoImpl implements UserDao{

    private Connection conn;
    private Statement stmt;
    private ResultSet rs;

    public int addUser(User user) {
        String sql = "insert into User(UserName,PhoneNumber,Email,Yn) values('" + user.getUserName() +"','"
                + user.getPhoneNumber() + "','" + user.getEmail() + "',1)";
        return this.doUpdate(sql);
    }

    public List<User> queryAllUser() {
        List<User> users = null;
        String sql = "select Id,UserName,PhoneNumber,Email from User where Yn=1";
        try{
            conn = JdbcUtil.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            users = this.userListMapper(rs);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            JdbcUtil.free(rs, stmt, conn);
        }
        return users;
    }

    private List<User> userListMapper(ResultSet rs) throws Exception{
        List<User> users = null;
        User user = null;
        if(rs != null){
            users = new ArrayList<User>();
            while(rs.next()){
                user = new User();
                user.setId(rs.getInt("Id"));
                user.setEmail(rs.getString("Email"));
                user.setPhoneNumber(rs.getString("PhoneNumber"));
                user.setUserName(rs.getString("UserName"));
                user.setYn(1);
                users.add(user);
            }
        }
        return users;
    }
}
