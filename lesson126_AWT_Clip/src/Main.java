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

            Rectangle2D rectangle2D = new Rectangle2D.Double(0,0,100,100);
            Color color = new Color(0f,0f,0f);
            g2.setColor(color);
            g2.fill(rectangle2D);

            Rectangle2D rectangle2D1 = new Rectangle2D.Double(50,0,100,100);
            Color color1 = new Color(0f,0f,0f,0.5f);
            g2.setColor(color1);
            int rule = AlphaComposite.SRC_OUT;
            //float alpha = 0.5f;
            g2.setComposite(AlphaComposite.getInstance(rule));
            g2.fill(rectangle2D1);

            Rectangle2D rectangle2D2 = new Rectangle2D.Double(200,0,100,100);
            Color color2 = new Color(0f,0f,0f,0.1f);
            g2.setColor(color2);
            g2.fill(rectangle2D2);
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
