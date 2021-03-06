/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.kasirApp.swing;
import com.kasirApp.helper.ThemeColor;
import java.awt.Color;
import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;

/**
 *
 * @author Nasyikh Al-Qusyairy
 */
public class ImageCard extends MyPanel {

    /**
     * Creates new form ImageCard
     */
    public ImageCard() {
        initComponents();
         imgPreview.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/com/kasirApp/img/noimage.png")).getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH)));
    }

    private boolean isDark;
    private String title;
    private String subtitle;
    private String body;
    private String image;
    private URL imageURL;
    
    public void setIsDark(boolean opt){
        isDark = opt;
        if (opt) {
            cardTitle.setForeground(Color.WHITE);
            cardSubtitle.setForeground(Color.WHITE);
            cardBody.setForeground(Color.WHITE);
        }else{
            cardTitle.setForeground(Color.BLACK);
            cardSubtitle.setForeground(Color.BLACK);
            cardBody.setForeground(Color.BLACK);
        }
    }
    
    public void setTitle(String str){
        title = str;
        cardTitle.setText(str);
    }
    public void setSubtitle(String str){
        subtitle = str;
        cardSubtitle.setText(str);
    }
    public void setBody(String str){
        body = str;
        cardBody.setText("<html><body><p align='justify'>"+str+"</p></body></html>");
    }
    public void setImage(String path){
        image = path;
        imgPreview.setIcon(new ImageIcon(new ImageIcon(path).getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH)));
    }
    public void setImageURL(URL path){
        imageURL = path;
        imgPreview.setIcon(new ImageIcon(new ImageIcon(path).getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH)));
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        cardTitle = new javax.swing.JLabel();
        cardSubtitle = new javax.swing.JLabel();
        cardBody = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        imgPreview = new javax.swing.JLabel();

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.LINE_AXIS));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setOpaque(false);

        cardTitle.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        cardTitle.setForeground(ThemeColor.PRIMARY);
        cardTitle.setText("Nama Barang");

        cardSubtitle.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        cardSubtitle.setForeground(ThemeColor.SECONDARY);
        cardSubtitle.setText("Rp. 1000000000");

        cardBody.setText("<html><body><p>\nLorem ipsum dolor sit amet commodo dis a ipsum hendrerit dapibus phasellus lacinia habitant ac urna donec aliquet sapien interdum vivamus tempus pede netus suscipit iaculis quis quam lectus dictum\n</p></body></html>");
        cardBody.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cardTitle)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cardBody, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(29, 29, 29))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cardSubtitle)
                        .addContainerGap(249, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cardTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cardSubtitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cardBody, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(jPanel1);

        jPanel2.setBackground(ThemeColor.DARK);

        imgPreview.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imgPreview.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/kasirApp/icon/Barang.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imgPreview, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imgPreview, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                .addContainerGap())
        );

        add(jPanel2);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel cardBody;
    private javax.swing.JLabel cardSubtitle;
    private javax.swing.JLabel cardTitle;
    private javax.swing.JLabel imgPreview;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
