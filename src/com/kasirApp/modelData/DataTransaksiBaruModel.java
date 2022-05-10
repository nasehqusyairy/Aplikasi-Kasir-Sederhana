/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kasirApp.modelData;

import javax.swing.JOptionPane;
import java.util.ArrayList;

public class DataTransaksiBaruModel {
    
    private  ArrayList<String[]> lists = new ArrayList<>();
    private int total;
    private int i;
    
    
    public String[] header = {"No.","Kode","Nama Barang","Harga Satuan","Jumlah","Total"};
    public String[][] get(){
        ArrayList<String[]> output = new ArrayList<>();
        try{
            i=1;
            lists.forEach((list) -> {
                String[] barang = DataBarangModel.getByKode(list[1]);
                int harga = Integer.parseInt(barang[2]);
                int jumlah = Integer.parseInt(list[2]);
                String[] result = {Integer.toString(i++) ,list[1],barang[1],"Rp. "+barang[2],list[2],Integer.toString(harga*jumlah)};
                output.add(result);
            });
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
        return output.toArray(new String[output.size()][]);
    }
    public void insert(){
        lists.forEach((list) -> {
            DataDetailTransaksiModel.insert(list);
        });
    }
    public String delete(String kode){
        String[] filter = {};
        for (String[] list : lists) {
            if (list[1].equals(kode)) {
                filter = list;
            }
        }
        lists.remove(lists.indexOf(filter));
        return Integer.toString(getTotal());
    }
    public String add(String[]data){
        String barang[] = DataBarangModel.getByKode(data[1]);
        if (barang.length>0) {
            if (!lists.isEmpty()) {
                int found = 0;
                for (String[] list : lists) {
                    if (list[1].equals(data[1])) {
                        found=found+1;
                    }
                }
                if (found>0) {
                    JOptionPane.showMessageDialog(null, "Kode "+data[1]+" sudah ada!");
                }else{
                    lists.add(data);
                }
            }else{
                lists.add(data);
            }   
        }else{
            JOptionPane.showMessageDialog(null, "Kode "+data[1]+" tidak dikenali!");
        }
        
        return Integer.toString(getTotal());
    }
    public int getTotal(){
        total=0;
        lists.forEach((list) -> {
            String[] barang = DataBarangModel.getByKode(list[1]);
            int harga = Integer.parseInt(barang[2]);
            int jumlah = Integer.parseInt(list[2]);
            total=total+harga*jumlah;
        });
        return total;
    }
    public String[][] getLists(){
        return lists.toArray(new String[lists.size()][]);
    }
}
