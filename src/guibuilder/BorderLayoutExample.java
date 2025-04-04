/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package guibuilder;

/**
 *
 * @author VIETTECH88
 */
import javax.swing.*;
import java.awt.*;

public class BorderLayoutExample {
    public static void main(String[] args) {
        // Tạo frame
        JFrame frame = new JFrame("BorderLayout Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        // Tạo panel bên trái
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new GridLayout(10, 1)); // 10 nút xếp dọc
        leftPanel.setPreferredSize(new Dimension(136, 600)); // 17% của 800px là khoảng 136px

        // Thêm 10 nút vào panel bên trái
        for (int i = 1; i <= 10; i++) {
            JButton button = new JButton("Button " + i);
            leftPanel.add(button);
        }

        // Thêm panel vào frame
        frame.add(leftPanel, BorderLayout.WEST);
        frame.add(new JPanel(), BorderLayout.CENTER); // Phần trung tâm trống

        // Hiển thị frame
        frame.setVisible(true);
    }
}

