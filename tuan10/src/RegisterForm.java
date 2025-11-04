package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import db.Database;
import model.HashUtil;

public class RegisterForm extends JFrame {
    private JTextField txtUser;
    private JPasswordField txtPass;
    private JButton btnRegister, btnBack;

    public RegisterForm() {
        setTitle("Đăng ký tài khoản");
        setSize(350, 220);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        panel.add(new JLabel("Tài khoản:"));
        txtUser = new JTextField();
        panel.add(txtUser);

        panel.add(new JLabel("Mật khẩu:"));
        txtPass = new JPasswordField();
        panel.add(txtPass);

        btnRegister = new JButton("Đăng ký");
        btnBack = new JButton("Trở lại");
        panel.add(btnRegister);
        panel.add(btnBack);

        add(panel);

        // 🟢 Xử lý đăng ký
        btnRegister.addActionListener(e -> {
            String user = txtUser.getText().trim();
            String pass = new String(txtPass.getPassword()).trim();

            if (user.isEmpty() || pass.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập đủ thông tin!", "Lỗi", JOptionPane.WARNING_MESSAGE);
                return;
            }

            if (pass.length() < 6) {
                JOptionPane.showMessageDialog(this, "Mật khẩu phải ít nhất 6 ký tự!", "Lỗi", JOptionPane.WARNING_MESSAGE);
                return;
            }

            try (Connection c = Database.getConnection()) {
                // Kiểm tra trùng tài khoản
                PreparedStatement check = c.prepareStatement("SELECT * FROM users WHERE taikhoan = ?");
                check.setString(1, user);
                ResultSet rs = check.executeQuery();
                if (rs.next()) {
                    JOptionPane.showMessageDialog(this, "Tài khoản đã tồn tại!", "Thất bại", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Thêm người dùng mới
                PreparedStatement ps = c.prepareStatement("INSERT INTO users (taikhoan, matkhau) VALUES (?, ?)");
                ps.setString(1, user);
                ps.setString(2, HashUtil.md5(pass));

                int row = ps.executeUpdate();
                if (row > 0) {
                    JOptionPane.showMessageDialog(this, "Đăng ký thành công!", "Thành công", JOptionPane.INFORMATION_MESSAGE);
                    new LoginForm().setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Đăng ký thất bại!", "Thất bại", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Lỗi kết nối cơ sở dữ liệu!\n" + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnBack.addActionListener(e -> {
            new LoginForm().setVisible(true);
            dispose();
        });
    }
}
