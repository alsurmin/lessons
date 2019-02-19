import javax.print.*;
import java.awt.*;
import java.awt.datatransfer.*;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.awt.print.*;
import java.io.*;
import java.nio.file.Files;

public class Main {

    public static void main(String[] args) throws IOException, PrinterException, PrintException, InterruptedException, UnsupportedFlavorException {
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        Image image = new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB);
        Graphics g = image.getGraphics();
        g.fillOval(0, 0, 100, 100);
        ImageTransferable selection = new ImageTransferable(image);
        clipboard.setContents(selection, null);

        DataFlavor flavor = DataFlavor.imageFlavor;
        if (clipboard.isDataFlavorAvailable(flavor)) {
            Image img = (Image)clipboard.getData(flavor);
            System.out.println(img.toString());
        }

    }
}

class ImageTransferable implements Transferable
{
    private Image theImage;
    public ImageTransferable(Image image)
    {
        theImage = image;
    }
    public DataFlavor[] getTransferDataFlavors()
    {
        return new DataFlavor[] { DataFlavor.imageFlavor };
    }
    public boolean isDataFlavorSupported(DataFlavor flavor)
    {
        return flavor.equals(DataFlavor.imageFlavor);
    }
    public Object getTransferData(DataFlavor flavor)
            throws UnsupportedFlavorException
    {
        if(flavor.equals(DataFlavor.imageFlavor))
        {
            return theImage;
        }
        else
        {
            throw new UnsupportedFlavorException(flavor);
        }
    }
}

