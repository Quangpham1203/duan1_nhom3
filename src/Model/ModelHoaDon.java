/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author VIETTECH88
 */
public class ModelHoaDon {
    private Integer maHoaDon;
    private String tenKhachHang;
    private String maNhanVien;
    private String maKhuyenMai;
    private String ngayMuaHang;
    private Integer tongTien;
    private Integer giaSauGiam;
    private boolean trangThai;

    public ModelHoaDon() {
    }

    public ModelHoaDon(Integer maHoaDon, String tenKhachHang, String maNhanVien, String maKhuyenMai, String ngayMuaHang, Integer tongTien, Integer giaSauGiam, boolean trangThai) {
        this.maHoaDon = maHoaDon;
        this.tenKhachHang = tenKhachHang;
        this.maNhanVien = maNhanVien;
        this.maKhuyenMai = maKhuyenMai;
        this.ngayMuaHang = ngayMuaHang;
        this.tongTien = tongTien;
        this.giaSauGiam = giaSauGiam;
        this.trangThai = trangThai;
    }

    public Integer getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(int maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getMaKhuyenMai() {
        return maKhuyenMai;
    }

    public void setMaKhuyenMai(String maKhuyenMai) {
        this.maKhuyenMai = maKhuyenMai;
    }

    public String getNgayMuaHang() {
        return ngayMuaHang;
    }

    public void setNgayMuaHang(String ngayMuaHang) {
        this.ngayMuaHang = ngayMuaHang;
    }

    public Integer getTongTien() {
        return tongTien;
    }

    public void setTongTien(Integer tongTien) {
        this.tongTien = tongTien;
    }

    public Integer getGiaSauGiam() {
        return giaSauGiam;
    }

    public void setGiaSauGiam(Integer giaSauGiam) {
        this.giaSauGiam = giaSauGiam;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

   

    @Override
    public String toString() {
       if(trangThai == false){
           return "Chưa thanh toán";
       }else{
           return "Đã thanh toán";
       }
    }
    
    public Object[] toDataRow(){
        return new Object[]{
          this.getMaHoaDon(), this.getTenKhachHang(), this.getMaNhanVien(), this.getMaKhuyenMai()
                ,this.getNgayMuaHang(), this.getTongTien(), this.getGiaSauGiam(), toString()
        };
    }
}
