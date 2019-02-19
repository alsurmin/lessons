import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class Main {

    public static void main(String[] args) {
        JFrame jFrame = getFrame();
        JPanel jPanel = new JPanel();
        jFrame.add(jPanel);
        JButton jButton = new JButton("submit");
        jPanel.add(jButton);
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.setTitle(jFrame.getTitle()+1);
                jPanel.setBackground(Color.CYAN);
            }
        });

        JButton jButton1 = new JButton("click cubmit");
        jPanel.add(jButton1);
        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GraphicsEnvironment environment = GraphicsEnvironment.getLocalGraphicsEnvironment();
                GraphicsDevice screen = environment.getDefaultScreenDevice();
                Robot robot = null;
                try {
                    robot = new Robot(screen);
//                    robot.mouseMove(750 + 200, 250 + 50); // x and y are absolute screen pixel coordinates.
//                    robot.mousePress(InputEvent.BUTTON1_MASK);
//                    robot.mouseRelease(InputEvent.BUTTON1_MASK);

//                    robot.keyPress(KeyEvent.VK_TAB);
//                    robot.keyRelease(KeyEvent.VK_TAB);

                    Rectangle rect = new Rectangle(0, 0, 1000, 1000);
                    BufferedImage image = robot.createScreenCapture(rect);

                } catch (AWTException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }


    static JFrame getFrame() {
        JFrame jFrame = new JFrame() {};
        jFrame.setVisible(true);
        jFrame.setBounds(750,250,500,500);
        jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
        return jFrame;
    }
}
