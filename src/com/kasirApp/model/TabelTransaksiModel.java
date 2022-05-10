/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kasirApp.model;

import javax.swing.table.DefaultTableModel;

import com.kasirApp.modelData.DataTransaksiModel;

/**
 *
 * @author Nasyikh Al-Qusyairy
 */
public class TabelTransaksiModel extends DefaultTableModel {

    public TabelTransaksiModel() {
        super(DataTransaksiModel.get(), DataTransaksiModel.TABLE_HEADER);
    }
    boolean[] canEdit = new boolean [] {
        false, false, false, false
    };

    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit [columnIndex];
    }

}
