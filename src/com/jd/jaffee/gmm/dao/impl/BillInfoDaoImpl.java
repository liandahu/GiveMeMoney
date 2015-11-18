/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jd.jaffee.gmm.dao.impl;

import com.jd.jaffee.gmm.dao.BillInfoDao;
import com.jd.jaffee.gmm.dao.ResultSetMapper;
import com.jd.jaffee.gmm.domain.BillInfo;
import com.jd.jaffee.gmm.domain.LunchInfo;
import com.jd.jaffee.gmm.domain.User;
import com.jd.jaffee.gmm.utils.DateUtil;
import com.jd.jaffee.gmm.utils.JdbcUtil;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jaffee
 */
public class BillInfoDaoImpl extends BaseDaoImpl implements BillInfoDao{

    private Connection conn;
    private Statement stmt;
    private ResultSet rs;

    public void addBillInfoList(List<BillInfo> infos) {
        try{
            conn = JdbcUtil.getConnection();
            stmt = conn.createStatement();
            for(BillInfo info : infos){
                stmt.addBatch(this.buildInsertSql(info));
            }
            stmt.executeBatch();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            JdbcUtil.free(null, stmt, conn);
        }
    }

    private String buildInsertSql(BillInfo info){
        String sql = "insert into BillInfo(UserId,UserName,LunchInfoId) "
                + "values(" + info.getUser().getId() + ",'" + info.getUser().getUserName()
                + "'," + info.getLunchInfo().getId() + ")";
        return sql;
    }

    public List<BillInfo> queryAllBillInfos() {
        String sql = "select b.ID,b.UserId,b.UserName,b.LunchInfoId,b.Pay,b.PayTime,b.PayMoney,"
                + "l.RestaurantName,l.LunchDate,l.Week,l.AllMoney,l.AverageMoney " +
                "from BillInfo as b , LunchInfo as l where b.LunchInfoId=l.ID and b.Yn=1 and l.Yn=1";
        return (List<BillInfo>)this.doSelect(sql, new BillInfoResultSetMapper());
    }

    public List<BillInfo> queryBillInfoBySql(String sql) {
        return (List<BillInfo>)this.doSelect(sql, new BillInfoResultSetMapper());
    }

    public int billPay(BillInfo info) {
        String sql = "update BillInfo set Pay=1,PayTime=#" + DateUtil.getCurrentLongDateString() + "#";
        if(info.getPayMoney() > 0){
            sql = sql + ", PayMoney=" + info.getPayMoney();
        }
        sql = sql + " where ID=" + info.getId();
        return this.doUpdate(sql);
    }

    public int unPayBill(int id) {
        String sql = "update BillInfo set Pay=0,PayTime=NULL,PayMoney=NULL where ID=" + id;
        return this.doUpdate(sql);
    }

}

class BillInfoResultSetMapper implements ResultSetMapper{

    public List<BillInfo> mapper(ResultSet rs) {
        List<BillInfo> billInfos = null;
        if(rs != null){
            billInfos = new ArrayList<BillInfo>();
            BillInfo billInfo = null;
            User user = null;
            LunchInfo lunchInfo = null;
            try {
                while(rs.next()){
                    billInfo = new BillInfo();
                    user = new User();
                    lunchInfo = new LunchInfo();

                    user.setId(rs.getInt("UserId"));
                    user.setUserName(rs.getString("UserName"));

                    lunchInfo.setAllMoney(rs.getDouble("AllMoney"));
                    lunchInfo.setAverageMoney(rs.getDouble("AverageMoney"));
                    lunchInfo.setId(rs.getInt("LunchInfoId"));
                    lunchInfo.setLunchDate(rs.getDate("LunchDate"));
                    lunchInfo.setRestaurantName(rs.getString("RestaurantName"));
                    lunchInfo.setWeek(rs.getString("Week"));

                    billInfo.setId(rs.getInt("ID"));
                    billInfo.setLunchInfo(lunchInfo);
                    billInfo.setPay(rs.getInt("Pay"));
                    billInfo.setPayMoney(rs.getDouble("PayMoney"));
                    billInfo.setPayTime(rs.getDate("PayTime"));
                    billInfo.setUser(user);
                    billInfos.add(billInfo);
                }
            }catch (SQLException ex) {
                Logger.getLogger(LunchInfoResultSetMapper.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return billInfos;
    }

}