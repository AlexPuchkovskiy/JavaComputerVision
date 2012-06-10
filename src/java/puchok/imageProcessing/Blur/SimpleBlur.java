package puchok.imageProcessing.Blur;

import com.sun.org.apache.bcel.internal.generic.FLOAD;
import puchok.imageProcessing.BufferedImageInformation;

import java.awt.*;
import java.awt.image.*;
import java.nio.Buffer;

/**
 * User: Puchok
 * Date: 10.06.12
 * Time: 12:34
 */
public class SimpleBlur {
    public void main(String[] args) {

    }

    /*
   *   Methods
   * */

    /*
   *   Returns blurred image using simple blurring technique with predefined kernelMatrix kernel.
   *
   *   @param sourceImage
   *   @param destImage
   * */
    public BufferedImage createSimpleBlurredImage(BufferedImage sourceImage, BufferedImage destImage) {
        if (sourceImage.getType() != 1) {
            sourceImage = BufferedImageInformation.changeBufferedImageType(sourceImage, BufferedImage.TYPE_INT_RGB);
        }
        if (destImage != null && destImage.getType() != 1) {
            destImage = BufferedImageInformation.changeBufferedImageType(destImage, BufferedImage.TYPE_INT_RGB);
        }

        BufferedImageOp op = new ConvolveOp(new Kernel(3, 3, kernelMatrix));

        return op.filter(sourceImage, destImage);
    }

     /*
   *   Returns better version of blurred image using simple blurring technique.
   *
   *   @param sourceImage
   *   @param destImage
   * */
    public BufferedImage createBetterSimpleBlurredImage(BufferedImage sourceImage, BufferedImage destImage) {
        if (sourceImage.getType() != 1) {
            sourceImage = BufferedImageInformation.changeBufferedImageType(sourceImage, BufferedImage.TYPE_INT_RGB);
        }
        if (destImage != null && destImage.getType() != 1) {
            destImage = BufferedImageInformation.changeBufferedImageType(destImage, BufferedImage.TYPE_INT_RGB);
        }

        float [] matrix = new float[400];
        for (int i = 0; i < 400; i++) {
            matrix[i] = 1.0f / 400.0f;
        }

        BufferedImageOp op = new ConvolveOp(new Kernel(3, 3, kernelMatrix), ConvolveOp.EDGE_NO_OP, null);

        return op.filter(sourceImage, destImage);
    }

    /*
   *   Variables
   * */

    private float[] kernelMatrix = { //Kernel matrix for simple blurring
            0.111f, 0.111f, 0.111f,
            0.111f, 0.111f, 0.111f,
            0.111f, 0.111f, 0.111f
    };
}
