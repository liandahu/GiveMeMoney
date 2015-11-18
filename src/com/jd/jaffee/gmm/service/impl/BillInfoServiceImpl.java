/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jd.jaffee.gmm.service.impl;

import com.jd.jaffee.gmm.dao.BillInfoDao;
import com.jd.jaffee.gmm.dao.impl.BillInfoDaoImpl;
import com.jd.jaffee.gmm.domain.BillInfo;
import com.jd.jaffee.gmm.domain.LunchInfo;
import com.jd.jaffee.gmm.domain.User;
import com.jd.jaffee.gmm.service.BillInfoService;
import com.jd.jaffee.gmm.utils.DateUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Jaffee
 */
public class BillInfoServiceImpl implements BillInfoService{

    private BillInfoDao billInfoDao = new BillInfoDaoImpl();

    public boolean addBillInfos(LunchInfo lunchInfo, List<User> users) {
        boolean result = false;
        if(lunchInfo != null && users != null && !users.isEmpty()){
            List<BillInfo> billInfos = new ArrayList<BillInfo>();
            BillInfo info = null;
            for(User user : users){
                info = new BillInfo();
                info.setLunchInfo(lunchInfo);
                info.setUser(user);
                billInfos.add(info);
            }
            this.billInfoDao.addBillInfoList(billInfos);
            result = true;
        }
        return result;
    }

    public List<BillInfo> queryAllBillInfos() {
        return this.billInfoDao.queryAllBillInfos();
    }

    public List<BillInfo> queryBillInfoByCond(Map<String, Object> cond) {
        List<BillInfo> billInfos = null;
        String sql = this.buildSQL(cond);
        try{
            billInfos = this.billInfoDao.queryBillInfoBySql(sql);
        }catch(Exception e){
            e.printStackTrace();
        }
        return billInfos;
    }

    private String buildSQL(Map<String, Object> cond){
        String baseSql = "select b.ID,b.UserId,b.UserName,b.LunchInfoId,b.Pay,b.PayTime,b.PayMoney,"
                + "l.RestaurantName,l.LunchDate,l.Week,l.AllMoney,l.AverageMoney " +
                "from BillInfo as b , LunchInfo as l where b.LunchInfoId=l.ID and b.Yn=1 and l.Yn=1";
        StringBuilder sb = new StringBuilder();
        sb.append(baseSql);
        Object today = cond.get("today");
        if(today != null){
            sb.append(" and l.LunchDate=#").append(DateUtil.getCurrentShortDateString()).append("#");
        }else{
            Object beginDate = cond.get("beginDate");
            if(beginDate != null){
                sb.append(" and l.LunchDate >= #").append(beginDate).append("#");
            }
            Object endDate = cond.get("endDate");
            if(endDate != null){
                sb.append(" and l.LunchDate <= #").append(endDate).append("#");
            }
            Object week = cond.get("week");
            if(week != null){
                sb.append(" and l.Week='").append(week).append("'");
            }
        }
        Object pay = cond.get("pay");
        if(pay != null){
            sb.append(" and b.Pay=").append(pay);
        }
        Object userName = cond.get("userName");
        if(userName != null){
            sb.append(" and b.UserName='").append(userName).append("'");
        }
        return sb.toString();
    }

    public boolean billPay(BillInfo info) {
        return this.billInfoDao.billPay(info) > 0;
    }

    public boolean unPayBill(int id) {
        return this.billInfoDao.unPayBill(id) > 0;
    }

}
