import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;


public class Main {
    static JFrame jFrame = getFrame();

    public static void main(String[] args) {
        jFrame.add(new MyComponent());

    }

    static class MyComponent extends JComponent {
        @Override
        public void paint(Graphics g) {
            Graphics2D g2 = (Graphics2D)g;
            g2.setStroke(new BasicStroke(10, BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND,5,new float[]{5,10,20,30},0));

            Line2D line2D = new Line2D.Double(20,20,150,150);
            ((Graphics2D) g).draw(line2D);

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
