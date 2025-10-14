import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class B5 extends JFrame implements ActionListener {
    private JTextField txtR, txtChieuDai, txtChieuRong, txtChuVi, txtDienTich;
    private JRadioButton rdTron, rdVuong, rdChuNhat;
    private JButton btnThucHien, btnTiepTuc, btnThoat;
    private ButtonGroup group;

    public B5() {
        setTitle("Tính Chu Vi & Diện Tích");
        setSize(400, 300);
        setLayout(new GridLayout(7, 2, 5, 5));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Nhập bán kính / cạnh / chiều dài, rộng
        add(new JLabel("Nhập R / Cạnh / Chiều dài:"));
        txtR = new JTextField();
        add(txtR);

        add(new JLabel("Chiều rộng (nếu là CN):"));
        txtChieuRong = new JTextField();
        add(txtChieuRong);

        add(new JLabel("Kết quả:"));
        add(new JLabel("")); // chỗ trống

        // Radio Buttons
        rdTron = new JRadioButton("Hình Tròn");
        rdVuong = new JRadioButton("Hình Vuông");
        rdChuNhat = new JRadioButton("Hình Chữ Nhật");
        group = new ButtonGroup();
        group.add(rdTron);
        group.add(rdVuong);
        group.add(rdChuNhat);

        add(rdTron);
        add(rdVuong);
        add(rdChuNhat);
        
        // Kết quả
        add(new JLabel("Chu vi:"));
        txtChuVi = new JTextField();
        txtChuVi.setEditable(false);
        add(txtChuVi);

        add(new JLabel("Diện tích:"));
        txtDienTich = new JTextField();
        txtDienTich.setEditable(false);
        add(txtDienTich);

        // Buttons
        btnThucHien = new JButton("Thực hiện");
        btnTiepTuc = new JButton("Tiếp tục");
        btnThoat = new JButton("Thoát");

        add(btnThucHien);
        add(btnTiepTuc);
        add(btnThoat);

        btnThucHien.addActionListener(this);
        btnTiepTuc.addActionListener(this);
        btnThoat.addActionListener(this);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();

        if (src == btnThoat) {
            System.exit(0);
        } 
        else if (src == btnTiepTuc) {
            txtR.setText("");
            txtChieuRong.setText("");
            txtChuVi.setText("");
            txtDienTich.setText("");
            group.clearSelection();
        } 
        else if (src == btnThucHien) {
            try {
                if (!rdTron.isSelected() && !rdVuong.isSelected() && !rdChuNhat.isSelected()) {
                    JOptionPane.showMessageDialog(this, "Vui lòng chọn loại hình!");
                    return;
                }

                double chuVi = 0, dienTich = 0;

                if (rdTron.isSelected()) {
                    double r = Double.parseDouble(txtR.getText());
                    chuVi = 2 * Math.PI * r;
                    dienTich = Math.PI * r * r;
                } 
                else if (rdVuong.isSelected()) {
                    double canh = Double.parseDouble(txtR.getText());
                    chuVi = 4 * canh;
                    dienTich = canh * canh;
                } 
                else if (rdChuNhat.isSelected()) {
                    double dai = Double.parseDouble(txtR.getText());
                    double rong = Double.parseDouble(txtChieuRong.getText());
                    chuVi = 2 * (dai + rong);
                    dienTich = dai * rong;
                }

                txtChuVi.setText(String.format("%.4f", chuVi));
                txtDienTich.setText(String.format("%.4f", dienTich));

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập số hợp lệ!");
            }
        }
    }

    public static void main(String[] args) {
        new B5();
    }
}
