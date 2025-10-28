package dao;

import database.DatabaseConnection;
import model.Schedule;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ScheduleDAO {

    public static void addSchedule(Schedule s) {
        String sql = "INSERT INTO Schedule (user_id, day_of_week, title, start_time, end_time, note) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, s.getUserId());
            stmt.setString(2, s.getDayOfWeek());
            stmt.setString(3, s.getTitle());
            stmt.setTime(4, s.getStartTime());
            stmt.setTime(5, s.getEndTime());
            stmt.setString(6, s.getNote());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Lỗi thêm lịch: " + e.getMessage());
        }
    }

    public static List<Schedule> getSchedulesByUser(int userId) {
        List<Schedule> list = new ArrayList<>();
        String sql = "SELECT * FROM Schedule WHERE user_id=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                list.add(new Schedule(
                    rs.getInt("id"),
                    userId,
                    rs.getString("day_of_week"),
                    rs.getString("title"),
                    rs.getTime("start_time"),
                    rs.getTime("end_time"),
                    rs.getString("note")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Lỗi lấy lịch: " + e.getMessage());
        }
        return list;
    }

    public static void deleteSchedule(int id) {
        String sql = "DELETE FROM Schedule WHERE id=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Lỗi xóa: " + e.getMessage());
        }
    }
}
