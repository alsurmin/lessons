import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;


public class Main {
    static JFrame jFrame = getFrame();

    public static void main(String[] args) {
        jFrame.add(new MyComponent());

    }

    static class MyComponent extends JComponent {
        @Override
        public void paint(Graphics g) {
            Graphics2D g2 = (Graphics2D)g;
            Point2D point1 = new Point2D.Double(50,0);
            Point2D point2 = new Point2D.Double(100,50);

            Line2D line = new Line2D.Float(point1,point2);
            g2.draw(line);

            Rectangle2D rectangle2D = new Rectangle2D.Double(100,0,100,50);
            g2.draw(rectangle2D);

            RoundRectangle2D rectangle2D1 = new RoundRectangle2D.Double(200,0,100,50,20,20);
            g2.draw(rectangle2D1);

            Ellipse2D ellipse2D = new Ellipse2D.Double(300,0,100,50);
            g2.draw(ellipse2D);

            QuadCurve2D quadCurve2D = new QuadCurve2D.Double(400,0,425,100,450,0);
            g2.draw(quadCurve2D);

            CubicCurve2D qCubicCurve2D = new CubicCurve2D.Double(450, 50,475,150,525,-50,550,50);
            g2.draw(qCubicCurve2D);

            Arc2D
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
