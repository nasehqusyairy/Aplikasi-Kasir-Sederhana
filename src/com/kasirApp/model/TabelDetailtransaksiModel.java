/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kasirApp.model;

import javax.swing.table.DefaultTableModel;

import com.kasirApp.modelData.DataBarangModel;
import com.kasirApp.modelData.DataDetailTransaksiModel;

/**
 *
 * @author Nasyikh Al-Qusyairy
 */
public class TabelDetailtransaksiModel extends DefaultTableModel {

    public TabelDetailtransaksiModel(String id) {
        super(DataDetailTransaksiModel.get(id), DataDetailTransaksiModel.TABLE_HEADER);
    }
    boolean[] canEdit = new boolean [] {
        false, false, false, false,false,false
    };

    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit [columnIndex];
    }

}
