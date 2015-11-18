/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jd.jaffee.gmm.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 *
 * @author Jaffee
 */
public class JdbcUtil {

    private static String url = "jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};" + "DBQ=db\\GiveMeMoney.mdb";
    private static final Properties prop = new Properties();

    private JdbcUtil() {
    }

    static {
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            prop.put("charSet", "gb2312");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,prop);
    }

    public static void free(ResultSet rs, Statement st, Connection conn) {
        if (rs != null) {
            try {
                rs.close();
                rs = null;
            } catch (SQLException ex) {
                ex.printStackTrace();
            } finally {
                if (st != null) {
                    try {
                        st.close();
                        st = null;
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    } finally {
                        if (conn != null) {
                            try {
                                conn.close();
                                conn = null;
                            } catch (SQLException ex) {
                                ex.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
    }

}
