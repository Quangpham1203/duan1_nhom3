/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reposystory;
import java.sql.*;
import Model.*;
import java.util.ArrayList;
/**
 *
 * @author VIETTECH88
 */
public class SanPhamChiTiet {
    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String sql = null;

    public SanPhamChiTiet() {
        con = DBConnect.getConnection();
    }
    
    
    public ArrayList<ModelSanPhamChiTiet> getAllSPCT() {
        ArrayList<ModelSanPhamChiTiet> listSp = new ArrayList<>();
        sql =   """
                SELECT A.ID, B.TenSanPham, C.TenMauSac, D.KichThuoc, E.TenChatLieu, F.TenCongNghe, A.SoLuong, A.DonGia, A.TrangThai FROM SanPhamChiTiet A
                INNER JOIN SanPham B ON A.IDSanPham = B.ID
                INNER JOIN MauSac C ON A.IDMauSac = C.ID
                INNER JOIN KichThuoc D ON A.IDKichThuoc = D.ID
                INNER JOIN ChatLieu E ON A.IDChatLieu = E.ID
                INNER JOIN CongNghe F ON A.IDCongNghe = F.ID;""";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int ID, soLuong;
                String tenSP, mauSac, kichThuoc, chatLieu, congNghe;
                double donGia;
                boolean trangThai;
                ID = rs.getInt(1);
                tenSP = rs.getString(2);
                mauSac = rs.getString(3);
                kichThuoc = rs.getString(4);
                chatLieu = rs.getString(5);
                congNghe = rs.getString(6);
                soLuong = rs.getInt(7);
                donGia = rs.getDouble(8);
                trangThai =  rs.getBoolean(9);
                listSp.add(new ModelSanPhamChiTiet(ID, tenSP, mauSac, kichThuoc, chatLieu, congNghe, soLuong, donGia, trangThai));
            }
            return listSp;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
