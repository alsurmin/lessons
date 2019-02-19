import javax.print.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.print.*;
import java.io.*;
import java.nio.file.Files;

public class Main {

    public static void main(String[] args) throws IOException, PrinterException, PrintException {
        DocFlavor flavor = DocFlavor.SERVICE_FORMATTED.PRINTABLE;
        String mimeType = "application/postscript";
        StreamPrintServiceFactory[] factories =
                StreamPrintServiceFactory.lookupStreamPrintServiceFactories(flavor, mimeType);
        OutputStream out = new FileOutputStream("PostService.odd");
        StreamPrintService service = factories[0].getPrintService(out);

        InputStream in = new FileInputStream("car.jpg");
        DocPrintJob job = service.createPrintJob();

        Doc doc = new SimpleDoc(in, DocFlavor.INPUT_STREAM.JPEG, null);
        job.print(doc, null);

        }

    }


