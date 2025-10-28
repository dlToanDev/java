package ui;

import dao.UserDAO;
import model.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame {
    public LoginFrame() {
        setTitle("Đăng nhập");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        JLabel lblUser = new JLabel("Tài khoản:");
        lblUser.setBounds(20, 20, 80, 25);
        JTextField txtUser = new JTextField();
        txtUser.setBounds(100, 20, 150, 25);

        JLabel lblPass = new JLabel("Mật khẩu:");
        lblPass.setBounds(20, 60, 80, 25);
        JPasswordField txtPass = new JPasswordField();
        txtPass.setBounds(100, 60, 150, 25);

        JButton btnLogin = new JButton("Đăng nhập");
        btnLogin.setBounds(50, 100, 100, 30);
        JButton btnRegister = new JButton("Đăng ký");
        btnRegister.setBounds(160, 100, 90, 30);

        add(lblUser); add(txtUser);
        add(lblPass); add(txtPass);
        add(btnLogin); add(btnRegister);

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                User user = UserDAO.login(txtUser.getText(), new String(txtPass.getPassword()));
                if (user != null) {
                    JOptionPane.showMessageDialog(null, "Đăng nhập thành công!");
                    new MainFrame(user).setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Sai tài khoản hoặc mật khẩu!");
                }
            }
        });

        btnRegister.addActionListener(e -> new RegisterFrame().setVisible(true));
    }
}
