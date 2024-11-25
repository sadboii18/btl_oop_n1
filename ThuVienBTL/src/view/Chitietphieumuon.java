/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import ctl.Phieumuon_ctl;
import ctl.Sv_ctl;
import ctl.Sach_ctl;
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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Chitietphieumuon extends javax.swing.JFrame {

    private Phieumuon_ctl phieumuon_ctl;

    public Chitietphieumuon() {
        initComponents();

        phieumuon_ctl = new Phieumuon_ctl();

        loadphieumuon();
        ts();
        ttc();
    }

    public void ts() {
        int tx = getTongSachChuaTra();

        // Đặt văn bản cho JLabel
        tongsachchuatra.setText(tx + "");

    }

    public void ttc() {
        float ttc = getTongTienCocSachChuaTra();

        // Đặt văn bản cho JLabel
        tongtiencocchuatra.setText(ttc + "");

    }

//    public void tongsachctPM() {
//        int tx = getTongSachChuaTraTheoMaPM();
//
//        // Đặt văn bản cho JLabel
//        tongsachchuatra.setText(tx + "");
//
//    }
//
//    public void tongtiencocctPM() {
//        float ttc = getTongTienSachChuaTraTheoMaPM();
//
//        // Đặt văn bản cho JLabel
//        tongtiencocchuatra.setText(ttc + "");
//
//    }

    private void loadphieumuon() {
        try {

            List<phieumuon_md> listlop = phieumuon_ctl.loadphieumuon();
            DefaultTableModel tb = new DefaultTableModel();
            tb.addColumn("Mã Phiếu Mượn");
            tb.addColumn("Mã Sinh Viên");
            tb.addColumn("Tên Sinh Viên");
            tb.addColumn("Mã Sách");
            tb.addColumn("Tên Sách");
            tb.addColumn("Ngày Mượn");
            tb.addColumn("Ngày Trả");
            tb.addColumn("Số Lượng Mượn");
            tb.addColumn("Giá Thành 1 cuốn");
            tb.addColumn("Trạng Thái");
            tb.addColumn("Ghi Chú");
            tb.addColumn("Tiền Cọc");

            for (phieumuon_md hd : listlop) {
                sv_md a = hd.getSv();
                sach_md b = hd.getSach();

                tb.addRow(new Object[]{
                    hd.getMaphieumuon(),
                    hd.getMasv(),
                    (a != null) ? a.getTensv() : "",
                    hd.getMasach(),
                    (b != null) ? b.getTensach() : "",
                    hd.getNgaymuon(), hd.getNgaytra(), hd.getSoluong(),
                    (b != null) ? b.getGiatien() : "",
                    hd.getTrangthai(), hd.getGhichu(),
                    (b != null) ? hd.getSoluong() * b.getGiatien() * 1.5 : 0.0

                });
            }
            tbpm.setModel(tb);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public float getTongTienCocSachChuaTra() {
        float tx = 0;
        try {

              String dbURL = "jdbc:sqlserver://127.0.0.1;databaseName=thuvien; user=sa;password=12345;encrypt=true;trustServerCertificate=true";
            Connection conn;
            conn = DriverManager.getConnection(dbURL);
            Statement st = conn.createStatement();

            String sql = "SELECT SUM(phieumuon.soluong * sach.giatien) AS tx FROM phieumuon "
                    + "INNER JOIN sv ON sv.masv = phieumuon.masv "
                    + "INNER JOIN sach ON phieumuon.masach = sach.masach "
                    + "WHERE phieumuon.trangthai like N'CHƯA TRẢ'";
            ResultSet rs = st.executeQuery(sql);

            // Lấy giá trị kết quả
            if (rs.next()) {
                tx = rs.getFloat("tx");
            }

        } catch (SQLException e) {
            e.printStackTrace();

        }

        return tx;
    }

    public int getTongSachChuaTra() {
        int tx = 0;
        try {

            String dbURL = "jdbc:sqlserver://127.0.0.1;databaseName=thuvien; user=sa;password=12345;encrypt=true;trustServerCertificate=true";
            Connection conn;
            conn = DriverManager.getConnection(dbURL);
            Statement st = conn.createStatement();

            String sql = "SELECT SUM(phieumuon.soluong) AS tx FROM phieumuon "
                    + "INNER JOIN sv ON sv.masv = phieumuon.masv "
                    + "INNER JOIN sach ON phieumuon.masach = sach.masach "
                    + "WHERE phieumuon.trangthai like N'CHƯA TRẢ'";
            ResultSet rs = st.executeQuery(sql);

            // Lấy giá trị kết quả
            if (rs.next()) {
                tx = rs.getInt("tx");
            }

        } catch (SQLException e) {
            e.printStackTrace();

        }

    
        return tx;
    }

    private void getTongTienSachChuaTraTheoMaPM() {
        float tx = 0;
        try {
 String dkien = cbtk.getSelectedItem().toString();
            String mapm = tk.getText();

            String dbURL = "jdbc:sqlserver://127.0.0.1;databaseName=thuvien; user=sa;password=12345;encrypt=true;trustServerCertificate=true";
            Connection conn;
            conn = DriverManager.getConnection(dbURL);
            Statement st = conn.createStatement();

            String sql = "SELECT SUM(phieumuon.soluong * sach.giatien * 1.5) AS ttx FROM phieumuon "
                    + "INNER JOIN sv ON sv.masv = phieumuon.masv "
                    + "INNER JOIN sach ON phieumuon.masach = sach.masach "
                    + "WHERE phieumuon.trangthai like N'CHƯA TRẢ'  and phieumuon.maphieumuon='"+mapm+"' group by phieumuon.maphieumuon";
            ResultSet rs = st.executeQuery(sql);

            // Lấy giá trị kết quả
            if (rs.next()) {
                tx = rs.getFloat("ttx");
            }

        } catch (SQLException e) {
            e.printStackTrace();

        }

       tongtiencocchuatra.setText(tx + "");
    }

    private void getTongSachChuaTraTheoMaPM() {
        int tx = 0;
        try {
 String dkien = cbtk.getSelectedItem().toString();
            String mapm = tk.getText();

         String dbURL = "jdbc:sqlserver://127.0.0.1;databaseName=thuvien; user=sa;password=12345;encrypt=true;trustServerCertificate=true";
            Connection conn;
            conn = DriverManager.getConnection(dbURL);
            Statement st = conn.createStatement();

            String sql = "SELECT SUM(phieumuon.soluong) AS ttx  FROM phieumuon "
                    + "INNER JOIN sv ON sv.masv = phieumuon.masv "
                    + "INNER JOIN sach ON phieumuon.masach = sach.masach "
                    + "WHERE phieumuon.trangthai like N'CHƯA TRẢ' and phieumuon.maphieumuon='"+mapm+"' group by phieumuon.maphieumuon";
            ResultSet rs = st.executeQuery(sql);

            // Lấy giá trị kết quả
            if (rs.next()) {
                tx = rs.getInt("ttx");
            }

        } catch (SQLException e) {
            e.printStackTrace();

        }

        tongsachchuatra.setText(tx + "");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cbtk = new javax.swing.JComboBox();
        tk = new javax.swing.JTextField();
        jToolBar4 = new javax.swing.JToolBar();
        jButton23 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbpm = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        tongsachchuatra = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        tongtiencocchuatra = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cbtk.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tất Cả", "MaPhieuMuon" }));
        getContentPane().add(cbtk, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 280, 164, 32));
        getContentPane().add(tk, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 280, 143, 32));

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

        getContentPane().add(jToolBar4, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 270, -1, 50));

        tbpm.setModel(new javax.swing.table.DefaultTableModel(
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
        tbpm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbpmMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbpm);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 370, 1050, 310));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Số sách Chưa Trả :");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 280, -1, -1));

        tongsachchuatra.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tongsachchuatra.setForeground(new java.awt.Color(255, 0, 0));
        tongsachchuatra.setText("0");
        getContentPane().add(tongsachchuatra, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 280, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Tiền Đang Cọc :");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 310, -1, -1));

        tongtiencocchuatra.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tongtiencocchuatra.setForeground(new java.awt.Color(255, 0, 51));
        tongtiencocchuatra.setText("0.0");
        getContentPane().add(tongtiencocchuatra, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 310, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("quyển");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 280, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("VNĐ");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 340, -1, -1));

        jLabel2.setBackground(new java.awt.Color(204, 204, 204));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/anh/ctpm.jpg"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-30, -40, 1190, 800));

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

        jMenuItem6.setText("Chi Tiết Phiếu Mượn");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem6);

        jMenuItem10.setText("Quản Lí Sách Quá Hạn Mượn");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem10);

        jMenuItem9.setText("Thống Kê");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem9);

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

    private void tbpmMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbpmMouseClicked

    }//GEN-LAST:event_tbpmMouseClicked

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
        try {
            String dkien = cbtk.getSelectedItem().toString();
            String mapm = tk.getText();

            if (dkien.equals("Tất Cả")) {
                List<phieumuon_md> listlop = phieumuon_ctl.loadphieumuon();

                DefaultTableModel tb = new DefaultTableModel();
                tb.addColumn("Mã Phiếu Mượn");
                tb.addColumn("Mã Sinh Viên");
                tb.addColumn("Tên Sinh Viên");
                tb.addColumn("Mã Sách");
                tb.addColumn("Tên Sách");
                tb.addColumn("Ngày Mượn");
                tb.addColumn("Ngày Trả");
                tb.addColumn("Số Lượng Mượn");
                tb.addColumn("Giá Thành 1 cuốn");
                tb.addColumn("Trạng Thái");
                tb.addColumn("Ghi Chú");
                tb.addColumn("Tiền Cọc");
                for (phieumuon_md hd : listlop) {
                    sv_md a = hd.getSv();
                    sach_md b = hd.getSach();

                    tb.addRow(new Object[]{
                        hd.getMaphieumuon(),
                        hd.getMasv(),
                        (a != null) ? a.getTensv() : "",
                        hd.getMasach(),
                        (b != null) ? b.getTensach() : "",
                        hd.getNgaymuon(), hd.getNgaytra(), hd.getSoluong(),
                        (b != null) ? b.getGiatien() : "",
                        hd.getTrangthai(), hd.getGhichu(),
                        (b != null) ? hd.getSoluong() * b.getGiatien() * 1.5 : 0.0

                    });
                }
                tbpm.setModel(tb);
              ttc();
              ts();
                
            }

            if (dkien.equals("MaPhieuMuon")) {
                List<phieumuon_md> listlop = phieumuon_ctl.timkiemmaphieumuon(mapm);

                DefaultTableModel tb = new DefaultTableModel();
                tb.addColumn("Mã Phiếu Mượn");
                tb.addColumn("Mã Sinh Viên");
                tb.addColumn("Tên Sinh Viên");
                tb.addColumn("Mã Sách");
                tb.addColumn("Tên Sách");
                tb.addColumn("Ngày Mượn");
                tb.addColumn("Ngày Trả");
                tb.addColumn("Số Lượng Mượn");
                tb.addColumn("Giá Thành 1 cuốn");
                tb.addColumn("Trạng Thái");
                tb.addColumn("Ghi Chú");
                tb.addColumn("Tiền Cọc");
                for (phieumuon_md hd : listlop) {
                    sv_md a = hd.getSv();
                    sach_md b = hd.getSach();

                    tb.addRow(new Object[]{
                        hd.getMaphieumuon(),
                        hd.getMasv(),
                        (a != null) ? a.getTensv() : "",
                        hd.getMasach(),
                        (b != null) ? b.getTensach() : "",
                        hd.getNgaymuon(), hd.getNgaytra(), hd.getSoluong(),
                        (b != null) ? b.getGiatien() : "",
                        hd.getTrangthai(), hd.getGhichu(),
                        (b != null) ? hd.getSoluong() * b.getGiatien() * 1.5 : 0.0

                    });
                }
                tbpm.setModel(tb);
               getTongSachChuaTraTheoMaPM();
               getTongTienSachChuaTraTheoMaPM();
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButton23ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        DefaultTableModel tableModel = (DefaultTableModel) tbpm.getModel();
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
        try (FileOutputStream fos = new FileOutputStream("FileExcelXuat/phieumuonsach.xlsx")) {
            workbook.write(fos);
            System.out.println("Xuất dữ liệu thành công!");
            JOptionPane.showMessageDialog(this, "Xuất Dữ Liệu Thành Công");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        Login1 a = new Login1();
        a.show();
        this.hide();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        Theloai a = new Theloai();
        a.show();
        this.hide();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        Tacgia a = new Tacgia();
        a.show();
        this.hide();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

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
        Sachhientaithuvien a = new Sachhientaithuvien();
        a.show();
        this.hide();
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        Tracuusinhvien a = new Tracuusinhvien();
        a.show();
        this.hide();
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
          Chitietphieumuon a=new Chitietphieumuon();
       a.show();
       this.hide();
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
         Phieumuonquahan a=new Phieumuonquahan();
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
            java.util.logging.Logger.getLogger(Chitietphieumuon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Chitietphieumuon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Chitietphieumuon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Chitietphieumuon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Chitietphieumuon().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cbtk;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
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
    private javax.swing.JTable tbpm;
    private javax.swing.JTextField tk;
    private javax.swing.JLabel tongsachchuatra;
    private javax.swing.JLabel tongtiencocchuatra;
    // End of variables declaration//GEN-END:variables
}
