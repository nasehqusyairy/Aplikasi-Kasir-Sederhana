/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kasirApp.modelData;

import java.sql.ResultSet;
import com.kasirApp.helper.SQLQuery;
import javax.swing.JOptionPane;
import java.util.ArrayList;

public class DataDetailTransaksiModel {
    public static final String TABLE_NAME = "detailTransaksi";
//    tabel database : idTransaksi, kode, jumlah
    public static final String[] TABLE_HEADER = {"No.","Kode","Nama Barang","Harga Satuan","Jumlah","Total"};
    public static String[][] get(String idTransaksi){
        ArrayList<String[]> output = new ArrayList<>();
        try{
            ResultSet detailTransaksi = new SQLQuery().get(TABLE_NAME, "`idTransaksi`=\""+idTransaksi+"\"");
            int i = 1;
            while(detailTransaksi.next()){
                String[] barang = DataBarangModel.getByKode(detailTransaksi.getString("kode"));
                if (barang.length>0) {
                    int harga = Integer.parseInt(barang[2]);
                    int jumlah = Integer.parseInt(detailTransaksi.getString("jumlah"));
                    String[] result = {Integer.toString(i++) ,detailTransaksi.getString("kode"),barang[1],"Rp. "+barang[2],detailTransaksi.getString("jumlah"),"Rp. "+Integer.toString(harga*jumlah)};
                    output.add(result);
                }else{
                    String str = "(terhapus)";
                    String[] result = {Integer.toString(i++) ,detailTransaksi.getString("kode"),str,str,str,str};
                    output.add(result);
                }
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
        return output.toArray(new String[output.size()][]);
    }
    
    public static int insert(String[] dataset){
        int res = 0;
        String error = "";
        try {
            for (String string : dataset) {
                if (string.equals("")) {
                    error = "Input field tidak boleh kosong";
                    throw new Exception(error);
                }
            }
            if (error.equals("")) {
                res = new SQLQuery().insert(TABLE_NAME, dataset);
            }
        } catch (Exception err) {
            String msg = err.getMessage()==null?"Terjadi kesalahan!":err.getMessage();
            JOptionPane.showMessageDialog(null, msg, "Error", 0);
        }
        return res;
    }
    public static void delete(String idTransaksi){
        new SQLQuery().delete(TABLE_NAME, "`idTransaksi`=\""+idTransaksi+"\"");
    }
    public static void empty(){
            new SQLQuery().delete(TABLE_NAME, "1");
    }
}
