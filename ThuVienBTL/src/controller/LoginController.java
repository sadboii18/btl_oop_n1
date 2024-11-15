/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;
import model.Login;
import view.TrangChuView;
import view.AdminView;
public class LoginController {
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
   
    public boolean login(String maNguoiDung, String matKhau){
        try{
        Connection conn = getConnection();
        String sql ="SELECT * FROM nguoidung WHERE manguoidung='"+maNguoiDung+"' AND matkhau='"+matKhau+"'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
                if (rs.next()) {
                    String chucDanh= rs.getString(3);
                
                    if (chucDanh.equals("AD")) {
                        AdminView f= new AdminView();
                        f.show();
                        return true;
                    }
                    if(chucDanh.equals("TT")) {
                        TrangChuView f = new TrangChuView();
                        f.show();
                        return true;
                    }

                }
           
        }catch(SQLException ex){
            ex.printStackTrace();
       }
       return false;
    }
    public boolean suamk(Login khach){
        try{
            Connection conn = getConnection();
            Statement st = conn.createStatement();
            String sql = "UPDATE nguoidung SET matkhau='"+khach.getMatkhau()+"' WHERE manguoidung='"+khach.getMangdung()+"'";
            int a = st.executeUpdate(sql);
            return a> 0;
        }catch(SQLException ex){
            ex.printStackTrace();
            return false;
        }
    }
}
