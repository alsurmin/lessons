import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame("App");
        frame.setContentPane(new App().getPanelMain());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setBounds(600,250,500,500);
        frame.setVisible(true);
    }
}
