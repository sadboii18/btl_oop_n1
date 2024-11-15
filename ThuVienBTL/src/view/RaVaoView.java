/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import model.SinhVien;
import model.Lop;
import controller.RaVaoController;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.toedter.calendar.JDateChooser;
public class RaVaoView extends javax.swing.JFrame {

    private RaVaoController ravao_ctl;

    public RaVaoView() {
        initComponents();
        ravao_ctl = new RaVaoController();
        loadravao();
          Date currentDate = new Date();
          SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        // Hiển thị ngày tháng lên JTextField
        n.setDate(currentDate); 
        n.getDateEditor().setEnabled(false);
    }

    private void loadravao() {
        try {
            List<model.RaVao> listkhoa = ravao_ctl.loadravao();
            DefaultTableModel tb = new DefaultTableModel();

            tb.addColumn("Mã ");
            tb.addColumn("Ngày");
            tb.addColumn("Thời Gian Vào(giờ:phút)");
            tb.addColumn("Thời Gian Ra (giờ:phút)");
            tb.addColumn("Mã SV");
            tb.addColumn("Tên Sv");

            tb.addColumn("Tên Lớp");
            tb.addColumn("Nội Dung");
            tb.addColumn("Ghi Chú");

            for (model.RaVao hd : listkhoa) {
                SinhVien a = hd.getSv();
                Lop b = hd.getLop();

                tb.addRow(new Object[]{
                    hd.getMa(), hd.getNgay(), hd.getTgvao(), hd.getTgra(),
                    hd.getMasv(),
                    (a != null) ? a.getTensv() : "",
//                    hd.getMalop(),
                    (b != null) ? b.getTenlop() : "",
                    hd.getNoidung(),
                    hd.getGhichu()
                });
            }
            tbrv.setModel(tb);
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
        jButton1 = new javax.swing.JButton();
        jButton26 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        m = new javax.swing.JTextField();
        n = new com.toedter.calendar.JDateChooser();
        v = new javax.swing.JComboBox();
        r = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        gc = new javax.swing.JTextField();
        nd = new javax.swing.JTextField();
        msv = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbrv = new javax.swing.JTable();
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

        cbtk.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tất Cả", "Ma", "Ngay", "MaLop", "MaSv" }));
        getContentPane().add(cbtk, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 190, 119, 32));
        getContentPane().add(tk, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 190, 190, 32));

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

        jButton1.setBackground(new java.awt.Color(255, 255, 102));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-microsoft-excel-2019-25.png"))); // NOI18N
        jButton1.setText("Xuất Excel");
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar4.add(jButton1);

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

        getContentPane().add(jToolBar4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 170, -1, -1));
        getContentPane().add(m, new org.netbeans.lib.awtextra.AbsoluteConstraints(307, 260, 360, -1));

        n.setDateFormatString("yyyy-MM-dd");
        getContentPane().add(n, new org.netbeans.lib.awtextra.AbsoluteConstraints(307, 300, 360, -1));

        v.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "7h", "8h", "9h", "10h", "11h", "14h", "15h", "16h", "17h" }));
        getContentPane().add(v, new org.netbeans.lib.awtextra.AbsoluteConstraints(307, 340, 360, -1));

        r.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "8h", "9h", "10h", "11h", "15h", "16h", "17h" }));
        getContentPane().add(r, new org.netbeans.lib.awtextra.AbsoluteConstraints(307, 380, 360, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("T/g Ra");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 380, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("T/g Vào");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 340, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Ngày");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 300, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Mã");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 260, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Mã SV");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 260, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Nội Dung");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 300, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Ghi Chú");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 340, -1, -1));
        getContentPane().add(gc, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 340, 350, -1));

        nd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ndActionPerformed(evt);
            }
        });
        getContentPane().add(nd, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 300, 350, -1));
        getContentPane().add(msv, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 260, 350, -1));

        tbrv.setModel(new javax.swing.table.DefaultTableModel(
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
        tbrv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbrvMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbrv);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(73, 432, 1370, 220));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/anh/rava.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1500, 800));

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

        jMenuItem10.setText("Quản Lí sách Quá Hạn Mượn");
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

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        TheLoaiView a = new TheLoaiView();
        a.show();
        this.hide();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        TacGiaView a = new TacGiaView();
        a.show();
        this.hide();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        NhaXuatBanView a = new NhaXuatBanView();
        a.show();
        this.hide();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        SachView a = new SachView();
        a.show();
        this.hide();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        SachHienTaiThuVien a = new SachHienTaiThuVien();
        a.show();
        this.hide();
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        TraCuuSinhVienView a = new TraCuuSinhVienView();
        a.show();
        this.hide();
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
        try {
            String dkien = cbtk.getSelectedItem().toString();
            String ma = tk.getText();
            String ngay = tk.getText();
            String masv = tk.getText();
            String malop = tk.getText();

            if (dkien.equals("Tất Cả")) {
                List<model.RaVao> listkhoa = ravao_ctl.loadravao();
                DefaultTableModel tb = new DefaultTableModel();

                tb.addColumn("Mã ");
                tb.addColumn("Ngày");
                tb.addColumn("Thời Gian Vào(giờ:phút)");
                tb.addColumn("Thời Gian Ra (giờ:phút");
                tb.addColumn("Mã SV");
                tb.addColumn("Tên Sv");
//                tb.addColumn("Mã Lớp");
                tb.addColumn("Tên Lớp");
                tb.addColumn("Nội Dung");
                tb.addColumn("Ghi Chú");

                for (model.RaVao hd : listkhoa) {
                    SinhVien a = hd.getSv();
                    Lop b = hd.getLop();

                    tb.addRow(new Object[]{
                        hd.getMa(), hd.getNgay(), hd.getTgvao(), hd.getTgra(),
                        hd.getMasv(),
                        (a != null) ? a.getTensv() : "",
                       
                        (b != null) ? b.getTenlop() : "",
                        hd.getNoidung(),
                        hd.getGhichu()
                    });
                }
                tbrv.setModel(tb);
            }
            if (dkien.equals("Ngay")) {
                List<model.RaVao> listkhoa = ravao_ctl.timkiemngay(ngay);
                DefaultTableModel tb = new DefaultTableModel();

                tb.addColumn("Mã ");
                tb.addColumn("Ngày");
                tb.addColumn("Thời Gian Vào(giờ:phút)");
                tb.addColumn("Thời Gian Ra (giờ:phút");
                tb.addColumn("Mã SV");
                tb.addColumn("Tên Sv");
//                tb.addColumn("Mã Lớp");
                tb.addColumn("Tên Lớp");
                tb.addColumn("Nội Dung");
                tb.addColumn("Ghi Chú");

                for (model.RaVao hd : listkhoa) {
                    SinhVien a = hd.getSv();
                    Lop b = hd.getLop();

                    tb.addRow(new Object[]{
                        hd.getMa(), hd.getNgay(), hd.getTgvao(), hd.getTgra(),
                        hd.getMasv(),
                        (a != null) ? a.getTensv() : "",
                       
                        (b != null) ? b.getTenlop() : "",
                        hd.getNoidung(),
                        hd.getGhichu()
                    });
                }
                tbrv.setModel(tb);
            }
            if (dkien.equals("Ma")) {
                List<model.RaVao> listkhoa = ravao_ctl.timkiemma(ma);
                DefaultTableModel tb = new DefaultTableModel();

                tb.addColumn("Mã ");
                tb.addColumn("Ngày");
                tb.addColumn("Thời Gian Vào(giờ:phút)");
                tb.addColumn("Thời Gian Ra (giờ:phút");
                tb.addColumn("Mã SV");
                tb.addColumn("Tên Sv");
//                tb.addColumn("Mã Lớp");
                tb.addColumn("Tên Lớp");
                tb.addColumn("Nội Dung");
                tb.addColumn("Ghi Chú");

                for (model.RaVao hd : listkhoa) {
                    SinhVien a = hd.getSv();
                    Lop b = hd.getLop();

                    tb.addRow(new Object[]{
                        hd.getMa(), hd.getNgay(), hd.getTgvao(), hd.getTgra(),
                        hd.getMasv(),
                        (a != null) ? a.getTensv() : "",
                       
                        (b != null) ? b.getTenlop() : "",
                        hd.getNoidung(),
                        hd.getGhichu()
                    });
                }
                tbrv.setModel(tb);
            }
            if (dkien.equals("MaSv")) {
                List<model.RaVao> listkhoa = ravao_ctl.timkiemmasv(masv);
                 DefaultTableModel tb = new DefaultTableModel();

                tb.addColumn("Mã ");
                tb.addColumn("Ngày");
                tb.addColumn("Thời Gian Vào(giờ:phút)");
                tb.addColumn("Thời Gian Ra (giờ:phút");
                tb.addColumn("Mã SV");
                tb.addColumn("Tên Sv");
//                tb.addColumn("Mã Lớp");
                tb.addColumn("Tên Lớp");
                tb.addColumn("Nội Dung");
                tb.addColumn("Ghi Chú");

                for (model.RaVao hd : listkhoa) {
                    SinhVien a = hd.getSv();
                    Lop b = hd.getLop();

                    tb.addRow(new Object[]{
                        hd.getMa(), hd.getNgay(), hd.getTgvao(), hd.getTgra(),
                        hd.getMasv(),
                        (a != null) ? a.getTensv() : "",
                       
                        (b != null) ? b.getTenlop() : "",
                        hd.getNoidung(),
                        hd.getGhichu()
                    });
                }
                tbrv.setModel(tb);
            }
            if (dkien.equals("MaLop")) {
                List<model.RaVao> listkhoa = ravao_ctl.timkiemmalop(malop);
                 DefaultTableModel tb = new DefaultTableModel();

                tb.addColumn("Mã ");
                tb.addColumn("Ngày");
                tb.addColumn("Thời Gian Vào(giờ:phút)");
                tb.addColumn("Thời Gian Ra (giờ:phút");
                tb.addColumn("Mã SV");
                tb.addColumn("Tên Sv");
//                tb.addColumn("Mã Lớp");
                tb.addColumn("Tên Lớp");
                tb.addColumn("Nội Dung");
                tb.addColumn("Ghi Chú");

                for (model.RaVao hd : listkhoa) {
                    SinhVien a = hd.getSv();
                    Lop b = hd.getLop();

                    tb.addRow(new Object[]{
                        hd.getMa(), hd.getNgay(), hd.getTgvao(), hd.getTgra(),
                        hd.getMasv(),
                        (a != null) ? a.getTensv() : "",
                       
                        (b != null) ? b.getTenlop() : "",
                        hd.getNoidung(),
                        hd.getGhichu()
                    });
                }
                tbrv.setModel(tb);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButton23ActionPerformed

    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed
        String mas = m.getText();
        Date ngay = n.getDate();
        String ra = r.getSelectedItem().toString();
        String vao = v.getSelectedItem().toString();
        String masv = msv.getText();
//        String mal = ml.getText();
        String noid = nd.getText();
        String ghic = gc.getText();
if (masv.trim().isEmpty()) {
    JOptionPane.showMessageDialog(this, "Mã sinh viên không được để trống", "Thông báo", JOptionPane.ERROR_MESSAGE);
    return;
}
if (!ravao_ctl.checkmasv(masv)) {
    JOptionPane.showMessageDialog(this, "Mã sinh viên không tồn tại", "Thông báo", JOptionPane.ERROR_MESSAGE);
    return;
}
        model.RaVao hd = new model.RaVao(mas, ngay, vao, ra, masv, noid, ghic);
        if (ravao_ctl.sua(hd)) {
            loadravao();
              JOptionPane.showMessageDialog(this, "Sửa dữ liệu thành công");

        } else {
            JOptionPane.showMessageDialog(this, "Lỗi khi thêm dữ liệu", "Thông báo", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton24ActionPerformed


    private void jButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton25ActionPerformed
        String mas = m.getText();
        Date ngay = n.getDate();
        String ra = r.getSelectedItem().toString();
        String vao = v.getSelectedItem().toString();
        String masv = msv.getText();
//        String mal = ml.getText();
        String noid = nd.getText();
        String ghic = gc.getText();
// Kiểm tra mã sinh viên không được để trống
if (masv.trim().isEmpty()) {
    JOptionPane.showMessageDialog(this, "Mã sinh viên không được để trống", "Thông báo", JOptionPane.ERROR_MESSAGE);
    return;
}
if (!ravao_ctl.checkmasv(masv)) {
    JOptionPane.showMessageDialog(this, "Mã sinh viên không tồn tại", "Thông báo", JOptionPane.ERROR_MESSAGE);
    return;
}
        model.RaVao hd = new model.RaVao(mas, ngay, vao, ra, masv, noid, ghic);
        if (ravao_ctl.them(hd)) {
            loadravao();
             JOptionPane.showMessageDialog(this, "Thêm dữ liệu thành công");
        } else {
            JOptionPane.showMessageDialog(this, "Trùng Mã", "Thông báo", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton25ActionPerformed

    private void jButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton26ActionPerformed
        String mas = m.getText();
        Date ngay = n.getDate();
        String ra = r.getSelectedItem().toString();
        String vao = v.getSelectedItem().toString();
        String masv = msv.getText();
//        String mal = ml.getText();
        String noid = nd.getText();
        String ghic = gc.getText();

        model.RaVao hd = new model.RaVao(mas, ngay, vao, ra, masv, noid, ghic);
        if (ravao_ctl.xoa(hd)) {
            loadravao();
            JOptionPane.showMessageDialog(this, "xóa dữ liệu thành công");

        } else {
            JOptionPane.showMessageDialog(this, "Lỗi khi thêm dữ liệu", "Thông báo", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton26ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        LoginView a = new LoginView();
        a.show();
        this.hide();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        RaVaoView a = new RaVaoView();
        a.show();
        this.hide();
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        TrangChuView a = new TrangChuView();
        a.show();
        this.hide();
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        DefaultTableModel tableModel = (DefaultTableModel) tbrv.getModel();
        int columnCount = tableModel.getColumnCount();
        int rowCount = tableModel.getRowCount();

        // Tạo workbook mới
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Dữ liệu");

        // Tạo hàng tiêu đề
        Row headerRow = sheet.createRow(0);
        for (int col = 0; col < columnCount; col++) {
            String columnName = tableModel.getColumnName(col);
            Cell cell = headerRow.createCell(col);
            cell.setCellValue(columnName);
        }

        // Sao chép dữ liệu từ bảng vào workbook
        for (int row = 0; row < rowCount; row++) {
            Row dataRow = sheet.createRow(row + 1);
            for (int col = 0; col < columnCount; col++) {
                Object cellValue = tableModel.getValueAt(row, col);
                Cell cell = dataRow.createCell(col);
                if (cellValue != null) {
                    cell.setCellValue(cellValue.toString());
                }
            }
        }
        File directory = new File("FileExcelXuat");
        directory.mkdirs();
        // Lưu workbook vào tệp tin
        try (FileOutputStream fos = new FileOutputStream("FileExcelXuat/ravaothuvien.xlsx")) {
            workbook.write(fos);
            System.out.println("Xuất dữ liệu thành công!");
            JOptionPane.showMessageDialog(this, "Xuất Dữ Liệu Thành Công");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        ChiTietPhieuMuonView a = new ChiTietPhieuMuonView();
        a.show();
        this.hide();
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        PhieuMuonQuaHanView a = new PhieuMuonQuaHanView();
        a.show();
        this.hide();
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void ndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ndActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ndActionPerformed

    private void tbrvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbrvMouseClicked
        ravao_ctl.click(tbrv, m, n, v, r, msv, nd, gc);
    }//GEN-LAST:event_tbrvMouseClicked

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
            java.util.logging.Logger.getLogger(RaVaoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RaVaoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RaVaoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RaVaoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RaVaoView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cbtk;
    private javax.swing.JTextField gc;
    private javax.swing.JButton jButton1;
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
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
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
    private javax.swing.JTextField m;
    private javax.swing.JTextField msv;
    private com.toedter.calendar.JDateChooser n;
    private javax.swing.JTextField nd;
    private javax.swing.JComboBox r;
    private javax.swing.JTable tbrv;
    private javax.swing.JTextField tk;
    private javax.swing.JComboBox v;
    // End of variables declaration//GEN-END:variables
}
