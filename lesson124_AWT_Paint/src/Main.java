import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.IOException;


public class Main {
    static JFrame jFrame = getFrame();

    public static void main(String[] args) {
        jFrame.add(new MyComponent());

    }

    static class MyComponent extends JComponent {
        @Override
        public void paint(Graphics g) {
            Graphics2D g2 = (Graphics2D)g;
            //g2.setPaint(new GradientPaint(new Point(0,0), Color.RED, new Point(200,100),Color.yellow));
            try {
                g2.setPaint(new TexturePaint(ImageIO.read(new File("")),new Rectangle2D.Double(0,0,200,100)));
            } catch (IOException e) {
                e.printStackTrace();
            }

            Ellipse2D ellipse2D = new Ellipse2D.Double(10,10,200,100);
            g2.fill(ellipse2D);

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
