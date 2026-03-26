/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sms;
import java.sql.*;
/**
 *
 * @author kiman
 */
public class Dbconnection {
     public static Connection getConnection() {
        try {
            return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/SMS", "root", "root"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
