/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kasirApp.helper;

import java.sql.*;
import javax.swing.JOptionPane;
import java.util.*;

public class SQLQuery {

  public ResultSet get(String tablename, String where) throws Exception {
    Connection conn = (Connection) DB.DB_connect();
    Statement ppt = conn.createStatement();
    ResultSet sql = ppt.executeQuery("SELECT * FROM `" + tablename + "` WHERE " + where);
    return sql;
  }

  public int insert(String tablename, String datasets[]) {
    for (int i = 0; i < datasets.length; i++) {
      datasets[i] = "'" + datasets[i] + "'";
    }
    int res = 0;
    try {
      Connection conn = (Connection) DB.DB_connect();
      Statement ppt = conn.createStatement();
      String sqlstr = "INSERT INTO `" + tablename + "` VALUES (NULL, "
          + Arrays.toString(datasets).replaceAll("\\[|\\]", "")
          + ")";
      res = ppt.executeUpdate(sqlstr);
    } catch (Exception err) {
      JOptionPane.showMessageDialog(null, err.getMessage(), "Error", 0);
    }
    return res;
  }

  public int update(String tablename, String datasets[], String where) {
    int res = 0;
    try {
      Connection conn = (Connection) DB.DB_connect();
      Statement ppt = conn.createStatement();
      String sqlstr = "Update `" + tablename + "` SET " + Arrays.toString(datasets).replaceAll("\\[|\\]", "")
          + " WHERE " + where;
      res = ppt.executeUpdate(sqlstr);
    } catch (Exception err) {
      JOptionPane.showMessageDialog(null, err.getMessage(), "Error", 0);
    }
    return res;
  }

  public int delete(String tablename, String where) {
    int res = 0;
    try {
      Connection conn = (Connection) DB.DB_connect();
      Statement ppt = conn.createStatement();
      String sqlstr = "DELETE FROM `" + tablename + "` " + "WHERE " + where;
      res = ppt.executeUpdate(sqlstr);
    } catch (Exception err) {
      JOptionPane.showMessageDialog(null, err.getMessage(), "Error", 0);
    }
    return res;
  }
}
