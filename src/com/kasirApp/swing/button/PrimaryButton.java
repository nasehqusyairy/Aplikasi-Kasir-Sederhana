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
public class PrimaryButton extends MyButton {

    public PrimaryButton() {
        super();
        setColor(ThemeColor.PRIMARY);
        setColorOver(ThemeColor.PRIMARY);
        setColorClick(ThemeColor.PRIMARY600);
        setContentAreaFilled(false);
        setForeground(Color.WHITE);
    }
    
}
