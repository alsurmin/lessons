import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.EventHandler;


public class Main {

    public static void main(String[] args) {
        JFrame jFrame = getFrame();
        JPanel jPanel = new JPanel();
        jFrame.add(jPanel);
        JButton jButton = new JButton("submit");
        jPanel.add(jButton);
//        jButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                jFrame.setTitle(((JButton)e.getSource()).getText());
//                jFrame.setTitle(JOptionPane.showInputDialog("Введите Title"));
//            }
//        });

        jButton.addActionListener(EventHandler.create(ActionListener.class, jFrame,"title", "source.text"));

    }

    static JFrame getFrame() {
        JFrame jFrame = new JFrame() {};
        jFrame.setVisible(true);
        jFrame.setBounds(750,250,500,500);
        jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
        return jFrame;
    }
}
