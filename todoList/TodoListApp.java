import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;

/**
 * Ứng dụng Danh sách Việc cần làm (Todo List App) sử dụng Java Swing.
 * Bao gồm cả màn hình Đăng nhập/Đăng ký giả lập (mock authentication).
 */
public class TodoListApp extends JFrame {

    // --- Mock Authentication Data ---
    // Sử dụng Map tĩnh để mô phỏng việc lưu trữ người dùng (Username -> Password)
    private static final Map<String, String> MOCK_USERS = new HashMap<>();
    static {
        // Thêm một người dùng mặc định để kiểm tra
        MOCK_USERS.put("user", "password");
        MOCK_USERS.put("admin", "123456");
    }
    // --- End Mock Authentication Data ---


    // Model chứa dữ liệu cho JList
    private DefaultListModel<String> todoListModel;
    // JList hiển thị danh sách công việc
    private JList<String> todoList;
    // Trường nhập liệu cho công việc mới
    private JTextField taskInputField;
    // Nút để hoàn thành/xóa công việc đã chọn
    private JButton completeButton;

    // Constructor để thiết lập giao diện chính của To-Do List
    public TodoListApp() {
        // Thiết lập tiêu đề và cấu hình frame
        setTitle("Danh sách Việc cần làm (To-Do List App)");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 600); // Kích thước cửa sổ
        setLocationRelativeTo(null); // Đặt cửa sổ ở giữa màn hình
        setLayout(new BorderLayout(10, 10)); // Sử dụng BorderLayout cho bố cục chính

        // 1. Khởi tạo Model và List
        todoListModel = new DefaultListModel<>();
        todoList = new JList<>(todoListModel);
        todoList.setFont(new Font("Arial", Font.PLAIN, 16));
        todoList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // Đặt JList vào JScrollPane để có thể cuộn
        JScrollPane scrollPane = new JScrollPane(todoList);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Công việc hiện tại:"));

        // Thêm JScrollPane vào trung tâm của frame
        add(scrollPane, BorderLayout.CENTER);

        // 2. Thiết lập Panel nhập liệu (Input Panel)
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BorderLayout(5, 5));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10)); // Padding

        // Nhãn và Trường nhập liệu
        JLabel inputLabel = new JLabel("Nhập công việc mới:");
        inputLabel.setFont(new Font("Arial", Font.BOLD, 14));
        taskInputField = new JTextField(25);
        taskInputField.setFont(new Font("Arial", Font.PLAIN, 14));

        // Nút Thêm
        JButton addButton = new JButton("Thêm");
        addButton.setFont(new Font("Arial", Font.BOLD, 14));
        addButton.setBackground(new Color(60, 179, 113)); // Màu xanh lá
        addButton.setForeground(Color.WHITE);
        addButton.setFocusPainted(false);
        // Thiết lập hành động khi nhấn nút Thêm
        addButton.addActionListener(new AddTaskListener());

        // Bố cục cho Input Panel
        inputPanel.add(inputLabel, BorderLayout.WEST);
        inputPanel.add(taskInputField, BorderLayout.CENTER);
        inputPanel.add(addButton, BorderLayout.EAST);

        // Thêm Input Panel vào phía trên (North) của frame
        add(inputPanel, BorderLayout.NORTH);

        // 3. Thiết lập Panel nút hành động (Action Panel)
        JPanel actionPanel = new JPanel();
        actionPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        actionPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));

        // Nút Hoàn thành/Xóa
        completeButton = new JButton("Hoàn thành công việc đã chọn");
        completeButton.setFont(new Font("Arial", Font.BOLD, 14));
        completeButton.setBackground(new Color(220, 20, 60)); // Màu đỏ
        completeButton.setForeground(Color.WHITE);
        completeButton.setFocusPainted(false);
        // Thiết lập hành động khi nhấn nút Hoàn thành/Xóa
        completeButton.addActionListener(new CompleteTaskListener());

        actionPanel.add(completeButton);

        // Thêm Action Panel vào phía dưới (South) của frame
        add(actionPanel, BorderLayout.SOUTH);

        // Liên kết phím Enter với nút "Thêm"
        taskInputField.addActionListener(new AddTaskListener());

        // CHÚ Ý: Không gọi setVisible(true) ở đây. Nó sẽ được gọi sau khi xác thực thành công.
    }

    /**
     * Lớp Listener xử lý sự kiện khi nhấn nút "Thêm" hoặc nhấn Enter trong ô nhập liệu.
     */
    private class AddTaskListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String taskText = taskInputField.getText().trim();

            if (!taskText.isEmpty()) {
                todoListModel.addElement(taskText);
                taskInputField.setText("");
            } else {
                JOptionPane.showMessageDialog(TodoListApp.this,
                        "Vui lòng nhập nội dung công việc.",
                        "Lỗi Nhập liệu",
                        JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    /**
     * Lớp Listener xử lý sự kiện khi nhấn nút "Hoàn thành công việc đã chọn".
     */
    private class CompleteTaskListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int selectedIndex = todoList.getSelectedIndex();

            if (selectedIndex != -1) {
                todoListModel.remove(selectedIndex);
            } else {
                JOptionPane.showMessageDialog(TodoListApp.this,
                        "Vui lòng chọn một công việc để hoàn thành/xóa.",
                        "Không có lựa chọn",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    /**
     * Lớp Dialog riêng biệt để xử lý Đăng nhập và Đăng ký.
     */
    private class AuthDialog extends JDialog implements ActionListener {
        private JTextField usernameField;
        private JPasswordField passwordField;
        private JButton loginButton;
        private JButton registerButton;
        private JLabel statusLabel;
        private boolean isAuthenticated = false; // Cờ theo dõi trạng thái đăng nhập

        public AuthDialog(JFrame parent) {
            super(parent, "Đăng nhập / Đăng ký", true); // Dialog modal (chặn tương tác với cửa sổ chính)
            setLayout(new BorderLayout(10, 10));
            setSize(350, 250);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(DISPOSE_ON_CLOSE); // Đóng dialog khi click X

            // --- Panel nhập liệu ---
            JPanel inputPanel = new JPanel(new GridLayout(3, 2, 5, 5));
            inputPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 10, 15));

            usernameField = new JTextField(15);
            passwordField = new JPasswordField(15);

            inputPanel.add(new JLabel("Tên đăng nhập:"));
            inputPanel.add(usernameField);
            inputPanel.add(new JLabel("Mật khẩu:"));
            inputPanel.add(passwordField);

            statusLabel = new JLabel("Vui lòng đăng nhập hoặc đăng ký");
            statusLabel.setHorizontalAlignment(SwingConstants.CENTER);
            inputPanel.add(new JLabel()); // Ô trống cho statusLabel
            inputPanel.add(statusLabel);


            // --- Panel nút bấm ---
            JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
            loginButton = new JButton("Đăng nhập");
            registerButton = new JButton("Đăng ký");

            loginButton.addActionListener(this);
            registerButton.addActionListener(this);

            buttonPanel.add(loginButton);
            buttonPanel.add(registerButton);

            // Thêm components vào dialog
            add(inputPanel, BorderLayout.CENTER);
            add(buttonPanel, BorderLayout.SOUTH);

            // Hiển thị dialog
            setVisible(true);
        }

        public boolean isAuthenticated() {
            return isAuthenticated;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String username = usernameField.getText().trim();
            String password = new String(passwordField.getPassword());

            if (username.isEmpty() || password.isEmpty()) {
                statusLabel.setText("Tên đăng nhập và mật khẩu không được trống!");
                statusLabel.setForeground(Color.RED);
                return;
            }

            if (e.getSource() == loginButton) {
                handleLogin(username, password);
            } else if (e.getSource() == registerButton) {
                handleRegister(username, password);
            }
        }

        private void handleLogin(String username, String password) {
            if (MOCK_USERS.containsKey(username) && MOCK_USERS.get(username).equals(password)) {
                isAuthenticated = true; // Đăng nhập thành công
                dispose(); // Đóng dialog
            } else {
                statusLabel.setText("Đăng nhập thất bại. Vui lòng kiểm tra lại.");
                statusLabel.setForeground(Color.RED);
            }
        }

        private void handleRegister(String username, String password) {
            if (MOCK_USERS.containsKey(username)) {
                statusLabel.setText("Tên đăng nhập đã tồn tại.");
                statusLabel.setForeground(Color.ORANGE);
            } else {
                MOCK_USERS.put(username, password);
                statusLabel.setText("Đăng ký thành công! Vui lòng Đăng nhập.");
                statusLabel.setForeground(new Color(60, 179, 113)); // Màu xanh lá
            }
        }
    }

    /**
     * Hàm main: Khởi chạy Dialog Đăng nhập/Đăng ký trước, sau đó mới mở ứng dụng chính.
     */
    public static void main(String[] args) {
        // Đảm bảo giao diện được tạo trên EDT (Event Dispatch Thread)
        SwingUtilities.invokeLater(() -> {
            // 1. Tạo instance của ứng dụng chính (chưa hiển thị)
            TodoListApp mainApp = new TodoListApp();

            // 2. Hiển thị dialog xác thực
            AuthDialog authDialog = mainApp.new AuthDialog(mainApp);

            // 3. Sau khi dialog đóng (dispose), kiểm tra trạng thái xác thực
            if (authDialog.isAuthenticated()) {
                mainApp.setVisible(true); // Nếu đăng nhập thành công, hiển thị ứng dụng chính
            } else {
                // Nếu người dùng đóng dialog mà không đăng nhập, thoát ứng dụng
                System.exit(0);
            }
        });
    }
}
