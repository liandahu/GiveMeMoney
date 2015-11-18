/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jd.jaffee.gmm.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

/**
 *
 * @author Jaffee
 */
public class PropertiesUtil {

    private static final String FILE_PATH = "config/config.properties";
    private static final Properties properties = new Properties();

    static{
        try {
            InputStream inStream = new FileInputStream(FILE_PATH);
            properties.load(inStream);
            inStream.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static String getProperty(String key){
        String resutl = properties.getProperty(key);
        try {
            resutl =  new String(resutl.getBytes("iso-8859-1"), "utf-8");
        } catch (UnsupportedEncodingException ex) { }
        return resutl;
    }
    
}
