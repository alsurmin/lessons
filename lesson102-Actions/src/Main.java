import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Main {
    static JFrame jFrame = getFrame();
    static JPanel jPanel = new JPanel();
    public static void main(String[] args) {
        jFrame.add(jPanel);
        AbstractAction myAction = new MyAction();
        JButton jButton = new JButton(new MyAction());
        jButton.setText("submit");
        jPanel.add(jButton);

        KeyStroke keyStroke = KeyStroke.getKeyStroke("ctrl B");
        InputMap inputMap = jPanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        inputMap.put(keyStroke,"change colour");
        ActionMap actionMap = jPanel.getActionMap();
        actionMap.put("change colour", myAction);

    }

        static class MyAction extends AbstractAction {

        MyAction() {
            putValue(AbstractAction.SHORT_DESCRIPTION, "My small action");
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            jPanel.setBackground(Color.BLUE);
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
