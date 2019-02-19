import javax.swing.*;

public class Main {
    static JFrame jFrame = getFrame();
    static JPanel jPanel = new JPanel();

    public static void main(String[] args) {
        jFrame.add(jPanel);

        JToolBar jToolBar = new JToolBar("title");
        JButton one = new JButton("one");
        one.setToolTipText("first");
        jToolBar.add(one);
        jToolBar.addSeparator();
        jToolBar.add(new JButton("two"));
        jToolBar.add(new JButton("three"));
        jPanel.add(jToolBar);


    }

    static JFrame getFrame() {
        JFrame jFrame = new JFrame() {};
        jFrame.setVisible(true);
        jFrame.setBounds(750,250,500,500);
        jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
        return jFrame;
    }
}
