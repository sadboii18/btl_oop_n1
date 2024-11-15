/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ctl;
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
import model.login_md;
import view.trangchu;
import view.Admin;
public class login_ctl {
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
   
     public boolean login(String mangdung, String matkhau){
       try{
       Connection conn = getConnection();
       String sql ="SELECT * FROM nguoidung WHERE manguoidung='"+mangdung+"' AND matkhau='"+matkhau+"'";
           Statement st = conn.createStatement();
           ResultSet rs = st.executeQuery(sql);
             if (rs.next())
                {
                   String chucdanh= rs.getString(3);
                  
                    if (chucdanh.equals("AD")) {
                        Admin f= new Admin();
                        f.show();
                    return true;
                    }
  if(chucdanh.equals("TT"))
                    {
                        trangchu f= new trangchu();
                        f.show();
                 
                    return true;
                    }

                }
           
       }catch(SQLException ex){
           ex.printStackTrace();
       }
       return false;
   }
        public boolean suamk(login_md khach){
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
