package com.collegeid.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.collegeid.dto.StudentDTO;

public class StudentDAO {

    // Save student details to DB
    public String saveStudent(StudentDTO studentDTO) throws ClassNotFoundException, SQLException {
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            String sql = "INSERT INTO students (enrol, name, course, shift, phone) VALUES (?, ?, ?, ?, ?)";

            con = DB.createConnection();
            pstmt = con.prepareStatement(sql);

            pstmt.setString(1, studentDTO.getEnrollment());
            pstmt.setString(2, studentDTO.getName());
            pstmt.setString(3, studentDTO.getCourse());
            pstmt.setString(4, studentDTO.getShift());
            pstmt.setString(5, studentDTO.getPhone());

            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                return "Student ID saved successfully!";
            } else {
                return "Failed to save student ID!";
            }
        } finally {
            if (pstmt != null) pstmt.close();
            if (con != null) con.close();
        }
    }
}
