import java.awt.*;
import java.io.File;
import java.net.URI;

public class Main {

    public static void main(String[] args) throws Exception {
        if (Desktop.isDesktopSupported()) {
            Desktop desktop = Desktop.getDesktop();
            if(desktop.isSupported(Desktop.Action.OPEN)) {
                //desktop.open(new File("C:\\Users\\Алексей\\Desktop\\interviews-master\\lesson139_AWT_Start_another_app\\car.jpg"));
            }

            if(desktop.isSupported(Desktop.Action.BROWSE)) {
                desktop.browse(new URI("https://www.google.com/"));
            }

        }
    }
}

