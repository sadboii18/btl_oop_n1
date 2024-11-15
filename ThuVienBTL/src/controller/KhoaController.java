/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Khoa;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class KhoaController {

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

    public List<Khoa> loadkhoa() {
        List<Khoa> listkhoa = new ArrayList<>();
        try {
            Connection conn = getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM khoa");
            while (rs.next()) {
                Khoa a = new Khoa();
                a.setMakhoa(rs.getString("makhoa"));
                a.setTenkhoa(rs.getString("tenkhoa"));
                a.setGhichu(rs.getString("ghichu"));
                listkhoa.add(a);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listkhoa;
    }

    public void click(JTable table, JTextField mk, JTextField tk, JTextField gc) {
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int row = table.getSelectedRow();
                    if (row != -1) {
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

    public List<Khoa> addmakhoa() {
        List<Khoa> listkhoa = new ArrayList<>();
        try {
            Connection conn = getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM khoa");
            while (rs.next()) {
                Khoa khach = new Khoa();
                khach.setMakhoa(rs.getString("makhoa"));
                listkhoa.add(khach);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listkhoa;
    }

    public List<Khoa> timkiemmakhoa(String makhoa) {
        List<Khoa> listkhoa = new ArrayList<>();
        try {
            Connection conn = getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM khoa WHERE makhoa='" + makhoa + "'");
            while (rs.next()) {
                Khoa a = new Khoa();
                a.setMakhoa(rs.getString("makhoa"));
                a.setTenkhoa(rs.getString("tenkhoa"));
                a.setGhichu(rs.getString("ghichu"));
                listkhoa.add(a);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listkhoa;
    }

    public List<Khoa> timkiemtenkhoa(String tenkhoa) {
        List<Khoa> listkhoa = new ArrayList<>();
        try {
            Connection conn = getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM khoa WHERE tenkhoa like N'" + tenkhoa + "'");
            while (rs.next()) {
                Khoa a = new Khoa();
                a.setMakhoa(rs.getString("makhoa"));
                a.setTenkhoa(rs.getString("tenkhoa"));
                a.setGhichu(rs.getString("ghichu"));
                listkhoa.add(a);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listkhoa;
    }

    public boolean themkhoa(Khoa khoa) {
        try {
            Connection conn = getConnection();
            Statement st = conn.createStatement();
            String sql = "INSERT INTO khoa VALUES(N'" + khoa.getMakhoa() + "',N'" + khoa.getTenkhoa() + "',N'" + khoa.getGhichu() + "')";
            int a = st.executeUpdate(sql);
            return a > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean suakhoa(Khoa khach) {
        try {
            Connection conn = getConnection();
            Statement st = conn.createStatement();
            String sql = "UPDATE khoa SET tenkhoa=N'" + khach.getTenkhoa() + "',ghichu=N'" + khach.getGhichu() + "' WHERE makhoa='" + khach.getMakhoa() + "'";
            int a = st.executeUpdate(sql);
            return a > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean xoakhoa(Khoa khoa) {
        try {
            Connection conn = getConnection();
            Statement st = conn.createStatement();
            String sql = "DELETE FROM  khoa WHERE makhoa=N'" + khoa.getMakhoa() + "'";
            int a = st.executeUpdate(sql);
            return a > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
