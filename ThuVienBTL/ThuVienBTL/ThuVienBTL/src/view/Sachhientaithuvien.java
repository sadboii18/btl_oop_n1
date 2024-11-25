/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import ctl.Lop_ctl;
import model.sach_md;
import model.nxb_md;
import model.theloai_md;
import model.tacgia_md;
import ctl.Tacgia_ctl;
import ctl.Theloai_ctl;
import ctl.Nxb_ctl;
import ctl.Phieumuon_ctl;
import ctl.Sach_ctl;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.lop_md;
import model.phieumuon_md;
import model.sv_md;
import javax.swing.JPanel;
import java.io.File;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import ctl.Phieumuon_ctl;
import java.text.DecimalFormat;

import model.phieumuon_md;
import model.sach_md;
import model.sv_md;
public class Sachhientaithuvien extends javax.swing.JFrame {

     private Tacgia_ctl tacgia_ctl;
   private Nxb_ctl nxb_ctl;
   private Theloai_ctl theloai_ctl;
   private Sach_ctl sach_ctl;
    private Phieumuon_ctl phieumuon_ctl;
    public Sachhientaithuvien() {
         initComponents();
        tacgia_ctl=new Tacgia_ctl();
        nxb_ctl=new Nxb_ctl();
        sach_ctl=new Sach_ctl();
        theloai_ctl=new Theloai_ctl();
         phieumuon_ctl = new Phieumuon_ctl();
      loadphieumuon();
        loadsach();
        tinhtongsosachcacloai();
      loadsachdangmuonchuatra();
      tinhtongsosachconlai();
    }


     public void tinhtongsosachcacloai(){
        int t1=0;
       for (int i=0;i<tbs.getRowCount();i++){
            t1 += Integer.parseInt(tbs.getValueAt(i, 11).toString());
        }
       tongsachdauvao.setText(t1+"");
       
       
       int t2=0;
        for (int i=0;i<tbpm.getRowCount();i++){
             t2 += Integer.parseInt(tbpm.getValueAt(i, 7).toString());
        }
       sosachdangmuon.setText(t2+""); 
       
       
        int a = t1-t2;
        tongsosachconlai.setText(a+"");
       
    }
  
   public void tinhtongsosachconlai(){
        try {
    
        List<phieumuon_md> listlop = phieumuon_ctl.loadtongsoluongsachconlaitheomasach();
        DefaultTableModel tb = new DefaultTableModel();
        tb.addColumn("Mã Sách");

        tb.addColumn(" Tổng Số Lượng Sách Còn Lại");

        for (phieumuon_md pm : listlop) {
           sach_md a = new sach_md();
            Object[] row = new Object[3];
            row[0] = pm.getMasach();
       
            row[1] = pm.getSoluong();
            tb.addRow(row);
        }
        
        tb2.setModel(tb);
    } catch (Exception ex) {
        ex.printStackTrace();
    }
       
    } 
      private void loadsachdangmuonchuatra() {
      try {
    
        List<phieumuon_md> listlop = phieumuon_ctl.loadtongsoluongsachdangmuontheotungmasach();
        DefaultTableModel tb = new DefaultTableModel();
        tb.addColumn("Mã Sách");
       tb.addColumn("Trạng Thái");
        tb.addColumn(" Tổng Số Lượng Đang Mượn Chưa Trả");

        for (phieumuon_md hd : listlop) {
            sach_md a = new sach_md();
            tb.addRow(new Object[]{
                hd.getMasach(),
           
               hd.getTrangthai(),
                hd.getSoluong()
            });
        }
        tb1.setModel(tb);
    } catch (Exception ex) {
        ex.printStackTrace();
    }
    }
      private void loadphieumuon() {
        try {
            sach_ctl = new Sach_ctl();
            List<phieumuon_md> listlop = phieumuon_ctl.loadphieumuondangmuonsach();
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
                    (b != null) ? hd.getSoluong() * b.getGiatien()*1.5 : 0.0

                });
            }
            tbpm.setModel(tb);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

   
private void loadsach(){
        try{ 
            sach_ctl = new Sach_ctl();
            List<sach_md> listlop =sach_ctl.loadsach();
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
            for(sach_md hd : listlop){
                tacgia_md a = hd.getTacgia(); 
                theloai_md b= hd.getTheloai();
                    nxb_md c = hd.getNhaxuatban();
                       
                tb.addRow(new Object[]{
                
                    hd.getMasach(),hd.getTensach(),    hd.getTomtatnoidung(),hd.getSotrang(), hd.getGiatien(),
                    hd.getMatacgia(),
                    (a !=null) ? a.getTentg() : "",
                    hd.getMatheloai(),
                     (b !=null) ? b.getTentheloai() : "",
                     hd.getManhaxb(),
                      (c !=null) ? c.getTennxb() : "",
                    hd.getSoluong()
                
                   
                });
            }
            tbs.setModel(tb);
        }catch(Exception ex){
            ex.printStackTrace();
        }
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbs = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbpm = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tb1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tb2 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        tongsachdauvao = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        tongsosachconlai = new javax.swing.JLabel();
        sosachdangmuon = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
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

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

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
        jScrollPane1.setViewportView(tbs);

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
        jScrollPane2.setViewportView(tbpm);

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
        jScrollPane3.setViewportView(tb1);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Thống Kê Kho Sách Ban Đầu");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Phiếu Mượn Hiện Tại Chưa Trả Sách");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Thống Kế Sách Đang Mượn ");

        tb2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(tb2);

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

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(102, 255, 0));
        jLabel13.setText("Tổng Số Lượng Đã Mượn Chưa Trả :");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(102, 255, 51));
        jLabel14.setText("Cuốn ");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(102, 255, 0));
        jLabel15.setText("Tổng Số Lượng Hiện  Tại Còn :");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(102, 255, 51));
        jLabel16.setText("Cuốn ");

        tongsosachconlai.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        tongsosachconlai.setForeground(new java.awt.Color(255, 255, 255));
        tongsosachconlai.setText("jLabel5");

        sosachdangmuon.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        sosachdangmuon.setForeground(new java.awt.Color(255, 255, 255));
        sosachdangmuon.setText("Jlable");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jLabel11)
                    .addComponent(jLabel15))
                .addGap(48, 48, 48)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(tongsosachconlai)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel16))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tongsachdauvao)
                            .addComponent(sosachdangmuon))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGap(190, 190, 190))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(tongsachdauvao)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(sosachdangmuon))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16)
                    .addComponent(tongsosachconlai))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 51, 51));
        jLabel5.setText("Thống Kê Số Sách Còn Lại");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane2)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1293, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(14, 14, 14))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/anh/thongke.png"))); // NOI18N

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        Theloai a=new Theloai();
        a.show();
        this.hide();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        Tacgia a=new Tacgia();
        a.show();
        this.hide();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        Nxb a=new Nxb();
        a.show();
        this.hide();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        Sach a=new Sach();
        a.show();
        this.hide();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        Sachhientaithuvien a=new Sachhientaithuvien();
       a.show();
       this.hide();
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        Tracuusinhvien a=new Tracuusinhvien();
        a.show();
        this.hide();
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        Trangchu a=new Trangchu();
       a.show();
       this.hide();
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        Ravao a=new Ravao();
       a.show();
       this.hide();
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
         Chitietphieumuon a=new Chitietphieumuon();
       a.show();
       this.hide();
    }//GEN-LAST:event_jMenuItem9ActionPerformed

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
            java.util.logging.Logger.getLogger(Sachhientaithuvien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sachhientaithuvien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sachhientaithuvien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sachhientaithuvien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sachhientaithuvien().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel sosachdangmuon;
    private javax.swing.JTable tb1;
    private javax.swing.JTable tb2;
    private javax.swing.JTable tbpm;
    private javax.swing.JTable tbs;
    private javax.swing.JLabel tongsachdauvao;
    private javax.swing.JLabel tongsosachconlai;
    // End of variables declaration//GEN-END:variables
}
