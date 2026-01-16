package com.collegeid.ui;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class IDCardPreview extends JFrame {

    public IDCardPreview(String name, String enroll, String course,
                         String shift, String mobile, String college,
                         ImageIcon photoIcon) {

        setTitle("ID Card");
        setSize(330, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel card = new JPanel(null);
        card.setBackground(new Color(230, 240, 255));
        card.setBorder(new LineBorder(Color.BLUE, 2, true));
        add(card);

        JLabel lblCollege = new JLabel(college.toUpperCase(), JLabel.CENTER);
        lblCollege.setBounds(0, 10, 300, 30);
        lblCollege.setFont(new Font("Arial", Font.BOLD, 16));
        card.add(lblCollege);

        JLabel photo = new JLabel("PHOTO", JLabel.CENTER);
        photo.setBounds(90, 50, 120, 120);
        photo.setBorder(new LineBorder(Color.GRAY));
        if (photoIcon != null)
            photo.setIcon(photoIcon);
        card.add(photo);

        JLabel lblName = new JLabel("Name: " + name);
        JLabel lblEnroll = new JLabel("Enroll: " + enroll);
        JLabel lblCourse = new JLabel("Course: " + course);
        JLabel lblShift = new JLabel("Shift: " + shift);
        JLabel lblMobile = new JLabel("Mobile: " + mobile);

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
    }
}
