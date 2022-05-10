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
public class SuccessButton extends MyButton {
  public SuccessButton() {
    super();
    setColor(ThemeColor.SUCCESS);
    setColorOver(ThemeColor.SUCCESS);
    setBorderColor(ThemeColor.SUCCESS);
    setColorClick(ThemeColor.SUCCESS600);
    setContentAreaFilled(false);
    setForeground(Color.WHITE);
  }
}
