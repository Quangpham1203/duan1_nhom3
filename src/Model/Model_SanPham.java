/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author hungb
 */
public class Model_SanPham {
    private int id;
    private String hang, tenSp;

    public Model_SanPham() {
    }

    public Model_SanPham(String hang, String tenSp) {
        this.hang = hang;
        this.tenSp = tenSp;
    }

    public Model_SanPham(int id, String hang, String tenSp) {
        this.id = id;
        this.hang = hang;
        this.tenSp = tenSp;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHang() {
        return hang;
    }

    public void setHang(String hang) {
        this.hang = hang;
    }

    public String getTenSp() {
        return tenSp;
    }

    public void setTenSp(String tenSp) {
        this.tenSp = tenSp;
    }

    
    
    public Object[] toDataRow(){
        return new Object[]{
            this.getId(), this.getHang(), this.getTenSp()
        };
    }
}
