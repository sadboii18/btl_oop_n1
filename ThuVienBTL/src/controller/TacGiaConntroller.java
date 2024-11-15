/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.TacGia;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class TacGiaConntroller {

    public static String dbURL = "jdbc:sqlserver://127.0.0.1;databaseName=thuvien;user=sa;password=123";

    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(dbURL);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return conn;
    }

    public List<TacGia> addmatacgia() {
        List<TacGia> listkhoa = new ArrayList<>();
        try {
            Connection conn = getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM tacgia1");
            while (rs.next()) {
                TacGia khach = new TacGia();
                khach.setMatg(rs.getString("matacgia"));
                listkhoa.add(khach);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listkhoa;
    }
}
