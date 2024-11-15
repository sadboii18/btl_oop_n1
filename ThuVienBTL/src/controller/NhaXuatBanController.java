/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.NhaXuatBan;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
public class NhaXuatBanController {
     public static String dbURL ="jdbc:sqlserver://127.0.0.1;databaseName=thuvien;user=sa;password=123";
    public static Connection getConnection(){
        Connection conn = null;
        try{
            conn = DriverManager.getConnection(dbURL);
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return conn;
    }
     public List<NhaXuatBan> loadnxb(){
        List<NhaXuatBan> listlop = new ArrayList<>();
        try{
            Connection conn = getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM nhaxb");
            while(rs.next()){
                NhaXuatBan a = new NhaXuatBan();
               
                
                a.setManxb(rs.getString("manhaxb"));
                a.setTennxb(rs.getString("tennhaxb"));
                a.setDiachi(rs.getString("diachi"));
                a.setSdt(rs.getString("sdt"));
               a.setGhichu(rs.getString("ghichu"));
              
                listlop.add(a);
            } 
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return listlop;
    }
      public void click(JTable table, JTextField mn,JTextField tn,JTextField dc, JTextField sdt,JTextField gc){
         table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
    
             public void valueChanged(ListSelectionEvent e){
                 if(!e.getValueIsAdjusting()){
                     int row = table.getSelectedRow();
                     if( row != -1){
                        
                          String man = table.getValueAt(row, 0).toString();
                         String tenn = table.getValueAt(row, 1).toString();
                         String diac = table.getValueAt(row, 2).toString();
                         String sdtt = table.getValueAt(row, 3).toString();
                          String ghic = table.getValueAt(row, 4).toString();
                            mn.setText(man); 
                        tn.setText(tenn);
                        dc.setText(diac);
                         sdt.setText(sdtt);
                           gc.setText(ghic);
     
                     }
                 }
             }
         });
         
     }
      
      
  public List<NhaXuatBan> addmanxb(){
        List<NhaXuatBan> listkhoa = new ArrayList<>();
        try{
            Connection conn = getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM nhaxb");
            while(rs.next()){
                NhaXuatBan khach = new NhaXuatBan();
                khach.setManxb(rs.getString("manhaxb"));
                listkhoa.add(khach);
            } 
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return listkhoa;
    }
        public List<NhaXuatBan> timkiemmanxb(String ma){
        List<NhaXuatBan> listlop = new ArrayList<>();
        try{
            Connection conn = getConnection();
            Statement st = conn.createStatement();
           ResultSet rs = st.executeQuery("SELECT * FROM nhaxb where manhaxb='"+ma+"'");
           while(rs.next()){
                NhaXuatBan a = new NhaXuatBan();
               
                
                a.setManxb(rs.getString("manhaxb"));
                a.setTennxb(rs.getString("tennhaxb"));
                a.setDiachi(rs.getString("diachi"));
                a.setSdt(rs.getString("sdt"));
               a.setGhichu(rs.getString("ghichu"));
              
                listlop.add(a);
            
            } 
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return listlop;
    }
            public List<NhaXuatBan> timkiemtennxb(String ten){
        List<NhaXuatBan> listlop = new ArrayList<>();
        try{
            Connection conn = getConnection();
            Statement st = conn.createStatement();
           ResultSet rs = st.executeQuery("SELECT * FROM nhaxb where tennhaxb like N'"+ten+"'");
            while(rs.next()){
                 NhaXuatBan a = new NhaXuatBan();
               
                
                a.setManxb(rs.getString("manhaxb"));
                a.setTennxb(rs.getString("tennhaxb"));
                a.setDiachi(rs.getString("diachi"));
                a.setSdt(rs.getString("sdt"));
               a.setGhichu(rs.getString("ghichu"));
              
                listlop.add(a);
            } 
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return listlop;
    }
         public List<NhaXuatBan> timkiemdiachi(String d){
        List<NhaXuatBan> listlop = new ArrayList<>();
        try{
            Connection conn = getConnection();
            Statement st = conn.createStatement();
           ResultSet rs = st.executeQuery("SELECT * FROM nhaxb where diachi='"+d+"'");
            while(rs.next()){
                NhaXuatBan a = new NhaXuatBan();
               
                
                a.setManxb(rs.getString("manhaxb"));
                a.setTennxb(rs.getString("tennhaxb"));
                a.setDiachi(rs.getString("diachi"));
                a.setSdt(rs.getString("sdt"));
                a.setGhichu(rs.getString("ghichu"));
              
                listlop.add(a);
            }       
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return listlop;
    }
        public boolean themnxb(NhaXuatBan a){
            try{
                Connection conn = getConnection();
                Statement st = conn.createStatement();
                String sql = "INSERT INTO nhaxb VALUES('"+a.getManxb()+"',N'"+a.getTennxb()+"',N'"+a.getDiachi()+"','"+a.getSdt()+"',N'"+a.getGhichu()+"')";
                int b = st.executeUpdate(sql);
                return b> 0;
            }catch(SQLException ex){
                ex.printStackTrace();
                return false;
            }
        }
                public boolean suanxb(NhaXuatBan b){
            try{
                Connection conn = getConnection();
                Statement st = conn.createStatement();
                String sql = "UPDATE nhaxb SET  tennhaxb=N'"+b.getTennxb()+"',diachi=N'"+b.getDiachi()+"',sdt='"+b.getSdt()+"',ghichu=N'"+b.getGhichu()+"' WHERE manhaxb='"+b.getManxb()+"'";
                int a = st.executeUpdate(sql);
                return a> 0;
            }catch(SQLException ex){
                ex.printStackTrace();
                return false;
            }
        }
                        public boolean xoanxb(NhaXuatBan b){
            try{
                Connection conn = getConnection();
                Statement st = conn.createStatement();
                String sql = "DELETE FROM  nhaxb WHERE manhaxb='"+b.getManxb()+"'";
                int a = st.executeUpdate(sql);
                return a> 0;
            }catch(SQLException ex){
                ex.printStackTrace();
                return false;
            }
        } 
}
