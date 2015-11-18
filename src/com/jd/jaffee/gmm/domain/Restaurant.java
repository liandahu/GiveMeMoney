/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jd.jaffee.gmm.domain;

/**
 *
 * @author Jaffee
 */
public class Restaurant {

    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Restaurant{" + "id=" + id + "name=" + name + '}';
    }
}
