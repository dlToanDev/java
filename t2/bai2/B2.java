import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class B2 extends JFrame implements ActionListener {
    // Các thành phần giao diện
    private JTextField txtA, txtB, txtKQ;
    private JButton btnThucHien, btnTiepTuc, btnThoat;

    public B2() {
        // Cài đặt khung
        setTitle("Giải phương trình bậc 1");
        setSize(400, 250);
        setLayout(new GridLayout(5, 2, 10, 10));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // căn giữa màn hình

        // Tạo các label và textfield
        JLabel lblA = new JLabel("Nhập a:");
        JLabel lblB = new JLabel("Nhập b:");
        JLabel lblKQ = new JLabel("Kết quả:");

        txtA = new JTextField();
        txtB = new JTextField();
        txtKQ = new JTextField();
        txtKQ.setEditable(false); // không cho nhập kết quả

        // Tạo các nút
        btnThucHien = new JButton("Thực hiện");
        btnTiepTuc = new JButton("Tiếp tục");
        btnThoat = new JButton("Thoát");

        // Gắn sự kiện
        btnThucHien.addActionListener(this);
        btnTiepTuc.addActionListener(this);
        btnThoat.addActionListener(this);

        // Thêm vào giao diện
        add(lblA); add(txtA);
        add(lblB); add(txtB);
        add(lblKQ); add(txtKQ);
        add(btnThucHien); add(btnTiepTuc);
        add(new JLabel("")); add(btnThoat);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();

        if (src == btnThucHien) {
            try {
                double a = Double.parseDouble(txtA.getText());
                double b = Double.parseDouble(txtB.getText());

                String kq;
                if (a == 0 && b == 0)
                    kq = "Vô số nghiệm";
                else if (a == 0)
                    kq = "Vô nghiệm";
                else
                    kq = "x = " + (-b / a);

                txtKQ.setText(kq);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập số hợp lệ!");
            }
        } 
        else if (src == btnTiepTuc) {
            txtA.setText("");
            txtB.setText("");
            txtKQ.setText("");
            txtA.requestFocus();
        } 
        else if (src == btnThoat) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new B2();
    }
}
