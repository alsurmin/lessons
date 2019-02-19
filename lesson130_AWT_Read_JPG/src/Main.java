import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) throws IOException {
//          Generate generate = new Generate();
//          generate.generate();

        File file = new File("car.jpg");
        BufferedImage image = ImageIO.read(file);

        WritableRaster raster = image.getRaster();
        for (int i = 0; i < raster.getWidth(); i++) {
            int[] pixel = raster.getPixel(i,0,new int[4]);
            pixel[0] = 50;
            pixel[1] = 10;
            pixel[2] = 5;
            raster.setPixel(i,0,pixel);
            raster.setPixel(i,1,pixel);
            raster.setPixel(i,2,pixel);
        }
        raster.getPixels(0,0, image.getHeight(), image.getWidth(), new int[4 * image.getHeight() * image.getWidth()]);
        raster.setPixels(0,0, image.getHeight(), image.getWidth(), new int[4 * image.getHeight() * image.getWidth()]);

        Object data = raster.getDataElements(0,0,null);
        ColorModel colorModel = image.getColorModel();
        Color color = new Color(colorModel.getRGB(1));

        image.setData(raster);
        ImageIO.write(image,"png", new File("car.png"));

    }
}

