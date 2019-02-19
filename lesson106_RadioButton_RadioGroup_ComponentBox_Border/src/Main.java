import javax.swing.*;
import javax.swing.border.Border;

public class Main {
    static JFrame jFrame = getFrame();
    static JPanel jPanel = new JPanel();

    public static void main(String[] args) {
        jFrame.add(jPanel);
        JCheckBox jCheckBox = new JCheckBox("check box label");
        jCheckBox.setSelected(true);
        jPanel.add(jCheckBox);

        JRadioButton jRadioButton = new JRadioButton("one");
        JRadioButton jRadioButton1 = new JRadioButton("two");
        jRadioButton1.setSelected(true);
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(jRadioButton);
        buttonGroup.add(jRadioButton1);
        jPanel.add(jRadioButton);
        jPanel.add(jRadioButton1);

        JComboBox<String> comboBox = new JComboBox<>();
        comboBox.addItem("one");
        comboBox.addItem("two");
        comboBox.addItem("three");
        comboBox.addItem("fore");
        jPanel.add(comboBox);

        Border border = BorderFactory.createEtchedBorder();
        Border border1 = BorderFactory.createTitledBorder(border, "title");
        jPanel.setBorder(border1);
    }

    static JFrame getFrame() {
        JFrame jFrame = new JFrame() {};
        jFrame.setVisible(true);
        jFrame.setBounds(750,250,500,500);
        jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
        return jFrame;
    }
}
