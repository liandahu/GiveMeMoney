/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jd.jaffee.gmm.service;

import com.jd.jaffee.gmm.domain.LunchInfo;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Jaffee
 */
public interface LunchInfoService {

    public boolean addLunchInfo(LunchInfo info);
    public List<LunchInfo> queryAllLunchInfo();
    public List<LunchInfo> queryLunchInfoByCond(Map<String, Object> cond);

}
