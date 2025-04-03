/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author VIETTECH88
 */
public class ModelHoaDonChiTiet {

    private int maHoaDonChiTiet;
    private String tenSanPham;
    private int maHoaDon;
    private int soLuong;
    private int donGia;

    public ModelHoaDonChiTiet() {
    }

    public ModelHoaDonChiTiet(int maHoaDonChiTiet, String tenSanPham, int maHoaDon, int soLuong, int donGia) {
        this.maHoaDonChiTiet = maHoaDonChiTiet;
        this.tenSanPham = tenSanPham;
        this.maHoaDon = maHoaDon;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public int getMaHoaDonChiTiet() {
        return maHoaDonChiTiet;
    }

    public void setMaHoaDonChiTiet(int maHoaDonChiTiet) {
        this.maHoaDonChiTiet = maHoaDonChiTiet;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public int getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(int maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }
    
    public Object[] toDataRow(){
        return new Object[]{
          this.getMaHoaDonChiTiet(), this.getTenSanPham(), this.getMaHoaDon(), this.getSoLuong(), this.getDonGia()
        };
    }
}
