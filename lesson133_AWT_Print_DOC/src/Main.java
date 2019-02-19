import javax.print.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.print.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

public class Main {

    public static void main(String[] args) throws IOException, PrinterException, PrintException {
        DocFlavor flavor = DocFlavor.INPUT_STREAM.JPEG;
        PrintService[] services = PrintServiceLookup.lookupPrintServices(flavor, null);
        InputStream inputStream = new FileInputStream("car.jpg");
        Doc doc = new SimpleDoc(inputStream, flavor, null);

        if (services.length > 0) {
            DocPrintJob job = services[0].createPrintJob();
            job.print(doc, null);

        }

    }
}

