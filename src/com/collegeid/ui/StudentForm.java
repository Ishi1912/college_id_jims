package com.collegeid.ui;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.sql.SQLException;

import com.collegeid.dao.StudentDAO;
import com.collegeid.dto.StudentDTO;

public class StudentForm extends JFrame {

    JTextField txtName, txtEnroll, txtCourse, txtShift, txtMobile, txtCollege;
    ImageIcon uploadedPhoto;

    public StudentForm() {

        setTitle("College ID Card Generator");
        setSize(450, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(8, 2, 10, 10));
        panel.setBorder(new TitledBorder("Student Details"));
        panel.setBackground(Color.cyan);
        add(panel);

        txtName = new JTextField();
        txtEnroll = new JTextField();
        txtCourse = new JTextField();
        txtShift = new JTextField();
        txtMobile = new JTextField();
        txtCollege = new JTextField();

        JButton btnUpload = new JButton("Upload Photo");
        JButton btnGenerate = new JButton("Generate ID");

        panel.add(new JLabel("Name:"));
        panel.add(txtName);

        panel.add(new JLabel("Enrollment No:"));
        panel.add(txtEnroll);

        panel.add(new JLabel("Course:"));
        panel.add(txtCourse);

        panel.add(new JLabel("Shift:"));
        panel.add(txtShift);

        panel.add(new JLabel("Mobile:"));
        panel.add(txtMobile);

        panel.add(new JLabel("College:"));
        panel.add(txtCollege);

        panel.add(btnUpload);
        panel.add(btnGenerate);

        //Upload Photo 
        btnUpload.addActionListener(e -> {
            JFileChooser fc = new JFileChooser();
            if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                ImageIcon icon = new ImageIcon(fc.getSelectedFile().getAbsolutePath());
                Image img = icon.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
                uploadedPhoto = new ImageIcon(img);
            }
        });

        //Generate Button
        btnGenerate.addActionListener(e -> {

            if (txtName.getText().trim().isEmpty() ||
                txtEnroll.getText().trim().isEmpty()) {

                JOptionPane.showMessageDialog(
                        this,
                        "Name and Enrollment are required",
                        "Validation Error",
                        JOptionPane.WARNING_MESSAGE
                );
                return;
            }

            StudentDTO dto = new StudentDTO();
            dto.setName(txtName.getText().trim());
            dto.setEnrollment(txtEnroll.getText().trim());
            dto.setCourse(txtCourse.getText().trim().toUpperCase());
            dto.setShift(txtShift.getText().trim());
            dto.setPhone(txtMobile.getText().trim());

            try {
                StudentDAO dao = new StudentDAO();
                String msg = dao.saveStudent(dto);
                JOptionPane.showMessageDialog(this, msg);
            } catch (ClassNotFoundException | SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(
                        this,
                        "Database Error: " + ex.getMessage(),
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );
                return;
            }

            new IDCardPreview(
                    txtName.getText(),
                    txtEnroll.getText(),
                    txtCourse.getText(),
                    txtShift.getText(),
                    txtMobile.getText(),
                    txtCollege.getText(),
                    uploadedPhoto
            ).setVisible(true);
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new StudentForm().setVisible(true));
    }
}