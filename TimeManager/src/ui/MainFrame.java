package ui;

import dao.ScheduleDAO;
import model.Schedule;
import model.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.sql.Time;
import java.util.List;

public class MainFrame extends JFrame {
    private User currentUser;
    private JTable table;
    private DefaultTableModel tableModel;

    public MainFrame(User user) {
        this.currentUser = user;
        setTitle("Quản lý thời khóa biểu - " + currentUser.getUsername());
        setSize(800, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        // Table
        tableModel = new DefaultTableModel(new String[]{"ID", "Ngày", "Tiêu đề", "Bắt đầu", "Kết thúc", "Note"}, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20, 20, 740, 250);
        add(scrollPane);

        // Buttons
        JButton btnAdd = new JButton("Thêm");
        btnAdd.setBounds(20, 300, 100, 30);
        JButton btnEdit = new JButton("Sửa");
        btnEdit.setBounds(140, 300, 100, 30);
        JButton btnDelete = new JButton("Xóa");
        btnDelete.setBounds(260, 300, 100, 30);

        add(btnAdd);
        add(btnEdit);
        add(btnDelete);

        // Load dữ liệu
        loadSchedule();

        // Thêm lịch
        btnAdd.addActionListener(e -> {
            Schedule s = showScheduleDialog(null);
            if (s != null) {
                ScheduleDAO.addSchedule(s);
                loadSchedule();
            }
        });

        // Sửa lịch
        btnEdit.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row >= 0) {
                int id = Integer.parseInt(tableModel.getValueAt(row, 0).toString());
                Schedule s = showScheduleDialog(new Schedule(
                        id,
                        currentUser.getId(),
                        tableModel.getValueAt(row, 1).toString(),
                        tableModel.getValueAt(row, 2).toString(),
                        Time.valueOf(tableModel.getValueAt(row, 3).toString()),
                        Time.valueOf(tableModel.getValueAt(row, 4).toString()),
                        tableModel.getValueAt(row, 5).toString()
                ));
                if (s != null) {
                    ScheduleDAO.deleteSchedule(id); // đơn giản: xóa rồi thêm lại
                    ScheduleDAO.addSchedule(s);
                    loadSchedule();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Chọn một dòng để sửa.");
            }
        });

        // Xóa lịch
        btnDelete.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row >= 0) {
                int id = Integer.parseInt(tableModel.getValueAt(row, 0).toString());
                int confirm = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xóa?");
                if (confirm == JOptionPane.YES_OPTION) {
                    ScheduleDAO.deleteSchedule(id);
                    loadSchedule();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Chọn một dòng để xóa.");
            }
        });
    }

    // Load dữ liệu từ database
    private void loadSchedule() {
        tableModel.setRowCount(0);
        List<Schedule> list = ScheduleDAO.getSchedulesByUser(currentUser.getId());
        for (Schedule s : list) {
            tableModel.addRow(new Object[]{
                    s.getId(),
                    s.getDayOfWeek(),
                    s.getTitle(),
                    s.getStartTime(),
                    s.getEndTime(),
                    s.getNote()
            });
        }
    }

    // Dialog thêm / sửa lịch
    private Schedule showScheduleDialog(Schedule old) {
        JTextField txtDay = new JTextField();
        JTextField txtTitle = new JTextField();
        JTextField txtStart = new JTextField();
        JTextField txtEnd = new JTextField();
        JTextField txtNote = new JTextField();

        if (old != null) {
            txtDay.setText(old.getDayOfWeek());
            txtTitle.setText(old.getTitle());
            txtStart.setText(old.getStartTime().toString());
            txtEnd.setText(old.getEndTime().toString());
            txtNote.setText(old.getNote());
        }

        Object[] message = {
                "Ngày:", txtDay,
                "Tiêu đề:", txtTitle,
                "Bắt đầu (HH:MM:SS):", txtStart,
                "Kết thúc (HH:MM:SS):", txtEnd,
                "Note:", txtNote
        };

        int option = JOptionPane.showConfirmDialog(null, message, old == null ? "Thêm lịch" : "Sửa lịch", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            try {
                return new Schedule(
                        old != null ? old.getId() : 0,
                        currentUser.getId(),
                        txtDay.getText(),
                        txtTitle.getText(),
                        Time.valueOf(txtStart.getText()),
                        Time.valueOf(txtEnd.getText()),
                        txtNote.getText()
                );
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, "Sai định dạng giờ! Vui lòng nhập HH:MM:SS");
            }
        }
        return null;
    }
}
