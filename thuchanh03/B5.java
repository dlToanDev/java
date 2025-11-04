import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class B5 extends JFrame implements ActionListener {
    private JTextField txtThuc1, txtAo1, txtThuc2, txtAo2, txtKQ;
    private JRadioButton rdCong, rdTru, rdNhan, rdChia;
    private JButton btnThucHien, btnXoa, btnThoat;
    private ButtonGroup group;

    public B5() {
        setTitle("Tính toán số phức");
        setSize(500, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(6, 2, 5, 5));

        JLabel lblSo1 = new JLabel("Số phức 1:");
        JLabel lblSo2 = new JLabel("Số phức 2:");
        JLabel lblKQ = new JLabel("Kết quả:");


        txtThuc1 = new JTextField();
        txtAo1 = new JTextField();
        txtThuc2 = new JTextField();
        txtAo2 = new JTextField();
        txtKQ = new JTextField();
        txtKQ.setEditable(false);


        rdCong = new JRadioButton("Cộng");
        rdTru = new JRadioButton("Trừ");
        rdNhan = new JRadioButton("Nhân");
        rdChia = new JRadioButton("Chia");
        group = new ButtonGroup();
        group.add(rdCong);
        group.add(rdTru);
        group.add(rdNhan);
        group.add(rdChia);
        rdCong.setSelected(true);


        btnThucHien = new JButton("Thực hiện");
        btnXoa = new JButton("Xóa");
        btnThoat = new JButton("Thoát");

        btnThucHien.addActionListener(this);
        btnXoa.addActionListener(this);
        btnThoat.addActionListener(this);


        add(new JLabel("")); add(new JLabel("Phần thực")); add(new JLabel("Phần ảo"));

        add(new JLabel("Số phức 1:"));
        add(txtThuc1);
        add(txtAo1);

        add(new JLabel("Số phức 2:"));
        add(txtThuc2);
        add(txtAo2);

        add(lblKQ);
        add(txtKQ);
        add(new JLabel(""));

        JPanel pnPhepToan = new JPanel();
        pnPhepToan.add(rdCong);
        pnPhepToan.add(rdTru);
        pnPhepToan.add(rdNhan);
        pnPhepToan.add(rdChia);
        add(pnPhepToan);
        add(new JLabel(""));

        JPanel pnButton = new JPanel();
        pnButton.add(btnThucHien);
        pnButton.add(btnXoa);
        pnButton.add(btnThoat);
        add(pnButton);
        add(new JLabel(""));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnThucHien) {
            try {
                double thuc1 = Double.parseDouble(txtThuc1.getText());
                double ao1 = Double.parseDouble(txtAo1.getText());
                double thuc2 = Double.parseDouble(txtThuc2.getText());
                double ao2 = Double.parseDouble(txtAo2.getText());

                double kqThuc = 0, kqAo = 0;

                if (rdCong.isSelected()) {
                    kqThuc = thuc1 + thuc2;
                    kqAo = ao1 + ao2;
                } else if (rdTru.isSelected()) {
                    kqThuc = thuc1 - thuc2;
                    kqAo = ao1 - ao2;
                } else if (rdNhan.isSelected()) {
                    kqThuc = thuc1 * thuc2 - ao1 * ao2;
                    kqAo = thuc1 * ao2 + ao1 * thuc2;
                } else if (rdChia.isSelected()) {
                    double mau = thuc2 * thuc2 + ao2 * ao2;
                    if (mau == 0) {
                        JOptionPane.showMessageDialog(this, "Không thể chia cho 0!");
                        return;
                    }
                    kqThuc = (thuc1 * thuc2 + ao1 * ao2) / mau;
                    kqAo = (ao1 * thuc2 - thuc1 * ao2) / mau;
                }

                txtKQ.setText(String.format("%.2f + %.2fi", kqThuc, kqAo));

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập đúng số!");
            }
        } 
        else if (e.getSource() == btnXoa) {
            txtThuc1.setText("");
            txtAo1.setText("");
            txtThuc2.setText("");
            txtAo2.setText("");
            txtKQ.setText("");
            txtThuc1.requestFocus();
        } 
        else if (e.getSource() == btnThoat) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new B5().setVisible(true));
    }
}
