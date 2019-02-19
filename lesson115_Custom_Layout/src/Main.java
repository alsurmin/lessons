import javax.swing.*;
import java.awt.*;

public class Main {
    static JFrame jFrame = getFrame();
    static JPanel jPanel = new JPanel();

    public static void main(String[] args) {
        jFrame.add(jPanel);
        jPanel.setLayout(new MyLayout());
        jPanel.add(new Button("submit"));
        jPanel.add(new Button("submit1"));
        jPanel.add(new Button("submit2"));


        jPanel.revalidate();
    }

    static class MyLayout implements LayoutManager {
        @Override
        public void addLayoutComponent(String name, Component comp) {

        }

        @Override
        public void removeLayoutComponent(Component comp) {

        }

        @Override
        public Dimension preferredLayoutSize(Container parent) {
            return null;
        }

        @Override
        public Dimension minimumLayoutSize(Container parent) {
            return null;
        }

        @Override
        public void layoutContainer(Container parent) {
            for (int i = 0; i < parent.getComponentCount(); i++) {
                Component component = parent.getComponent(i);
                component.setBounds(i*100, i*40, 100, 40);
            }
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
