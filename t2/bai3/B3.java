import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class B3 extends JFrame implements ActionListener {
    private JTextField txtA, txtB, txtC, txtKQ;
    private JButton btnThucHien, btnTiepTuc, btnThoat;

    public B3() {
        setTitle("Giải phương trình bậc 2");
        setSize(400, 300);
        setLayout(new GridLayout(6, 2, 10, 10));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // căn giữa cửa sổ

        JLabel lblA = new JLabel("Nhập a:");
        JLabel lblB = new JLabel("Nhập b:");
        JLabel lblC = new JLabel("Nhập c:");
        JLabel lblKQ = new JLabel("Kết quả:");

        txtA = new JTextField();
        txtB = new JTextField();
        txtC = new JTextField();
        txtKQ = new JTextField();
        txtKQ.setEditable(false); // không cho nhập kết quả

        btnThucHien = new JButton("Thực hiện");
        btnTiepTuc = new JButton("Tiếp tục");
        btnThoat = new JButton("Thoát");

        btnThucHien.addActionListener(this);
        btnTiepTuc.addActionListener(this);
        btnThoat.addActionListener(this);

        add(lblA); add(txtA);
        add(lblB); add(txtB);
        add(lblC); add(txtC);
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
                double c = Double.parseDouble(txtC.getText());

                String kq;
                if (a == 0) {
                    // Giải phương trình bậc 1: bx + c = 0
                    if (b == 0) {
                        if (c == 0)
                            kq = "Vô số nghiệm";
                        else
                            kq = "Vô nghiệm";
                    } else {
                        double x = -c / b;
                        kq = "Phương trình bậc 1: x = " + x;
                    }
                } else {
                    double delta = b * b - 4 * a * c;
                    if (delta < 0) {
                        kq = "Vô nghiệm";
                    } else if (delta == 0) {
                        double x = -b / (2 * a);
                        kq = "Nghiệm kép: x1 = x2 = " + x;
                    } else {
                        double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                        double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                        kq = "Hai nghiệm phân biệt: x1 = " + x1 + ", x2 = " + x2;
                    }
                }

                txtKQ.setText(kq);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập số hợp lệ!");
            }
        } else if (src == btnTiepTuc) {
            txtA.setText("");
            txtB.setText("");
            txtC.setText("");
            txtKQ.setText("");
            txtA.requestFocus();
        } else if (src == btnThoat) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new B3();
    }
}
