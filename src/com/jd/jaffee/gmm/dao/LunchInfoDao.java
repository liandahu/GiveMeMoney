/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jd.jaffee.gmm.dao;

import com.jd.jaffee.gmm.domain.LunchInfo;
import java.util.List;

/**
 *
 * @author Jaffee
 */
public interface LunchInfoDao extends BaseDao{

    public int addLunchInfo(LunchInfo info);
    public List<LunchInfo> queryAllLunchInfo();
    public List<LunchInfo> queryLunchInfoBySql(String sql);
    
}
