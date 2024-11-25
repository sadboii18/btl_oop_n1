/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.io.File;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Tacgia extends javax.swing.JFrame {

    public Tacgia() {
        initComponents();
        loadtacgia();
    }

    public void loadtacgia() {

 String dbURL = "jdbc:sqlserver://127.0.0.1;databaseName=thuvien;user=sa;password=12345;encrypt=true;trustServerCertificate=true";
        Connection conn;
        try {
            conn = DriverManager.getConnection(dbURL);

            Statement st = conn.createStatement();
            DefaultTableModel tableModel = new DefaultTableModel();
            tableModel.addColumn("Mã Tác Giả");
            tableModel.addColumn("Tên Tác Giả");
            tableModel.addColumn("Giới Tính");
            tableModel.addColumn("Năm Sinh");
            tableModel.addColumn("Năm Mất");
            tableModel.addColumn("Quê Quán");
            tableModel.addColumn("Ghi Chú");

            String sql = "Select * from tacgia1 ";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Vector vt = new Vector();
                vt.add(rs.getString("matacgia"));
                vt.add(rs.getString("tentacgia"));
                vt.add(rs.getString("gioitinh"));
                vt.add(rs.getString("namsinh"));
                vt.add(rs.getString("nammat"));
                vt.add(rs.getString("quequan"));
                vt.add(rs.getString("ghichu"));

                //Đưa dữ liệu vào TableModel
                tableModel.addRow(vt);
            }
            tb1.setModel(tableModel);

        } catch (SQLException ex) {

        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        cbtk = new javax.swing.JComboBox();
        tk = new javax.swing.JTextField();
        jToolBar4 = new javax.swing.JToolBar();
        jButton23 = new javax.swing.JButton();
        jButton24 = new javax.swing.JButton();
        jButton25 = new javax.swing.JButton();
        jButton26 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        mtg = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        ttg = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        nam = new javax.swing.JRadioButton();
        nu = new javax.swing.JRadioButton();
        gc = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        nm = new javax.swing.JTextField();
        ns = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        qq = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb1 = new javax.swing.JTable();
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

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cbtk.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tất Cả", "MaTacGia", "TenTacGia", "QueQuan", "NamMat", "NamSinh" }));
        getContentPane().add(cbtk, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 200, 170, 32));
        getContentPane().add(tk, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 200, 140, 32));

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

        getContentPane().add(jToolBar4, new org.netbeans.lib.awtextra.AbsoluteConstraints(693, 192, 370, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Mã Tác Giả");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 250, -1, -1));
        getContentPane().add(mtg, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 250, 198, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Tên Tác Giả");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 280, -1, -1));
        getContentPane().add(ttg, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 280, 198, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Giới Tính");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 310, -1, -1));

        buttonGroup1.add(nam);
        nam.setText("Nam");
        getContentPane().add(nam, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 310, -1, -1));

        buttonGroup1.add(nu);
        nu.setText("Nữ");
        getContentPane().add(nu, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 310, -1, -1));
        getContentPane().add(gc, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 340, 210, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Ghi Chú");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 340, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Năm Mất");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 310, -1, -1));
        getContentPane().add(nm, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 310, 210, -1));
        getContentPane().add(ns, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 270, 210, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Năm Sinh");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 270, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Quê Quán");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 340, -1, -1));
        getContentPane().add(qq, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 340, 198, 20));

        tb1.setModel(new javax.swing.table.DefaultTableModel(
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
        tb1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tb1);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 380, 930, 200));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/anh/tcagias.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, 1100, 610));

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
        try {

String dbURL = "jdbc:sqlserver://127.0.0.1;databaseName=thuvien;user=sa;password=12345;encrypt=true;trustServerCertificate=true";
            Connection conn = DriverManager.getConnection(dbURL);
            Statement st = conn.createStatement();
             String matg = mtg.getText().trim();
            String tentg = ttg.getText().trim();
            String Gioitinh;
            if (nam.isSelected()) {
                Gioitinh = "Nam";
            } else if (nu.isSelected()) {
                Gioitinh = "Nữ";
            } else {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn giới tính", "Thông báo", JOptionPane.ERROR_MESSAGE);
                return;
            }
            String nams = ns.getText().trim();
            String namm = nm.getText().trim();
            String queq = qq.getText().trim();
            String ghic = gc.getText().trim();

            // Kiểm tra mã tác giả không được để trống
            if (matg.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập mã tác giả", "Thông báo", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Kiểm tra tên tác giả không được để trống
            if (tentg.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập tên tác giả", "Thông báo", JOptionPane.ERROR_MESSAGE);
                return;
            }
            String sql = "update tacgia1 set tentacgia=N'" + ttg.getText() + "',gioitinh=N'" + Gioitinh + "',namsinh= N'" + ns.getText() + "',nammat=N'" + nm.getText() + "',quequan=N'" + qq.getText() + "',ghichu=N'" + gc.getText() + "' where matacgia='" + mtg.getText() + "'";
// TODO add your handling code here:
            int a = st.executeUpdate(sql);
            loadtacgia();
            JOptionPane.showMessageDialog(this, "Sửa dữ liệu thành công");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Lỗi khi sửa dữ liệu", "Thông báo", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jButton24ActionPerformed

    private void jButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton25ActionPerformed
        try {

String dbURL = "jdbc:sqlserver://127.0.0.1;databaseName=thuvien;user=sa;password=12345;encrypt=true;trustServerCertificate=true";
            Connection conn = DriverManager.getConnection(dbURL);
            Statement st = conn.createStatement();
            String matg = mtg.getText().trim();
            String tentg = ttg.getText().trim();
            String Gioitinh;
            if (nam.isSelected()) {
                Gioitinh = "Nam";
            } else if (nu.isSelected()) {
                Gioitinh = "Nữ";
            } else {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn giới tính", "Thông báo", JOptionPane.ERROR_MESSAGE);
                return;
            }
            String nams = ns.getText().trim();
            String namm = nm.getText().trim();
            String queq = qq.getText().trim();
            String ghic = gc.getText().trim();

            // Kiểm tra mã tác giả không được để trống
            if (matg.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập mã tác giả", "Thông báo", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Kiểm tra tên tác giả không được để trống
            if (tentg.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập tên tác giả", "Thông báo", JOptionPane.ERROR_MESSAGE);
                return;
            }
            String sql = "insert into tacgia1 values('" + mtg.getText() + "',N'" + ttg.getText() + "',N'" + Gioitinh + "', N'" + ns.getText() + "', N'" + nm.getText() + "',N'" + qq.getText() + "',N'" + gc.getText() + "')";
// TODO add your handling code here:
            int a = st.executeUpdate(sql);
            loadtacgia();
            JOptionPane.showMessageDialog(this, "Thêm dữ liệu thành công");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Lỗi khi thêm dữ liệu", "Thông báo", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jButton25ActionPerformed

    private void jButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton26ActionPerformed
        try {

String dbURL = "jdbc:sqlserver://127.0.0.1;databaseName=thuvien;user=sa;password=12345;encrypt=true;trustServerCertificate=true";
            Connection conn = DriverManager.getConnection(dbURL);
            Statement st = conn.createStatement();

            String sql = "delete from tacgia1 where matacgia='" + mtg.getText() + "'";
// TODO add your handling code here:
            int a = st.executeUpdate(sql);
            loadtacgia();
            JOptionPane.showMessageDialog(this, "xóa dữ liệu thành công");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Lỗi khixóa dữ liệu", "Thông báo", JOptionPane.ERROR_MESSAGE);
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

String dbURL = "jdbc:sqlserver://127.0.0.1;databaseName=thuvien;user=sa;password=12345;encrypt=true;trustServerCertificate=true";
        Connection conn;
        try {
            conn = DriverManager.getConnection(dbURL);

            Statement st = conn.createStatement();
            DefaultTableModel tableModel = new DefaultTableModel();
            tableModel.addColumn("Mã Tác Giả");
            tableModel.addColumn("Tên Tác Giả");
            tableModel.addColumn("Giới Tính");
            tableModel.addColumn("Năm Sinh");
            tableModel.addColumn("Năm Mất");
            tableModel.addColumn("Quê Quán");
            tableModel.addColumn("Ghi Chú");

            String dkien = cbtk.getSelectedItem().toString();
            String mtg1 = tk.getText();
            String ttg1 = tk.getText();
            String nams = tk.getText();
            String namm = tk.getText();
            String queq = tk.getText();
            if (dkien.equals("Tất Cả")) {
                String sql = "Select * from tacgia1 ";
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    Vector vt = new Vector();
                    vt.add(rs.getString("matacgia"));
                    vt.add(rs.getString("tentacgia"));
                    vt.add(rs.getString("gioitinh"));
                    vt.add(rs.getString("namsinh"));
                    vt.add(rs.getString("nammat"));
                    vt.add(rs.getString("quequan"));
                    vt.add(rs.getString("ghichu"));

                    //Đưa dữ liệu vào TableModel
                    tableModel.addRow(vt);
                }
                tb1.setModel(tableModel);

            }
            if (dkien.equals("MaTacGia")) {
                String sql = "Select * from tacgia1 where matacgia='" + mtg1 + "' ";
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    Vector vt = new Vector();
                    vt.add(rs.getString("matacgia"));
                    vt.add(rs.getString("tentacgia"));
                    vt.add(rs.getString("gioitinh"));
                    vt.add(rs.getString("namsinh"));
                    vt.add(rs.getString("nammat"));
                    vt.add(rs.getString("quequan"));
                    vt.add(rs.getString("ghichu"));

                    //Đưa dữ liệu vào TableModel
                    tableModel.addRow(vt);
                }
                tb1.setModel(tableModel);

            }
            if (dkien.equals("TenTacGia")) {
                String sql = "Select * from tacgia1 where tentacgia like N'" + ttg1 + "' ";
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    Vector vt = new Vector();
                    vt.add(rs.getString("matacgia"));
                    vt.add(rs.getString("tentacgia"));
                    vt.add(rs.getString("gioitinh"));
                    vt.add(rs.getString("namsinh"));
                    vt.add(rs.getString("nammat"));
                    vt.add(rs.getString("quequan"));
                    vt.add(rs.getString("ghichu"));

                    //Đưa dữ liệu vào TableModel
                    tableModel.addRow(vt);
                }
                tb1.setModel(tableModel);

            }
            if (dkien.equals("NamSinh")) {
                String sql = "Select * from tacgia1 where namsinh='" + nams + "' ";
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    Vector vt = new Vector();
                    vt.add(rs.getString("matacgia"));
                    vt.add(rs.getString("tentacgia"));
                    vt.add(rs.getString("gioitinh"));
                    vt.add(rs.getString("namsinh"));
                    vt.add(rs.getString("nammat"));
                    vt.add(rs.getString("quequan"));
                    vt.add(rs.getString("ghichu"));

                    //Đưa dữ liệu vào TableModel
                    tableModel.addRow(vt);
                }
                tb1.setModel(tableModel);

            }
            if (dkien.equals("NamMat")) {
                String sql = "Select * from tacgia1 where nammat='" + namm + "' ";
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    Vector vt = new Vector();
                    vt.add(rs.getString("matacgia"));
                    vt.add(rs.getString("tentacgia"));
                    vt.add(rs.getString("gioitinh"));
                    vt.add(rs.getString("namsinh"));
                    vt.add(rs.getString("nammat"));
                    vt.add(rs.getString("quequan"));
                    vt.add(rs.getString("ghichu"));

                    //Đưa dữ liệu vào TableModel
                    tableModel.addRow(vt);
                }
                tb1.setModel(tableModel);

            }
            if (dkien.equals("QueQuan")) {
                String sql = "Select * from tacgia1 where quequan like N'" + queq + "' ";
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    Vector vt = new Vector();
                    vt.add(rs.getString("matacgia"));
                    vt.add(rs.getString("tentacgia"));
                    vt.add(rs.getString("gioitinh"));
                    vt.add(rs.getString("namsinh"));
                    vt.add(rs.getString("nammat"));
                    vt.add(rs.getString("quequan"));
                    vt.add(rs.getString("ghichu"));

                    //Đưa dữ liệu vào TableModel
                    tableModel.addRow(vt);
                }
                tb1.setModel(tableModel);

            }
        } catch (SQLException ex) {

        }
    }//GEN-LAST:event_jButton23ActionPerformed

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

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        Trangchu a = new Trangchu();
        a.show();
        this.hide();
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        Ravao a = new Ravao();
        a.show();
        this.hide();
    }//GEN-LAST:event_jMenuItem5ActionPerformed

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

    private void tb1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb1MouseClicked
        int row = tb1.getSelectedRow();
        mtg.setText(tb1.getValueAt(row, 0).toString());
        ttg.setText(tb1.getValueAt(row, 1).toString());
        String gt = tb1.getValueAt(row, 2).toString();
        if (gt.equals("Nam")) {
            nam.setSelected(true);
        } else {
            nu.setSelected(true);
        }
        ns.setText(tb1.getValueAt(row, 3).toString());

        nm.setText(tb1.getValueAt(row, 4).toString());

        qq.setText(tb1.getValueAt(row, 5).toString());
        gc.setText(tb1.getValueAt(row, 6).toString());

    }//GEN-LAST:event_tb1MouseClicked

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
            java.util.logging.Logger.getLogger(Tacgia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tacgia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tacgia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tacgia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tacgia().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox cbtk;
    private javax.swing.JTextField gc;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToolBar jToolBar4;
    private javax.swing.JTextField mtg;
    private javax.swing.JRadioButton nam;
    private javax.swing.JTextField nm;
    private javax.swing.JTextField ns;
    private javax.swing.JRadioButton nu;
    private javax.swing.JTextField qq;
    private javax.swing.JTable tb1;
    private javax.swing.JTextField tk;
    private javax.swing.JTextField ttg;
    // End of variables declaration//GEN-END:variables
}
