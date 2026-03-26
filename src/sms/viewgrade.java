package sms;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class viewgrade extends JFrame {

    private int studentId;
    private JTable table;

    public viewgrade(int studentId) {
        this.studentId = studentId;
        initUI();
        loadGrades();
    }

    private void initUI() {
        setTitle("View Grades");
        setSize(600, 400);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(221,232,242));
        panel.setLayout(null);

        JLabel title = new JLabel(" Your Grades");
        title.setFont(new Font("Segoe UI", Font.BOLD, 20));
        title.setBounds(220, 20, 200, 30);
        panel.add(title);

        table = new JTable();
        JScrollPane scroll = new JScrollPane(table);
        scroll.setBounds(50, 80, 500, 200);
        panel.add(scroll);

        JButton btnClose = new JButton("Close");
        btnClose.setBounds(230, 300, 120, 35);
        btnClose.setBackground(new Color(0,102,204));
        btnClose.setForeground(Color.WHITE);
        btnClose.addActionListener(e -> dispose());
        panel.add(btnClose);

        add(panel);
    }

    private void loadGrades() {
        DefaultTableModel model = new DefaultTableModel(
                new String[]{"Course", "Grade"}, 0);
        table.setModel(model);

        String sql = "SELECT c.course_name, g.grade " +
                     "FROM grades g " +
                     "JOIN courses c ON c.id = g.course_id " +
                     "WHERE g.student_id = ?";

        try (Connection c = Dbconnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(1, studentId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                model.addRow(new Object[]{
                        rs.getString("course_name"),
                        rs.getString("grade")
                });
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}