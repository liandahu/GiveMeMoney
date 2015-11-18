/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jd.jaffee.gmm.domain;

/**
 *
 * @author Jaffee
 */
public class Admin {

    private int id;
    private String adminName;
    private String password;
    private String phoneNumber;
    private String email;
    private int yn;

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getYn() {
        return yn;
    }

    public void setYn(int yn) {
        this.yn = yn;
    }

    @Override
    public String toString() {
        return "Admin{" + "id=" + id + "adminName=" + adminName + "password=" + password + "phoneNumber=" + phoneNumber + "email=" + email + "yn=" + yn + '}';
    }

    
}
