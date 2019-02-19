import javax.print.PrintException;
import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.print.*;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, PrinterException, PrintException {
        Printable printable = new Printable() {
            @Override
            public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
                if (pageIndex == 0) {
                    Graphics2D graphics2D = (Graphics2D) graphics;
                    Line2D line2D = new Line2D.Double(0, 0, 100, 100);
                    graphics2D.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
                    graphics2D.draw(line2D);
                    return PAGE_EXISTS;
                }
                return NO_SUCH_PAGE;
            }
        };
        PrinterJob job = PrinterJob.getPrinterJob();
        job.setPrintable(printable);
        if (job.printDialog()) {
            job.print();
        }
    }
}

