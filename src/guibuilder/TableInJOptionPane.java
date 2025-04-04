/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package guibuilder;

import javax.swing.*;
import java.awt.*;

public class TableInJOptionPane {
    public static void main(String[] args) {
        // Dữ liệu cho bảng
        String[][] data = {
            {"1", "Nguyễn Văn A", "20"},
            {"2", "Trần Thị B", "22"},
            {"3", "Lê Văn C", "21"}
        };
        
        // Tiêu đề cột
        String[] columnNames = {"ID", "Họ và Tên", "Tuổi"};
        
        // Tạo bảng
        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        
        // Hiển thị bảng trong JOptionPane
        JOptionPane.showMessageDialog(null, scrollPane, "Danh Sách Sinh Viên", JOptionPane.INFORMATION_MESSAGE);
    }
}
