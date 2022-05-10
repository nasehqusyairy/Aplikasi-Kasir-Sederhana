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
public class LightButton extends MyButton {
  public LightButton() {
    super();
    setColor(ThemeColor.LIGHT);
    setColorOver(ThemeColor.LIGHT);
    setBorderColor(ThemeColor.LIGHT);
    setColorClick(ThemeColor.GRAY200);
    setContentAreaFilled(false);
    setForeground(Color.BLACK);
  }
}
