/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ctl;
import model.sach_md;
import model.nxb_md;
import model.tacgia_md;
import model.theloai_md;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
public class Sach_ctl {

      public static String dbURL ="jdbc:sqlserver://127.0.0.1;databaseName=thuvien;user=sa;password=12345;encrypt=true;trustServerCertificate=true";
    public static Connection getConnection(){
        Connection conn = null;
        try{
            conn = DriverManager.getConnection(dbURL);
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return conn;
    }
          public List<sach_md> addmasach(){
        List<sach_md> listkhoa = new ArrayList<>();
        try{
            Connection conn = getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM sach");
            while(rs.next()){
                sach_md khach = new sach_md();
                khach.setMasach(rs.getString("masach"));
                listkhoa.add(khach);
            } 
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return listkhoa;
    }
      public List<sach_md> loadsach(){
        List<sach_md> listlop = new ArrayList<>();
        try{
            Connection conn = getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM sach inner join tacgia1 on sach.matacgia=tacgia1.matacgia inner join theloai on theloai.matheloai=sach.matheloai inner join nhaxb on nhaxb.manhaxb=sach.manhaxb order by sach.masach ASC");
            while(rs.next()){
                sach_md a = new sach_md();
                tacgia_md b=new tacgia_md();
                  theloai_md c=new theloai_md();
                    nxb_md d=new nxb_md();
                    
                a.setMasach(rs.getString("masach"));
                a.setTensach(rs.getString("tensach"));
               a.setTomtatnoidung(rs.getString("tomtatnoidung"));
                a.setSotrang(rs.getInt("sotrang"));
                  a.setGiatien(rs.getFloat("giatien"));
                      a.setMatacgia(rs.getString("matacgia"));
                b.setTentg(rs.getString("tentacgia"));
                  a.setMatheloai(rs.getString("matheloai"));
                  c.setTentheloai(rs.getString("tentheloai"));
                    a.setManhaxb(rs.getString("manhaxb"));
                    d.setTennxb(rs.getString("tennhaxb"));
                       a.setSoluong(rs.getInt("soluong"));
                a.setTacgia(b);
                a.setTheloai(c);
                a.setNhaxuatban(d);
                listlop.add(a);
            } 
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return listlop;
    }
      public void click(JTable table, JTextField ms,JTextField ts,JTextField tt, JTextField st, JTextField gt,JComboBox mtg,JComboBox mtl,JComboBox mnxb,JTextField sl){
         table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
    
             public void valueChanged(ListSelectionEvent e){
                 if(!e.getValueIsAdjusting()){
                     int row = table.getSelectedRow();
                     if( row != -1){
                        
                          String mas = table.getValueAt(row, 0).toString();
                         String tens= table.getValueAt(row, 1).toString();
                         String tomt= table.getValueAt(row, 2).toString();
                         String sot = table.getValueAt(row, 3).toString();
                          String giat = table.getValueAt(row, 4).toString();
                         String matg= table.getValueAt(row, 5).toString();
                         String matl= table.getValueAt(row, 7).toString();
                         String manxb = table.getValueAt(row, 9).toString();
                          String sol = table.getValueAt(row, 11).toString();
                          
                          
                            ms.setText(mas);
                         ts.setText(tens);
                         tt.setText(tomt);
                          st.setText(sot);
                         gt.setText(giat);
                            mtg.setSelectedItem(matg); 
                      mtl.setSelectedItem(matl); 
                         mnxb.setSelectedItem(manxb); 
       sl.setText(sol);
                     }
                 }
             }
         });
         
     }
      
      

        public List<sach_md> timkiemmasach(String ma){
        List<sach_md> listlop = new ArrayList<>();
        try{
            Connection conn = getConnection();
            Statement st = conn.createStatement();
           ResultSet rs = st.executeQuery("SELECT * FROM sach inner join tacgia1 on sach.matacgia=tacgia1.matacgia inner join theloai on theloai.matheloai=sach.matheloai inner join nhaxb on nhaxb.manhaxb=sach.manhaxb where sach.masach='"+ma+"'");
            while(rs.next()){
              sach_md a = new sach_md();
                tacgia_md b=new tacgia_md();
                  theloai_md c=new theloai_md();
                    nxb_md d=new nxb_md();
                    
                a.setMasach(rs.getString("masach"));
                a.setTensach(rs.getString("tensach"));
               a.setTomtatnoidung(rs.getString("tomtatnoidung"));
                a.setSotrang(rs.getInt("sotrang"));
                  a.setGiatien(rs.getFloat("giatien"));
                      a.setMatacgia(rs.getString("matacgia"));
                b.setTentg(rs.getString("tentacgia"));
                  a.setMatheloai(rs.getString("matheloai"));
                  c.setTentheloai(rs.getString("tentheloai"));
                    a.setManhaxb(rs.getString("manhaxb"));
                    d.setTennxb(rs.getString("tennhaxb"));
                       a.setSoluong(rs.getInt("soluong"));
                a.setTacgia(b);
                a.setTheloai(c);
                a.setNhaxuatban(d);
                listlop.add(a);
            } 
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return listlop;
    }
            public List<sach_md> timkiemtensach(String ten){
        List<sach_md> listlop = new ArrayList<>();
        try{
            Connection conn = getConnection();
            Statement st = conn.createStatement();
           ResultSet rs = st.executeQuery("SELECT * FROM sach inner join tacgia1 on sach.matacgia=tacgia1.matacgia inner join theloai on theloai.matheloai=sach.matheloai inner join nhaxb on nhaxb.manhaxb=sach.manhaxb where sach.tensach like N'"+ten+"'");
            while(rs.next()){
                sach_md a = new sach_md();
                tacgia_md b=new tacgia_md();
                  theloai_md c=new theloai_md();
                    nxb_md d=new nxb_md();
                    
                a.setMasach(rs.getString("masach"));
                a.setTensach(rs.getString("tensach"));
               a.setTomtatnoidung(rs.getString("tomtatnoidung"));
                a.setSotrang(rs.getInt("sotrang"));
                  a.setGiatien(rs.getFloat("giatien"));
                      a.setMatacgia(rs.getString("matacgia"));
                b.setTentg(rs.getString("tentacgia"));
                  a.setMatheloai(rs.getString("matheloai"));
                  c.setTentheloai(rs.getString("tentheloai"));
                    a.setManhaxb(rs.getString("manhaxb"));
                    d.setTennxb(rs.getString("tennhaxb"));
                       a.setSoluong(rs.getInt("soluong"));
                a.setTacgia(b);
                a.setTheloai(c);
                a.setNhaxuatban(d);
                listlop.add(a);
            } 
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return listlop;
    }
         public List<sach_md> timkiemtentacgia(String ten){
        List<sach_md> listlop = new ArrayList<>();
        try{
            Connection conn = getConnection();
            Statement st = conn.createStatement();
           ResultSet rs = st.executeQuery("SELECT * FROM sach inner join tacgia1 on sach.matacgia=tacgia1.matacgia inner join theloai on theloai.matheloai=sach.matheloai inner join nhaxb on nhaxb.manhaxb=sach.manhaxb where tacgia1.tentacgia like N'"+ten+"'");
            while(rs.next()){
               sach_md a = new sach_md();
                tacgia_md b=new tacgia_md();
                  theloai_md c=new theloai_md();
                    nxb_md d=new nxb_md();
                    
                a.setMasach(rs.getString("masach"));
                a.setTensach(rs.getString("tensach"));
               a.setTomtatnoidung(rs.getString("tomtatnoidung"));
                a.setSotrang(rs.getInt("sotrang"));
                  a.setGiatien(rs.getFloat("giatien"));
                      a.setMatacgia(rs.getString("matacgia"));
                b.setTentg(rs.getString("tentacgia"));
                  a.setMatheloai(rs.getString("matheloai"));
                  c.setTentheloai(rs.getString("tentheloai"));
                    a.setManhaxb(rs.getString("manhaxb"));
                    d.setTennxb(rs.getString("tennhaxb"));
                       a.setSoluong(rs.getInt("soluong"));
                a.setTacgia(b);
                a.setTheloai(c);
                a.setNhaxuatban(d);
                listlop.add(a);
            } 
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return listlop;
    }
          public List<sach_md> timkiemtentheloai(String ten){
        List<sach_md> listlop = new ArrayList<>();
        try{
            Connection conn = getConnection();
            Statement st = conn.createStatement();
           ResultSet rs = st.executeQuery("SELECT * FROM sach inner join tacgia1 on sach.matacgia=tacgia1.matacgia inner join theloai on theloai.matheloai=sach.matheloai inner join nhaxb on nhaxb.manhaxb=sach.manhaxb where theloai.tentheloai like N'"+ten+"'");
            while(rs.next()){
               sach_md a = new sach_md();
                tacgia_md b=new tacgia_md();
                  theloai_md c=new theloai_md();
                    nxb_md d=new nxb_md();
                    
                a.setMasach(rs.getString("masach"));
                a.setTensach(rs.getString("tensach"));
               a.setTomtatnoidung(rs.getString("tomtatnoidung"));
                a.setSotrang(rs.getInt("sotrang"));
                  a.setGiatien(rs.getFloat("giatien"));
                      a.setMatacgia(rs.getString("matacgia"));
                b.setTentg(rs.getString("tentacgia"));
                  a.setMatheloai(rs.getString("matheloai"));
                  c.setTentheloai(rs.getString("tentheloai"));
                    a.setManhaxb(rs.getString("manhaxb"));
                    d.setTennxb(rs.getString("tennhaxb"));
                       a.setSoluong(rs.getInt("soluong"));
                a.setTacgia(b);
                a.setTheloai(c);
                a.setNhaxuatban(d);
                listlop.add(a);
            } 
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return listlop;
    }
           public List<sach_md> timkiemtennhaxb(String ten){
        List<sach_md> listlop = new ArrayList<>();
        try{
            Connection conn = getConnection();
            Statement st = conn.createStatement();
           ResultSet rs = st.executeQuery("SELECT * FROM sach inner join tacgia1 on sach.matacgia=tacgia1.matacgia inner join theloai on theloai.matheloai=sach.matheloai inner join nhaxb on nhaxb.manhaxb=sach.manhaxb where nhaxb.tennhaxb like N'"+ten+"'");
            while(rs.next()){
               sach_md a = new sach_md();
                tacgia_md b=new tacgia_md();
                  theloai_md c=new theloai_md();
                    nxb_md d=new nxb_md();
                    
                a.setMasach(rs.getString("masach"));
                a.setTensach(rs.getString("tensach"));
               a.setTomtatnoidung(rs.getString("tomtatnoidung"));
                a.setSotrang(rs.getInt("sotrang"));
                  a.setGiatien(rs.getFloat("giatien"));
                      a.setMatacgia(rs.getString("matacgia"));
                b.setTentg(rs.getString("tentacgia"));
                  a.setMatheloai(rs.getString("matheloai"));
                  c.setTentheloai(rs.getString("tentheloai"));
                    a.setManhaxb(rs.getString("manhaxb"));
                    d.setTennxb(rs.getString("tennhaxb"));
                       a.setSoluong(rs.getInt("soluong"));
                a.setTacgia(b);
                a.setTheloai(c);
                a.setNhaxuatban(d);
                listlop.add(a);
            } 
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return listlop;
    }
        public boolean themsach(sach_md a){
            try{
                Connection conn = getConnection();
                Statement st = conn.createStatement();
                String sql = "INSERT INTO sach VALUES('"+a.getMasach()+"',N'"+a.getTensach()+"',N'"+a.getTomtatnoidung()+"','"+a.getSotrang()+"','"+a.getGiatien()+"','"+a.getMatacgia()+"','"+a.getMatheloai()+"','"+a.getManhaxb()+"','"+a.getSoluong()+"')";
                int b = st.executeUpdate(sql);
                return b> 0;
            }catch(SQLException ex){
                ex.printStackTrace();
                return false;
            }
        }
                public boolean suasach(sach_md b){
            try{
                Connection conn = getConnection();
                Statement st = conn.createStatement();
                String sql = "UPDATE sach SET  tensach=N'"+b.getTensach()+"',tomtatnoidung=N'"+b.getTomtatnoidung()+"',sotrang='"+b.getSotrang()+"',giatien='"+b.getGiatien()+"',matacgia='"+b.getMatacgia()+"',matheloai='"+b.getMatheloai()+"',manhaxb='"+b.getManhaxb()+"',soluong='"+b.getSoluong()+"' WHERE masach='"+b.getMasach()+"'";
                int a = st.executeUpdate(sql);
                return a> 0;
            }catch(SQLException ex){
                ex.printStackTrace();
                return false;
            }
        }
                        public boolean xoasach(sach_md b){
            try{
                Connection conn = getConnection();
                Statement st = conn.createStatement();
                String sql = "DELETE FROM  sach WHERE masach='"+b.getMasach()+"'";
                int a = st.executeUpdate(sql);
                return a> 0;
            }catch(SQLException ex){
                ex.printStackTrace();
                return false;
            }
        } 

 public boolean kiemTraSachTruocKhiThem(String maSach, int soLuong) {
    try {
        Connection conn = getConnection();
        Statement st = conn.createStatement();
        
        ResultSet rs = st.executeQuery("SELECT sach.soluong - COALESCE(SUM(p.soluong), 0) AS soluong_con_lai FROM sach LEFT JOIN phieumuon p ON sach.masach = p.masach WHERE sach.masach = '" + maSach + "' AND p.trangthai LIKE N'Chưa Trả' GROUP BY sach.masach, sach.soluong");
        
        if (rs.next()) {
            int soLuongConLai = rs.getInt("soluong_con_lai");
            return (soLuongConLai > 0 && soLuongConLai >= soLuong);
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    
    return false;
}
}
