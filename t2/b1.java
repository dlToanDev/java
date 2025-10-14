import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class b1 extends JFrame implements ActionListener {
    private JButton btn;

    public b1() {
        setTitle("Demo Applet thay thế bằng JFrame");
        setSize(300, 200);
        setLayout(new FlowLayout());

        btn = new JButton("Nhấn tôi");
        btn.addActionListener(this);

        add(btn);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(this, "Bạn vừa nhấn nút!");
    }

    public static void main(String[] args) {
        new b1();
    }
}
