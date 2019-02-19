import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) throws IOException {
        //File file = new File("car.jpg");
        //BufferedImage image = ImageIO.read(file);
        //ImageIO.write(image,"png", new File("car.png"));

//        String[] extension = ImageIO.getReaderFileSuffixes();
//        for (String str : extension) {
//            System.out.println(str);
//        }

        ImageReader reader = null;
        Iterator<ImageReader> iterator = ImageIO.getImageReadersByFormatName("JPEG");
        if(iterator.hasNext()) {
            reader = iterator.next();
//            System.out.println(reader.getFormatName());
        }

        InputStream inputStream = new FileInputStream(new File("car.jpg"));
        ImageInputStream imageInputStream = ImageIO.createImageInputStream(inputStream);
        ImageInputStream imageInputStream1 = ImageIO.createImageInputStream(new File("car.jpg"));
        reader.setInput(imageInputStream, true);
        BufferedImage image1 = reader.read(reader.getNumImages(true));

        int count = reader.getNumThumbnails(0);
        BufferedImage image2 = reader.readThumbnail(0,count);
        System.out.println(reader.getHeight(0));
        System.out.println(reader.getWidth(0));

    }
}

