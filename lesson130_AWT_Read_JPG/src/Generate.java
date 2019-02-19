import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;

public class Generate {
    private BufferedImage mImage, mNewImage;
    private int mWidth, mHeight;
    private int[] mPixelData;

    public void generate() {
        try {
            mImage = ImageIO.read(new File("car.jpg"));
            mWidth = mImage.getWidth();
            mHeight = mImage.getHeight();
            mPixelData = new int[mWidth * mHeight];
            // get pixel data from image
            for (int i = 0; i < mHeight; i++) {
                for (int j = 0; j < mWidth; j++) {
                    int rgb = mImage.getRGB(j, i);
                    int a = rgb >>> 24;
                    int r = (rgb >> 16) & 0xff;
                    int g = (rgb >> 8) & 0xff;
                    int b = rgb & 0xff;
                    int newRgb = (a << 24 | r << 16 | g << 8 | b);
                    mPixelData[i * mWidth + j] = newRgb;
                }

                mNewImage = new BufferedImage(mWidth, mHeight, mImage.getType());
                WritableRaster raster = (WritableRaster) mNewImage.getData();
                raster.setPixels(0, 0, mWidth, mHeight, mPixelData);
                File file = new File("car.png");
                ImageIO.write(mNewImage, "png", file);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
