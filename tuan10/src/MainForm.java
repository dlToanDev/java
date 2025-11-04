package ui;

import javax.swing.*;
import java.awt.event.*;

public class MainForm extends JFrame {
    private String username;
    private JButton btnChangePass = new JButton("Đổi mật khẩu");
    private JButton btnLogout = new JButton("Đăng xuất");

    public MainForm(String username) {
        this.username = username;
        setTitle("Xin chào, " + username);
        setSize(300, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel p = new JPanel();
        p.add(btnChangePass);
        p.add(btnLogout);
        add(p);

        btnChangePass.addActionListener(e -> new ChangePasswordForm(username).setVisible(true));
        btnLogout.addActionListener(e -> {
            dispose();
            new LoginForm().setVisible(true);
        });
    }
}
