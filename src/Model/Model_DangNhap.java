/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author hungb
 */
public class Model_DangNhap {
    private String dang_nhap, mat_khau;

    public Model_DangNhap() {
    }

    public Model_DangNhap(String dang_nhap, String mat_khau) {
        this.dang_nhap = dang_nhap;
        this.mat_khau = mat_khau;
    }

    public String getDang_nhap() {
        return dang_nhap;
    }

    public void setDang_nhap(String dang_nhap) {
        this.dang_nhap = dang_nhap;
    }

    public String getMat_khau() {
        return mat_khau;
    }

    public void setMat_khau(String mat_khau) {
        this.mat_khau = mat_khau;
    }
    
    public Object[] toDataRow(){
        return new Object[]{
            this.getDang_nhap(),this.getMat_khau()
        };
    }
}
