/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ctl;

import model.khoa_md;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
public class khoa_ctl {
      public static String dbURL ="jdbc:sqlserver://127.0.0.1;databaseName=thuvien;user=vuthibac1106;password=111";
    public static Connection getConnection(){
        Connection conn = null;
        try{
            conn = DriverManager.getConnection(dbURL);
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return conn;
    }
     public List<khoa_md> loadkhoa(){
        List<khoa_md> listkhoa = new ArrayList<>();
        try{
            Connection conn = getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM khoa");
            while(rs.next()){
                khoa_md a = new khoa_md();
                a.setMakhoa(rs.getString("makhoa"));
                a.setTenkhoa(rs.getString("tenkhoa"));
                a.setGhichu(rs.getString("ghichu"));
                listkhoa.add(a);
            } 
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return listkhoa;
    }
      public void click(JTable table, JTextField mk,JTextField tk,JTextField gc){
         table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
    
             public void valueChanged(ListSelectionEvent e){
                 if(!e.getValueIsAdjusting()){
                     int row = table.getSelectedRow();
                     if( row != -1){
                         String makhoa = table.getValueAt(row, 0).toString();
                         String tenkhoa = table.getValueAt(row, 1).toString();
                         String ghichu = table.getValueAt(row, 2).toString();
                         mk.setText(makhoa);
                         tk.setText(tenkhoa);
                         gc.setText(ghichu);
                        
     
                     }
                 }
             }
         });
         
     }
      
      
      public List<khoa_md> addmakhoa(){
        List<khoa_md> listkhoa = new ArrayList<>();
        try{
            Connection conn = getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM khoa");
            while(rs.next()){
                khoa_md khach = new khoa_md();
                khach.setMakhoa(rs.getString("makhoa"));
                listkhoa.add(khach);
            } 
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return listkhoa;
    }
        public List<khoa_md> timkiemmakhoa(String makhoa){
        List<khoa_md> listkhoa = new ArrayList<>();
        try{
            Connection conn = getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM khoa WHERE makhoa='"+makhoa+"'");
            while(rs.next()){
                khoa_md a = new khoa_md();
                a.setMakhoa(rs.getString("makhoa"));
                a.setTenkhoa(rs.getString("tenkhoa"));
                a.setGhichu(rs.getString("ghichu"));
                listkhoa.add(a);
            } 
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return listkhoa;
    }
          public List<khoa_md> timkiemtenkhoa(String tenkhoa){
        List<khoa_md> listkhoa = new ArrayList<>();
        try{
            Connection conn = getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM khoa WHERE tenkhoa like N'"+tenkhoa+"'");
            while(rs.next()){
                khoa_md a = new khoa_md();
                a.setMakhoa(rs.getString("makhoa"));
                a.setTenkhoa(rs.getString("tenkhoa"));
                a.setGhichu(rs.getString("ghichu"));
                listkhoa.add(a);
            } 
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return listkhoa;
    }
        public boolean themkhoa(khoa_md khoa){
            try{
                Connection conn = getConnection();
                Statement st = conn.createStatement();
                String sql = "INSERT INTO khoa VALUES(N'"+khoa.getMakhoa()+"',N'"+khoa.getTenkhoa()+"',N'"+khoa.getGhichu()+"')";
                int a = st.executeUpdate(sql);
                return a> 0;
            }catch(SQLException ex){
                ex.printStackTrace();
                return false;
            }
        }
                public boolean suakhoa(khoa_md khach){
            try{
                Connection conn = getConnection();
                Statement st = conn.createStatement();
                String sql = "UPDATE khoa SET tenkhoa=N'"+khach.getTenkhoa()+"',ghichu=N'"+khach.getGhichu()+"' WHERE makhoa='"+khach.getMakhoa()+"'";
                int a = st.executeUpdate(sql);
                return a> 0;
            }catch(SQLException ex){
                ex.printStackTrace();
                return false;
            }
        }
                        public boolean xoakhoa(khoa_md khoa){
            try{
                Connection conn = getConnection();
                Statement st = conn.createStatement();
                String sql = "DELETE FROM  khoa WHERE makhoa=N'"+khoa.getMakhoa()+"'";
                int a = st.executeUpdate(sql);
                return a> 0;
            }catch(SQLException ex){
                ex.printStackTrace();
                return false;
            }
        }
}
