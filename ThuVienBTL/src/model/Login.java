/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

public class Login {

    private String mangdung, matkhau;

    public Login(String mangdung, String matkhau) {
        this.mangdung = mangdung;
        this.matkhau = matkhau;

    }

    public Login() {

    }

    public String getMangdung() {
        return mangdung;
    }

    public void setMangdung(String mangdung) {
        this.mangdung = mangdung;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

}
