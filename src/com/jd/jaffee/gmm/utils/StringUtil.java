/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jd.jaffee.gmm.utils;

/**
 *
 * @author Jaffee
 */
public class StringUtil {

    public static boolean isBlank(String text){
        return text == null || text.trim().length() ==0;
    }
}
