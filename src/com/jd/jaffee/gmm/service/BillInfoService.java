/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jd.jaffee.gmm.service;

import com.jd.jaffee.gmm.domain.BillInfo;
import com.jd.jaffee.gmm.domain.LunchInfo;
import com.jd.jaffee.gmm.domain.User;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Jaffee
 */
public interface BillInfoService {

    public boolean addBillInfos(LunchInfo lunchInfo, List<User> users);
    public List<BillInfo> queryAllBillInfos();
    public List<BillInfo> queryBillInfoByCond(Map<String, Object> cond);
    public boolean billPay(BillInfo info);
    public boolean unPayBill(int id);

}
