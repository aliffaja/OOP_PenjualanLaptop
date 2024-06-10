/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package BAB10_Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Fauzan
 */
public class GUI_PenjualanLaptop extends javax.swing.JFrame {

    /**
     * Creates new form GUI_PenjualanLaptop
     */
    public GUI_PenjualanLaptop() {
        initComponents();
        tampil();
    }

    public Connection conn;

    public void batal() {
        txtPembeli.setText("");
        txtLaptop.setText("");
        txtHargaLaptop.setText("");
        txtJumlah_Uang.setText("");
        txtAlamat.setText("");
        btnPembayaran.clearSelection();
    }

    public void koneksi() throws SQLException {
        try {
            conn = null;
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/oop_laptop?user=root&password=");
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Driver Tidak Ditemukan");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "BELUM TERKONEKSI");
        }
    }

    public String nama, nama_laptop, pembayaran, harga, jumlah_uang, alamat;

    public void itempilih() {
        txtPembeli.setText(nama);
        txtLaptop.setText(nama_laptop);
        txtHargaLaptop.setText(harga);
        txtJumlah_Uang.setText(jumlah_uang);
        txtAlamat.setText(alamat);
        if (pembayaran.equals("Cash")) {
            radiobtnCash.setSelected(true);
        } else {
            radiobtnKredit.setSelected(true);
        }
    }

    public void tampil() {
        DefaultTableModel tabelhead = new DefaultTableModel();
        tabelhead.addColumn("NamaPembeli");
        tabelhead.addColumn("MerkLaptop");
        tabelhead.addColumn("HargaLaptop");
        tabelhead.addColumn("JumlahUang");
        tabelhead.addColumn("Pembayaran");
        tabelhead.addColumn("Alamat");
        try {
            koneksi();
            String sql = "SELECT * FROM tb_laptop";
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery(sql);
            while (res.next()) {
                tabelhead.addRow(new Object[]{res.getString("nama_pembeli"), res.getString("merk_laptop"), res.getString("harga_laptop"), res.getString("jumlah_uang"), res.getString("pembayaran"), res.getString("alamat")});
            }
            Tabel_Penjualan_Laptop.setModel(tabelhead);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Failed to fetch data!");
        }
    }

    public void delete() {
        int ok = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this data?", "Confirmation", JOptionPane.YES_NO_OPTION);
        if (ok == 0) {
            try {
                String sql = "DELETE FROM tb_laptop WHERE nama_pembeli='" + txtPembeli.getText() + "'";
                java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data deleted successfully!");
                batal();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Failed to delete data!");
            }
        }
        refresh();
    }

    public void update() {
        String Pembeli = txtPembeli.getText();
        String Laptop = txtLaptop.getText();
        String bayar;
        if (radiobtnCash.isSelected()) {
            bayar = "Cash";
        } else {
            bayar = "Credit";
        }
        String HargaLaptop = txtHargaLaptop.getText();
        String JumlahUang = txtJumlah_Uang.getText();
        String Alamat = txtAlamat.getText();
        try {
            Statement statement = conn.createStatement();
            statement.executeUpdate("UPDATE tb_laptop SET nama_pembeli='" + Pembeli + "'," + "merk_laptop='" + Laptop + "',"
                    + "harga_laptop='" + HargaLaptop + "'" + ",jumlah_uang='" + JumlahUang + "',pembayaran='" + bayar + "',alamat='" + Alamat + "' WHERE nama_pembeli = '" + Pembeli + "'");
            statement.close();
            conn.close();
            JOptionPane.showMessageDialog(null, "Data updated successfully!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Failed to update data!");
        }
        refresh();
    }

    public void refresh() {
        new GUI_PenjualanLaptop().setVisible(true);
        this.setVisible(false);
    }

    public void insert() {
        String Pembeli = txtPembeli.getText();
        String Laptop = txtLaptop.getText();
        String bayar;
        if (radiobtnCash.isSelected()) {
            bayar = "Cash";
        } else {
            bayar = "Credit";
        }
        String HargaLaptop = txtHargaLaptop.getText();
        String JumlahUang = txtJumlah_Uang.getText();
        String Alamat = txtAlamat.getText();
        try {
            koneksi();
            Statement statement = conn.createStatement();
            statement.executeUpdate("INSERT INTO tb_laptop (nama_pembeli,merk_laptop,pembayaran,harga_laptop,jumlah_uang,alamat)"
                    + "VALUES('" + Pembeli + "','" + Laptop + "','" + bayar + "','" + HargaLaptop + "','" + JumlahUang + "','" + Alamat + "')");
            statement.close();
            JOptionPane.showMessageDialog(null, "Data inserted successfully!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Failed to insert data!");
        }
        refresh();
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnPembayaran = new javax.swing.ButtonGroup();
        jOptionPane1 = new javax.swing.JOptionPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtPembeli = new javax.swing.JTextField();
        txtLaptop = new javax.swing.JTextField();
        txtHargaLaptop = new javax.swing.JTextField();
        radiobtnCash = new javax.swing.JRadioButton();
        radiobtnKredit = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtJumlah_Uang = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Tabel_Penjualan_Laptop = new javax.swing.JTable();
        btnDelete = new javax.swing.JButton();
        btnSimpan = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtAlamat = new javax.swing.JTextField();
        btnUpdate = new javax.swing.JButton();
        btnBayar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nama Pembeli");

        jLabel3.setText("Merk Laptop");

        jLabel4.setText("Harga Laptop");

        btnPembayaran.add(radiobtnCash);
        radiobtnCash.setText("Cash");

        btnPembayaran.add(radiobtnKredit);
        radiobtnKredit.setText("Kredit");
        radiobtnKredit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radiobtnKreditActionPerformed(evt);
            }
        });

        jLabel5.setText("Pembayaran");

        jLabel6.setText("Jumlah Uang");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel2.setText("Data Penjualan Laptop");

        Tabel_Penjualan_Laptop.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Nama Pembeli", "Merk Laptop", "Harga Laptop", "Jumlah Uang", "Kembalian", "Alamat"
            }
        ));
        Tabel_Penjualan_Laptop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tabel_Penjualan_LaptopMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(Tabel_Penjualan_Laptop);

        btnDelete.setText("Hapus");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnBatal.setText("Batal");
        btnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalActionPerformed(evt);
            }
        });

        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        jLabel7.setText("Alamat");

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnBayar.setText("BAYAR");
        btnBayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBayarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtPembeli, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                    .addComponent(txtLaptop)
                    .addComponent(txtHargaLaptop)
                    .addComponent(txtJumlah_Uang)
                    .addComponent(radiobtnCash, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(radiobtnKredit, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAlamat))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSimpan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBatal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnClose)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUpdate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBayar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnDelete)
                            .addComponent(btnSimpan)
                            .addComponent(btnBatal)
                            .addComponent(btnClose)
                            .addComponent(btnUpdate)
                            .addComponent(btnBayar)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(54, 54, 54)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(txtHargaLaptop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtPembeli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtLaptop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtJumlah_Uang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(radiobtnCash))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(radiobtnKredit)
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(77, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void radiobtnKreditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radiobtnKreditActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radiobtnKreditActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
        insert();
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        // Untuk menghapus tabel
        delete();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
        // TODO add your handling code here:
        batal();
    }//GEN-LAST:event_btnBatalActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        // TODO add your handling code here:
        // Untuk Close Program
        dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        update();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void Tabel_Penjualan_LaptopMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tabel_Penjualan_LaptopMouseClicked
        // TODO add your handling code here:
        int tabel = Tabel_Penjualan_Laptop.getSelectedRow();
        nama = Tabel_Penjualan_Laptop.getValueAt(tabel, 0).toString();
        nama_laptop = Tabel_Penjualan_Laptop.getValueAt(tabel, 1).toString();
        harga = Tabel_Penjualan_Laptop.getValueAt(tabel, 2).toString();
        jumlah_uang = Tabel_Penjualan_Laptop.getValueAt(tabel, 3).toString();
        pembayaran = Tabel_Penjualan_Laptop.getValueAt(tabel, 4).toString();
        alamat = Tabel_Penjualan_Laptop.getValueAt(tabel, 5).toString();
        itempilih();
    }//GEN-LAST:event_Tabel_Penjualan_LaptopMouseClicked

    private void btnBayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBayarActionPerformed
        // TODO add your handling code here:
        new GUI_DataBayar().setVisible(true);
    }//GEN-LAST:event_btnBayarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI_PenjualanLaptop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_PenjualanLaptop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_PenjualanLaptop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_PenjualanLaptop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_PenjualanLaptop().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tabel_Penjualan_Laptop;
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnBayar;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnDelete;
    private javax.swing.ButtonGroup btnPembayaran;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JOptionPane jOptionPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton radiobtnCash;
    private javax.swing.JRadioButton radiobtnKredit;
    private javax.swing.JTextField txtAlamat;
    private javax.swing.JTextField txtHargaLaptop;
    private javax.swing.JTextField txtJumlah_Uang;
    private javax.swing.JTextField txtLaptop;
    private javax.swing.JTextField txtPembeli;
    // End of variables declaration//GEN-END:variables
}
