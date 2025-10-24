import java.awt.*;
import javax.swing.*;

public class B1 extends JFrame {

    private JList<String> listA, listB;
    private DefaultListModel<String> modelA, modelB;
    private JButton btnToRight, btnToLeft;

    public B1() {
        setTitle("Bài 1 - TransferBox");
        setSize(500, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        modelA = new DefaultListModel<>();
        modelB = new DefaultListModel<>();

        modelA.addElement("Black");
        modelA.addElement("Blue");
        modelA.addElement("Cyan");
        modelA.addElement("Gray");
        modelA.addElement("Dark Gray");

        listA = new JList<>(modelA);
        listB = new JList<>(modelB);

        listA.setVisibleRowCount(8);
        listB.setVisibleRowCount(8);
        listA.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        listB.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        btnToRight = new JButton("Copy >>>");
        btnToLeft = new JButton("<<< Copy");

        btnToRight.addActionListener(e -> {
            for (String value : listA.getSelectedValuesList()) {
                modelB.addElement(value);
                modelA.removeElement(value);
            }
        });

        btnToLeft.addActionListener(e -> {
            for (String value : listB.getSelectedValuesList()) {
                modelA.addElement(value);
                modelB.removeElement(value);
            }
        });

        JPanel panelBtn = new JPanel(new GridLayout(2, 1, 5, 5));
        panelBtn.add(btnToRight);
        panelBtn.add(btnToLeft);

        add(new JScrollPane(listA));
        add(panelBtn);
        add(new JScrollPane(listB));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new B1().setVisible(true));
    }
}
