/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.toedter.calendar.JDateChooser;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import model.SinhVien;
import model.Lop;
import model.RaVao;

public class RaVaoController {

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

    public List<RaVao> loadravao() {
        List<RaVao> listlop = new ArrayList<>();
        try {
            Connection conn = getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM ravao inner join sv on sv.masv=ravao.masv inner join lop on lop.malop=sv.malop");
            while (rs.next()) {
                RaVao a = new RaVao();
                Lop b = new Lop();
                SinhVien c = new SinhVien();
                a.setMa(rs.getString("ma"));
                a.setNgay(rs.getDate("ngay"));
                a.setTgvao(rs.getString("tgvao"));
                a.setTgra(rs.getString("tgra"));
                a.setMasv(rs.getString("masv"));
                c.setTensv(rs.getString("tensv"));
//                 b.setMalop(rs.getString("malop"));
                b.setTenlop(rs.getString("tenlop"));
                a.setNoidung(rs.getString("noidung"));
                a.setGhichu(rs.getString("ghichu"));
                a.setSv(c);
                a.setLop(b);
                listlop.add(a);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listlop;
    }

    public void click(JTable table, JTextField m, JDateChooser n, JComboBox tgv, JComboBox tgr, JTextField msv, JTextField nd, JTextField gc) {
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int row = table.getSelectedRow();
                    if (row != -1) {
                        String ma = table.getValueAt(row, 0).toString();
                        Date ngay = (Date) table.getValueAt(row, 1);
                        String tgvao = table.getValueAt(row, 2).toString();
                        String tgra = table.getValueAt(row, 3).toString();
                        String masv = table.getValueAt(row, 4).toString();

                        String noidung = table.getValueAt(row, 7).toString();
                        String ghichu = table.getValueAt(row, 8).toString();

                        m.setText(ma);
                        n.setDate(ngay);
                        tgv.setSelectedItem(tgvao);
                        tgr.setSelectedItem(tgra);
                        msv.setText(masv);

                        nd.setText(noidung);
                        gc.setText(ghichu);
                    }
                }
            }
        });
    }

    public List<RaVao> timkiemma(String ma) {
        List<RaVao> listlop = new ArrayList<>();
        try {
            Connection conn = getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM ravao inner join lop on lop.malop=ravao.malop inner join sv on sv.masv=ravao.masv where ravao.ma='" + ma + "'");
            while (rs.next()) {
                RaVao a = new RaVao();
//                lop_md b=new lop_md();
                SinhVien c = new SinhVien();
                a.setMa(rs.getString("ma"));
                a.setNgay(rs.getDate("ngay"));
                a.setTgvao(rs.getString("tgvao"));
                a.setTgra(rs.getString("tgra"));
                a.setMasv(rs.getString("masv"));
                c.setTensv(rs.getString("tensv"));
                c.setMalop(rs.getString("malop"));
//                b.setTenlop(rs.getString("tenlop"));
                a.setNoidung(rs.getString("noidung"));
                a.setGhichu(rs.getString("ghichu"));
                a.setSv(c);
//                a.setLop(b);
                listlop.add(a);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listlop;
    }

    public List<RaVao> timkiemngay(String ten) {
        List<RaVao> listlop = new ArrayList<>();
        try {
            Connection conn = getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM ravao inner join lop on lop.malop=ravao.malop inner join sv on sv.masv=ravao.masv where ravao.ngay='" + ten + "'");
            while (rs.next()) {
                RaVao a = new RaVao();
//                lop_md b=new lop_md();
                SinhVien c = new SinhVien();
                a.setMa(rs.getString("ma"));
                a.setNgay(rs.getDate("ngay"));
                a.setTgvao(rs.getString("tgvao"));
                a.setTgra(rs.getString("tgra"));
                a.setMasv(rs.getString("masv"));
                c.setTensv(rs.getString("tensv"));
                c.setMalop(rs.getString("malop"));
//                b.setTenlop(rs.getString("tenlop"));
                a.setNoidung(rs.getString("noidung"));
                a.setGhichu(rs.getString("ghichu"));
                a.setSv(c);
//                a.setLop(b);
                listlop.add(a);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listlop;
    }

    public List<RaVao> timkiemmalop(String khoa) {
        List<RaVao> listlop = new ArrayList<>();
        try {
            Connection conn = getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM ravao inner join lop on lop.malop=ravao.malop inner join sv on sv.masv=ravao.masv where ravao.malop='" + khoa + "'");
            while (rs.next()) {
                RaVao a = new RaVao();
//                lop_md b=new lop_md();
                SinhVien c = new SinhVien();
                a.setMa(rs.getString("ma"));
                a.setNgay(rs.getDate("ngay"));
                a.setTgvao(rs.getString("tgvao"));
                a.setTgra(rs.getString("tgra"));
                a.setMasv(rs.getString("masv"));
                c.setTensv(rs.getString("tensv"));
                c.setMalop(rs.getString("malop"));
//                b.setTenlop(rs.getString("tenlop"));
                a.setNoidung(rs.getString("noidung"));
                a.setGhichu(rs.getString("ghichu"));
                a.setSv(c);
//                a.setLop(b);
                listlop.add(a);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listlop;
    }

    public List<RaVao> timkiemmasv(String sv) {
        List<RaVao> listlop = new ArrayList<>();
        try {
            Connection conn = getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM ravao inner join lop on lop.malop=ravao.malop inner join sv on sv.masv=ravao.masv where sv.masv='" + sv + "'");
            while (rs.next()) {
                RaVao a = new RaVao();
//                lop_md b=new lop_md();
                SinhVien c = new SinhVien();
                a.setMa(rs.getString("ma"));
                a.setNgay(rs.getDate("ngay"));
                a.setTgvao(rs.getString("tgvao"));
                a.setTgra(rs.getString("tgra"));
                a.setMasv(rs.getString("masv"));
                c.setTensv(rs.getString("tensv"));
                c.setMalop(rs.getString("malop"));
//                b.setTenlop(rs.getString("tenlop"));
                a.setNoidung(rs.getString("noidung"));
                a.setGhichu(rs.getString("ghichu"));
                a.setSv(c);
//                a.setLop(b);
                listlop.add(a);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listlop;
    }

    public boolean checkmasv(String studentID) {
        // Kết nối đến cơ sở dữ liệu hoặc nguồn dữ liệu lưu trữ thông tin sinh viên
        Connection conn = getConnection();

        try {
            // Chuẩn bị câu truy vấn SQL để kiểm tra sự tồn tại của mã sinh viên
            String sql = "SELECT COUNT(*) FROM sv WHERE masv = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, studentID);

            // Thực thi truy vấn và lấy kết quả
            ResultSet rs = stmt.executeQuery();
            rs.next();
            int count = rs.getInt(1);

            // Nếu có ít nhất 1 bản ghi, thì mã sinh viên tồn tại
            return count > 0;
        } catch (SQLException e) {
            // Xử lý lỗi kết nối cơ sở dữ liệu
            e.printStackTrace();
            return false;
        } finally {
            // Đóng kết nối
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean them(RaVao a) {
        boolean isSuccess = false;
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = getConnection(); // Lấy connection từ nguồn dữ liệu
            String sql = "INSERT INTO ravao (ma, ngay, tgvao, tgra, masv,  noidung, ghichu) VALUES (?, ?, ?, ?, ?, ?, ?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1, a.getMa());
            statement.setDate(2, new java.sql.Date(a.getNgay().getTime()));
            statement.setString(3, a.getTgvao());
            statement.setString(4, a.getTgra());
            statement.setString(5, a.getMasv());
//        statement.setString(6, a.getMalop());
            statement.setString(6, a.getNoidung());
            statement.setString(7, a.getGhichu());

            int rowsInserted = statement.executeUpdate();
            isSuccess = rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return isSuccess;
    }

    public boolean sua(RaVao b) {
        try {
            Connection conn = getConnection();
            Statement st = conn.createStatement();
            String sql = "UPDATE ravao SET ngay='" + b.getNgay() + "', tgvao='" + b.getTgvao() + "',tgra='" + b.getTgra() + "',masv='" + b.getMasv() + "',noidung=N'" + b.getNoidung() + "',ghichu='" + b.getGhichu() + "' WHERE ma='" + b.getMa() + "'";
            int a = st.executeUpdate(sql);
            return a > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean xoa(RaVao b) {
        try {
            Connection conn = getConnection();
            Statement st = conn.createStatement();
            String sql = "DELETE FROM  ravao WHERE ma='" + b.getMa() + "'";
            int a = st.executeUpdate(sql);
            return a > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
