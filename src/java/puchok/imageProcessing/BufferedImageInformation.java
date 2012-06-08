package puchok.imageProcessing;

import java.awt.*;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ColorConvertOp;

/**
 * User: Puchok
 * Date: 08.06.12
 * Time: 14:07
 */
public class BufferedImageInformation {
    public static BufferedImage convertToGrayScale(BufferedImage source) {
        BufferedImageOp op = new ColorConvertOp(ColorSpace.getInstance(ColorSpace.CS_GRAY), null);
        return op.filter(source, null);
    }

    //Default constructor
    public BufferedImageInformation(BufferedImage img) {
        if (img != null) {
            image = img;
            imageWidth = image.getWidth();
            imageHeight = image.getHeight();
        }
        else image = new BufferedImage(0, 0, 0);
    }

    //return pixel color intensity; Image need to be in Gray scale scheme
    public int[][] getGrayImageColorIntensity() {
        if (image.getType() != BufferedImage.TYPE_BYTE_GRAY)
            return null;

        int[][] pixelIntensity = new int[imageWidth][imageHeight];
        Color pixelColor;

        for (int i = 0; i < imageWidth; i++) {
            for (int j = 0; j < imageHeight; j++) {
                pixelColor = new Color(image.getRGB(i, j));
                pixelIntensity[i][j] = pixelColor.getBlue();
            }
        }

        return pixelIntensity;
    }

    //return an array of image pixel colors; Image need to be in RGB scheme
    public Color[][] getImagePixelsColors() {
        Color[][] pixelColorArr = new Color[imageWidth][imageHeight];

        for (int i = 0; i < imageWidth; i++) {
            for (int j = 0; j < imageHeight; j++) {
                pixelColorArr[i][j] = new Color(image.getRGB(i, j));
            }
        }

        return pixelColorArr;
    }

    //return the instance of source image
    public BufferedImage getImage() {
        return image;
    }

    private BufferedImage image; //source image
    private int imageWidth; //image width
    private int imageHeight; //image height
}

