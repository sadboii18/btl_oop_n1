/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import ctl.Nxb_ctl;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.lop_md;
import model.nxb_md;
import java.io.File;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Nxb extends javax.swing.JFrame {

    private Nxb_ctl nxb_ctl;

    public Nxb() {
        initComponents();
        nxb_ctl = new Nxb_ctl();
        loadnxb();
    }

    private void loadnxb() {
        try {
            nxb_ctl = new Nxb_ctl();
            List<nxb_md> listlop = nxb_ctl.loadnxb();
            DefaultTableModel tb = new DefaultTableModel();
            tb.addColumn("Mã Nhà Xuất Bản");
            tb.addColumn("Tên Nhà Xuất Bản");
            tb.addColumn("Địa Chỉ");
            tb.addColumn("Số Điện Thoại");
            tb.addColumn("Ghi Chú");
            for (nxb_md hd : listlop) {

                tb.addRow(new Object[]{
                    hd.getManxb(), hd.getTennxb(),
                    hd.getDiachi(), hd.getSdt(),
                    hd.getGhichu()

                });
            }
            tbnxb.setModel(tb);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cbtk = new javax.swing.JComboBox();
        tk = new javax.swing.JTextField();
        jToolBar4 = new javax.swing.JToolBar();
        jButton23 = new javax.swing.JButton();
        jButton24 = new javax.swing.JButton();
        jButton25 = new javax.swing.JButton();
        jButton26 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        mnxb = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tnxb = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        sdt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        dc = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        gc = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbnxb = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cbtk.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tất Cả", "MaNhaXuatBan", "TenNhaXuatBan", "DiaChi" }));
        getContentPane().add(cbtk, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 200, 135, 32));
        getContentPane().add(tk, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 200, 181, 32));

        jToolBar4.setBackground(new java.awt.Color(204, 204, 204));
        jToolBar4.setRollover(true);

        jButton23.setBackground(new java.awt.Color(255, 153, 204));
        jButton23.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_search_25px.png"))); // NOI18N
        jButton23.setText("Tìm Kiếm");
        jButton23.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton23.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });
        jToolBar4.add(jButton23);

        jButton24.setBackground(new java.awt.Color(102, 255, 51));
        jButton24.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_edit_25px.png"))); // NOI18N
        jButton24.setText("   Sửa   ");
        jButton24.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton24.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
            }
        });
        jToolBar4.add(jButton24);

        jButton25.setBackground(new java.awt.Color(255, 51, 51));
        jButton25.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_add_25px_5.png"))); // NOI18N
        jButton25.setText("   Thêm   ");
        jButton25.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton25.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton25ActionPerformed(evt);
            }
        });
        jToolBar4.add(jButton25);

        jButton26.setBackground(new java.awt.Color(204, 255, 102));
        jButton26.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_delete_25px_1.png"))); // NOI18N
        jButton26.setText("    Xóa    ");
        jButton26.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton26.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton26ActionPerformed(evt);
            }
        });
        jToolBar4.add(jButton26);

        jButton4.setBackground(new java.awt.Color(204, 204, 255));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_test_account_25px.png"))); // NOI18N
        jButton4.setText("Đăng Xuất");
        jButton4.setFocusable(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jToolBar4.add(jButton4);

        getContentPane().add(jToolBar4, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 180, -1, 60));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Mã Nhà Xuất Bản");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 250, -1, -1));
        getContentPane().add(mnxb, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 250, 499, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Tên Nhà Xuất Bản");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 280, -1, -1));
        getContentPane().add(tnxb, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 280, 499, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Số Điện Thoại");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 320, -1, -1));
        getContentPane().add(sdt, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 320, 499, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Đia Chỉ");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 360, 70, -1));
        getContentPane().add(dc, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 360, 499, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Ghi Chú");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 390, 58, -1));
        getContentPane().add(gc, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 390, 499, -1));

        tbnxb.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbnxb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbnxbMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbnxb);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 430, 860, 140));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/anh/nhaxb.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 610));

        jMenu1.setText("Quản Lí Sách");

        jMenuItem2.setText("QL Thể Loại");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("QL Tác Giả");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem1.setText("QL Nhà XB");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem4.setText("QL Sách");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Quản Lý Thư Viện");

        jMenuItem5.setText("Quản Lí Ra Vào Thư Viện");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuItem7.setText("Quản Lí Phiếu Mượn Trả");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem7);

        jMenuItem9.setText("Chi Tiết Phiếu Mượn");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem9);

        jMenuItem10.setText("Quản Lí Sách Quá Hạn Mượn");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem10);

        jMenuItem6.setText("Thống Kê");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem6);

        jMenuItem8.setText("Tra Cứu Sinh Viên");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem8);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        Tacgia a = new Tacgia();
        a.show();
        this.hide();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        Sachhientaithuvien a = new Sachhientaithuvien();
        a.show();
        this.hide();
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed
        String manxb = mnxb.getText().trim();
        String tennxb = tnxb.getText().trim();
        String diac = dc.getText().trim();
        String sdt1 = sdt.getText().trim();
        String ghic = gc.getText().trim();

// Kiểm tra mã NXB không được để trống
        if (manxb.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập mã nhà xuất bản", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return;
        }

// Kiểm tra tên NXB không được để trống
        if (tennxb.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập tên nhà xuất bản", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return;
        }

// Kiểm tra SDT phải là số và tối đa 12 chữ số
        if (!sdt1.matches("\\d{1,12}")) {
            JOptionPane.showMessageDialog(this, "Số điện thoại phải là số và tối đa 12 chữ số", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return;
        }
        nxb_md hd = new nxb_md(manxb, tennxb, diac, sdt1, ghic);
        if (nxb_ctl.suanxb(hd)) {
            loadnxb();
            JOptionPane.showMessageDialog(this, "Sửa dữ liệu thành công");
        } else {
            JOptionPane.showMessageDialog(this, "Lỗi khi sửa dữ liệu", "Thông báo", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton24ActionPerformed

    private void jButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton25ActionPerformed
        String manxb = mnxb.getText().trim();
        String tennxb = tnxb.getText().trim();
        String diac = dc.getText().trim();
        String sdt1 = sdt.getText().trim();
        String ghic = gc.getText().trim();

// Kiểm tra mã NXB không được để trống
        if (manxb.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập mã nhà xuất bản", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return;
        }

// Kiểm tra tên NXB không được để trống
        if (tennxb.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập tên nhà xuất bản", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return;
        }

// Kiểm tra SDT phải là số và tối đa 12 chữ số
        if (!sdt1.matches("\\d{1,12}")) {
            JOptionPane.showMessageDialog(this, "Số điện thoại phải là số và tối đa 12 chữ số", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return;
        }

        nxb_md hd = new nxb_md(manxb, tennxb, diac, sdt1, ghic);
        if (nxb_ctl.themnxb(hd)) {
            loadnxb();
            JOptionPane.showMessageDialog(this, "Thêm dữ liệu thành công");
        } else {
            JOptionPane.showMessageDialog(this, "Lỗi khi thêm dữ liệu", "Thông báo", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton25ActionPerformed

    private void jButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton26ActionPerformed
        String manxb = mnxb.getText();
        String tennxb = tnxb.getText();
        String diac = dc.getText();
        String sdt1 = sdt.getText();
        String ghic = gc.getText();
        nxb_md hd = new nxb_md(manxb, tennxb, diac, sdt1, ghic);
        if (nxb_ctl.xoanxb(hd)) {
            loadnxb();
            JOptionPane.showMessageDialog(this, "xóa dữ liệu thành công");
        } else {
            JOptionPane.showMessageDialog(this, "Lỗi khi xóa dữ liệu", "Thông báo", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton26ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        Theloai a = new Theloai();
        a.show();
        this.hide();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        Nxb a = new Nxb();
        a.show();
        this.hide();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        Sach a = new Sach();
        a.show();
        this.hide();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
        try {
            String dkien = cbtk.getSelectedItem().toString();
            String manxb = tk.getText();
            String tennxb = tk.getText();
            String diachi = tk.getText();

            if (dkien.equals("Tất Cả")) {
                List<nxb_md> listkhoa = nxb_ctl.loadnxb();
                DefaultTableModel tb = new DefaultTableModel();
                tb.addColumn("Mã Nhà Xuất Bản");
                tb.addColumn("Tên Nhà Xuất Bản");
                tb.addColumn("Địa Chỉ");
                tb.addColumn("Số Điện Thoại");
                tb.addColumn("ghi Chú");
                for (nxb_md a : listkhoa) {
                    tb.addRow(new Object[]{
                        a.getManxb(), a.getTennxb(), a.getDiachi(), a.getSdt(), a.getGhichu()
                    });
                }
                tbnxb.setModel(tb);
            }
            if (dkien.equals("TenNhaXuatBan")) {
                List<nxb_md> listkhoa = nxb_ctl.timkiemtennxb(tennxb);
                DefaultTableModel tb = new DefaultTableModel();
                tb.addColumn("Mã Nhà Xuất Bản");
                tb.addColumn("Tên Nhà Xuất Bản");
                tb.addColumn("Địa Chỉ");
                tb.addColumn("Số Điện Thoại");
                tb.addColumn("ghi Chú");
                for (nxb_md a : listkhoa) {
                    tb.addRow(new Object[]{
                        a.getManxb(), a.getTennxb(), a.getDiachi(), a.getSdt(), a.getGhichu()
                    });
                }
                tbnxb.setModel(tb);
            }
            if (dkien.equals("MaNhaXuatBan")) {
                List<nxb_md> listkhoa = nxb_ctl.timkiemmanxb(manxb);
                DefaultTableModel tb = new DefaultTableModel();
                tb.addColumn("Mã Nhà Xuất Bản");
                tb.addColumn("Tên Nhà Xuất Bản");
                tb.addColumn("Địa Chỉ");
                tb.addColumn("Số Điện Thoại");
                tb.addColumn("ghi Chú");
                for (nxb_md a : listkhoa) {
                    tb.addRow(new Object[]{
                        a.getManxb(), a.getTennxb(), a.getDiachi(), a.getSdt(), a.getGhichu()
                    });
                }
                tbnxb.setModel(tb);
            }
            if (dkien.equals("DiaChi")) {
                List<nxb_md> listkhoa = nxb_ctl.timkiemdiachi(diachi);
                DefaultTableModel tb = new DefaultTableModel();
                tb.addColumn("Mã Nhà Xuất Bản");
                tb.addColumn("Tên Nhà Xuất Bản");
                tb.addColumn("Địa Chỉ");
                tb.addColumn("Số Điện Thoại");
                tb.addColumn("ghi Chú");
                for (nxb_md a : listkhoa) {
                    tb.addRow(new Object[]{
                        a.getManxb(), a.getTennxb(), a.getDiachi(), a.getSdt(), a.getGhichu()
                    });
                }
                tbnxb.setModel(tb);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButton23ActionPerformed

    private void tbnxbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbnxbMouseClicked
        nxb_ctl.click(tbnxb, mnxb, tnxb, dc, sdt, gc);
    }//GEN-LAST:event_tbnxbMouseClicked

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        Tracuusinhvien a = new Tracuusinhvien();
        a.show();
        this.hide();
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        Login1 a = new Login1();
        a.show();
        this.hide();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        Ravao a = new Ravao();
        a.show();
        this.hide();
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        Trangchu a = new Trangchu();
        a.show();
        this.hide();
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        Chitietphieumuon a = new Chitietphieumuon();
        a.show();
        this.hide();
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        Phieumuonquahan a = new Phieumuonquahan();
        a.show();
        this.hide();
    }//GEN-LAST:event_jMenuItem10ActionPerformed

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
            java.util.logging.Logger.getLogger(Nxb.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Nxb.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Nxb.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Nxb.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Nxb().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cbtk;
    private javax.swing.JTextField dc;
    private javax.swing.JTextField gc;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar4;
    private javax.swing.JTextField mnxb;
    private javax.swing.JTextField sdt;
    private javax.swing.JTable tbnxb;
    private javax.swing.JTextField tk;
    private javax.swing.JTextField tnxb;
    // End of variables declaration//GEN-END:variables
}
