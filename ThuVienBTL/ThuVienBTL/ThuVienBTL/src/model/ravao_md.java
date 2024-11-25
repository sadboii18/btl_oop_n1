/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;
import model.sv_md;
import model.lop_md;
public class ravao_md {
    private String ma,tgvao,tgra,masv,noidung,ghichu;
    private Date ngay;
private sv_md sv;
private lop_md lop;

    public sv_md getSv() {
        return sv;
    }

    public void setSv(sv_md sv) {
        this.sv = sv;
    }

    public lop_md getLop() {
        return lop;
    }

    public void setLop(lop_md lop) {
        this.lop = lop;
    }
    public ravao_md(String ma, java.util.Date ngay1, String tgvao, String tgra, String masv,String noidung, String ghichu) {
        this.ma = ma;
        this.ngay = new java.sql.Date(ngay1.getTime());
        this.tgvao = tgvao;
        this.tgra = tgra;
        this.masv = masv;
  
        this.noidung = noidung;
        this.ghichu = ghichu;
    }
      public ravao_md() {
    
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
