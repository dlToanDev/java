import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class B3 extends JFrame {

    private JTextField txtMaLoai, txtTenLoai;
    private JTable table;
    private DefaultTableModel model;

    public B3() {
        setTitle("Bài 3 - Danh mục loại sản phẩm");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        JPanel pnlNhap = new JPanel(new GridLayout(2, 2, 10, 10));
        pnlNhap.setBorder(BorderFactory.createTitledBorder("Thông tin loại sản phẩm"));

        pnlNhap.add(new JLabel("Mã loại:"));
        txtMaLoai = new JTextField();
        pnlNhap.add(txtMaLoai);

        pnlNhap.add(new JLabel("Tên loại:"));
        txtTenLoai = new JTextField();
        pnlNhap.add(txtTenLoai);

        String[] columnNames = {"Mã loại", "Tên loại"};
        model = new DefaultTableModel(columnNames, 0);
        table = new JTable(model);
        JScrollPane scroll = new JScrollPane(table);

        JPanel pnlButton = new JPanel();
        JButton btnThem = new JButton("Thêm");
        JButton btnLuu = new JButton("Lưu");
        JButton btnXoa = new JButton("Xóa");
        JButton btnThoat = new JButton("Thoát");

        pnlButton.add(btnThem);
        pnlButton.add(btnLuu);
        pnlButton.add(btnXoa);
        pnlButton.add(btnThoat);

        add(pnlNhap, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);
        add(pnlButton, BorderLayout.SOUTH);

        // SỰ KIỆN
        btnThem.addActionListener(e -> {
            String ma = txtMaLoai.getText().trim();
            String ten = txtTenLoai.getText().trim();

            if (ma.isEmpty() || ten.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập đủ thông tin!");
                return;
            }

            model.addRow(new Object[]{ma, ten});
            txtMaLoai.setText("");
            txtTenLoai.setText("");
        });

        btnLuu.addActionListener(e ->
            JOptionPane.showMessageDialog(this, "Đã lưu danh mục loại sản phẩm!")
        );

        btnXoa.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn dòng cần xóa!");
                return;
            }
            model.removeRow(row);
        });

        btnThoat.addActionListener(e -> System.exit(0));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new B3().setVisible(true));
    }
}
