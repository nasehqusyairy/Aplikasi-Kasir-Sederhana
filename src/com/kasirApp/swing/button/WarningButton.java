/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kasirApp.swing.button;

import com.kasirApp.helper.ThemeColor;
import java.awt.Color;

/**
 *
 * @author Nasyikh Al-Qusyairy
 */
public class WarningButton extends MyButton {
  public WarningButton() {
    super();
    setColor(ThemeColor.WARNING);
    setColorOver(ThemeColor.WARNING);
    setBorderColor(ThemeColor.WARNING);
    setColorClick(ThemeColor.WARNING600);
    setContentAreaFilled(false);
    setForeground(Color.BLACK);
  }
}
