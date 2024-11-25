/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import model.khoa_md;
public class lop_md {
    private String malop,tenlop,ghichu,makhoa;
private khoa_md khoa;

    public khoa_md getKhoa() {
        return khoa;
    }

    public void setKhoa(khoa_md khoa) {
        this.khoa = khoa;
    }
    public lop_md(String malop, String tenlop, String ghichu, String makhoa) {
        this.malop = malop;
        this.tenlop = tenlop;
        this.ghichu = ghichu;
        this.makhoa = makhoa;
    }
      public lop_md() {
     
    }

    public String getMalop() {
        return malop;
    }

    public void setMalop(String malop) {
        this.malop = malop;
    }

    public String getTenlop() {
        return tenlop;
    }

    public void setTenlop(String tenlop) {
        this.tenlop = tenlop;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }

    public String getMakhoa() {
        return makhoa;
    }

    public void setMakhoa(String makhoa) {
        this.makhoa = makhoa;
    }
}
