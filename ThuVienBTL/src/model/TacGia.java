/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

public class TacGia {

    private String matg, tentg, gioitinh;
    private String namsinh, nammat;
    private String quequan, ghichu;

    public TacGia(String matg, String tentg, String gioitinh, String namsinh, String nammat, String ghichu) {
        this.matg = matg;
        this.tentg = tentg;
        this.gioitinh = gioitinh;
        this.namsinh = namsinh;
        this.nammat = nammat;
        this.ghichu = ghichu;
    }

    public TacGia() {

    }

    public String getMatg() {
        return matg;
    }

    public void setMatg(String matg) {
        this.matg = matg;
    }

    public String getTentg() {
        return tentg;
    }

    public void setTentg(String tentg) {
        this.tentg = tentg;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getNamsinh() {
        return namsinh;
    }

    public void setNamsinh(String namsinh) {
        this.namsinh = namsinh;
    }

    public String getNammat() {
        return nammat;
    }

    public void setNammat(String nammat) {
        this.nammat = nammat;
    }

    public String getQuequan() {
        return quequan;
    }

    public void setQuequan(String quequan) {
        this.quequan = quequan;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }

}
