/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kasirApp.helper;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Driver;
import java.sql.*;
import javax.swing.JOptionPane;

public class DB {
  public static Connection conn;

  public static Connection DB_connect() throws SQLException {
    if (conn == null) {
      try {
        String url = "jdbc:mysql://localhost/kasirApp";
        String user = "root";
        String pass = "";
        DriverManager.registerDriver(new Driver());
        conn = (Connection) DriverManager.getConnection(url, user, pass);
      } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Koneksi database gagal!", "Error", JOptionPane.ERROR_MESSAGE);
      }
    }
    return conn;
  }
}
