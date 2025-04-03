/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reposystory;

import Model.*;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author VIETTECH88
 */
public class HoaDon {

    View.ViewHoaDon view;
    private Connection con;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String sql = null;

    public HoaDon(View.ViewHoaDon viewHoaDon) {
        con = DBConnect.getConnection();
        this.view = viewHoaDon;
    }

    public ArrayList<ModelHoaDon> danhSachHoaDon() {
        ArrayList<ModelHoaDon> list = new ArrayList<>();
        try {
            sql = "SELECT * FROM DanhSachHoaDon";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Integer maHoaDon = rs.getInt(1);
                String tenKhachHang = rs.getString(2);
                String maNhanVien = rs.getString(3);
                String maKhuyenMai = rs.getString(4);
                String ngayMuaHang = rs.getString(5);
                Integer tongTien = rs.getInt(6);
                Integer giaSauGiam = rs.getInt(7);
                boolean trangThai = rs.getBoolean(8);
                list.add(new ModelHoaDon(maHoaDon, tenKhachHang, maNhanVien, maKhuyenMai, ngayMuaHang, tongTien, giaSauGiam, true));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return list;
    }

    public ArrayList<ModelHoaDonChiTiet> danhSachHoaDonChiTiet(int index) {
        ArrayList<ModelHoaDonChiTiet> list = new ArrayList<>();
        try {
            sql = """
                  SELECT hdct.ID as MaHoaDonChiTiet, SP.TenSanPham, HD.ID as MaHoaDon, HDCT.SoLuong, HDCT.DonGia
                  FROM HoaDon HD
                  JOIN HoaDonChiTiet HDCT ON HDCT.IDHoaDon = HD.ID
                  JOIN SanPham SP ON HDCT.IDSanPhamChiTiet = SP.ID
                  JOIN KhachHang KH ON HD.IDKhachHang = KH.ID  
                  JOIN NhanVien NV ON HD.IDNhanVien = NV.ID  
                  JOIN KhuyenMai KM ON HD.IDKhuyenMai = KM.ID
                  WHERE HDCT.IDHoaDon = ?
                  """;
            ps = con.prepareStatement(sql);
            ps.setInt(1, index);
            rs = ps.executeQuery();
            while (rs.next()) {
                int maHoaDonChiTiet = rs.getInt(1);
                String tenSanPham = rs.getString(2);
                int maHoaDon = rs.getInt(3);
                int soLuong = rs.getInt(4);
                int donGia = rs.getInt(5);
                list.add(new ModelHoaDonChiTiet(maHoaDonChiTiet, tenSanPham, maHoaDon, soLuong, donGia));
            }
            }catch (Exception e) {
                e.printStackTrace();
                return null;
        }
        return list;
        }

 }
