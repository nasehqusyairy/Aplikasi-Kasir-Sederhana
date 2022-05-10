/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kasirApp.modelData;

import java.sql.ResultSet;
import com.kasirApp.helper.SQLQuery;
import javax.swing.JOptionPane;
import java.util.ArrayList;

public class DataTransaksiModel {
    public static final String TABLE_NAME = "transaksi";
    public static final String[] TABLE_HEADER = {"No.","Id Transaksi","Waktu","Total"};
    private static String resetID(String oldID){
        String id = Integer.toString(((int) Math.floor(Math.random() * Math.pow(10, 7))));
        JOptionPane.showMessageDialog(null, "Id Transaksi "+oldID+" sudah pernah ada, kami akan mencoba menggantinya dengan "+id);
        try {
            ResultSet cek = new SQLQuery().get(TABLE_NAME, "`idTransaksi`='" + id+"'");
            if (cek.next()) {
                id = resetID(id);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Terjadi Kesalahan! "+e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
        return id;
    }
    public static String[][] get(){
        ArrayList<String[]> output = new ArrayList<>();
        try{
            ResultSet sql = new SQLQuery().get(TABLE_NAME, "1");
            int i = 1;
            while(sql.next()){
                String[] result = {Integer.toString(i++) ,sql.getString("idTransaksi"),sql.getString("waktu"),"Rp. "+sql.getString("total")};
                output.add(result);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
        return output.toArray(new String[output.size()][]);
    }
    public static String[] getByID(String idTransaksi){
        ArrayList<String> output = new ArrayList<>();
        try{
            ResultSet sql = new SQLQuery().get(TABLE_NAME, "`idTransaksi`=\""+idTransaksi+"\"");
            while(sql.next()){
                output.add(sql.getString("idTransaksi"));
                output.add(sql.getString("waktu"));
                output.add(sql.getString("total"));
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
        return output.toArray(new String[output.size()]);
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
            
            ResultSet cek = new SQLQuery().get(TABLE_NAME, "`idTransaksi`='" + dataset[0]+"'");
            if (cek.next()) {
                dataset[0] = resetID(dataset[0]);
            }
            if (error.equals("")) {
                res = new SQLQuery().insert(TABLE_NAME, dataset);
                if (res > 0) {
                    JOptionPane.showMessageDialog(null, "Data baru berhasil disimpan!");
                }
            }
        } catch (Exception err) {
            String msg = err.getMessage()==null?"Terjadi kesalahan!":err.getMessage();
            JOptionPane.showMessageDialog(null, msg, "Error", 0);
        }
        return res;
    }
    public static void delete(String idTransaksi){
        int confirm = JOptionPane.showConfirmDialog(null, "Data akan hilang untuk selamanya. Anda yakin?", "Hapus Data", 0);
        if (confirm==JOptionPane.OK_OPTION) {
            new SQLQuery().delete(TABLE_NAME, "`idTransaksi`=\""+idTransaksi+"\"");
            DataDetailTransaksiModel.delete(idTransaksi);
        }
    }
    public static void empty(){
        int confirm = JOptionPane.showConfirmDialog(null, "Seluruh data akan hilang untuk selamanya. Anda yakin?", "Kosongkan Data", 0);
        if (confirm==JOptionPane.OK_OPTION) {
            new SQLQuery().delete(TABLE_NAME, "1");
            DataDetailTransaksiModel.empty();
        }
    }
    public static String[][] search(String str){
        ArrayList<String[]> output = new ArrayList<>();
        try{
            ResultSet sql = new SQLQuery().get(TABLE_NAME, "idTransaksi LIKE '%"+str+"%' OR waktu LIKE '%"+str+"%' OR total LIKE '%"+str+"%'");
            int i = 1;
            while(sql.next()){
                String[] result = {Integer.toString(i++) ,sql.getString("idTransaksi"),sql.getString("waktu"),"Rp. "+sql.getString("total")};
                output.add(result);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
        return output.toArray(new String[output.size()][]);
    }
}
