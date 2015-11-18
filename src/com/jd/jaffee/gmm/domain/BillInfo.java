/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jd.jaffee.gmm.domain;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Date;

/**
 *
 * @author Jaffee
 */
public class BillInfo {

    private int id;
    private User user;
    private LunchInfo lunchInfo;
    private int pay;
    private Date payTime;
    private double payMoney;
    private int yn;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LunchInfo getLunchInfo() {
        return lunchInfo;
    }

    public void setLunchInfo(LunchInfo lunchInfo) {
        this.lunchInfo = lunchInfo;
    }

    public int getPay() {
        return pay;
    }

    public void setPay(int pay) {
        this.pay = pay;
    }

    public double getPayMoney() {
        return new BigDecimal(payMoney).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    public void setPayMoney(double payMoney) {
        this.payMoney = payMoney;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getYn() {
        return yn;
    }

    public void setYn(int yn) {
        this.yn = yn;
    }

    @Override
    public String toString() {
        return "BillInfo{" + "id=" + id + "user=" + user + "lunchInfo=" + lunchInfo + "pay=" + pay + "payTime=" + payTime + "payMoney=" + payMoney + "yn=" + yn + '}';
    }
}
