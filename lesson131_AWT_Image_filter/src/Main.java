import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) throws IOException {
        File file = new File("car.jpg");
        BufferedImage image = ImageIO.read(file);

        BufferedImage imageFiltered = new BufferedImage(image.getWidth(),image.getHeight(),image.getType());
        AffineTransform transform = AffineTransform.getRotateInstance(45, image.getWidth() / 2, image.getHeight() / 2);
        BufferedImageOp op = new AffineTransformOp(transform, AffineTransformOp.TYPE_BILINEAR);
        op.filter(image, imageFiltered);

        ImageIO.write(imageFiltered,"png", new File("car.png"));

    }
}

