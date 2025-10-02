import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DentalAppGUI extends JFrame {
    private JTextField txtTen, txtNhoRang, txtTramRang, txtTongCong;
    private JCheckBox chkCaoVoi, chkTayTrang;
    private JButton btnTinh, btnXoa, btnThoat;

    // Giá dịch vụ
    private static final int GIA_CAO_VOI = 1000000;
    private static final int GIA_TAY_TRANG = 1500000;
    private static final int GIA_NHO_RANG = 100000;
    private static final int GIA_TRAM_RANG = 200000;

    public DentalAppGUI() {
        setTitle("DENTAL PAYMENT APPLICATION");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel chính
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(9, 2, 5, 5));

        // Tên khách hàng
        panel.add(new JLabel("Tên khách hàng:"));
        txtTen = new JTextField();
        panel.add(txtTen);

        // Cạo vôi
        chkCaoVoi = new JCheckBox("Cạo vôi (1.000.000đ)");
        panel.add(chkCaoVoi);
        panel.add(new JLabel(""));

        // Tẩy trắng
        chkTayTrang = new JCheckBox("Tẩy trắng (1.500.000đ)");
        panel.add(chkTayTrang);
        panel.add(new JLabel(""));

        // Nhổ răng
        panel.add(new JLabel("Số răng nhổ (100.000đ/cái):"));
        txtNhoRang = new JTextField("0");
        panel.add(txtNhoRang);

        // Trám răng
        panel.add(new JLabel("Số răng trám (200.000đ/cái):"));
        txtTramRang = new JTextField("0");
        panel.add(txtTramRang);

        // Tổng cộng
        panel.add(new JLabel("Tổng cộng:"));
        txtTongCong = new JTextField();
        txtTongCong.setEditable(false);
        panel.add(txtTongCong);

        // Nút bấm
        btnTinh = new JButton("Tính tiền");
        btnXoa = new JButton("Xóa");
        btnThoat = new JButton("Thoát");
        panel.add(btnTinh);
        panel.add(btnXoa);
        panel.add(btnThoat);

        add(panel);

        // Xử lý sự kiện
        btnTinh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tinhTien();
            }
        });

        btnXoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xoaForm();
            }
        });

        btnThoat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    private void tinhTien() {
        try {
            int nho = Integer.parseInt(txtNhoRang.getText().trim());
            int tram = Integer.parseInt(txtTramRang.getText().trim());

            double tong = 0;
            if (chkCaoVoi.isSelected()) tong += GIA_CAO_VOI;
            if (chkTayTrang.isSelected()) tong += GIA_TAY_TRANG;
            tong += nho * GIA_NHO_RANG;
            tong += tram * GIA_TRAM_RANG;

            txtTongCong.setText(String.format("%.0f VND", tong));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số hợp lệ cho răng!");
        }
    }

    private void xoaForm() {
        txtTen.setText("");
        txtNhoRang.setText("0");
        txtTramRang.setText("0");
        txtTongCong.setText("");
        chkCaoVoi.setSelected(false);
        chkTayTrang.setSelected(false);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new DentalAppGUI().setVisible(true);
        });
    }
}
