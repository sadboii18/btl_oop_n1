/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import model.nxb_md;
import model.tacgia_md;
import model.theloai_md;
public class sach_md {
  private String masach,tensach,tomtatnoidung;
  private int sotrang;
  private float giatien;
  private String matacgia,matheloai,manhaxb;
  private int soluong;
private nxb_md nhaxuatban;
private tacgia_md tacgia;
private theloai_md theloai;

    public nxb_md getNhaxuatban() {
        return nhaxuatban;
    }

    public void setNhaxuatban(nxb_md nhaxuatban) {
        this.nhaxuatban = nhaxuatban;
    }

    public tacgia_md getTacgia() {
        return tacgia;
    }

    public void setTacgia(tacgia_md tacgia) {
        this.tacgia = tacgia;
    }

    public theloai_md getTheloai() {
        return theloai;
    }

    public void setTheloai(theloai_md theloai) {
        this.theloai = theloai;
    }
    public sach_md(String masach, String tensach, String tomtatnoidung, int sotrang, float giatien, String matacgia, String matheloai, String manhaxb, int soluong) {
        this.masach = masach;
        this.tensach = tensach;
        this.tomtatnoidung = tomtatnoidung;
        this.sotrang = sotrang;
        this.giatien = giatien;
        this.matacgia = matacgia;
        this.matheloai = matheloai;
        this.manhaxb = manhaxb;
        this.soluong = soluong;
    }
      public sach_md() {
       
    }

    public String getMasach() {
        return masach;
    }

    public void setMasach(String masach) {
        this.masach = masach;
    }

    public String getTensach() {
        return tensach;
    }

    public void setTensach(String tensach) {
        this.tensach = tensach;
    }

    public String getTomtatnoidung() {
        return tomtatnoidung;
    }

    public void setTomtatnoidung(String tomtatnoidung) {
        this.tomtatnoidung = tomtatnoidung;
    }

    public int getSotrang() {
        return sotrang;
    }

    public void setSotrang(int sotrang) {
        this.sotrang = sotrang;
    }

    public float getGiatien() {
        return giatien;
    }

    public void setGiatien(float giatien) {
        this.giatien = giatien;
    }

    public String getMatacgia() {
        return matacgia;
    }

    public void setMatacgia(String matacgia) {
        this.matacgia = matacgia;
    }

    public String getMatheloai() {
        return matheloai;
    }

    public void setMatheloai(String matheloai) {
        this.matheloai = matheloai;
    }

    public String getManhaxb() {
        return manhaxb;
    }

    public void setManhaxb(String manhaxb) {
        this.manhaxb = manhaxb;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }
}
