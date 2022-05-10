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
public class DarkButton extends MyButton {

    public DarkButton() {
        super();
        setColorOver(ThemeColor.DARK);
        setColor(ThemeColor.DARK);
        setBorderColor(ThemeColor.DARK);
        setColorClick(ThemeColor.BLACK);
        setContentAreaFilled(false);
        setForeground(Color.WHITE);
        setRadius(50);
    }

}
