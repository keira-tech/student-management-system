package sms;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class viewcourse extends JFrame {

    private int studentId;
    private JTable table;

    public viewcourse(int studentId) {
        this.studentId = studentId;
        initComponents();
        loadCourses();
    }

    private void initComponents() {
        setTitle("View Courses");
        setSize(600, 400);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new java.awt.Color(221,232,242));

        JLabel title = new JLabel("My Courses");
        title.setFont(new java.awt.Font("Segoe UI", 1, 20));
        title.setBounds(220, 10, 200, 30);
        panel.add(title);

        table = new JTable();
        JScrollPane scroll = new JScrollPane(table);
        scroll.setBounds(50, 60, 500, 220);
        panel.add(scroll);

        JButton back = new JButton("Close");
        back.setBounds(250, 300, 100, 30);
        back.setBackground(new java.awt.Color(0,102,204));
        back.setForeground(java.awt.Color.WHITE);

        back.addActionListener(e -> dispose());

        panel.add(back);

        add(panel);
    }

    private void loadCourses() {
        DefaultTableModel model = new DefaultTableModel(
                new String[]{"Course Name"}, 0);

        table.setModel(model);

        String sql = "SELECT c.course_name FROM courses c " +
                     "JOIN grades g ON g.course_id = c.id " +
                     "WHERE g.student_id = ?";

        try (Connection conn = Dbconnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, studentId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                model.addRow(new Object[]{
                        rs.getString("course_name")
                });
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}