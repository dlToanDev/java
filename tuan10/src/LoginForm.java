package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import db.Database;
import model.HashUtil;

public class LoginForm extends JFrame {
    private JTextField txtUser;
    private JPasswordField txtPass;
    private JButton btnLogin, btnRegister;

    public LoginForm() {
        setTitle("Đăng nhập hệ thống");
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

        btnLogin = new JButton("Đăng nhập");
        btnRegister = new JButton("Đăng ký");
        panel.add(btnLogin);
        panel.add(btnRegister);

        add(panel);

        // 🟢 Xử lý đăng nhập
        btnLogin.addActionListener(e -> {
            String user = txtUser.getText().trim();
            String pass = new String(txtPass.getPassword()).trim();

            if (user.isEmpty() || pass.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập đủ thông tin!", "Lỗi", JOptionPane.WARNING_MESSAGE);
                return;
            }

            try (Connection c = Database.getConnection()) {
                String sql = "SELECT * FROM users WHERE taikhoan = ? AND matkhau = ?";
                PreparedStatement ps = c.prepareStatement(sql);
                ps.setString(1, user);
                ps.setString(2, HashUtil.md5(pass));

                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    JOptionPane.showMessageDialog(this, "Đăng nhập thành công!", "Thành công", JOptionPane.INFORMATION_MESSAGE);
                    dispose(); // đóng form hiện tại
                    new MainForm(user).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(this, "Sai tài khoản hoặc mật khẩu!", "Thất bại", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Lỗi kết nối cơ sở dữ liệu!\n" + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        });

        // 🟡 Chuyển sang form đăng ký
        btnRegister.addActionListener(e -> {
            new RegisterForm().setVisible(true);
            dispose();
        });
    }
}
