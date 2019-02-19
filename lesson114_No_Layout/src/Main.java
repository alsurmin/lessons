import javax.swing.*;
import java.awt.*;

public class Main {
    static JFrame jFrame = getFrame();
    static JPanel jPanel = new JPanel();

    public static void main(String[] args) {
        jFrame.add(jPanel);
        jPanel.setLayout(null);

        JButton jButton = new JButton("submit");
        jButton.setBounds(50,50,150,40);
        jPanel.add(jButton);
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
