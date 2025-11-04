import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class B3 extends JFrame implements ActionListener {
    private JTextField txtA, txtB, txtChuVi, txtDienTich;
    private JButton btnTinh, btnTiepTuc, btnThoat;

    public B3() {
        setTitle("Tính chu vi và diện tích HCN");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 2, 5, 5));
        setLocationRelativeTo(null); 

        JLabel lblA = new JLabel("Nhập chiều dài A:");
        JLabel lblB = new JLabel("Nhập chiều rộng B:");
        JLabel lblChuVi = new JLabel("Chu vi HCN:");
        JLabel lblDienTich = new JLabel("Diện tích HCN:");

        txtA = new JTextField();
        txtB = new JTextField();
        txtChuVi = new JTextField();
        txtDienTich = new JTextField();
        txtChuVi.setEditable(false);
        txtDienTich.setEditable(false);

        btnTinh = new JButton("Thực hiện");
        btnTiepTuc = new JButton("Tiếp tục");
        btnThoat = new JButton("Thoát");

        btnTinh.addActionListener(this);
        btnTiepTuc.addActionListener(this);
        btnThoat.addActionListener(this);

        add(lblA); add(txtA);
        add(lblB); add(txtB);
        add(lblChuVi); add(txtChuVi);
        add(lblDienTich); add(txtDienTich);
        add(btnTinh); add(btnTiepTuc);
        add(new JLabel()); 
        add(btnThoat);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnTinh) {
            if (txtA.getText().isEmpty() || txtB.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ chiều dài và chiều rộng.");
                return;
            }
            try {
                double a = Double.parseDouble(txtA.getText());
                double b = Double.parseDouble(txtB.getText());
                double chuVi = 2 * (a + b);
                double dienTich = a * b;
                txtChuVi.setText(String.valueOf(chuVi));
                txtDienTich.setText(String.valueOf(dienTich));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập số hợp lệ cho chiều dài và chiều rộng.");
            }
        } 
        else if (e.getSource() == btnTiepTuc) {
            txtA.setText("");
            txtB.setText("");
            txtChuVi.setText("");
            txtDienTich.setText("");
            txtA.requestFocus();
        } 
        else if (e.getSource() == btnThoat) {
            int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn thoát không?", "Xác nhận", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            B3 frame = new B3();
            frame.setVisible(true);
        });
    }
}
