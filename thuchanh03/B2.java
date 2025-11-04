import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class B2 extends JFrame implements ActionListener {
    private JTextField txtFirst, txtSecond, txtSum;
    private JButton btnSum, btnExit;

    public B2() {
        setTitle("Bai 2 - My Addition Operator");
        setSize(350, 200);  // ✅ Sửa: setSIze -> setSize
        setDefaultCloseOperation(EXIT_ON_CLOSE); // ✅ Sửa: setDeafaultCloseOperation -> setDefaultCloseOperation
        setLayout(new GridLayout(4, 2, 10, 10));
        setLocationRelativeTo(null); // Căn giữa cửa sổ

        // Label
        JLabel lblFirst = new JLabel("Số thứ nhất:");
        JLabel lblSecond = new JLabel("Số thứ hai:");
        JLabel lblSum = new JLabel("Tổng:");

        // TextField
        txtFirst = new JTextField();
        txtSecond = new JTextField();
        txtSum = new JTextField();
        txtSum.setEditable(false);

        // Button
        btnSum = new JButton("Tính Tổng");
        btnExit = new JButton("Thoát");

        // ✅ Sửa: dùng ActionListener chứ không phải ItemListener
        btnSum.addActionListener(this);
        btnExit.addActionListener(this);

        // Thêm các thành phần vào frame
        add(lblFirst); add(txtFirst);
        add(lblSecond); add(txtSecond);
        add(lblSum); add(txtSum);
        add(btnSum); add(btnExit);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSum) {
            try {
                int soThuNhat = Integer.parseInt(txtFirst.getText());
                int soThuHai = Integer.parseInt(txtSecond.getText());
                int tong = soThuNhat + soThuHai;
                txtSum.setText(String.valueOf(tong));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập số hợp lệ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == btnExit) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new B2().setVisible(true));
    }
}
