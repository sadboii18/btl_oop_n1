/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.time.LocalDate;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.awt.CardLayout;
import javax.swing.JPanel;
import view.Trangchu;
import ctl.Phieumuon_ctl;
import static ctl.Phieumuon_ctl.getConnection;
import ctl.Sv_ctl;
import ctl.Sach_ctl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import model.phieumuon_md;
import model.sach_md;
import model.sv_md;
import java.io.File;
import java.io.FileOutputStream;
import com.toedter.calendar.JDateChooser;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Themphieumuon extends javax.swing.JFrame {

    private Phieumuon_ctl phieumuon_ctl;
    private Sach_ctl sach_ctl;
    private Sv_ctl sv_ctl;

    public Themphieumuon() {
        initComponents();
        phieumuon_ctl = new Phieumuon_ctl();
        sv_ctl = new Sv_ctl();
        sach_ctl = new Sach_ctl();
        addmas();
        Date currentDate = new Date();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        // Hiển thị ngày tháng lên JTextField
        nm.setDate(currentDate);
    }

    private void addmas() {
        try {
            List<sach_md> listkhoa = sach_ctl.addmasach();
            DefaultTableModel tb = new DefaultTableModel();
            for (sach_md a : listkhoa) {
                cbms.addItem(a.getMasach());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        mpm = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        msv = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cbms = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        sldm = new javax.swing.JTextField();
        cbtt = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        gc = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        nm = new com.toedter.calendar.JDateChooser();
        nt = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Mã Phiếu Mượn");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Mã SV");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Mã Sách");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Ngày Mượn");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Ngày Trả");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Số Lượng Sách Mượn");

        sldm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sldmMouseClicked(evt);
            }
        });
        sldm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sldmActionPerformed(evt);
            }
        });

        cbtt.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Chưa Trả" }));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Ghi Chú");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel1.setText("Trạng Thái");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/anh/buttonthempms.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/anh/buttonquayvetrangchu.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        nm.setDateFormatString("yyyy-MM-dd");

        nt.setDateFormatString("yyyy-MM-dd");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(5, 5, 5)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4)
                                .addComponent(jLabel8)
                                .addComponent(jLabel3)
                                .addComponent(jLabel2))
                            .addGap(42, 42, 42)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(msv, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(cbms, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(mpm, javax.swing.GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)
                                .addComponent(nm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5)
                                .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(sldm)
                                        .addComponent(cbtt, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(gc, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(5, 5, 5)
                                    .addComponent(nt, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(cbms, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(mpm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(msv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(nm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(nt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(sldm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5)))
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbtt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/anh/thempms.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sldmMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sldmMouseClicked


    }//GEN-LAST:event_sldmMouseClicked

    private void sldmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sldmActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sldmActionPerformed
// public int laysoluongsachconlai(String maSach) {
//    int soLuongConLai = 0;
//    
//    try {
//        Connection conn = getConnection();
//        Statement st = conn.createStatement();
//        
//        ResultSet rs = st.executeQuery("SELECT sach.soluong - COALESCE(SUM(p.soluong), 0) AS soluong_con_lai FROM sach LEFT JOIN phieumuon p ON sach.masach = p.masach WHERE sach.masach = '" + maSach + "' AND p.trangthai like N'Chưa Trả' GROUP BY sach.masach, sach.soluong");
//        
//        if (rs.next()) {
//            soLuongConLai = rs.getInt("soluong_con_lai");
//        }
//        
//        rs.close();
//        st.close();
//        conn.close();
//    } catch (SQLException ex) {
//        ex.printStackTrace();
//    }
//    
//    return soLuongConLai;
//}
// public boolean kiemTraSoLuongSachMuonToiDa(String maSV) {
//    boolean duocMuon = true;
//    
//    try {
//        Connection conn = getConnection();
//        PreparedStatement stmt = conn.prepareStatement("SELECT SUM(soluong) AS tong_sach FROM phieumuon WHERE masv ='"+maSV+"' AND trangthai like N'Chưa Trả' group by masv");
//     
//        
//        ResultSet rs = stmt.executeQuery();
//        
//        if (rs.next()) {
//            int tongSach = rs.getInt("tong_sach");
//            
//            if (tongSach >= 5) {
//                duocMuon = false;
//            }
//        }
//        
//        rs.close();
//        stmt.close();
//        conn.close();
//    } catch (SQLException ex) {
//        ex.printStackTrace();
//    }
//    
//    return duocMuon;
//}

    public int laysoluongsachconlai(String maSach) {
        int soLuongConLai = 0;

        try {
            Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT sach.soluong - COALESCE(SUM(CASE WHEN p.trangthai = N'Chưa Trả' THEN p.soluong ELSE 0 END), 0) AS soluong_con_lai FROM sach LEFT JOIN phieumuon p ON sach.masach = p.masach WHERE sach.masach = ? GROUP BY sach.masach, sach.soluong");
            stmt.setString(1, maSach);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                soLuongConLai = rs.getInt("soluong_con_lai");
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return soLuongConLai;
    }

    public boolean kiemTraSoLuongSachMuonToiDa(String maSV) {
        boolean duocMuon = true;

        try {
            Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT SUM(p.soluong) AS tong_sach FROM phieumuon p WHERE p.masv = ? AND p.trangthai like N'Chưa Trả'");
            stmt.setString(1, maSV);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int tongSach = rs.getInt("tong_sach");

                if (tongSach >= 5) {
                    duocMuon = false;
                }
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return duocMuon;
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String mapm = mpm.getText();
        String masv = msv.getText();
        String mas = cbms.getSelectedItem().toString();

        Date ngaymuonDate = nm.getDate();
        Date ngaytraDate = nt.getDate();

        int sol = Integer.parseInt(sldm.getText());
        String trangt = cbtt.getSelectedItem().toString();
        String ghic = gc.getText();

        int soLuongConLai = laysoluongsachconlai(mas);
// Kiểm tra ngaytraDate phải lớn hơn hoặc bằng ngaymuonDate tối đa 14 ngày
long diffInDays = (ngaytraDate.getTime() - ngaymuonDate.getTime()) / (1000 * 60 * 60 * 24);
if (diffInDays > 14 || diffInDays < 0) {
    JOptionPane.showMessageDialog(this, "Ngày trả sách phải lớn hơn hoặc bằng ngày mượn tối đa 14 ngày", "Thông báo", JOptionPane.ERROR_MESSAGE);
    return;
}

        if (soLuongConLai >= sol && kiemTraSoLuongSachMuonToiDa(masv)) {
            phieumuon_md phieumuon = new phieumuon_md(mapm, masv, mas, ngaymuonDate, ngaytraDate, sol, trangt, ghic);
            if (phieumuon_ctl.themphieumuon(phieumuon)) {
                JOptionPane.showMessageDialog(this, "Mượn Thành Công");
            } else {
                JOptionPane.showMessageDialog(this, "Đã xảy ra lỗi khi thêm phiếu mượn", "Thông báo", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Số lượng sách trong kho không đủ hoặc đã vượt quá số lượng sách mượn tối đa", "Thông báo", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Trangchu a = new Trangchu();
        a.show();
        this.hide();
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(Themphieumuon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Themphieumuon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Themphieumuon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Themphieumuon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Themphieumuon().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cbms;
    private javax.swing.JComboBox cbtt;
    private javax.swing.JTextField gc;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField mpm;
    private javax.swing.JTextField msv;
    private com.toedter.calendar.JDateChooser nm;
    private com.toedter.calendar.JDateChooser nt;
    private javax.swing.JTextField sldm;
    // End of variables declaration//GEN-END:variables
}
