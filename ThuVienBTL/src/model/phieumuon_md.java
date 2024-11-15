/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;
import model.sach_md;
import model.sv_md;
public class phieumuon_md {
 private String maphieumuon;
    private String masv;
    private String masach;
    private Date ngaymuon;
    private Date ngaytra;
    private int soluong;
    private String trangthai;
    private String ghichu;
private sach_md sach;
private sv_md sv;

 public phieumuon_md(String mapm, String masv, String mas, java.util.Date ngaymuonDate, java.util.Date ngaytraDate, int sol, String trangt, String ghic) {
    this.maphieumuon = mapm;
    this.masv = masv;
    this.masach = mas;
    this.ngaymuon = new Date(ngaymuonDate.getTime());
    this.ngaytra = new Date(ngaytraDate.getTime());
    this.soluong = sol;
    this.trangthai = trangt;
    this.ghichu = ghic;
}

    public sach_md getSach() {
        return sach;
    }

    public void setSach(sach_md sach) {
        this.sach = sach;
    }

    public sv_md getSv() {
        return sv;
    }

    public void setSv(sv_md sv) {
        this.sv = sv;
    }




    public phieumuon_md() {
 
    }

    public String getMaphieumuon() {
        return maphieumuon;
    }

    public void setMaphieumuon(String maphieumuon) {
        this.maphieumuon = maphieumuon;
    }

    public String getMasv() {
        return masv;
    }

    public void setMasv(String masv) {
        this.masv = masv;
    }

    public String getMasach() {
        return masach;
    }

    public void setMasach(String masach) {
        this.masach = masach;
    }

    public Date getNgaymuon() {
        return ngaymuon;
    }

    public void setNgaymuon(Date ngaymuon) {
        this.ngaymuon = ngaymuon;
    }

    public Date getNgaytra() {
        return ngaytra;
    }

    public void setNgaytra(Date ngaytra) {
        this.ngaytra = ngaytra;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }

 
}
