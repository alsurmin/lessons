package com.company;

import javax.swing.*;

public class Main {
    static JFrame jFrame = getFrame();
    static JPanel jPanel = new JPanel();

    public static void main(String[] args) {
        jFrame.add(jPanel);
        jPanel.add(new JTextField("this is textField",20));
        JTextField jTextField = new JTextField();

        JLabel jLabel = new JLabel("this is label");
        jPanel.add(jLabel);

        JPasswordField jPasswordField = new JPasswordField(20);
        jPanel.add(jPasswordField);

        JTextArea jTextArea = new JTextArea(5, 20);
        jTextArea.setLineWrap(true);
        JScrollPane jScrollPane = new JScrollPane(jTextArea);
        jPanel.add(jScrollPane);

        jPanel.revalidate();

    }

    static JFrame getFrame() {
        JFrame jFrame = new JFrame() {};
        jFrame.setVisible(true);
        jFrame.setBounds(750,250,500,500);
        jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
        return jFrame;
    }
}
