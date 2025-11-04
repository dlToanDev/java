import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class B1 extends JFrame implements ItemListener {
    private JCheckBox checkBold;
    private JCheckBox checkItalic;
    private JTextField txtText;

    public B1() {
        setTitle("Demo Checkbox");
        setSize(300, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        checkBold = new JCheckBox("Bold");
        checkItalic = new JCheckBox("Italic");

        checkBold.addItemListener(this);
        checkItalic.addItemListener(this);

        txtText = new JTextField("Sample Text", 16);
        txtText.setFont(new Font("Courier", Font.PLAIN, 14));

        add(txtText);
        add(checkBold);
        add(checkItalic);
    }

    public void itemStateChanged(ItemEvent e) {
        int style = Font.PLAIN;
        if (checkBold.isSelected()) style += Font.BOLD;
        if (checkItalic.isSelected()) style += Font.ITALIC;
        txtText.setFont(new Font("Courier", style, 14));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new B1().setVisible(true));
    }
}
