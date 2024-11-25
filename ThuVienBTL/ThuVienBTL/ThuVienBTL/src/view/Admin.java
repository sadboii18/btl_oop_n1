package view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import com.toedter.calendar.JDateChooser;
import java.io.File;
import java.io.FileOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.toedter.calendar.JDateChooser;
      
public class Admin extends javax.swing.JFrame {

    public Admin() {
        initComponents();
        loadcombotenlop();
        loadsv();
//        Date currentDate = new Date();
//
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//
//        // Hiển thị ngày tháng lên JTextField
//        d.setDate(currentDate); 
        d.getDateEditor().setEnabled(false);
    
    }

    public void loadsv() {

        try {

            String dbURL = "jdbc:sqlserver://127.0.0.1;databaseName=thuvien; user=sa;password=12345;encrypt=true;trustServerCertificate=true";
            Connection conn;
            conn = DriverManager.getConnection(dbURL);

            Statement st = conn.createStatement();
            DefaultTableModel tableModel = new DefaultTableModel();
            tableModel.addColumn("Mã Sinh Viên");
            tableModel.addColumn("Tên sinh Viên");
            tableModel.addColumn("DD/MM/YYY");
            tableModel.addColumn("Tên Lớp");
            tableModel.addColumn("Tên Khoa");
            tableModel.addColumn("Giới Tính");
            tableModel.addColumn("Quê Quán");
            tableModel.addColumn("Khóa Học");

            String sql = "Select * from sv inner join lop on lop.malop=sv.malop inner join khoa on khoa.makhoa=lop.makhoa ";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Vector vt = new Vector();
                vt.add(rs.getString("masv"));
                vt.add(rs.getString("tensv"));
                vt.add(rs.getString("namsinh"));
                vt.add(rs.getString("tenlop"));
                vt.add(rs.getString("tenkhoa"));
                vt.add(rs.getString("gioitinh"));
                vt.add(rs.getString("quequan"));
                vt.add(rs.getString("khoahoc"));

                //Đưa dữ liệu vào TableModel
                tableModel.addRow(vt);
            }
            tbsv.setModel(tableModel);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    void loadcombotenlop() {
        try {
            String dbURL = "jdbc:sqlserver://127.0.0.1;databaseName=thuvien; user=sa;password=12345;encrypt=true;trustServerCertificate=true";
            Connection conn = DriverManager.getConnection(dbURL);
            Statement st = conn.createStatement();
            String sql = "select * from lop ";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                cbml.addItem(rs.getString("malop"));

            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        cbtk = new javax.swing.JComboBox();
        tk = new javax.swing.JTextField();
        jToolBar4 = new javax.swing.JToolBar();
        jButton23 = new javax.swing.JButton();
        jButton24 = new javax.swing.JButton();
        jButton25 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton26 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        d = new com.toedter.calendar.JDateChooser();
        ht = new javax.swing.JTextField();
        msv = new javax.swing.JTextField();
        nu = new javax.swing.JRadioButton();
        nam = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cbml = new javax.swing.JComboBox();
        kh = new javax.swing.JTextField();
        qq = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbsv = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cbtk.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tất Cả", "MaSV", "TenSV", "QueQuan", "KhoaHoc", "TenLop" }));
        getContentPane().add(cbtk, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 240, 129, 32));
        getContentPane().add(tk, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 240, 143, 32));

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

        getContentPane().add(jToolBar4, new org.netbeans.lib.awtextra.AbsoluteConstraints(679, 230, 460, 50));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Mã SV ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 290, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Họ Và Tên ");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 330, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Năm Sinh");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 370, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Giới Tính");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 400, -1, -1));

        d.setDateFormatString("yyyy-MM-dd");
        getContentPane().add(d, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 370, 253, -1));
        getContentPane().add(ht, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 330, 253, -1));
        getContentPane().add(msv, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 290, 253, -1));

        buttonGroup1.add(nu);
        nu.setText("Nữ");
        getContentPane().add(nu, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 400, -1, -1));

        buttonGroup1.add(nam);
        nam.setText("Nam");
        getContentPane().add(nam, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 400, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Quê Quán ");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 310, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Khóa Học");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 350, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Mã Lớp");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 390, -1, -1));

        getContentPane().add(cbml, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 390, 270, -1));
        getContentPane().add(kh, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 350, 270, -1));
        getContentPane().add(qq, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 310, 270, -1));

        tbsv.setModel(new javax.swing.table.DefaultTableModel(
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
        tbsv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbsvMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbsv);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 450, 1090, 170));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/anh/sinhv.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1180, 670));

        jMenu2.setText("Quản Lý Chung");

        jMenuItem5.setText("Quản Lí Thông Tin Sinh Viên");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuItem7.setText("Quản Lí Khoa");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem7);

        jMenuItem6.setText("Quản Lí Lớp");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem6);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        Lop a = new Lop();
        a.show();
        this.hide();
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        Admin a = new Admin();
        a.show();
        this.hide();
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        Khoa a = new Khoa();
        a.show();
        this.hide();
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed
        try {
         String dbURL = "jdbc:sqlserver://127.0.0.1;databaseName=thuvien; user=sa;password=12345;encrypt=true;trustServerCertificate=true";
            Connection conn = DriverManager.getConnection(dbURL);
            Statement st = conn.createStatement();
            String Gioitinh;
            if (nam.isSelected()) {
                Gioitinh = "Nam";
            } else {
                Gioitinh = "Nữ";
            }
             // Format the date to a string in the correct format
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    String dateString = dateFormat.format(d.getDate());

            String sql = "update sv set tensv=N'" + ht.getText() + "',namsinh='" + dateString + "',malop='" + cbml.getSelectedItem().toString() + "',gioitinh=N'" + Gioitinh + "',quequan=N'" + qq.getText() + "',khoahoc='" + kh.getText() + "' where masv='" + msv.getText() + "'";
// TODO add your handling code here:
            int a = st.executeUpdate(sql);
            loadsv();
             JOptionPane.showMessageDialog(this, "Sửa dữ liệu thành công");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Lỗi khi sửa dữ liệu", "Thông báo", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton24ActionPerformed

    private void jButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton25ActionPerformed
        try {
         String dbURL = "jdbc:sqlserver://127.0.0.1;databaseName=thuvien; user=sa;password=12345;encrypt=true;trustServerCertificate=true";
            Connection conn = DriverManager.getConnection(dbURL);
            Statement st = conn.createStatement();
            String Gioitinh;
            if (nam.isSelected()) {
                Gioitinh = "Nam";
            } else {
                Gioitinh = "Nữ";
            }

            // Check if msv is empty
            if (msv.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập Mã sinh viên", "Thông báo", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Check if tsv is empty
            if (ht.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập Tên sinh viên", "Thông báo", JOptionPane.ERROR_MESSAGE);
                return;
            }
   // Check if tsv is empty
            if (qq.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập quê quán", "Thông báo", JOptionPane.ERROR_MESSAGE);
                return;
            }
            // Check if date is empty
            if (d.getDate() == null) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập Ngày sinh", "Thông báo", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Check if msv is numeric
  
//            try {
//                Integer.parseInt(msv.getText());
//            } catch (NumberFormatException e) {
//                JOptionPane.showMessageDialog(this, "Mã sinh viên phải là số", "Thông báo", JOptionPane.ERROR_MESSAGE);
//                return;
//            }

            // Format the date to a string in the correct format
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String dateString = dateFormat.format(d.getDate());

            String sql = "insert into sv values('" + msv.getText() + "',N'" + ht.getText() + "','" + dateString + "','" + cbml.getSelectedItem().toString() + "',N'" + Gioitinh + "',N'" + qq.getText() + "','" + kh.getText() + "')";
            int a = st.executeUpdate(sql);
            loadsv();
             JOptionPane.showMessageDialog(this, "Thêm dữ liệu thành công");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Đã có mã sinh viên này rồi", "Thông báo", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton25ActionPerformed

    private void jButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton26ActionPerformed
        try {
         String dbURL = "jdbc:sqlserver://127.0.0.1;databaseName=thuvien; user=sa;password=12345;encrypt=true;trustServerCertificate=true";
            Connection conn = DriverManager.getConnection(dbURL);
            Statement st = conn.createStatement();
            String Gioitinh;
            if (nam.isSelected()) {
                Gioitinh = "Nam";
            } else {
                Gioitinh = "Nữ";
            }
            String sql = "delete from sv  where masv='" + msv.getText() + "'";
// TODO add your handling code here:
            int a = st.executeUpdate(sql);
            loadsv();
              JOptionPane.showMessageDialog(this, "xóa dữ liệu thành công");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Lỗi khi xóa dữ liệu", "Thông báo", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton26ActionPerformed

    private void tbsvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbsvMouseClicked
        int row = tbsv.getSelectedRow();
        msv.setText(tbsv.getValueAt(row, 0).toString());
        ht.setText(tbsv.getValueAt(row, 1).toString());

// Parse the date string to a Date object
      String dateString = tbsv.getValueAt(row, 2).toString();
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date date = dateFormat.parse(dateString);
            d.setDate(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        cbml.setSelectedItem(tbsv.getValueAt(row, 3).toString());

        String gt = tbsv.getValueAt(row, 5).toString();
        if (gt.equals("Nam")) {
            nam.setSelected(true);
        } else {
            nu.setSelected(true);
        }

        qq.setText(tbsv.getValueAt(row, 6).toString());
        kh.setText(tbsv.getValueAt(row, 7).toString());
    }//GEN-LAST:event_tbsvMouseClicked

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed

         String dbURL = "jdbc:sqlserver://127.0.0.1;databaseName=thuvien; user=sa;password=12345;encrypt=true;trustServerCertificate=true";
        Connection conn;
        try {
            conn = DriverManager.getConnection(dbURL);

            Statement st = conn.createStatement();
            DefaultTableModel tableModel = new DefaultTableModel();
            tableModel.addColumn("Mã Sinh Viên");
            tableModel.addColumn("Tên sinh Viên");
            tableModel.addColumn("YYYY-MM-DD");
            tableModel.addColumn("Tên Lớp");
            tableModel.addColumn("Tên Khoa");
            tableModel.addColumn("Giới Tính");
            tableModel.addColumn("Quê Quán");
            tableModel.addColumn("Khóa Học");

            String dkien = cbtk.getSelectedItem().toString();
            String msv = tk.getText();
            String tsv = tk.getText();
            String nams = tk.getText();
            String tenl = tk.getText();
            String queq = tk.getText();
            String khoah = tk.getText();
            if (dkien.equals("Tất Cả")) {
                loadsv();

            }
            if (dkien.equals("MaSV")) {
                String sql = "Select * from sv inner join lop on lop.malop=sv.malop inner join khoa on khoa.makhoa=lop.makhoa where masv='" + msv + "' ";
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    Vector vt = new Vector();
                    vt.add(rs.getString("masv"));
                    vt.add(rs.getString("tensv"));
                    vt.add(rs.getString("namsinh"));
                    vt.add(rs.getString("tenlop"));
                    vt.add(rs.getString("tenkhoa"));
                    vt.add(rs.getString("gioitinh"));
                    vt.add(rs.getString("quequan"));
                    vt.add(rs.getString("khoahoc"));

                    //Đưa dữ liệu vào TableModel
                    tableModel.addRow(vt);
                }
                tbsv.setModel(tableModel);

            }
            if (dkien.equals("TenSV")) {
                String sql = "Select * from sv inner join lop on lop.malop=sv.malop inner join khoa on khoa.makhoa=lop.makhoa where tensv like N'" + tsv + "' ";
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    Vector vt = new Vector();
                    vt.add(rs.getString("masv"));
                    vt.add(rs.getString("tensv"));
                    vt.add(rs.getString("namsinh"));
                    vt.add(rs.getString("tenlop"));
                    vt.add(rs.getString("tenkhoa"));
                    vt.add(rs.getString("gioitinh"));
                    vt.add(rs.getString("quequan"));
                    vt.add(rs.getString("khoahoc"));

                    //Đưa dữ liệu vào TableModel
                    tableModel.addRow(vt);
                }
                tbsv.setModel(tableModel);

            }
            if (dkien.equals("NamSinh")) {
                String sql = "Select * from sv inner join lop on lop.malop=sv.malop inner join khoa on khoa.makhoa=lop.makhoa where namsinh='" + nams + "' ";
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    Vector vt = new Vector();
                    vt.add(rs.getString("masv"));
                    vt.add(rs.getString("tensv"));
                    vt.add(rs.getString("namsinh"));
                    vt.add(rs.getString("tenlop"));
                    vt.add(rs.getString("tenkhoa"));
                    vt.add(rs.getString("gioitinh"));
                    vt.add(rs.getString("quequan"));
                    vt.add(rs.getString("khoahoc"));

                    //Đưa dữ liệu vào TableModel
                    tableModel.addRow(vt);
                }
                tbsv.setModel(tableModel);

            }
            if (dkien.equals("TenLop")) {
                String sql = "Select * from sv inner join lop on lop.malop=sv.malop inner join khoa on khoa.makhoa=lop.makhoa where lop.tenlop like N'" + tenl + "' ";
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    Vector vt = new Vector();
                    vt.add(rs.getString("masv"));
                    vt.add(rs.getString("tensv"));
                    vt.add(rs.getString("namsinh"));
                    vt.add(rs.getString("tenlop"));
                    vt.add(rs.getString("tenkhoa"));
                    vt.add(rs.getString("gioitinh"));
                    vt.add(rs.getString("quequan"));
                    vt.add(rs.getString("khoahoc"));

                    //Đưa dữ liệu vào TableModel
                    tableModel.addRow(vt);
                }
                tbsv.setModel(tableModel);

            }
            if (dkien.equals("QueQuan")) {
                String sql = "Select * from sv inner join lop on lop.malop=sv.malop inner join khoa on khoa.makhoa=lop.makhoa where quequan like N'" + queq + "' ";
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    Vector vt = new Vector();
                    vt.add(rs.getString("masv"));
                    vt.add(rs.getString("tensv"));
                    vt.add(rs.getString("namsinh"));
                    vt.add(rs.getString("tenlop"));
                    vt.add(rs.getString("tenkhoa"));
                    vt.add(rs.getString("gioitinh"));
                    vt.add(rs.getString("quequan"));
                    vt.add(rs.getString("khoahoc"));

                    //Đưa dữ liệu vào TableModel
                    tableModel.addRow(vt);
                }
                tbsv.setModel(tableModel);

            }
            if (dkien.equals("KhoaHoc")) {
                String sql = "Select * from sv inner join lop on lop.malop=sv.malop inner join khoa on khoa.makhoa=lop.makhoa where khoahoc='" + khoah + "' ";
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    Vector vt = new Vector();
                    vt.add(rs.getString("masv"));
                    vt.add(rs.getString("tensv"));
                    vt.add(rs.getString("namsinh"));
                    vt.add(rs.getString("tenlop"));
                    vt.add(rs.getString("tenkhoa"));
                    vt.add(rs.getString("gioitinh"));
                    vt.add(rs.getString("quequan"));
                    vt.add(rs.getString("khoahoc"));

                    //Đưa dữ liệu vào TableModel
                    tableModel.addRow(vt);
                }
                tbsv.setModel(tableModel);

            }
        } catch (SQLException ex) {

        }
    }//GEN-LAST:event_jButton23ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        Login1 a = new Login1();
        a.show();
        this.hide();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        DefaultTableModel tableModel = (DefaultTableModel) tbsv.getModel();
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
        try (FileOutputStream fos = new FileOutputStream("FileExcelXuat/sinhvien.xlsx")) {
            workbook.write(fos);
            System.out.println("Xuất dữ liệu thành công!");
            JOptionPane.showMessageDialog(this, "Xuất Dữ Liệu Thành Công");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cbml;
    private javax.swing.JComboBox cbtk;
    private com.toedter.calendar.JDateChooser d;
    private javax.swing.JTextField ht;
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
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar4;
    private javax.swing.JTextField kh;
    private javax.swing.JTextField msv;
    private javax.swing.JRadioButton nam;
    private javax.swing.JRadioButton nu;
    private javax.swing.JTextField qq;
    private javax.swing.JTable tbsv;
    private javax.swing.JTextField tk;
    // End of variables declaration//GEN-END:variables
}
