import javax.swing.*;

public class Main {
    static JFrame jFrame = getFrame();
    static JPanel jPanel = new JPanel();

    public static void main(String[] args) throws Exception {
        jFrame.add(jPanel);
        JTextField jTextField = new JTextField(10);
        JTextField jTextField1 = new JTextField(10);
        jTextField.setDragEnabled(true);
        jTextField1.setDragEnabled(true);

        jPanel.add(jTextField);
        jPanel.add(jTextField1);

        jFrame.revalidate();
    }

    static JFrame getFrame() {
        JFrame jFrame = new JFrame(){};
        jFrame.setVisible(true);
        jFrame.setBounds(750,250,500,500);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        return  jFrame;
    }
}

