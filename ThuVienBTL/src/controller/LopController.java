/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Lop;
import model.Khoa;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class LopController {
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
    public List<Lop> loadlop(){
        List<Lop> listlop = new ArrayList<>();
        try{
            Connection conn = getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM lop inner join khoa on khoa.makhoa=lop.makhoa");
            while(rs.next()){
                Lop a = new Lop();
                Khoa b=new Khoa();
                
                a.setMalop(rs.getString("malop"));
                a.setTenlop(rs.getString("tenlop"));
                 b.setTenkhoa(rs.getString("tenkhoa"));
                a.setGhichu(rs.getString("ghichu"));
                a.setKhoa(b);
                listlop.add(a);
            } 
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return listlop;
    }
    public void click(JTable table,JComboBox mk, JTextField ml,JTextField tl,JTextField gc){
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
    
            public void valueChanged(ListSelectionEvent e){
                if(!e.getValueIsAdjusting()){
                    int row = table.getSelectedRow();
                    if( row != -1){
                        
                        String malop = table.getValueAt(row, 0).toString();
                        String tenlop = table.getValueAt(row, 1).toString();
                        String makhoa = table.getValueAt(row, 2).toString();
                        String ghichu = table.getValueAt(row, 3).toString();
                        mk.setSelectedItem(makhoa); 
                        ml.setText(malop);
                        tl.setText(tenlop);
                        gc.setText(ghichu);
                    }
                }
            }
        });     
    }
      
      

    public List<Lop> timkiemmalop(String malop){
        List<Lop> listlop = new ArrayList<>();
        try{
            Connection conn = getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM lop inner join khoa on khoa.makhoa=lop.makhoa where malop='"+malop+"'");
            while(rs.next()){
                Lop a = new Lop();
                Khoa b=new Khoa();   
                a.setMalop(rs.getString("malop"));
                a.setTenlop(rs.getString("tenlop"));
                    b.setTenkhoa(rs.getString("tenkhoa"));
                a.setGhichu(rs.getString("ghichu"));
                a.setKhoa(b);
                listlop.add(a);
            } 
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return listlop;
    }
    public List<Lop> timkiemtenlop(String tenlop){
        List<Lop> listlop = new ArrayList<>();
        try{
            Connection conn = getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM lop inner join khoa on khoa.makhoa=lop.makhoa where tenlop='"+tenlop+"'");
            while(rs.next()){
                Lop a = new Lop();
                Khoa b=new Khoa();   
                a.setMalop(rs.getString("malop"));
                a.setTenlop(rs.getString("tenlop"));
                    b.setTenkhoa(rs.getString("tenkhoa"));
                a.setGhichu(rs.getString("ghichu"));
                a.setKhoa(b);
                listlop.add(a);
            } 
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return listlop;
    }
    public List<Lop> timkiemtenkhoa(String tenkhoa){
        List<Lop> listlop = new ArrayList<>();
        try{
            Connection conn = getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM lop inner join khoa on khoa.makhoa=lop.makhoa where khoa.tenkhoa like N'"+tenkhoa+"'");
            while(rs.next()){
                Lop a = new Lop();
                Khoa b=new Khoa();   
                a.setMalop(rs.getString("malop"));
                a.setTenlop(rs.getString("tenlop"));
                    b.setTenkhoa(rs.getString("tenkhoa"));
                a.setGhichu(rs.getString("ghichu"));
                a.setKhoa(b);
                listlop.add(a);
            } 
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return listlop;
    }
    
    
    public List<Lop> timkiemmakhoa(String tenkhoa){
        List<Lop> listlop = new ArrayList<>();
        try{
            Connection conn = getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM lop inner join khoa on khoa.makhoa=lop.makhoa where khoa.makhoa ='"+tenkhoa+"'");
            while(rs.next()){
                Lop a = new Lop();
                Khoa b=new Khoa();   
                a.setMalop(rs.getString("malop"));
                a.setTenlop(rs.getString("tenlop"));
                b.setTenkhoa(rs.getString("tenkhoa"));
                a.setGhichu(rs.getString("ghichu"));
                a.setKhoa(b);
                listlop.add(a);
            } 
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return listlop;
    }
        public boolean themlop(Lop a){
            try{
                Connection conn = getConnection();
                Statement st = conn.createStatement();
                String sql = "INSERT INTO lop VALUES('"+a.getMalop()+"',N'"+a.getTenlop()+"',N'"+a.getGhichu()+"','"+a.getMakhoa()+"')";
                int b = st.executeUpdate(sql);
                return b> 0;
            }catch(SQLException ex){
                ex.printStackTrace();
                return false;
            }
        }
        public boolean sualop(Lop b){
            try{
                Connection conn = getConnection();
                Statement st = conn.createStatement();
                String sql = "UPDATE lop SET  tenlop=N'"+b.getTenlop()+"',ghichu=N'"+b.getGhichu()+"',makhoa='"+b.getMakhoa()+"' WHERE malop='"+b.getMalop()+"'";
                int a = st.executeUpdate(sql);
                return a> 0;
            }catch(SQLException ex){
                ex.printStackTrace();
                return false;
            }
        }
                        public boolean xoalop(Lop b){
            try{
                Connection conn = getConnection();
                Statement st = conn.createStatement();
                String sql = "DELETE FROM  lop WHERE malop='"+b.getMalop()+"'";
                int a = st.executeUpdate(sql);
                return a> 0;
            }catch(SQLException ex){
                ex.printStackTrace();
                return false;
            }
        } 
}
