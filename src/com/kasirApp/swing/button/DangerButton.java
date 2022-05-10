package com.kasirApp.swing.button;

import com.kasirApp.helper.ThemeColor;
import java.awt.Color;

public class DangerButton extends MyButton {

    public DangerButton() {
        super();
        setColor(ThemeColor.DANGER);
        setColorOver(ThemeColor.DANGER);
        setBorderColor(ThemeColor.DANGER);
        setColorClick(ThemeColor.DANGER600);
        setContentAreaFilled(false);
        setForeground(Color.WHITE);
    }

}
