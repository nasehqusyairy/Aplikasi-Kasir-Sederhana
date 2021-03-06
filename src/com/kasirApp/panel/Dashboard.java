/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.kasirApp.panel;
import com.kasirApp.form.DataTransaksiForm;
import com.kasirApp.helper.ThemeColor;
import com.kasirApp.model.TabelTransaksiModel;
import com.kasirApp.modelData.DataBarangModel;
import com.kasirApp.modelData.DataTransaksiModel;
/**
 *
 * @author Nasyikh Al-Qusyairy
 */
public class Dashboard extends javax.swing.JPanel {
    private String jumlahBarang;
    private String jumlahTransaksi;
    private String pendapatan;
    private String idTransaksi = "";
    private TabelTransaksiModel model = new TabelTransaksiModel();
    
    public void setJumlahBarang(String str){
        jumlahBarang=str;
        cardJumlahBarang.setSubtitle(str);
    }
    public void setJumlahTransaksi(String str){
        jumlahBarang=str;
        cardJumlahTransaksi.setSubtitle(str);
    }public void setPendapatan(String str){
        jumlahBarang=str;
        cardPendapatan.setSubtitle(str);
    }
    public void setIdTransaksi(String str){
        idTransaksi=str;
    }
    
    public void refresh(){
        setJumlahBarang(Integer.toString(DataBarangModel.get().length));
        setJumlahTransaksi(Integer.toString(DataTransaksiModel.get().length));
        String[][] transaksi = DataTransaksiModel.get();
        int total = 0;
        for (String[] strings : transaksi) {
            total=total+Integer.parseInt(strings[3].replace("Rp. ", ""));
        }
        setPendapatan("Rp. "+Integer.toString(total));
        model.setDataVector(DataTransaksiModel.get(), DataTransaksiModel.TABLE_HEADER);
    }
    
    /**
     * Creates new form Dashboard
     */
    public Dashboard() {
        initComponents();
        setJumlahBarang(Integer.toString(DataBarangModel.get().length));
        setJumlahTransaksi(Integer.toString(DataTransaksiModel.get().length));
        String[][] transaksi = DataTransaksiModel.get();
        int total = 0;
        for (String[] strings : transaksi) {
            total=total+Integer.parseInt(strings[3].replace("Rp. ", ""));
        }
        setPendapatan("Rp. "+Integer.toString(total));
        tblTransaksi.setModel(model);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTransaksi = new com.kasirApp.swing.myTable();
        btnDetail = new com.kasirApp.swing.button.PrimaryButton();
        btnRefresh = new com.kasirApp.swing.button.SecondaryButton();
        inpCari = new com.kasirApp.swing.MyTextField();
        btnKosongkan = new com.kasirApp.swing.button.SecondaryButton();
        jPanel1 = new javax.swing.JPanel();
        cardJumlahBarang = new com.kasirApp.swing.Card();
        cardJumlahTransaksi = new com.kasirApp.swing.Card();
        cardPendapatan = new com.kasirApp.swing.Card();

        setBackground(ThemeColor.LIGHT);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Dashboard");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Data Transaksi");

        tblTransaksi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "No", "Id Transaksi", "Waktu", "Total"
            }
        ));
        tblTransaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTransaksiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblTransaksi);

        btnDetail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/kasirApp/icon/Detail.png"))); // NOI18N
        btnDetail.setText("Detail");
        btnDetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetailActionPerformed(evt);
            }
        });

        btnRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/kasirApp/icon/Refresh.png"))); // NOI18N
        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        inpCari.setText("Cari di sini...");
        inpCari.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                inpCariFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                inpCariFocusLost(evt);
            }
        });
        inpCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                inpCariKeyReleased(evt);
            }
        });

        btnKosongkan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/kasirApp/icon/Kosongkan.png"))); // NOI18N
        btnKosongkan.setText("Kosongkan");
        btnKosongkan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKosongkanActionPerformed(evt);
            }
        });

        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));

        cardJumlahBarang.setBody("");
        cardJumlahBarang.setBorderColor(ThemeColor.PRIMARY);
        cardJumlahBarang.setIsDark(false);
        cardJumlahBarang.setSubtitle("1000000000");
        cardJumlahBarang.setTitle("Jumlah Barang");
        jPanel1.add(cardJumlahBarang);

        cardJumlahTransaksi.setBody("");
        cardJumlahTransaksi.setBorderColor(ThemeColor.SECONDARY);
        cardJumlahTransaksi.setIsDark(false);
        cardJumlahTransaksi.setSubtitle("1000000000");
        cardJumlahTransaksi.setTitle("Jumlah Transaksi");
        jPanel1.add(cardJumlahTransaksi);

        cardPendapatan.setBody("");
        cardPendapatan.setBorderColor(ThemeColor.SUCCESS);
        cardPendapatan.setIsDark(false);
        cardPendapatan.setSubtitle("Rp. 1000000000");
        cardPendapatan.setTitle("Pendapatan");
        jPanel1.add(cardPendapatan);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 786, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnDetail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnKosongkan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inpCari, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDetail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inpCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnKosongkan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblTransaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTransaksiMouseClicked
        idTransaksi = tblTransaksi.getValueAt(tblTransaksi.getSelectedRow(), 1).toString();
    }//GEN-LAST:event_tblTransaksiMouseClicked

    private void btnDetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetailActionPerformed
        if (!idTransaksi.equals("")) {
            new DataTransaksiForm(idTransaksi,this).setVisible(true);
        }
    }//GEN-LAST:event_btnDetailActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        refresh();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void inpCariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inpCariKeyReleased
        model.setDataVector(DataTransaksiModel.search(inpCari.getText().trim()), DataTransaksiModel.TABLE_HEADER);
    }//GEN-LAST:event_inpCariKeyReleased

    private void inpCariFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inpCariFocusGained
        if (inpCari.getText().equals("Cari di sini...")) {
            inpCari.setText("");
        }
    }//GEN-LAST:event_inpCariFocusGained

    private void inpCariFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inpCariFocusLost
         if (inpCari.getText().equals("")) {
            inpCari.setText("Cari di sini...");
        }
    }//GEN-LAST:event_inpCariFocusLost

    private void btnKosongkanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKosongkanActionPerformed
        DataTransaksiModel.empty();
        refresh();
    }//GEN-LAST:event_btnKosongkanActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.kasirApp.swing.button.PrimaryButton btnDetail;
    private com.kasirApp.swing.button.SecondaryButton btnKosongkan;
    private com.kasirApp.swing.button.SecondaryButton btnRefresh;
    private com.kasirApp.swing.Card cardJumlahBarang;
    private com.kasirApp.swing.Card cardJumlahTransaksi;
    private com.kasirApp.swing.Card cardPendapatan;
    private com.kasirApp.swing.MyTextField inpCari;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private com.kasirApp.swing.myTable tblTransaksi;
    // End of variables declaration//GEN-END:variables
}
