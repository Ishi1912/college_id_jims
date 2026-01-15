/*package com.collegeid.ui;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.sql.SQLException;

import com.collegeid.dao.StudentDAO;
import com.collegeid.dto.StudentDTO;

public class StudentForm extends JFrame {

    // Globals
    JTextField txtName, txtEnroll, txtCourse, txtShift, txtMobile, txtCollege;
    JLabel lblName, lblEnroll, lblCourse, lblShift, lblMobile, lblCollege;
    JLabel photo;

    public StudentForm() {

        setTitle("College ID Card Generator");
        setSize(950, 520);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // Left Panel (Form)
        JPanel leftPanel = new JPanel(new GridLayout(8, 2, 10, 10));
        leftPanel.setBorder(new TitledBorder("Student Details"));

        // Right Panel (Preview)
        JPanel rightPanel = new JPanel(null);
        rightPanel.setBorder(new TitledBorder("ID Card Preview"));
        rightPanel.setBackground(Color.WHITE);

        // Form Fields
        txtName = new JTextField();
        txtEnroll = new JTextField();
        txtCourse = new JTextField();
        txtShift = new JTextField();
        txtMobile = new JTextField();
        txtCollege = new JTextField();

        JButton btnGenerate = new JButton("Generate & Save ID");
        JButton btnUpload = new JButton("Upload Photo");

        leftPanel.add(new JLabel("Name:"));
        leftPanel.add(txtName);
        leftPanel.add(new JLabel("Enrollment No:"));
        leftPanel.add(txtEnroll);
        leftPanel.add(new JLabel("Course:"));
        leftPanel.add(txtCourse);
        leftPanel.add(new JLabel("Shift:"));
        leftPanel.add(txtShift);
        leftPanel.add(new JLabel("Mobile:"));
        leftPanel.add(txtMobile);
        leftPanel.add(new JLabel("College:"));
        leftPanel.add(txtCollege);
        leftPanel.add(btnUpload);
        leftPanel.add(btnGenerate);

        // ID Card Panel
        JPanel card = new JPanel(null);
        card.setBounds(50, 30, 300, 400);
        //card.setBackground(new Color(230, 240, 255));
        //card.setBorder(new LineBorder(Color.BLUE, 2, true));
        rightPanel.add(card);

        lblCollege = new JLabel("YOUR COLLEGE NAME", JLabel.CENTER);
        lblCollege.setBounds(0, 10, 300, 30);
        lblCollege.setFont(new Font("Arial", Font.BOLD, 16));
        card.add(lblCollege);

        photo = new JLabel("PHOTO", JLabel.CENTER);
        photo.setBounds(90, 50, 120, 120);
        photo.setBorder(new LineBorder(Color.GRAY));
        card.add(photo);

        lblName = new JLabel("Name:");
        lblEnroll = new JLabel("Enrol No:");
        lblCourse = new JLabel("Course:");
        lblShift = new JLabel("Shift:");
        lblMobile = new JLabel("Mobile:");

        lblName.setBounds(20, 190, 260, 20);
        lblEnroll.setBounds(20, 215, 260, 20);
        lblCourse.setBounds(20, 240, 260, 20);
        lblShift.setBounds(20, 265, 260, 20);
        lblMobile.setBounds(20, 290, 260, 20);

        card.add(lblName);
        card.add(lblEnroll);
        card.add(lblCourse);
        card.add(lblShift);
        card.add(lblMobile);

        // Generate + Save Button
        btnGenerate.addActionListener(e -> {

            // Validation
            if (txtName.getText().isEmpty() || txtEnroll.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "Name and Enrollment cannot be empty",
                        "Validation Error",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            // Preview Update
            lblName.setText("Name: " + txtName.getText());
            lblEnroll.setText("Enrol No: " + txtEnroll.getText());
            lblCourse.setText("Course: " + txtCourse.getText());
            lblShift.setText("Shift: " + txtShift.getText());
            lblMobile.setText("Mobile: " + txtMobile.getText());
            lblCollege.setText(txtCollege.getText().toUpperCase());

            // DTO Object
            StudentDTO dto = new StudentDTO();
            dto.setEnrollment(txtEnroll.getText());
            dto.setName(txtName.getText());
            dto.setCourse(txtCourse.getText());
            dto.setShift(txtShift.getText());
            dto.setPhone(txtMobile.getText());

            // DAO Call
            StudentDAO dao = new StudentDAO();
            try {
                String result = dao.saveStudent(dto);
                JOptionPane.showMessageDialog(this, result);
            } catch (ClassNotFoundException | SQLException ex) {
                JOptionPane.showMessageDialog(this,
                        "Database Error: " + ex.getMessage(),
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            }
        });

        // Upload Photo
        btnUpload.addActionListener(e -> {
            JFileChooser fc = new JFileChooser();
            if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                ImageIcon icon = new ImageIcon(fc.getSelectedFile().getAbsolutePath());
                Image img = icon.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
                photo.setIcon(new ImageIcon(img));
                photo.setText("");
            }
        });

        add(leftPanel, BorderLayout.WEST);
        add(rightPanel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        new StudentForm().setVisible(true);
    }
}
*/

package com.collegeid.ui;

import java.awt.Font;
import javax.swing.*;

import com.collegeid.dao.StudentDAO;
import com.collegeid.dto.StudentDTO;

public class StudentForm extends JFrame {

    JTextField txtName, txtEnroll, txtCourse, txtShift, txtMobile, txtCollege;
    JLabel lblPreview;

    public StudentForm() {

        setTitle("College ID Generator");
        setSize(600, 600);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null); // No Layout

        // -------- Labels --------
        JLabel nameLbl = new JLabel("Name");
        nameLbl.setBounds(50, 50, 100, 30);
        getContentPane().add(nameLbl);

        JLabel enrollLbl = new JLabel("Enrollment");
        enrollLbl.setBounds(50, 100, 100, 30);
        getContentPane().add(enrollLbl);

        JLabel courseLbl = new JLabel("Course");
        courseLbl.setBounds(50, 150, 100, 30);
        getContentPane().add(courseLbl);

        JLabel shiftLbl = new JLabel("Shift");
        shiftLbl.setBounds(50, 200, 100, 30);
        getContentPane().add(shiftLbl);

        JLabel mobileLbl = new JLabel("Mobile");
        mobileLbl.setBounds(50, 250, 100, 30);
        getContentPane().add(mobileLbl);

        JLabel collegeLbl = new JLabel("College");
        collegeLbl.setBounds(50, 300, 100, 30);
        getContentPane().add(collegeLbl);

        // -------- Text Fields --------
        txtName = new JTextField();
        txtName.setBounds(180, 50, 200, 30);
        getContentPane().add(txtName);

        txtEnroll = new JTextField();
        txtEnroll.setBounds(180, 100, 200, 30);
        getContentPane().add(txtEnroll);

        txtCourse = new JTextField();
        txtCourse.setBounds(180, 150, 200, 30);
        getContentPane().add(txtCourse);

        txtShift = new JTextField();
        txtShift.setBounds(180, 200, 200, 30);
        getContentPane().add(txtShift);

        txtMobile = new JTextField();
        txtMobile.setBounds(180, 250, 200, 30);
        getContentPane().add(txtMobile);

        txtCollege = new JTextField();
        txtCollege.setBounds(180, 300, 200, 30);
        getContentPane().add(txtCollege);

        // -------- Button --------
        JButton saveBtn = new JButton("Generate ID");
        saveBtn.setBounds(200, 360, 120, 40);
        getContentPane().add(saveBtn);

        saveBtn.addActionListener(e -> {
            doSave();
        });

        // -------- Preview --------
        lblPreview = new JLabel();
        lblPreview.setFont(new Font("Arial", Font.BOLD, 12));
        lblPreview.setBounds(50, 430, 500, 120);
        getContentPane().add(lblPreview);
    }

    // Same idea as doLogin()
    void doSave() {

       /* if (txtName.getText().isEmpty() || txtEnroll.getText().isEmpty()) { //agar empty hai to not allowed
            JOptionPane.showMessageDialog(this,
                    "Name & Enrollment are mandatory");
            return;
        }*/

        StudentDTO dto = new StudentDTO();
        dto.setName(txtName.getText());
        dto.setEnrollment(txtEnroll.getText());
        dto.setCourse(txtCourse.getText());
        dto.setShift(txtShift.getText());
        dto.setPhone(txtMobile.getText());

        StudentDAO dao = new StudentDAO();
        try {
            String result = dao.saveStudent(dto);
            JOptionPane.showMessageDialog(this, result);

            // Preview
            lblPreview.setText(
                "<html><b>" + txtCollege.getText().toUpperCase() + "</b><br>" +
                "Name: " + txtName.getText() + "<br>" +
                "Enroll: " + txtEnroll.getText() + "<br>" +
                "Course: " + txtCourse.getText() + "<br>" +
                "Shift: " + txtShift.getText() + "<br>" +
                "Mobile: " + txtMobile.getText() +
                "</html>"
            );

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        StudentForm sf = new StudentForm();
        sf.setVisible(true);
    }
}
