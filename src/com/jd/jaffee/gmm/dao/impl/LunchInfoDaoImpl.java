/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jd.jaffee.gmm.dao.impl;

import com.jd.jaffee.gmm.dao.LunchInfoDao;
import com.jd.jaffee.gmm.dao.ResultSetMapper;
import com.jd.jaffee.gmm.domain.LunchInfo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jaffee
 */
public class LunchInfoDaoImpl extends BaseDaoImpl implements LunchInfoDao{

    private DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
    private static final String TABLE = "LunchInfo";

    public int addLunchInfo(LunchInfo info) {
        String sql = "insert into LunchInfo(RestaurantId,RestaurantName,LunchDate,Week,AllMoney,AverageMoney,UserNames,Yn)"
                + " values(" + info.getRestaurantId() + ",'" + info.getRestaurantName() + "','" + df.format(info.getLunchDate()) + "','"
                + info.getWeek() + "'," + info.getAllMoney() + "," + info.getAverageMoney() + ",'" + info.getUserNames() + "',1)";
        return this.doInsertAndReturnId(sql, TABLE);
    }

    public List<LunchInfo> queryAllLunchInfo() {
        String sql = "select ID,RestaurantId,RestaurantName,LunchDate,Week,AllMoney,AverageMoney,UserNames "
                + "from LunchInfo where Yn=1";
        return (List<LunchInfo>) this.doSelect(sql, new LunchInfoResultSetMapper());
    }

    public List<LunchInfo> queryLunchInfoBySql(String sql) {
        return (List<LunchInfo>) this.doSelect(sql, new LunchInfoResultSetMapper());
    }

}

class LunchInfoResultSetMapper implements ResultSetMapper{

    public List<LunchInfo> mapper(ResultSet rs) {
        List<LunchInfo> infos = null;
        if(rs != null){
            infos = new ArrayList<LunchInfo>();
            LunchInfo info = null;
            try {
                while (rs.next()) {
                    info = new LunchInfo();
                    info.setId(rs.getInt("ID"));
                    info.setAllMoney(rs.getDouble("AllMoney"));
                    info.setAverageMoney(rs.getDouble("AverageMoney"));
                    info.setLunchDate(rs.getDate("LunchDate"));
                    info.setRestaurantId(rs.getInt("RestaurantId"));
                    info.setRestaurantName(rs.getString("RestaurantName"));
                    info.setUserNames(rs.getString("UserNames"));
                    info.setWeek(rs.getString("Week"));
                    info.setYn(1);
                    infos.add(info);
                }
            } catch (SQLException ex) {
                Logger.getLogger(LunchInfoResultSetMapper.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return infos;
    }

}