/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.TheLoai;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class TheLoaiController {

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

    public List<TheLoai> loadtheloai() {
        List<TheLoai> listlop = new ArrayList<>();
        try {
            Connection conn = getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM theloai ");
            while (rs.next()) {
                TheLoai a = new TheLoai();

                a.setMatheloai(rs.getString("matheloai"));
                a.setTentheloai(rs.getString("tentheloai"));

                a.setGhichu(rs.getString("ghichu"));

                listlop.add(a);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listlop;
    }

    public void click(JTable table, JTextField ml, JTextField tl, JTextField gc) {
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int row = table.getSelectedRow();
                    if (row != -1) {

                        String matl = table.getValueAt(row, 0).toString();
                        String tentl = table.getValueAt(row, 1).toString();

                        String ghichu = table.getValueAt(row, 2).toString();

                        ml.setText(matl);
                        tl.setText(tentl);
                        gc.setText(ghichu);

                    }
                }
            }
        });

    }

    public List<TheLoai> addmatheloai() {
        List<TheLoai> listkhoa = new ArrayList<>();
        try {
            Connection conn = getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM theloai");
            while (rs.next()) {
                TheLoai khach = new TheLoai();
                khach.setMatheloai(rs.getString("matheloai"));
                listkhoa.add(khach);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listkhoa;
    }

    public List<TheLoai> timkiemmatheloai(String ma) {
        List<TheLoai> listlop = new ArrayList<>();
        try {
            Connection conn = getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM theloai where matheloai='" + ma + "'");
            while (rs.next()) {
                TheLoai a = new TheLoai();

                a.setMatheloai(rs.getString("matheloai"));
                a.setTentheloai(rs.getString("tentheloai"));

                a.setGhichu(rs.getString("ghichu"));

                listlop.add(a);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listlop;
    }

    public List<TheLoai> timkiemtentheloai(String ten) {
        List<TheLoai> listlop = new ArrayList<>();
        try {
            Connection conn = getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM theloai where tentheloai like N'" + ten + "'");
            while (rs.next()) {
                TheLoai a = new TheLoai();

                a.setMatheloai(rs.getString("matheloai"));
                a.setTentheloai(rs.getString("tentheloai"));

                a.setGhichu(rs.getString("ghichu"));

                listlop.add(a);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return listlop;
    }

    public boolean themtheloai(TheLoai a) {
        try {
            Connection conn = getConnection();
            Statement st = conn.createStatement();
            String sql = "INSERT INTO theloai VALUES('" + a.getMatheloai() + "',N'" + a.getTentheloai() + "',N'" + a.getGhichu() + "')";
            int b = st.executeUpdate(sql);
            return b > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean suatheloai(TheLoai b) {
        try {
            Connection conn = getConnection();
            Statement st = conn.createStatement();
            String sql = "UPDATE theloai SET  tentheloai=N'" + b.getTentheloai() + "',ghichu=N'" + b.getGhichu() + "' WHERE matheloai='" + b.getMatheloai() + "'";
            int a = st.executeUpdate(sql);
            return a > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean xoatheloai(TheLoai b) {
        try {
            Connection conn = getConnection();
            Statement st = conn.createStatement();
            String sql = "DELETE FROM  theloai WHERE matheloai='" + b.getMatheloai() + "'";
            int a = st.executeUpdate(sql);
            return a > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
