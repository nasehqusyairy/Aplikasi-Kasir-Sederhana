/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kasirApp.modelData;
import java.sql.ResultSet;
import com.kasirApp.helper.SQLQuery;
import javax.swing.JOptionPane;
/**
 *
 * @author Nasyikh Al-Qusyairy
 */
public class DataLoginModel {
    public static String TABLE_NAME = "login";
    public static boolean isExist(String password){
        boolean output = false;
        try{
            ResultSet sql = new SQLQuery().get(TABLE_NAME, "`password`=\""+password+"\"");
            if(sql.next()){
                output = true;
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
        return output;
    }
    public static boolean update(String oldPassword,String newPassword,String repeatPassword){
        boolean updated = false;
        if (isExist(oldPassword)) {
            if (newPassword.trim().equals(repeatPassword.trim())) {
                String dataset[] = {"`password`='" + newPassword + "'"};
                try {
                    int res = new SQLQuery().update(TABLE_NAME, dataset, "`password`='" + oldPassword + "'");
                    if (res > 0) {
                        JOptionPane.showMessageDialog(null, "Kata Sandi berhasil diubah!");
                        updated = true;
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Terjadi kesalahan! "+e.getMessage(), "Error", 0);
                }
            }else{
                JOptionPane.showMessageDialog(null, "Sandi yang diulang harus sama");
            }
        }else{
             JOptionPane.showMessageDialog(null, "Sandi lama tidak sesuai");
        }
        return updated;
    }
}
