import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class B2 extends JFrame {

    private DefaultListModel<Integer> model;
    private JList<Integer> list;
    private JTextField txtNhap;
    private JCheckBox chkChan;
    private JButton btnThem, btnXoa, btnTong, btnThemChan, btnThemLe;

    public B2() {
        setTitle("Bài 2 - Thao tác trên JList - Checkbox");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        model = new DefaultListModel<>();
        list = new JList<>(model);
        JScrollPane scroll = new JScrollPane(list);

        JPanel pnlNhap = new JPanel();
        pnlNhap.add(new JLabel("Nhập:"));
        txtNhap = new JTextField(8);
        pnlNhap.add(txtNhap);

        chkChan = new JCheckBox("Chỉ nhập số chẵn");
        pnlNhap.add(chkChan);

        btnThem = new JButton("Thêm");
        pnlNhap.add(btnThem);

        JPanel pnlButton = new JPanel(new GridLayout(2, 2, 10, 10));
        btnThemChan = new JButton("Thêm số chẵn");
        btnThemLe = new JButton("Thêm số lẻ");
        btnXoa = new JButton("Xóa các giá trị đang chọn");
        btnTong = new JButton("Tổng giá trị trong List");

        pnlButton.add(btnThemChan);
        pnlButton.add(btnThemLe);
        pnlButton.add(btnXoa);
        pnlButton.add(btnTong);

        add(pnlNhap, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);
        add(pnlButton, BorderLayout.SOUTH);

        // SỰ KIỆN
        btnThem.addActionListener(e -> {
            try {
                int n = Integer.parseInt(txtNhap.getText());
                if (chkChan.isSelected() && n % 2 != 0) {
                    JOptionPane.showMessageDialog(this, "Chỉ được nhập số chẵn!");
                    return;
                }
                model.addElement(n);
                txtNhap.setText("");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập số nguyên!");
            }
        });

        btnThemChan.addActionListener(e -> {
            for (int i = 2; i <= 20; i += 2)
                model.addElement(i);
        });

        btnThemLe.addActionListener(e -> {
            for (int i = 1; i <= 19; i += 2)
                model.addElement(i);
        });

        btnXoa.addActionListener(e -> {
            List<Integer> selected = list.getSelectedValuesList();
            for (Integer val : selected)
                model.removeElement(val);
        });

        btnTong.addActionListener(e -> {
            int sum = 0;
            for (int i = 0; i < model.size(); i++)
                sum += model.getElementAt(i);
            JOptionPane.showMessageDialog(this, "Tổng các giá trị: " + sum);
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new B2().setVisible(true));
    }
}
