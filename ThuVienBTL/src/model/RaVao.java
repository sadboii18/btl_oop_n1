/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;
import model.SinhVien;
import model.Lop;

public class RaVao {

    private String ma, tgvao, tgra, masv, noidung, ghichu;
    private Date ngay;
    private SinhVien sv;
    private Lop lop;

    public SinhVien getSv() {
        return sv;
    }

    public void setSv(SinhVien sv) {
        this.sv = sv;
    }

    public Lop getLop() {
        return lop;
    }

    public void setLop(Lop lop) {
        this.lop = lop;
    }

    public RaVao(String ma, java.util.Date ngay1, String tgvao, String tgra, String masv, String noidung, String ghichu) {
        this.ma = ma;
        this.ngay = new java.sql.Date(ngay1.getTime());
        this.tgvao = tgvao;
        this.tgra = tgra;
        this.masv = masv;

        this.noidung = noidung;
        this.ghichu = ghichu;
    }

    public RaVao() {

    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public Date getNgay() {
        return ngay;
    }

    public void setNgay(Date ngay) {
        this.ngay = ngay;
    }

    public String getTgvao() {
        return tgvao;
    }

    public void setTgvao(String tgvao) {
        this.tgvao = tgvao;
    }

    public String getTgra() {
        return tgra;
    }

    public void setTgra(String tgra) {
        this.tgra = tgra;
    }

    public String getMasv() {
        return masv;
    }

    public void setMasv(String masv) {
        this.masv = masv;
    }

//    public String getMalop() {
//        return malop;
//    }
//
//    public void setMalop(String malop) {
//        this.malop = malop;
//    }
    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }
}
