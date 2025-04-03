/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reposystory;

import Model.ModelThuocTinhSanPham;
import View.ViewQuanLiSanPham;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author VIETTECH88
 */
public class ThuocTinhSanPham {

    private Connection con;
    private ResultSet rs = null;
    private PreparedStatement ps = null;
    private DefaultTableModel mol = new DefaultTableModel();
    ViewQuanLiSanPham view;
    private String sql = null;

    public ThuocTinhSanPham() {
        con = DBConnect.getConnection();
    }

    public ThuocTinhSanPham(ViewQuanLiSanPham view) {
        con = DBConnect.getConnection();
        this.view = view;
    }

    public ArrayList<ModelThuocTinhSanPham> getAll(String type) {
        ArrayList<ModelThuocTinhSanPham> list = new ArrayList<>();
        if (type.equalsIgnoreCase("sanpham")) {
            sql = "SELECT ID, TenSanPham from SanPham";
        } else {
            sql = "SELECT * FROM " + type;
        }

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String tenThuocTinh = rs.getString(2);
                list.add(new ModelThuocTinhSanPham(id, tenThuocTinh));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return list;
    }

    public void filltableTTSP(ArrayList<ModelThuocTinhSanPham> list, JTable tbl) {
        mol = (DefaultTableModel) tbl.getModel();
        mol.setRowCount(0);

        for (ModelThuocTinhSanPham x : list) {
            mol.addRow(x.toDataRow());
        }

    }

    public int themThuocTinh(ModelThuocTinhSanPham t) {
        if(view.radio().equalsIgnoreCase("kichthuoc")){
            sql = "INSERT INTO " + view.radio() + "(" + view.radio() + ")" + " VALUES(?)";
        }else{
            sql = "INSERT INTO " + view.radio() + "(Ten" + view.radio() + ")" + " VALUES(?)";
        }
        try {
            ps = con.prepareStatement(sql);
            if (view.radio().equalsIgnoreCase("kichthuoc")) {

                ps.setInt(1, Integer.parseInt(t.getTenThuocTinh()));
            } else {
                ps.setString(1, t.getTenThuocTinh());
            }
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int suaThuocTinh(ModelThuocTinhSanPham t) {
        sql = "UPDATE " + view.radio() + " SET Ten" + view.radio() + " = ? WHERE ID = ?";
        try {
            ps = con.prepareStatement(sql);
            if (view.radio().equalsIgnoreCase("kichthuoc")) {

                ps.setInt(1, Integer.parseInt(t.getTenThuocTinh()));
            } else {
                ps.setString(1, t.getTenThuocTinh());
                ps.setObject(2, t.getMaThuocTinh());
            }
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public ModelThuocTinhSanPham readFormThuocTinhSanPham() {
        return new ModelThuocTinhSanPham(Integer.parseInt(view.getTxtMaThuocTinh().getText()), view.getTxtTenThuocTinh().getText(), view.radio());
    }
}
