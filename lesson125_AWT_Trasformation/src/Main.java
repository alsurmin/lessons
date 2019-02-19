import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Main {
    static JFrame jFrame = getFrame();

    public static void main(String[] args) {
        jFrame.add(new MyComponent());
    }

    static class MyComponent extends JComponent {
        @Override
        public void paint(Graphics g) {
            Graphics2D g2 = (Graphics2D)g;
            Rectangle2D rectangle2D = new Rectangle2D.Double(50,50,100,100);
            g2.scale(2,2);
            g2.translate(50,50);
            g2.shear(0.2,0.5);
            g2.rotate(1);

            g2.draw(rectangle2D);
        }
    }

    static JFrame getFrame() {
        JFrame jFrame = new JFrame() {};
        jFrame.setVisible(true);
        jFrame.setBounds(750,250,600,500);
        jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
        return jFrame;
    }
}
