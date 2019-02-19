import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Main {
    static JFrame jFrame = getFrame();

    public static void main(String[] args) {
        JComponent jComponent = new MyComponent();
        jFrame.add(jComponent);
        jFrame.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                super.mouseMoved(e);
                MyComponent.x = e.getX();
                MyComponent.y = e.getY();
                jComponent.repaint();
            }
        });
    }

    static class MyComponent extends JComponent {
        public static int x;
        public static int y;

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            ((Graphics2D)g).drawString("Coordinates x: "+ x + " y: "+ y, 50, 50);
        }
    }

    static JFrame getFrame() {
        JFrame jFrame = new JFrame() {};
        jFrame.setVisible(true);
        jFrame.setBounds(750,250,500,500);
        jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
        return jFrame;
    }
}
