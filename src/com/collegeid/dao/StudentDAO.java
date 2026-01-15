package com.collegeid.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.collegeid.dto.StudentDTO;

public class StudentDAO {

    // Save student details to DB
    public String saveStudent(StudentDTO studentDTO) throws ClassNotFoundException, SQLException {
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            String sql = "INSERT INTO students (enrol, name, course, shift, phone) VALUES (?, ?, ?, ?, ?)";

            con = DB.createConnection(); // use your DB class
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

    // Optional: fetch student by enrollment
    public StudentDTO getStudentByEnrollment(String enrollment) throws ClassNotFoundException, SQLException {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM students WHERE enrol=?";
            con = DB.createConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, enrollment);

            rs = pstmt.executeQuery();
            if (rs.next()) {
                StudentDTO dto = new StudentDTO();
                dto.setEnrollment(rs.getString("enrol"));
                dto.setName(rs.getString("name"));
                dto.setCourse(rs.getString("course"));
                dto.setShift(rs.getString("shift"));
                dto.setPhone(rs.getString("phone"));
                return dto;
            } else {
                return null; // student not found
            }
        } finally {
            if (rs != null) rs.close();
            if (pstmt != null) pstmt.close();
            if (con != null) con.close();
        }
    }
}
