import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    static JFrame jFrame = getFrame();
    static JPanel jPanel = new JPanel();

    public static void main(String[] args) {
        jFrame.add(jPanel);
        JButton jButton = new JButton("show file dialog");
        jPanel.add(jButton);
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                //fileChooser.showOpenDialog(jPanel);
                //fileChooser.showSaveDialog(jPanel);

                fileChooser.setMultiSelectionEnabled(true);
                fileChooser.setCurrentDirectory(new File("C:\\"));

                int i = fileChooser.showDialog(jPanel,"save as");
                System.out.println(i);

                File file = fileChooser.getSelectedFile();
                System.out.println(file.getName());

                //fileChooser.setSelectedFile(new File(""));
                //fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

//                fileChooser.setFileFilter(new FileFilter() {
//                    @Override
//                    public boolean accept(File f) {
//                        if(f.getName().endsWith("jpg")){
//                            return true;
//                        }
//                       return false;
//                    }
//
//                    @Override
//                    public String getDescription() {
//                        return "only jpg files";
//                    }
//                });

//                TextField textField = new TextField("blasagkljalg", 50);
//                //fileChooser.add(textField);
//
//                fileChooser.addPropertyChangeListener(new PropertyChangeListener() {
//                    @Override
//                    public void propertyChange(PropertyChangeEvent evt) {
//                        textField.setText(evt.getPropertyName());
//                    }
//                });


            }
        });


        jPanel.revalidate();
    }

    static JFrame getFrame() {
        JFrame jFrame = new JFrame() {};
        jFrame.setVisible(true);
        jFrame.setBounds(750,250,500,500);
        jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
        return jFrame;
    }
}
