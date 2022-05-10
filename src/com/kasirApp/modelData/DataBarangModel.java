/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kasirApp.modelData;

import com.kasirApp.helper.FileExtension;
import java.sql.ResultSet;
import com.kasirApp.helper.SQLQuery;
import java.io.File;
import java.nio.file.Files;
import javax.swing.JOptionPane;
import java.util.ArrayList;

public class DataBarangModel {
    public static final String TABLE_NAME = "barang";
    public static final String[] TABLE_HEADER = {"No.","Kode","Nama Barang","Harga"};
    public static String[][] get(){
        ArrayList<String[]> output = new ArrayList<>();
        try{
            ResultSet sql = new SQLQuery().get(TABLE_NAME, "1");
            int i = 1;
            while(sql.next()){
                String[] result = {Integer.toString(i++) ,sql.getString("kode"),sql.getString("namaBarang"),"Rp. "+sql.getString("harga")};
                output.add(result);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
        return output.toArray(new String[output.size()][]);
    }
    public static String[][] getAll(){
        ArrayList<String[]> output = new ArrayList<>();
        try{
            ResultSet sql = new SQLQuery().get(TABLE_NAME, "1");
            while(sql.next()){
                String[] result = {sql.getString("kode"),sql.getString("namaBarang"),"Rp. "+sql.getString("harga"),sql.getString("deskripsi"),sql.getString("foto")};
                output.add(result);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
        return output.toArray(new String[output.size()][]);
    }
    public static String[] getByKode(String kode){
        ArrayList<String> output = new ArrayList<>();
        try{
            ResultSet sql = new SQLQuery().get(TABLE_NAME, "`kode`=\""+kode+"\"");
            while(sql.next()){
                output.add(sql.getString("kode"));
                output.add(sql.getString("namaBarang"));
                output.add(sql.getString("harga"));
                output.add(sql.getString("deskripsi"));
                output.add(sql.getString("foto"));
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
            
            File file = new File(dataset[4]);
            String ext = FileExtension.get(file);
            File dir = new File("img");
            dir.mkdir();
            File nfile = new File(dir.getAbsolutePath()+ "/" + ((int) Math.floor(Math.random() * Math.pow(10, 7))) +ext);
            String filename = nfile.getAbsolutePath();
            dataset[4] = filename.replace("\\", "\\\\");
            
            ResultSet cek = new SQLQuery().get(TABLE_NAME, "`kode`='" + dataset[0]+"'");
            if (cek.next()) {
                error = "Kode " + dataset[0] + " sudah pernah ada!";
                throw new Exception(error);
            }
            if (error.equals("")) {
                res = new SQLQuery().insert(TABLE_NAME, dataset);
                if (res > 0) {
                    JOptionPane.showMessageDialog(null, "Data baru berhasil disimpan!");
                    Files.copy(file.toPath(),nfile.toPath());
                }
            }
        } catch (Exception err) {
            String msg = err.getMessage()==null?"Terjadi kesalahan!":err.getMessage();
            JOptionPane.showMessageDialog(null, msg, "Error", 0);
        }
        return res;
    }
    public static int update(String[] data){
        String error = "";
        int res =0;
        try {
            
            String[] oldData = getByKode(data[0]);
            if (!oldData[4].replace("\\", "\\\\").replace("%20", " ").equals(data[4])) {
                File oldFile = new File(oldData[4]);
                oldFile.delete();
                File file = new File(data[4]);
                String ext = FileExtension.get(file);
                File dir = new File("img");
                dir.mkdir();
                File nfile = new File(dir.getAbsolutePath()+ "/" + ((int) Math.floor(Math.random() * Math.pow(10, 7))) +ext);
                Files.copy(file.toPath(),nfile.toPath());
                String filename = nfile.getAbsolutePath();
                data[4] = filename.replace("\\", "\\\\");
            }
        
            String[] dataset = {
                    "`namaBarang`='" + data[1] + "'",
                    "`harga`='" + data[2] + "'",
                    "`deskripsi`='" + data[3] + "'",
                    "`foto`='" + data[4] + "'",
            };
            for (String string : dataset) {
                if (string.equals("")) {
                    error = "Input field tidak boleh kosong";
                    throw new Exception(error);
                }
            }
            if (error.equals("")) {
                res = new SQLQuery().update(TABLE_NAME, dataset, "`kode`=\""+data[0]+"\"");
                if (res > 0) {
                    JOptionPane.showMessageDialog(null, "Data berhasil diubah!");
                }
            }
        } catch (Exception err) {
            String msg = err.getMessage()==null?"Terjadi kesalahan!":err.getMessage();
            JOptionPane.showMessageDialog(null, msg, "Error", 0);
        }
        return res;
    }
    public static void delete(String kode){
        String[] oldData = getByKode(kode);
        File oldFile = new File(oldData[4]);
        oldFile.delete();
        new SQLQuery().delete(TABLE_NAME, "`kode`=\""+kode+"\"");
    }
    public static void empty(){
            String[][] oldData = getAll();
            for (String[] strings : oldData) {
                File oldFile = new File(strings[4]);
                oldFile.delete();
            }
            new SQLQuery().delete(TABLE_NAME, "1");
    }
    public static String[][] search(String str){
        ArrayList<String[]> output = new ArrayList<>();
        try{
            ResultSet sql = new SQLQuery().get(TABLE_NAME, "kode LIKE '%"+str+"%' OR namaBarang LIKE '%"+str+"%' OR harga LIKE '%"+str+"%'");
            int i = 1;
            while(sql.next()){
                String[] result = {Integer.toString(i++) ,sql.getString("kode"),sql.getString("namaBarang"),"Rp. "+sql.getString("harga")};
                output.add(result);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
        return output.toArray(new String[output.size()][]);
    }
}
