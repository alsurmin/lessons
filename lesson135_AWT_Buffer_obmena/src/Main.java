import javax.print.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.geom.Line2D;
import java.awt.print.*;
import java.io.*;
import java.nio.file.Files;

public class Main {

    public static void main(String[] args) throws IOException, PrinterException, PrintException, InterruptedException, UnsupportedFlavorException {
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        StringSelection selection = new StringSelection("123123123");
        clipboard.setContents(selection, null);

        DataFlavor flavor = DataFlavor.stringFlavor;
        if (clipboard.isDataFlavorAvailable(flavor)){
            System.out.println((String) clipboard.getData(flavor));}
    }

}


