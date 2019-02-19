package com.company;

import bumpersticker.BumperSticker;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        JFrame jFrame = getFrame();
        JPanel jPanel = new JPanel();
        jPanel.add(new BumperSticker());
        jFrame.add(jPanel);
        FaceBean faceBean = new FaceBean();
        faceBean.frown();
        jFrame.add(faceBean);
        jFrame.revalidate();
    }

    static JFrame getFrame() {
        JFrame jFrame = new JFrame();
        jFrame.setVisible(true);
        jFrame.setBounds(750,250,500,500);
        jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
        return  jFrame;
    }

}
