/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.toedter.calendar.JDateChooser;
import model.Sach;
import model.SinhVien;
import model.PhieuMuon;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Date;
import javax.swing.*;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class PhieuMuonController {

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

    public List<PhieuMuon> loadphieumuon() {
        List<PhieuMuon> listlop = new ArrayList<>();
        try {
            Connection conn = getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM phieumuon inner join sv on sv.masv=phieumuon.masv inner join sach on phieumuon.masach=sach.masach order by phieumuon.maphieumuon ASC ");
            while (rs.next()) {
                PhieuMuon a = new PhieuMuon();
                SinhVien b = new SinhVien();
                Sach c = new Sach();

                a.setMaphieumuon(rs.getString("maphieumuon"));
                a.setMasv(rs.getString("masv"));
                b.setTensv(rs.getString("tensv"));
                a.setMasach(rs.getString("masach"));
                c.setTensach(rs.getString("tensach"));
                a.setNgaymuon(rs.getDate("ngaymuon"));
                a.setNgaytra(rs.getDate("ngaytra"));
                a.setSoluong(rs.getInt("soluong"));
                c.setGiatien(rs.getInt("giatien"));
                a.setTrangthai(rs.getString("trangthai"));
                a.setGhichu(rs.getString("ghichu"));
                a.setSv(b);
                a.setSach(c);
                listlop.add(a);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listlop;
    }

    public List<PhieuMuon> loadphieumuonquahan() {
        List<PhieuMuon> listlop = new ArrayList<>();
        try {
            Connection conn = getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM phieumuon inner join sv on sv.masv=phieumuon.masv inner join sach on phieumuon.masach=sach.masach order by phieumuon.maphieumuon ASC ");

            Date ngayHienTai = new Date(); // Ngày hiện tại

            while (rs.next()) {
                Date ngayTra = rs.getDate("ngaytra");
                String trangThai = rs.getString("trangthai");

                // Kiểm tra xem ngày trả đã quá hạn và trạng thái là "chưa trả"
                if (ngayTra != null && ngayTra.before(ngayHienTai) && trangThai.equals("Chưa Trả")) {
                    PhieuMuon a = new PhieuMuon();
                    SinhVien b = new SinhVien();
                    Sach c = new Sach();

                    a.setMaphieumuon(rs.getString("maphieumuon"));
                    a.setMasv(rs.getString("masv"));
                    b.setTensv(rs.getString("tensv"));
                    a.setMasach(rs.getString("masach"));
                    c.setTensach(rs.getString("tensach"));
                    a.setNgaymuon(rs.getDate("ngaymuon"));
                    a.setNgaytra(new java.sql.Date(ngayTra.getTime())); // Gán ngày trả
                    a.setSoluong(rs.getInt("soluong"));
                    c.setGiatien(rs.getInt("giatien"));
                    a.setTrangthai(trangThai); // Gán trạng thái
                    a.setGhichu(rs.getString("ghichu"));
                    a.setSv(b);
                    a.setSach(c);
                    listlop.add(a);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listlop;
    }

    public List<PhieuMuon> loadphieumuondangmuonsach() {
        List<PhieuMuon> listlop = new ArrayList<>();
        try {
            Connection conn = getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM phieumuon inner join sv on sv.masv=phieumuon.masv inner join sach on phieumuon.masach=sach.masach where trangthai like N'Chưa Trả' order by phieumuon.maphieumuon ASC ");
            while (rs.next()) {
                PhieuMuon a = new PhieuMuon();
                SinhVien b = new SinhVien();
                Sach c = new Sach();

                a.setMaphieumuon(rs.getString("maphieumuon"));
                a.setMasv(rs.getString("masv"));
                b.setTensv(rs.getString("tensv"));
                a.setMasach(rs.getString("masach"));
                c.setTensach(rs.getString("tensach"));
                a.setNgaymuon(rs.getDate("ngaymuon"));
                a.setNgaytra(rs.getDate("ngaytra"));
                a.setSoluong(rs.getInt("soluong"));
                c.setGiatien(rs.getInt("giatien"));
                a.setTrangthai(rs.getString("trangthai"));
                a.setGhichu(rs.getString("ghichu"));
                a.setSv(b);
                a.setSach(c);
                listlop.add(a);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listlop;
    }

    public List<PhieuMuon> loadtongsoluongsachdangmuontheotungmasach() {
        List<PhieuMuon> listlop = new ArrayList<>();
        try {
            Connection conn = getConnection();
            Statement st = conn.createStatement();
//        ResultSet rs = st.executeQuery("SELECT phieumuon.masach, SUM(phieumuon.soluong) AS total FROM phieumuon inner join sv on sv.masv=phieumuon.masv inner join sach on phieumuon.masach=sach.masach trangthai like N'Chưa Trả' GROUP BY phieumuon.masach");
            ResultSet rs = st.executeQuery("SELECT phieumuon.masach,phieumuon.trangthai, SUM(phieumuon.soluong) AS total FROM phieumuon  INNER JOIN sach ON phieumuon.masach = sach.masach WHERE trangthai LIKE N'Chưa Trả' GROUP BY phieumuon.masach,phieumuon.trangthai order by phieumuon.masach ASC");
            while (rs.next()) {
                Sach c = new Sach();
                PhieuMuon a = new PhieuMuon();
                a.setMasach(rs.getString("masach"));

                a.setTrangthai(rs.getString("trangthai"));
                a.setSoluong(rs.getInt("total"));

                listlop.add(a);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listlop;
    }

    public List<PhieuMuon> loadtongsoluongsachconlaitheomasach() {
        List<PhieuMuon> listlop = new ArrayList<>();
        try {
            Connection conn = getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT  sach.masach,sach.soluong - (SELECT COALESCE(SUM(p.soluong), 0) FROM phieumuon p WHERE p.masach = sach.masach and trangthai like N'Chưa Trả') AS soluong_con_lai FROM sach order by sach.masach ASC ");
            while (rs.next()) {
                Sach c = new Sach();
                PhieuMuon a = new PhieuMuon();
                a.setMasach(rs.getString("masach"));

                a.setSoluong(rs.getInt("soluong_con_lai"));

                listlop.add(a);
                a.setSach(c);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listlop;
    }

    public void click(JTable table, JTextField mpm, JTextField msv, JComboBox ms, JDateChooser nm, JDateChooser nt, JTextField sl, JComboBox tt, JTextField gc, JLabel a) {
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int row = table.getSelectedRow();
                    if (row != -1) {

                        String mapm = table.getValueAt(row, 0).toString();
                        String masv = table.getValueAt(row, 1).toString();
                        String mas = table.getValueAt(row, 3).toString();
                        Date ngaym = (Date) table.getValueAt(row, 5);
                        Date ngayt = (Date) table.getValueAt(row, 6);
                        String sol = table.getValueAt(row, 7).toString();
                        String trangt = table.getValueAt(row, 9).toString();
                        String ghic = table.getValueAt(row, 10).toString();
                        String coct = table.getValueAt(row, 11).toString();

                        mpm.setText(mapm);
                        msv.setText(masv);
                        ms.setSelectedItem(mas);
                        nm.setDate(ngaym);
                        nt.setDate(ngayt);
                        sl.setText(sol);
                        tt.setSelectedItem(trangt);
                        gc.setText(ghic);
                        a.setText(coct);
                    }
                }
            }
        });

    }

    public List<PhieuMuon> timkiemmaphieumuon(String ma) {
        List<PhieuMuon> listlop = new ArrayList<>();
        try {
            Connection conn = getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM phieumuon inner join sv on sv.masv=phieumuon.masv inner join sach on phieumuon.masach=sach.masach where phieumuon.maphieumuon='" + ma + "'");
            while (rs.next()) {
                PhieuMuon a = new PhieuMuon();
                SinhVien b = new SinhVien();
                Sach c = new Sach();

                a.setMaphieumuon(rs.getString("maphieumuon"));
                a.setMasv(rs.getString("masv"));
                b.setTensv(rs.getString("tensv"));
                a.setMasach(rs.getString("masach"));
                c.setTensach(rs.getString("tensach"));
                a.setNgaymuon(rs.getDate("ngaymuon"));
                a.setNgaytra(rs.getDate("ngaytra"));
                a.setSoluong(rs.getInt("soluong"));
                c.setGiatien(rs.getInt("giatien"));
                a.setTrangthai(rs.getString("trangthai"));
                a.setGhichu(rs.getString("ghichu"));

                a.setSv(b);
                a.setSach(c);
                listlop.add(a);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listlop;
    }

    public List<PhieuMuon> timkiemmasv(String ma) {
        List<PhieuMuon> listlop = new ArrayList<>();
        try {
            Connection conn = getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM phieumuon inner join sv on sv.masv=phieumuon.masv inner join sach on phieumuon.masach=sach.masach where sv.masv = '" + ma + "'");
            while (rs.next()) {
                PhieuMuon a = new PhieuMuon();
                SinhVien b = new SinhVien();
                Sach c = new Sach();

                a.setMaphieumuon(rs.getString("maphieumuon"));
                a.setMasv(rs.getString("masv"));
                b.setTensv(rs.getString("tensv"));
                a.setMasach(rs.getString("masach"));
                c.setTensach(rs.getString("tensach"));
                a.setNgaymuon(rs.getDate("ngaymuon"));
                a.setNgaytra(rs.getDate("ngaytra"));
                a.setSoluong(rs.getInt("soluong"));
                c.setGiatien(rs.getInt("giatien"));
                a.setTrangthai(rs.getString("trangthai"));
                a.setGhichu(rs.getString("ghichu"));
                a.setSv(b);
                a.setSach(c);
                listlop.add(a);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listlop;
    }

    public List<PhieuMuon> timkiemmasach(String ma) {
        List<PhieuMuon> listlop = new ArrayList<>();
        try {
            Connection conn = getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM phieumuon inner join sv on sv.masv=phieumuon.masv inner join sach on phieumuon.masach=sach.masach where sach.masach ='" + ma + "'");
            while (rs.next()) {
                PhieuMuon a = new PhieuMuon();
                SinhVien b = new SinhVien();
                Sach c = new Sach();
                a.setMaphieumuon(rs.getString("maphieumuon"));
                a.setMasv(rs.getString("masv"));
                b.setTensv(rs.getString("tensv"));
                a.setMasach(rs.getString("masach"));
                c.setTensach(rs.getString("tensach"));
                a.setNgaymuon(rs.getDate("ngaymuon"));
                a.setNgaytra(rs.getDate("ngaytra"));
                a.setSoluong(rs.getInt("soluong"));
                c.setGiatien(rs.getInt("giatien"));
                a.setTrangthai(rs.getString("trangthai"));
                a.setGhichu(rs.getString("ghichu"));
                a.setSv(b);
                a.setSach(c);
                listlop.add(a);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listlop;
    }

    public List<PhieuMuon> timkiemtensach(String ten) {
        List<PhieuMuon> listlop = new ArrayList<>();
        try {
            Connection conn = getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM phieumuon inner join sv on sv.masv=phieumuon.masv inner join sach on phieumuon.masach=sach.masach where sach.tensach like N'" + ten + "'");
            while (rs.next()) {
                PhieuMuon a = new PhieuMuon();
                SinhVien b = new SinhVien();
                Sach c = new Sach();

                a.setMaphieumuon(rs.getString("maphieumuon"));
                a.setMasv(rs.getString("masv"));
                b.setTensv(rs.getString("tensv"));
                a.setMasach(rs.getString("masach"));
                c.setTensach(rs.getString("tensach"));
                a.setNgaymuon(rs.getDate("ngaymuon"));
                a.setNgaytra(rs.getDate("ngaytra"));
                a.setSoluong(rs.getInt("soluong"));
                c.setGiatien(rs.getInt("giatien"));
                a.setTrangthai(rs.getString("trangthai"));
                a.setGhichu(rs.getString("ghichu"));
                a.setSv(b);
                a.setSach(c);
                listlop.add(a);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listlop;
    }

    public List<PhieuMuon> timkiemtrangthai(String tt) {
        List<PhieuMuon> listlop = new ArrayList<>();
        try {
            Connection conn = getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM phieumuon inner join sv on sv.masv=phieumuon.masv inner join sach on phieumuon.masach=sach.masach where phieumuon.trangthai like N'" + tt + "'");
            while (rs.next()) {
                PhieuMuon a = new PhieuMuon();
                SinhVien b = new SinhVien();
                Sach c = new Sach();

                a.setMaphieumuon(rs.getString("maphieumuon"));
                a.setMasv(rs.getString("masv"));
                b.setTensv(rs.getString("tensv"));
                a.setMasach(rs.getString("masach"));
                c.setTensach(rs.getString("tensach"));
                a.setNgaymuon(rs.getDate("ngaymuon"));
                a.setNgaytra(rs.getDate("ngaytra"));
                a.setSoluong(rs.getInt("soluong"));
                c.setGiatien(rs.getInt("giatien"));
                a.setTrangthai(rs.getString("trangthai"));
                a.setGhichu(rs.getString("ghichu"));
                a.setSv(b);
                a.setSach(c);
                listlop.add(a);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listlop;
    }

//    public boolean themphieumuon(phieumuon_md a) {
//        try {
//            Connection conn = getConnection();
//            Statement st = conn.createStatement();
//              SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        String ngaymuon = dateFormat.format(a.getNgaymuon());
//        String ngaytra = dateFormat.format(a.getNgaytra());
//            String sql = "INSERT INTO phieumuon VALUES('" + a.getMaphieumuon() + "','" + a.getMasv() + "','" + a.getMasach() + "','" + ngaymuon + "','" + ngaytra + "','" + a.getSoluong() + "',N'" + a.getTrangthai() + "',N'" + a.getGhichu() + "')";
//            int b = st.executeUpdate(sql);
//            return b > 0;
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//            return false;
//        }
//    }
    public static boolean themphieumuon(PhieuMuon phieumuon) {
        boolean isSuccess = false;
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = getConnection(); // Lấy connection từ nguồn dữ liệu
            String sql = "INSERT INTO phieumuon (maphieumuon, masv, masach, ngaymuon, ngaytra, soluong, trangthai, ghichu) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1, phieumuon.getMaphieumuon());
            statement.setString(2, phieumuon.getMasv());
            statement.setString(3, phieumuon.getMasach());
            statement.setDate(4, phieumuon.getNgaymuon());
            statement.setDate(5, phieumuon.getNgaytra());
            statement.setInt(6, phieumuon.getSoluong());
            statement.setString(7, phieumuon.getTrangthai());
            statement.setString(8, phieumuon.getGhichu());

            int rowsInserted = statement.executeUpdate();
            isSuccess = rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return isSuccess;
    }

//    public boolean suaphieumuon(phieumuon_md b) {
//        try {
//            Connection conn = getConnection();
//            Statement st = conn.createStatement();
//            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//            String ngaymuon = dateFormat.format(b.getNgaymuon());
//            String ngaytra = dateFormat.format(b.getNgaytra());
//            String sql = "UPDATE phieumuon SET  masv='" + b.getMasv() + "',masach='" + b.getMasach() + "',ngaymuon='" + ngaymuon + "',ngaytra='" + ngaytra + "',soluong='" + b.getSoluong() + "',trangthai=N'" + b.getTrangthai() + "',ghichu=N'" + b.getGhichu() + "' WHERE maphieumuon='" + b.getMaphieumuon() + "' and masv='" + b.getMasv() + "'  and masach='" + b.getMasach() + "'and ngaymuon='" + b.getNgaymuon() + "' and ngaytra='" + b.getNgaytra() + "'";
//            int a = st.executeUpdate(sql);
//            return a > 0;
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//            return false;
//        }
//    }
    public static boolean suaphieumuon(PhieuMuon phieumuon) {
        boolean isSuccess = false;
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = getConnection(); // Lấy connection từ nguồn dữ liệu
            String sql = "UPDATE phieumuon SET masv = ?, masach = ?, ngaymuon = ?, ngaytra = ?, soluong = ?, trangthai = ?, ghichu = ? WHERE maphieumuon = ? AND masach = ? AND ngaymuon = ?  AND masv = ? ";
            statement = connection.prepareStatement(sql);
            statement.setString(1, phieumuon.getMasv());
            statement.setString(2, phieumuon.getMasach());
            statement.setDate(3, phieumuon.getNgaymuon());
            statement.setDate(4, phieumuon.getNgaytra());
            statement.setInt(5, phieumuon.getSoluong());
            statement.setString(6, phieumuon.getTrangthai());
            statement.setString(7, phieumuon.getGhichu());
            statement.setString(8, phieumuon.getMaphieumuon());
            statement.setString(9, phieumuon.getMasach());
            statement.setDate(10, phieumuon.getNgaymuon());

            statement.setString(11, phieumuon.getMasv());

            int rowsUpdated = statement.executeUpdate();
            isSuccess = rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return isSuccess;
    }
//    public boolean xoaphieumuon(phieumuon_md b) {
//        try {
//            Connection conn = getConnection();
//            Statement st = conn.createStatement();
//            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//            String ngaymuon = dateFormat.format(b.getNgaymuon());
//            String ngaytra = dateFormat.format(b.getNgaytra());
//            String sql = "DELETE FROM  phieumuon WHERE maphieumuon='" + b.getMaphieumuon() + "' and masv='" + b.getMasv() + "' and masach='" + b.getMasach() + "' and soluong='" + b.getSoluong() + "' and ngaymuon='" + ngaymuon + "' and ngaytra='" + ngaytra + "'";
//            int a = st.executeUpdate(sql);
//            return a > 0;
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//            return false;
//        }
//    }

    public static boolean xoasphieumuon(PhieuMuon phieumuon) {
        boolean isSuccess = false;
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = getConnection(); // Lấy connection từ nguồn dữ liệu
            String sql = "DELETE FROM phieumuon WHERE maphieumuon = ? AND masv = ? AND ngaymuon = ? AND ngaytra = ? AND soluong = ? AND masach = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, phieumuon.getMaphieumuon());
            statement.setString(2, phieumuon.getMasv());
            statement.setDate(3, phieumuon.getNgaymuon());
            statement.setDate(4, phieumuon.getNgaytra());
            statement.setInt(5, phieumuon.getSoluong());
            statement.setString(6, phieumuon.getMasach());

            int rowsDeleted = statement.executeUpdate();
            isSuccess = rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return isSuccess;
    }

    public int getTongSoSachTheoMaSinhVien(String maSinhVien) {
        try {
            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT SUM(soluong) AS tongSoSach FROM phieumuon WHERE masv = ? AND trangthai like =N'Chưa Trả'  group by masv'");
            ps.setString(1, maSinhVien);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int tongSoSach = rs.getInt("tongSoSach");
                if (tongSoSach <= 5) {
                    return tongSoSach;
                } else {
                    return 0;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

}
