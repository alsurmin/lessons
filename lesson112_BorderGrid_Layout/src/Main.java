import javax.swing.*;
import java.awt.*;

public class Main {
    static JFrame jFrame = getFrame();
    static JPanel jPanel = new JPanel();

    public static void main(String[] args) {
//        jFrame.add(new JButton("one"), BorderLayout.NORTH);
//        jFrame.add(new JButton("two"), BorderLayout.WEST);
//        jFrame.add(new JButton("three"), BorderLayout.SOUTH);
//        jFrame.add(new JButton("fore"), BorderLayout.EAST);
//        jFrame.add(new JButton("five"), BorderLayout.CENTER);

        JPanel jPanel = new JPanel();
        jFrame.add(jPanel);
        jPanel.setLayout(new GridLayout(3,3));
        jPanel.add(new JButton("one"));
        jPanel.add(new JButton("two"));
        jPanel.add(new JButton("three"));
        jPanel.add(new JButton("fore"));
        jPanel.add(new JButton("five"));
        jPanel.add(new JButton("six"));
        jPanel.add(new JButton("seven"));
        jPanel.add(new JButton("eight"));
        jPanel.add(new JButton("nine"));

    }

    static JFrame getFrame() {
        JFrame jFrame = new JFrame() {};
        jFrame.setVisible(true);
        jFrame.setBounds(750,250,500,500);
        jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
        return jFrame;
    }
}
