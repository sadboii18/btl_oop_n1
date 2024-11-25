package view;

import ctl.Lop_ctl;
import model.sach_md;
import model.nxb_md;
import model.theloai_md;
import model.tacgia_md;
import ctl.Tacgia_ctl;
import ctl.Theloai_ctl;
import ctl.Nxb_ctl;
import ctl.Sach_ctl;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.lop_md;
import java.io.File;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Sach extends javax.swing.JFrame {

    private Tacgia_ctl tacgia_ctl;
    private Nxb_ctl nxb_ctl;
    private Theloai_ctl theloai_ctl;
    private Sach_ctl sach_ctl;

    public Sach() {
        initComponents();
        tacgia_ctl = new Tacgia_ctl();
        nxb_ctl = new Nxb_ctl();
        sach_ctl = new Sach_ctl();
        theloai_ctl = new Theloai_ctl();
        addmanxb();
        addmatg();
        addmatheloai();
        loadsach();
        tinhtongs();

    }

    public void tinhtongs() {
        int t = 0;
        for (int i = 0; i < tbs.getRowCount(); i++) {
            t += Double.parseDouble(tbs.getValueAt(i, 11) + "");
        }
        tongsachdauvao.setText(t + "");
    }

    private void addmatg() {
        try {
            List<tacgia_md> listkhoa = tacgia_ctl.addmatacgia();
            DefaultTableModel tb = new DefaultTableModel();
            for (tacgia_md a : listkhoa) {
                cbmtg.addItem(a.getMatg());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void addmatheloai() {
        try {
            List<theloai_md> listkhoa = theloai_ctl.addmatheloai();
            DefaultTableModel tb = new DefaultTableModel();
            for (theloai_md a : listkhoa) {
                cbmtl.addItem(a.getMatheloai());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void addmanxb() {
        try {
            List<nxb_md> listkhoa = nxb_ctl.addmanxb();
            DefaultTableModel tb = new DefaultTableModel();
            for (nxb_md a : listkhoa) {
                cbmnxb.addItem(a.getManxb());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void loadsach() {
        try {
            sach_ctl = new Sach_ctl();
            List<sach_md> listlop = sach_ctl.loadsach();
            DefaultTableModel tb = new DefaultTableModel();

            tb.addColumn("Mã Sách");
            tb.addColumn("Tên sách");
            tb.addColumn("Tóm Tắt Nội Dung");
            tb.addColumn("Số trang");
            tb.addColumn("Giá Tiền");
            tb.addColumn("Mã Tác Giả");
            tb.addColumn("Tên Tác Giả");
            tb.addColumn("Mã Thể Loại");
            tb.addColumn("Tên Thể Loại");
            tb.addColumn("Mã Nhà Xuất Bản");
            tb.addColumn("Tên Nhà Xuất Bản");
            tb.addColumn("Số Lượng");
            for (sach_md hd : listlop) {
                tacgia_md a = hd.getTacgia();
                theloai_md b = hd.getTheloai();
                nxb_md c = hd.getNhaxuatban();

                tb.addRow(new Object[]{
                    hd.getMasach(), hd.getTensach(), hd.getTomtatnoidung(), hd.getSotrang(), hd.getGiatien(),
                    hd.getMatacgia(),
                    (a != null) ? a.getTentg() : "",
                    hd.getMatheloai(),
                    (b != null) ? b.getTentheloai() : "",
                    hd.getManhaxb(),
                    (c != null) ? c.getTennxb() : "",
                    hd.getSoluong()

                });
            }
            tbs.setModel(tb);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cbtk = new javax.swing.JComboBox();
        tk = new javax.swing.JTextField();
        sldv = new javax.swing.JTextField();
        cbmtl = new javax.swing.JComboBox();
        cbmnxb = new javax.swing.JComboBox();
        cbmtg = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        ms = new javax.swing.JTextField();
        ts = new javax.swing.JTextField();
        ttnd = new javax.swing.JTextField();
        st = new javax.swing.JTextField();
        gt = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jToolBar4 = new javax.swing.JToolBar();
        jButton23 = new javax.swing.JButton();
        jButton24 = new javax.swing.JButton();
        jButton25 = new javax.swing.JButton();
        jButton26 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbs = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        tongsachdauvao = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
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
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cbtk.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tất Cả", "MaSach", "TenSach", "TenTheLoai", "TenNXB", "TenTacGia" }));
        cbtk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbtkActionPerformed(evt);
            }
        });
        getContentPane().add(cbtk, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 250, 119, 32));
        getContentPane().add(tk, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 250, 281, 32));
        getContentPane().add(sldv, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 360, 346, -1));

        getContentPane().add(cbmtl, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 390, 346, -1));

        getContentPane().add(cbmnxb, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 420, 346, -1));

        getContentPane().add(cbmtg, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 450, 346, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Mã Tác GIả");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 450, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Mã Nhà XB");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 420, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Mã Thể Loại");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 390, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Số Lượng Sách Đầu Vào");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 360, -1, -1));
        getContentPane().add(ms, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 300, 310, -1));
        getContentPane().add(ts, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 340, 310, -1));
        getContentPane().add(ttnd, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 380, 310, -1));
        getContentPane().add(st, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 420, 310, -1));
        getContentPane().add(gt, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 450, 310, 30));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Giá Thành");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 460, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Số Trang");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 420, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("TT Nội Dung");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 380, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Tên sách");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 340, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Mã sách");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 300, -1, -1));

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

        getContentPane().add(jToolBar4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 250, 460, 60));

        tbs.setModel(new javax.swing.table.DefaultTableModel(
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
        tbs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbs);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 500, 1470, 210));

        jPanel2.setBackground(new java.awt.Color(255, 51, 51));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 255, 0));
        jLabel11.setText("Tổng Số Lượng Sách Đầu Vào :");

        tongsachdauvao.setBackground(new java.awt.Color(255, 255, 255));
        tongsachdauvao.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        tongsachdauvao.setForeground(new java.awt.Color(255, 255, 255));
        tongsachdauvao.setText("jLabel12");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(102, 255, 51));
        jLabel12.setText("Cuốn ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(1030, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tongsachdauvao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel12)
                .addGap(149, 149, 149))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(tongsachdauvao)
                    .addComponent(jLabel12))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 800, 1690, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/anh/sach1.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, 1700, 800));

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

        jMenuItem10.setText("Chi Tiết Phiếu Mượn");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem10);

        jMenuItem9.setText("Quản Lí Sách Quá Hạn Mượn");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem9);

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
               String mas = ms.getText();
        String tens = ts.getText();
        String tomtnd = ttnd.getText();

// Kiểm tra mã sách
        if (mas.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập mã sách", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

// Kiểm tra tên sách
        if (tens.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập tên sách", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

// Kiểm tra số trang
        int sotrang;
        try {
            sotrang = Integer.parseInt(st.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Số trang phải là một số nguyên", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

// Kiểm tra giá tiền
        float giatien;
        if (gt.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập giá tiền", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            giatien = Float.parseFloat(gt.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Giá tiền phải là một số thực", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

// Kiểm tra số lượng
        int soluong;
        if (sldv.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số lượng", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            soluong = Integer.parseInt(sldv.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Số lượng phải là một số nguyên", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String matg = cbmtg.getSelectedItem().toString();
        String matl = cbmtl.getSelectedItem().toString();
        String manxb = cbmnxb.getSelectedItem().toString();
        sach_md hd = new sach_md(mas, tens, tomtnd, sotrang, giatien, matg, matl, manxb, soluong);
        if (sach_ctl.suasach(hd)) {
            loadsach();
            tinhtongs();
            JOptionPane.showMessageDialog(this, "Sửa dữ liệu thành công");
        } else {
            JOptionPane.showMessageDialog(this, "Lỗi khi thêm dữ liệu", "Thông báo", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton24ActionPerformed

    private void jButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton25ActionPerformed
        String mas = ms.getText();
        String tens = ts.getText();
        String tomtnd = ttnd.getText();

// Kiểm tra mã sách
        if (mas.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập mã sách", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

// Kiểm tra tên sách
        if (tens.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập tên sách", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

// Kiểm tra số trang
        int sotrang;
        try {
            sotrang = Integer.parseInt(st.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Số trang phải là một số nguyên", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

// Kiểm tra giá tiền
        float giatien;
        if (gt.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập giá tiền", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            giatien = Float.parseFloat(gt.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Giá tiền phải là một số thực", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

// Kiểm tra số lượng
        int soluong;
        if (sldv.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số lượng", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            soluong = Integer.parseInt(sldv.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Số lượng phải là một số nguyên", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String matg = cbmtg.getSelectedItem().toString();
        String matl = cbmtl.getSelectedItem().toString();
        String manxb = cbmnxb.getSelectedItem().toString();

        sach_md hd = new sach_md(mas, tens, tomtnd, sotrang, giatien, matg, matl, manxb, soluong);
        if (sach_ctl.themsach(hd)) {
            loadsach();
            tinhtongs();
            JOptionPane.showMessageDialog(this, "Thêm dữ liệu thành công");
        } else {
            JOptionPane.showMessageDialog(this, "Lỗi khi thêm dữ liệu", "Thông báo", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton25ActionPerformed

    private void jButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton26ActionPerformed
        String mas = ms.getText();
        String tens = ts.getText();
        String tomtnd = ttnd.getText();
        int sotrang = Integer.parseInt(st.getText());
        float giatien = Float.parseFloat(gt.getText());
        String matg = cbmtg.getSelectedItem().toString();
        String matl = cbmtl.getSelectedItem().toString();
        String manxb = cbmnxb.getSelectedItem().toString();
        int soluong = Integer.parseInt(sldv.getText());
        sach_md hd = new sach_md(mas, tens, tomtnd, sotrang, giatien, matg, matl, manxb, soluong);
        if (sach_ctl.xoasach(hd)) {
            loadsach();
            tinhtongs();
            JOptionPane.showMessageDialog(this, "xóa dữ liệu thành công");
        } else {
            JOptionPane.showMessageDialog(this, "Lỗi khi thêm dữ liệu", "Thông báo", JOptionPane.ERROR_MESSAGE);
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

    private void tbsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbsMouseClicked
        sach_ctl.click(tbs, ms, ts, ttnd, st, gt, cbmtg, cbmtl, cbmnxb, sldv);
    }//GEN-LAST:event_tbsMouseClicked

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
        try {
            String dkien = cbtk.getSelectedItem().toString();
            String mas = tk.getText();
            String tens = tk.getText();
            String tentl = tk.getText();
            String tennxb = tk.getText();
            String tentg = tk.getText();

            if (dkien.equals("Tất Cả")) {
                List<sach_md> listkhoa = sach_ctl.loadsach();
                DefaultTableModel tb = new DefaultTableModel();

                tb.addColumn("Mã Sách");
                tb.addColumn("Tên sách");
                tb.addColumn("Tóm Tắt Nội Dung");
                tb.addColumn("Số trang");
                tb.addColumn("Giá Tiền");
                tb.addColumn("Mã Tác Giả");
                tb.addColumn("Tên Tác Giả");
                tb.addColumn("Mã Thể Loại");
                tb.addColumn("Tên Thể Loại");
                tb.addColumn("Mã Nhà Xuất Bản");
                tb.addColumn("Tên Nhà Xuất Bản");
                tb.addColumn("Số Lượng");
                for (sach_md hd : listkhoa) {
                    tacgia_md a = hd.getTacgia();
                    theloai_md b = hd.getTheloai();
                    nxb_md c = hd.getNhaxuatban();
                    tb.addRow(new Object[]{
                        hd.getMasach(), hd.getTensach(), hd.getTomtatnoidung(), hd.getSotrang(), hd.getGiatien(),
                        hd.getMatacgia(),
                        (a != null) ? a.getTentg() : "",
                        hd.getMatheloai(),
                        (b != null) ? b.getTentheloai() : "",
                        hd.getManhaxb(),
                        (c != null) ? c.getTennxb() : "",
                        hd.getSoluong()
                    });
                }
                tbs.setModel(tb);
            }
            if (dkien.equals("MaSach")) {
                List<sach_md> listkhoa = sach_ctl.timkiemmasach(mas);
                DefaultTableModel tb = new DefaultTableModel();

                tb.addColumn("Mã Sách");
                tb.addColumn("Tên sách");
                tb.addColumn("Tóm Tắt Nội Dung");
                tb.addColumn("Số trang");
                tb.addColumn("Giá Tiền");
                tb.addColumn("Mã Tác Giả");
                tb.addColumn("Tên Tác Giả");
                tb.addColumn("Mã Thể Loại");
                tb.addColumn("Tên Thể Loại");
                tb.addColumn("Mã Nhà Xuất Bản");
                tb.addColumn("Tên Nhà Xuất Bản");
                tb.addColumn("Số Lượng");
                for (sach_md hd : listkhoa) {
                    tacgia_md a = hd.getTacgia();
                    theloai_md b = hd.getTheloai();
                    nxb_md c = hd.getNhaxuatban();
                    tb.addRow(new Object[]{
                        hd.getMasach(), hd.getTensach(), hd.getTomtatnoidung(), hd.getSotrang(), hd.getGiatien(),
                        hd.getMatacgia(),
                        (a != null) ? a.getTentg() : "",
                        hd.getMatheloai(),
                        (b != null) ? b.getTentheloai() : "",
                        hd.getManhaxb(),
                        (c != null) ? c.getTennxb() : "",
                        hd.getSoluong()
                    });
                }
                tbs.setModel(tb);
            }
            if (dkien.equals("TenSach")) {
                List<sach_md> listkhoa = sach_ctl.timkiemtensach(tens);
                DefaultTableModel tb = new DefaultTableModel();

                tb.addColumn("Mã Sách");
                tb.addColumn("Tên sách");
                tb.addColumn("Tóm Tắt Nội Dung");
                tb.addColumn("Số trang");
                tb.addColumn("Giá Tiền");
                tb.addColumn("Mã Tác Giả");
                tb.addColumn("Tên Tác Giả");
                tb.addColumn("Mã Thể Loại");
                tb.addColumn("Tên Thể Loại");
                tb.addColumn("Mã Nhà Xuất Bản");
                tb.addColumn("Tên Nhà Xuất Bản");
                tb.addColumn("Số Lượng");
                for (sach_md hd : listkhoa) {
                    tacgia_md a = hd.getTacgia();
                    theloai_md b = hd.getTheloai();
                    nxb_md c = hd.getNhaxuatban();
                    tb.addRow(new Object[]{
                        hd.getMasach(), hd.getTensach(), hd.getTomtatnoidung(), hd.getSotrang(), hd.getGiatien(),
                        hd.getMatacgia(),
                        (a != null) ? a.getTentg() : "",
                        hd.getMatheloai(),
                        (b != null) ? b.getTentheloai() : "",
                        hd.getManhaxb(),
                        (c != null) ? c.getTennxb() : "",
                        hd.getSoluong()
                    });
                }
                tbs.setModel(tb);
            }
            if (dkien.equals("TenTheLoai")) {
                List<sach_md> listkhoa = sach_ctl.timkiemtentheloai(tentl);
                DefaultTableModel tb = new DefaultTableModel();

                tb.addColumn("Mã Sách");
                tb.addColumn("Tên sách");
                tb.addColumn("Tóm Tắt Nội Dung");
                tb.addColumn("Số trang");
                tb.addColumn("Giá Tiền");
                tb.addColumn("Mã Tác Giả");
                tb.addColumn("Tên Tác Giả");
                tb.addColumn("Mã Thể Loại");
                tb.addColumn("Tên Thể Loại");
                tb.addColumn("Mã Nhà Xuất Bản");
                tb.addColumn("Tên Nhà Xuất Bản");
                tb.addColumn("Số Lượng");
                for (sach_md hd : listkhoa) {
                    tacgia_md a = hd.getTacgia();
                    theloai_md b = hd.getTheloai();
                    nxb_md c = hd.getNhaxuatban();
                    tb.addRow(new Object[]{
                        hd.getMasach(), hd.getTensach(), hd.getTomtatnoidung(), hd.getSotrang(), hd.getGiatien(),
                        hd.getMatacgia(),
                        (a != null) ? a.getTentg() : "",
                        hd.getMatheloai(),
                        (b != null) ? b.getTentheloai() : "",
                        hd.getManhaxb(),
                        (c != null) ? c.getTennxb() : "",
                        hd.getSoluong()
                    });
                }
                tbs.setModel(tb);
            }
            if (dkien.equals("TenTacGia")) {
                List<sach_md> listkhoa = sach_ctl.timkiemtentacgia(tentg);
                DefaultTableModel tb = new DefaultTableModel();

                tb.addColumn("Mã Sách");
                tb.addColumn("Tên sách");
                tb.addColumn("Tóm Tắt Nội Dung");
                tb.addColumn("Số trang");
                tb.addColumn("Giá Tiền");
                tb.addColumn("Mã Tác Giả");
                tb.addColumn("Tên Tác Giả");
                tb.addColumn("Mã Thể Loại");
                tb.addColumn("Tên Thể Loại");
                tb.addColumn("Mã Nhà Xuất Bản");
                tb.addColumn("Tên Nhà Xuất Bản");
                tb.addColumn("Số Lượng");
                for (sach_md hd : listkhoa) {
                    tacgia_md a = hd.getTacgia();
                    theloai_md b = hd.getTheloai();
                    nxb_md c = hd.getNhaxuatban();
                    tb.addRow(new Object[]{
                        hd.getMasach(), hd.getTensach(), hd.getTomtatnoidung(), hd.getSotrang(), hd.getGiatien(),
                        hd.getMatacgia(),
                        (a != null) ? a.getTentg() : "",
                        hd.getMatheloai(),
                        (b != null) ? b.getTentheloai() : "",
                        hd.getManhaxb(),
                        (c != null) ? c.getTennxb() : "",
                        hd.getSoluong()
                    });
                }
                tbs.setModel(tb);
            }
            if (dkien.equals("TenNXB")) {
                List<sach_md> listkhoa = sach_ctl.timkiemtennhaxb(tennxb);
                DefaultTableModel tb = new DefaultTableModel();

                tb.addColumn("Mã Sách");
                tb.addColumn("Tên sách");
                tb.addColumn("Tóm Tắt Nội Dung");
                tb.addColumn("Số trang");
                tb.addColumn("Giá Tiền");
                tb.addColumn("Mã Tác Giả");
                tb.addColumn("Tên Tác Giả");
                tb.addColumn("Mã Thể Loại");
                tb.addColumn("Tên Thể Loại");
                tb.addColumn("Mã Nhà Xuất Bản");
                tb.addColumn("Tên Nhà Xuất Bản");
                tb.addColumn("Số Lượng");
                for (sach_md hd : listkhoa) {
                    tacgia_md a = hd.getTacgia();
                    theloai_md b = hd.getTheloai();
                    nxb_md c = hd.getNhaxuatban();
                    tb.addRow(new Object[]{
                        hd.getMasach(), hd.getTensach(), hd.getTomtatnoidung(), hd.getSotrang(), hd.getGiatien(),
                        hd.getMatacgia(),
                        (a != null) ? a.getTentg() : "",
                        hd.getMatheloai(),
                        (b != null) ? b.getTentheloai() : "",
                        hd.getManhaxb(),
                        (c != null) ? c.getTennxb() : "",
                        hd.getSoluong()
                    });
                }
                tbs.setModel(tb);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        DefaultTableModel tableModel = (DefaultTableModel) tbs.getModel();
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
        try (FileOutputStream fos = new FileOutputStream("FileExcelXuat/sach.xlsx")) {
            workbook.write(fos);
            System.out.println("Xuất dữ liệu thành công!");
            JOptionPane.showMessageDialog(this, "Xuất Dữ Liệu Thành Công");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cbtkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbtkActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbtkActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        Phieumuonquahan a = new Phieumuonquahan();
        a.show();
        this.hide();
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        Chitietphieumuon a = new Chitietphieumuon();
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
            java.util.logging.Logger.getLogger(Sach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sach().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cbmnxb;
    private javax.swing.JComboBox cbmtg;
    private javax.swing.JComboBox cbmtl;
    private javax.swing.JComboBox cbtk;
    private javax.swing.JTextField gt;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
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
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar4;
    private javax.swing.JTextField ms;
    private javax.swing.JTextField sldv;
    private javax.swing.JTextField st;
    private javax.swing.JTable tbs;
    private javax.swing.JTextField tk;
    private javax.swing.JLabel tongsachdauvao;
    private javax.swing.JTextField ts;
    private javax.swing.JTextField ttnd;
    // End of variables declaration//GEN-END:variables
}
