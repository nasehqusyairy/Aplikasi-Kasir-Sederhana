/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kasirApp.model;

import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Nasyikh Al-Qusyairy
 */
public class TabelTransaksiBaruModel extends DefaultTableModel {

    public TabelTransaksiBaruModel(String[][] data,String[] header) {
        super(data,header);
    }
    boolean[] canEdit = new boolean [] {
        false, false, false, false,false,false
    };

    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit [columnIndex];
    }

}
