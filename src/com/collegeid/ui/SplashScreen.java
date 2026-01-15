package com.collegeid.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;
import javax.swing.Timer;

public class SplashScreen extends JWindow {

    JProgressBar progressBar;
    Timer timer;

    public SplashScreen() {

        // window size (ID card theme → smaller looks better)
        setSize(800, 500);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.WHITE);

        // College Logo / ID Card Image
        ImageIcon image = new ImageIcon("images/college_logo.png");
        JLabel lbl = new JLabel(image);
        lbl.setHorizontalAlignment(JLabel.CENTER);
        getContentPane().add(lbl, BorderLayout.CENTER);

        // Progress Bar
        progressBar = new JProgressBar(0, 100);
        progressBar.setStringPainted(true);
        progressBar.setForeground(new Color(0, 102, 204)); // blue shade
        getContentPane().add(progressBar, BorderLayout.SOUTH);

        loadProgress();
    }

    void loadProgress() {
        timer = new Timer(25, e -> {
            int value = progressBar.getValue();

            if (value < 100) {
                progressBar.setValue(value + 1);
            } else {
                timer.stop();
                dispose(); // close splash screen

                // Open College ID Generator Screen
                StudentForm frame = new StudentForm();
                frame.setVisible(true);
            }
        });
        timer.start();
    }

    public static void main(String[] args) {
        new SplashScreen().setVisible(true);
    }
}
