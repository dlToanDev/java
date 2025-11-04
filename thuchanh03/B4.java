import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class B4 extends JFrame implements ActionListener {
    private JTextField txtN;
    private JButton btnKiemTra;
    private JLabel lblKq;

    public B4() {
        setTitle("Kiểm tra số nguyên tố");
        setSize(350, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 2, 5, 5));

        JLabel lblN = new JLabel("Nhập số nguyên n:");
        txtN = new JTextField();
        btnKiemTra = new JButton("Kiểm tra SNT");
        lblKq = new JLabel("Kết quả: ", SwingConstants.CENTER);

        btnKiemTra.addActionListener(this);

        add(lblN);
        add(txtN);
        add(new JLabel()); 
        add(btnKiemTra);
        add(new JLabel());
        add(lblKq);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnKiemTra) {
            try {
                int n = Integer.parseInt(txtN.getText());
                if (n < 2) {
                    lblKq.setText("Kết quả: " + n + " không phải số nguyên tố.");
                    return;
                }
                boolean laSNT = true;
                for (int i = 2; i <= Math.sqrt(n); i++) {
                    if (n % i == 0) {
                        laSNT = false;
                        break;
                    }
                }
                if (laSNT)
                    lblKq.setText("Kết quả: " + n + " là số nguyên tố.");
                else
                    lblKq.setText("Kết quả: " + n + " không phải số nguyên tố.");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập một số nguyên hợp lệ!");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new B4().setVisible(true);
        });
    }
}
