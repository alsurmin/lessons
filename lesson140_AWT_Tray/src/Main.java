import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    public static void main(String[] args) throws AWTException {
        if (SystemTray.isSupported()) {
            SystemTray tray = SystemTray.getSystemTray();
            Image image = new ImageIcon("C:\\Users\\Алексей\\Desktop\\interviews-master\\lesson140_AWT_Tray\\tray.jpg").getImage();

            MenuItem menuItem = new MenuItem("one");
            menuItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("one");
                }
            });

            PopupMenu popupMenu = new PopupMenu();
            popupMenu.add(menuItem);
            popupMenu.add(new MenuItem("two"));
            tray.add(new TrayIcon(image,"tray description"));

        }
    }
}
