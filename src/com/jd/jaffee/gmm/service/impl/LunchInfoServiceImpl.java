/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jd.jaffee.gmm.service.impl;

import com.jd.jaffee.gmm.dao.LunchInfoDao;
import com.jd.jaffee.gmm.dao.impl.LunchInfoDaoImpl;
import com.jd.jaffee.gmm.domain.LunchInfo;
import com.jd.jaffee.gmm.service.LunchInfoService;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Jaffee
 */
public class LunchInfoServiceImpl implements LunchInfoService{

    private LunchInfoDao lunchInfoDao = new LunchInfoDaoImpl();

    public boolean addLunchInfo(LunchInfo info) {
        int id = this.lunchInfoDao.addLunchInfo(info);
        if(id > 0){
            info.setId(id);
            return true;
        }
        return false;
    }

    public List<LunchInfo> queryAllLunchInfo() {
        return this.lunchInfoDao.queryAllLunchInfo();
    }

    public List<LunchInfo> queryLunchInfoByCond(Map<String, Object> cond) {
        List<LunchInfo> infos = null;
        StringBuilder sb = new StringBuilder();
        sb.append("select ID,RestaurantId,RestaurantName,LunchDate,Week,AllMoney,AverageMoney,UserNames from LunchInfo where Yn=1 ");
        Object restaurantId = cond.get("restaurantId");
        if(restaurantId != null){
            sb.append(" and restaurantId=").append(restaurantId);
        }
        Object beginDate = cond.get("beginDate");
        if(beginDate != null){
            sb.append(" and LunchDate >= #").append(beginDate).append("#");
        }
        Object endDate = cond.get("endDate");
        if(endDate != null){
            sb.append(" and LunchDate <= #").append(endDate).append("#");
        }
        Object week = cond.get("week");
        if(week != null){
            sb.append(" and Week='").append(week).append("'");
        }
        infos = this.lunchInfoDao.queryLunchInfoBySql(sb.toString());
        return infos;
    }

    /*
     * Map<String, Object> cond = new HashMap<String, Object>();
        int restaurantId = queryLunchResJComboBox.getSelectedIndex();
        if(restaurantId > 0){
            cond.put("restaurantId", restaurantId);
        }
        String beginDate = queryLunchBtJTextField.getText().trim();
        if(!StringUtil.isBlank(beginDate)){
            cond.put("beginDate", beginDate);
        }
        String endDate = queryLunchEtJTextField.getText().trim();
        if(!StringUtil.isBlank(endDate)){
            cond.put("endDate", endDate);
        }
        String week = queryLunchInfoWeekJComboBox.getSelectedItem().toString();
        if(!StringUtil.isBlank(week)){
            cond.put("week", week);
        }
     */
}
