/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jd.jaffee.gmm.domain;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author Jaffee
 */
public class LunchInfo {

    private int id;
    private int restaurantId;
    private String restaurantName;
    private Date lunchDate;
    private String week;
    private double allMoney;
    private double averageMoney;
    private String userNames;
    private int yn;

    public double getAllMoney() {
        return new BigDecimal(allMoney).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    public void setAllMoney(double allMoney) {
        this.allMoney = allMoney;
    }

    public double getAverageMoney() {
        return new BigDecimal(averageMoney).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    public void setAverageMoney(double averageMoney) {
        this.averageMoney = averageMoney;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getLunchDate() {
        return lunchDate;
    }

    public void setLunchDate(Date lunchDate) {
        this.lunchDate = lunchDate;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getUserNames() {
        return userNames;
    }

    public void setUserNames(String userNames) {
        this.userNames = userNames;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public int getYn() {
        return yn;
    }

    public void setYn(int yn) {
        this.yn = yn;
    }

    @Override
    public String toString() {
        return "LunchInfo{" + "id=" + id + "restaurantId=" + restaurantId + "restaurantName=" + restaurantName + "lunchDate=" + lunchDate + "week=" + week + "allMoney=" + allMoney + "averageMoney=" + averageMoney + "userNames=" + userNames + "yn=" + yn + '}';
    }
}
