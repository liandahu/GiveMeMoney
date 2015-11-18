/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jd.jaffee.gmm.dao;

import com.jd.jaffee.gmm.domain.BillInfo;
import java.util.List;

/**
 *
 * @author Jaffee
 */
public interface BillInfoDao extends BaseDao{

    public void addBillInfoList(List<BillInfo> infos);
    public List<BillInfo> queryAllBillInfos();
    public List<BillInfo> queryBillInfoBySql(String sql);
    public int billPay(BillInfo info);
    public int unPayBill(int id);

}
