import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

public class B6 extends JFrame implements ActionListener {
    private JTextField txtSoLuong, txtPhanTu, txtMangNhap, txtTong, txtSapXep;
    private JButton btnNhap, btnThucHien, btnXoa, btnThoat;

    private int[] arr;
    private int n = 0;
    private int index = 0;

    public B6() {
        setTitle("Bài 6 - Mảng số nguyên");
        setSize(500, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(6, 2, 5, 5));

        // Label
        JLabel lblSoLuong = new JLabel("Nhập số pt mảng:");
        JLabel lblPhanTu = new JLabel("Nhập phần tử:");
        JLabel lblMangNhap = new JLabel("Mảng đã nhập:");
        JLabel lblTong = new JLabel("Tổng mảng:");
        JLabel lblSapXep = new JLabel("Sắp xếp tăng dần:");

        // TextField
        txtSoLuong = new JTextField();
        txtPhanTu = new JTextField();
        txtMangNhap = new JTextField();
        txtTong = new JTextField();
        txtSapXep = new JTextField();

        txtMangNhap.setEditable(false);
        txtTong.setEditable(false);
        txtSapXep.setEditable(false);

        // Buttons
        btnNhap = new JButton("Nhập");
        btnThucHien = new JButton("Thực hiện");
        btnXoa = new JButton("Xóa");
        btnThoat = new JButton("Thoát");

        // Add ActionListener
        btnNhap.addActionListener(this);
        btnThucHien.addActionListener(this);
        btnXoa.addActionListener(this);
        btnThoat.addActionListener(this);

        // Thêm vào giao diện
        add(lblSoLuong);
        add(txtSoLuong);
        add(lblPhanTu);
        add(txtPhanTu);
        add(lblMangNhap);
        add(txtMangNhap);
        add(lblTong);
        add(txtTong);
        add(lblSapXep);
        add(txtSapXep);

        JPanel pnButton = new JPanel();
        pnButton.add(btnNhap);
        pnButton.add(btnThucHien);
        pnButton.add(btnXoa);
        pnButton.add(btnThoat);
        add(pnButton);
        add(new JLabel(""));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnNhap) {
            // Bước 1: Nếu chưa nhập mảng -> lấy số lượng phần tử
            if (arr == null) {
                try {
                    n = Integer.parseInt(txtSoLuong.getText());
                    if (n <= 0) {
                        JOptionPane.showMessageDialog(this, "Số lượng phần tử phải > 0!");
                        return;
                    }
                    arr = new int[n];
                    index = 0;
                    JOptionPane.showMessageDialog(this, "Hãy nhập từng phần tử và nhấn 'Nhập' sau mỗi lần!");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Vui lòng nhập số nguyên hợp lệ!");
                }
                return;
            }

            // Bước 2: Nhập từng phần tử vào mảng
            if (index < n) {
                try {
                    arr[index] = Integer.parseInt(txtPhanTu.getText());
                    index++;
                    txtPhanTu.setText("");
                    txtPhanTu.requestFocus();

                    // Hiển thị mảng đã nhập
                    txtMangNhap.setText(Arrays.toString(Arrays.copyOf(arr, index)));

                    // Thông báo nếu nhập đủ
                    if (index == n) {
                        JOptionPane.showMessageDialog(this, "Đã nhập đủ " + n + " phần tử!");
                    }

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Vui lòng nhập số nguyên hợp lệ!");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Bạn đã nhập đủ số phần tử!");
            }
        } 
        else if (e.getSource() == btnThucHien) {
            if (arr == null || index < n) {
                JOptionPane.showMessageDialog(this, "Hãy nhập đủ các phần tử trước khi thực hiện!");
                return;
            }

            // Tính tổng
            int tong = 0;
            for (int num : arr) tong += num;
            txtTong.setText(String.valueOf(tong));

            // Sắp xếp tăng dần
            Arrays.sort(arr);
            txtSapXep.setText(Arrays.toString(arr));
        } 
        else if (e.getSource() == btnXoa) {
            txtSoLuong.setText("");
            txtPhanTu.setText("");
            txtMangNhap.setText("");
            txtTong.setText("");
            txtSapXep.setText("");
            arr = null;
            n = 0;
            index = 0;
            txtSoLuong.requestFocus();
        } 
        else if (e.getSource() == btnThoat) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new B6().setVisible(true));
    }
}
