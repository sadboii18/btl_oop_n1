/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


public class theloai_md {
    private String matheloai,tentheloai,ghichu;

    public theloai_md(String matheloai, String tentheloai, String ghichu) {
        this.matheloai = matheloai;
        this.tentheloai = tentheloai;
        this.ghichu = ghichu;
    }
     public theloai_md() {
     
    }

    public String getMatheloai() {
        return matheloai;
    }

    public void setMatheloai(String matheloai) {
        this.matheloai = matheloai;
    }

    public String getTentheloai() {
        return tentheloai;
    }

    public void setTentheloai(String tentheloai) {
        this.tentheloai = tentheloai;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }
}
