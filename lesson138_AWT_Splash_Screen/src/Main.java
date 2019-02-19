import javax.swing.*;
import java.awt.*;

public class Main {

    static SplashScreen splash = SplashScreen.getSplashScreen();

    public static void main(String[] args) throws InterruptedException {
        Rectangle bounds = splash.getBounds();
        Graphics2D g = splash.createGraphics();
        g.setColor(Color.blue);

        for (int i = 0; i < 100; i++) {
//            drawOnSplash(i);
//            Thread.sleep(100);
       }

        final Image image = new ImageIcon(splash.getImageURL()).getImage();
        final JPanel splashPanel = new JPanel() {
            public void paintComponent(Graphics g)
            {g.drawImage(image, 0, 0, null);}
        };
        final JFrame splashFrame = new JFrame();
        splashFrame.setUndecorated(true);
        final JProgressBar progressBar = new JProgressBar();
        progressBar.setStringPainted(true);
        splashPanel.setLayout(new BorderLayout());
        splashPanel.add(progressBar, BorderLayout.SOUTH);
        splashFrame.add(splashPanel);
        splashFrame.setBounds(splash.getBounds());
        splashFrame.setVisible(true);

        try {
            for (int i = 0; i <= 100; i++) {
                progressBar.setString("Loading module " + i);
                progressBar.setValue(i);
                splashPanel.repaint(); // because img is loaded asynchronously
                Thread.sleep(100);
            }

    } catch (InterruptedException e) {
        }
        splashFrame.setVisible(false);
    }

    private static void drawOnSplash(int percent) {
        Rectangle bounds = splash.getBounds();
        Graphics2D g = splash.createGraphics();
        int height = 20;
        int x = 2;
        int y = bounds.height - height - 2;
        int width = bounds.width - 4;
        Color brightPurple = new Color(76, 36, 121);
        g.setColor(brightPurple);
        g.fillRect(x, y, width * percent / 100, height);
        splash.update();
        }

}
