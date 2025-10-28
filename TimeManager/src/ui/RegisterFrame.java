package ui;

import dao.UserDAO;
import model.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterFrame extends JFrame {

    public RegisterFrame() {
        setTitle("Đăng ký");
        setSize(300, 220);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(null);

        JLabel lblUser = new JLabel("Tài khoản:");
        lblUser.setBounds(20, 20, 80, 25);
        JTextField txtUser = new JTextField();
        txtUser.setBounds(100, 20, 150, 25);

        JLabel lblPass = new JLabel("Mật khẩu:");
        lblPass.setBounds(20, 60, 80, 25);
        JPasswordField txtPass = new JPasswordField();
        txtPass.setBounds(100, 60, 150, 25);

        JLabel lblConfirm = new JLabel("Nhập lại mật khẩu:");
        lblConfirm.setBounds(20, 100, 120, 25);
        JPasswordField txtConfirm = new JPasswordField();
        txtConfirm.setBounds(140, 100, 110, 25);

        JButton btnRegister = new JButton("Đăng ký");
        btnRegister.setBounds(80, 140, 120, 30);

        add(lblUser); add(txtUser);
        add(lblPass); add(txtPass);
        add(lblConfirm); add(txtConfirm);
        add(btnRegister);

        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = txtUser.getText();
                String password = new String(txtPass.getPassword());
                String confirm = new String(txtConfirm.getPassword());

                if (!password.equals(confirm)) {
                    JOptionPane.showMessageDialog(null, "Mật khẩu không trùng khớp!");
                    return;
                }

                boolean success = UserDAO.register(username, password);
                if (success) {
                    JOptionPane.showMessageDialog(null, "Đăng ký thành công!");
                    // Lấy user vừa đăng ký
                    User user = UserDAO.login(username, password);
                    if (user != null) {
                        // Mở MainFrame
                        new MainFrame(user).setVisible(true);
                        dispose(); // đóng RegisterFrame
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Đăng ký thất bại! Có thể tên đã tồn tại.");
                }
            }
        });
    }
}
