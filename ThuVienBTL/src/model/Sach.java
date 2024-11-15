/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import model.NhaXuatBan;
import model.TacGia;
import model.TheLoai;

public class Sach {

    private String masach, tensach, tomtatnoidung;
    private int sotrang;
    private float giatien;
    private String matacgia, matheloai, manhaxb;
    private int soluong;
    private NhaXuatBan nhaxuatban;
    private TacGia tacgia;
    private TheLoai theloai;

    public NhaXuatBan getNhaxuatban() {
        return nhaxuatban;
    }

    public void setNhaxuatban(NhaXuatBan nhaxuatban) {
        this.nhaxuatban = nhaxuatban;
    }

    public TacGia getTacgia() {
        return tacgia;
    }

    public void setTacgia(TacGia tacgia) {
        this.tacgia = tacgia;
    }

    public TheLoai getTheloai() {
        return theloai;
    }

    public void setTheloai(TheLoai theloai) {
        this.theloai = theloai;
    }

    public Sach(String masach, String tensach, String tomtatnoidung, int sotrang, float giatien, String matacgia, String matheloai, String manhaxb, int soluong) {
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

    public Sach() {

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
