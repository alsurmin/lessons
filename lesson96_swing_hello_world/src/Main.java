import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {

    public static void main(String[] args) {
        JFrame jFrame = getFrame();
        jFrame.add(new MyComponent());

    }

    static class MyComponent extends JComponent {
        @Override
        protected void paintComponent(Graphics g) {
            Font font = new Font("Verdana", Font.BOLD, 20);
            Graphics2D g2 = (Graphics2D)g;
            g2.setFont(font);
            g2.drawString("hello world", 50,50);

            Point2D p1 = new Point2D.Double(70,70);
            Point2D p2 = new Point2D.Double(200,200);

            Line2D l2 = new Line2D.Double(p1,p2);
            g2.draw(l2);

            Ellipse2D el = new Ellipse2D.Double();
            el.setFrameFromDiagonal(p1,p2);
            g2.setPaint(Color.RED);
            g2.draw(el);

            Rectangle r2 = new Rectangle();
            r2.setFrameFromDiagonal(p1,p2);
            g2.draw(r2);

            //URL url = new URL("http://is2.mzstatic.com/image/thumb/Purple20/v4/90/4e/bc/904ebcd9-cf5c-3805-1ff5-9cf1e28db068/source/175x175bb.jpg");
            Image image = new ImageIcon("img/java.jpg").getImage();
            g2.drawImage(image, 250,60,null);

        }
    }

    static JFrame getFrame() {
        JFrame jFrame = new JFrame();
        jFrame.setTitle("this is my app");
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        jFrame.setBounds(dimension.width/2 - 250,dimension.height/2 - 150,500,300);
        return jFrame;
    }

}
