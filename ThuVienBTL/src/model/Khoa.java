/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

public class Khoa {

    private String makhoa, tenkhoa, ghichu;

    public Khoa(String makhoa, String tenkhoa, String ghichu) {
        this.makhoa = makhoa;
        this.tenkhoa = tenkhoa;
        this.ghichu = ghichu;
    }

    public Khoa() {

    }

    public String getMakhoa() {
        return makhoa;
    }

    public void setMakhoa(String makhoa) {
        this.makhoa = makhoa;
    }

    public String getTenkhoa() {
        return tenkhoa;
    }

    public void setTenkhoa(String tenkhoa) {
        this.tenkhoa = tenkhoa;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }
}
