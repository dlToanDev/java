import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class B4 extends JFrame implements ActionListener {

    private JTextField txtN;
    private JButton btnKiemTra;
    private JLabel lblKQ;

    public B4() {
        setTitle("Kiểm tra số chính phương");
        setSize(400, 400);
        setLayout(new GridLayout(3, 2, 10, 10));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // căn giữa

        JLabel lblNhap = new JLabel("Nhập số nguyên dương N:");
        txtN = new JTextField();
        btnKiemTra = new JButton("Kiểm tra SCP");
        lblKQ = new JLabel("Kết quả sẽ hiển thị ở đây");

        btnKiemTra.addActionListener(this);

        add(lblNhap);
        add(txtN);
        add(btnKiemTra);
        add(lblKQ);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            int n = Integer.parseInt(txtN.getText());

            if (n < 0) {
                lblKQ.setText("Không phải số chính phương (âm)");
                return;
            }

            int sqrt = (int) Math.sqrt(n);
            if (sqrt * sqrt == n) {
                lblKQ.setText(n + " là số chính phương ✅");
            } else {
                lblKQ.setText(n + " không phải số chính phương ❌");
            }
        } catch (NumberFormatException ex) {
            lblKQ.setText("Vui lòng nhập một số nguyên hợp lệ!");
        }
    }

    public static void main(String[] args) {
        new B4();
    }
}
