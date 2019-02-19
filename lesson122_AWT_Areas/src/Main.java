import javax.swing.*;
import java.awt.*;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
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

            Area area = new Area(new Rectangle2D.Double(0,0,100,100));
            //area.add(new Area(new Ellipse2D.Double(50,50,150,150)));
            //area.subtract(new Area(new Ellipse2D.Double(50,50,150,150)));
            //area.intersect(new Area(new Ellipse2D.Double(50,50,150,150)));
            area.exclusiveOr(new Area(new Ellipse2D.Double(50,50,150,150)));


            g2.fill(area);

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
