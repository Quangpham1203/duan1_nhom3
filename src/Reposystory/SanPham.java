/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reposystory;

import Model.Model_DangNhap;
import Model.ModelSanPhamChiTiet;
import Model.Model_SanPham;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author hungb
 */
public class SanPham {

    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String sql = null;

    public SanPham() {
        con = DBConnect.getConnection();
    }

    public ArrayList<Model.Model_DangNhap> checkDangNhap(String DangNhap, String MatKhau) {
        ArrayList<Model.Model_DangNhap> listNv = new ArrayList<>();
        sql = "SELECT * \n"
                + "FROM NhanVien \n"
                + "WHERE TenDangNhap COLLATE Latin1_General_BIN = ? \n"
                + "AND MatKhau COLLATE Latin1_General_BIN = ?;";
        try {
            ps = con.prepareStatement(sql);
            ps.setObject(1, DangNhap);
            ps.setObject(2, MatKhau);
            rs = ps.executeQuery();
            while (rs.next()) {
                String dang_nhap, mat_khau;
                dang_nhap = rs.getString(1);
                mat_khau = rs.getString(2);
                listNv.add(new Model_DangNhap(dang_nhap, mat_khau));
            }
            return listNv;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<Model.Model_SanPham> getAllSanPham() {
        ArrayList<Model.Model_SanPham> listSp = new ArrayList<>();
        sql = """
              SELECT SanPham.ID, Hang.TenHang, TenSanPham FROM SanPham
                 INNER JOIN Hang ON SanPham.IDHang = Hang.ID
              """;
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int ID;
                String Hang, tenSp;
                ID = rs.getInt(1);
                Hang = rs.getString(2);
                tenSp = rs.getString(3);
                listSp.add(new Model_SanPham(ID, Hang, tenSp));
            }
            return listSp;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    

    public int themSanPham(Model_SanPham Sp_moi) {
        sql = "SELECT ID FROM Hang WHERE TenHang = ?";
        String addSP = """
                       INSERT INTO SanPham (IDHang, TenSanPham)
                       VALUES (?, ?);""";
        try {
            ps = con.prepareStatement(sql);
            ps.setObject(1, Sp_moi.getHang());
            rs = ps.executeQuery();
            int ID = 0;
            while(rs.next()){
                ID = rs.getInt("ID");
            }
            if(ID != 0){
                ps = con.prepareStatement(addSP);
                ps.setObject(1, ID);
                ps.setObject(2, Sp_moi.getTenSp());
                
                return ps.executeUpdate();
            }else{
                return 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    
    public int suaSanPham(Model_SanPham sua){
        sql="""
            UPDATE SanPham
            SET TenSanPham = ?,
            \tIDHang = (SELECT ID FROM Hang WHERE TenHang = ?) 
            WHERE ID = ?""";
        try {
            ps = con.prepareStatement(sql);
            ps.setObject(1, sua.getTenSp());
            ps.setObject(2, sua.getHang());
            ps.setObject(3, sua.getId());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    
    public ArrayList<Model.Model_Hang> getAllHang(){
        ArrayList<Model.Model_Hang> listHang = new ArrayList<>();
        sql="SELECT ID, TenHang FROM Hang;";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                int maHang;
                String tenHang;
                maHang = rs.getInt(1);
                tenHang = rs.getString(2);
                listHang.add(new Model.Model_Hang(maHang, tenHang));
            }
            return listHang;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    
}
