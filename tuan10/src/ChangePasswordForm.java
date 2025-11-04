package ui;

import db.Database;
import model.HashUtil;
import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class ChangePasswordForm extends JFrame {
    private JPasswordField txtOld = new JPasswordField(15);
    private JPasswordField txtNew = new JPasswordField(15);
    private JButton btnChange = new JButton("Đổi mật khẩu");
    private String username;

    public ChangePasswordForm(String username) {
        this.username = username;
        setTitle("Đổi mật khẩu");
        setSize(350, 200);
        setLocationRelativeTo(null);

        JPanel p = new JPanel(new GridLayout(3,2,5,5));
        p.add(new JLabel("Mật khẩu cũ:")); p.add(txtOld);
        p.add(new JLabel("Mật khẩu mới:")); p.add(txtNew);
        p.add(btnChange);

        add(p);
        btnChange.addActionListener(e -> changePassword());
    }

    private void changePassword() {
        String oldPass = new String(txtOld.getPassword());
        String newPass = new String(txtNew.getPassword());

        if (newPass.length() < 6) {
            JOptionPane.showMessageDialog(this, "Mật khẩu mới >= 6 ký tự!");
            return;
        }

        try (Connection c = Database.getConnection()) {
            PreparedStatement ps = c.prepareStatement("SELECT * FROM users WHERE taikhoan=? AND matkhau=?");
            ps.setString(1, username);
            ps.setString(2, HashUtil.md5(oldPass));

            ResultSet rs = ps.executeQuery();
            if (!rs.next()) {
                JOptionPane.showMessageDialog(this, "Mật khẩu cũ không đúng!");
                return;
            }

            PreparedStatement psUpdate = c.prepareStatement("UPDATE users SET matkhau=? WHERE taikhoan=?");
            psUpdate.setString(1, HashUtil.md5(newPass));
            psUpdate.setString(2, username);
            psUpdate.executeUpdate();

            JOptionPane.showMessageDialog(this, "Đổi mật khẩu thành công!");
            dispose();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
