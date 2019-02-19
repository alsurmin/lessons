import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    static JFrame jFrame = getFrame();

    public static void main(String[] args) {
        JMenuBar jMenuBar = new JMenuBar();

        JMenu file = new JMenu("File");
        JMenu edit = new JMenu("Edit");
        jMenuBar.add(file);
        jMenuBar.add(edit);

        file.add(new JMenuItem("Open"));
        JMenuItem save = file.add(new JMenuItem("Save"));
        save.setEnabled(false);
        file.addSeparator();
        JMenuItem exit = file.add(new JMenuItem("Exit"));
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        exit.setAccelerator(KeyStroke.getKeyStroke("ctrl E"));

        edit.add(new JMenuItem("Cut"));
        edit.add(new JMenuItem("Copy"));
        JMenu options = new JMenu("Options");
        edit.add(options);
        options.add("one");
        options.add("two");

        edit.add(new JCheckBoxMenuItem("checkBox"));

        ButtonGroup buttonGroup = new ButtonGroup();
        JRadioButtonMenuItem radioButtonMenuItem = new JRadioButtonMenuItem("Radio1");
        JRadioButtonMenuItem radioButtonMenuItem1 = new JRadioButtonMenuItem("Radio2");
        buttonGroup.add(radioButtonMenuItem);
        buttonGroup.add(radioButtonMenuItem1);
        edit.add(radioButtonMenuItem);
        edit.add(radioButtonMenuItem1);

//        radioButtonMenuItem.setDebugGraphicsOptions(DebugGraphics.LOG_OPTION);


        jFrame.setJMenuBar(jMenuBar);
        jFrame.revalidate();

        RepaintManager.currentManager(jFrame.getRootPane()).setDoubleBufferingEnabled(false);
        ((JComponent)jFrame.getContentPane()).setDebugGraphicsOptions(DebugGraphics.FLASH_OPTION);

    }

    static JFrame getFrame() {
        JFrame jFrame = new JFrame() {};
        jFrame.setVisible(true);
        jFrame.setBounds(750,250,500,500);
        jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
        return jFrame;
    }
}
