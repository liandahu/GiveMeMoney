/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jd.jaffee.gmm.view;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jaffee
 */
public class GmmTableModel extends DefaultTableModel {

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
}
