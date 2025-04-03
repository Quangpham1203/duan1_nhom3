/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author VIETTECH88
 */
public class ModelThuocTinhSanPham {
    private int maThuocTinh;
    private String tenThuocTinh;
    private String moTa;

    public ModelThuocTinhSanPham() {
    }

    public ModelThuocTinhSanPham(String tenThuocTinh) {
        this.tenThuocTinh = tenThuocTinh;
    }
    

    public ModelThuocTinhSanPham(int maThuocTinh, String tenThuocTinh, String moTa) {
        this.maThuocTinh = maThuocTinh;
        this.tenThuocTinh = tenThuocTinh;
        this.moTa = moTa;
    }

    public ModelThuocTinhSanPham(int maThuocTinh, String tenThuocTinh) {
        this.maThuocTinh = maThuocTinh;
        this.tenThuocTinh = tenThuocTinh;
    }

    public ModelThuocTinhSanPham(String tenThuocTinh, String moTa) {
        this.tenThuocTinh = tenThuocTinh;
        this.moTa = moTa;
    }
    
    
    
    

    public int getMaThuocTinh() {
        return maThuocTinh;
    }

    public void setMaThuocTinh(int maThuocTinh) {
        this.maThuocTinh = maThuocTinh;
    }

    public String getTenThuocTinh() {
        return tenThuocTinh;
    }

    public void setTenThuocTinh(String tenThuocTinh) {
        this.tenThuocTinh = tenThuocTinh;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }
    
    public Object[] toDataRow(){
        return new Object[]{
          this.getMaThuocTinh(), this.getTenThuocTinh(), this.getMoTa()
        };
    };
}
