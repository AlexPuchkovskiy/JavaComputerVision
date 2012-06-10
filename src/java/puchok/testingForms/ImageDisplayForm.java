package puchok.testingForms;

import puchok.additional.AdditionalMethodsForDebugging;
import puchok.imageProcessing.Blur.SimpleBlur;
import puchok.imageProcessing.BufferedImageInformation;
import sun.java2d.pipe.SpanShapeRenderer;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * User: Puchok
 * Date: 08.06.12
 * Time: 14:02
 */
public class ImageDisplayForm {
    public static void main(String[] args) {
        ImageDisplayForm form = new ImageDisplayForm();
        BufferedImage img;
        try {
            img = ImageIO.read(new File("src/files/dog.jpg"));
            form.displayImage(img);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean displayImage(BufferedImage image) {
        Frame frame = new Frame(image);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        return true;
    }
}

class Frame extends JFrame {
    public Frame(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();

        setSize(width, height);
        setLocation(100, 100);
        setTitle("Image Displaying");

        Panel panel = new Panel(image);

        add(panel);
    }
}

class Panel extends JPanel {
    BufferedImage image;

    public Panel(BufferedImage image) {
        this.image = image;

        //Test image pixels intensity
        //TestMethods.testImagePixelsIntensity(image);

        //Test image pixels colors value
        //TestMethods.testImagePixelsColors(image);

        //Test Simple Image Blur
        //this.image = TestMethods.testSimpleImageBlurring(image);

        //Test Better Simple Image Blur
        this.image = TestMethods.testBetterSimpleImageBlurring(image);
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        g2.drawImage(image, null, null);
    }
}

//static methods for testing different classes
class TestMethods {
    //Test image pixels intensity
    public static boolean testImagePixelsIntensity(BufferedImage image) {
        //Creates gray scale image and store it
        image = BufferedImageInformation.convertToGrayScale(image);
        BufferedImageInformation bufImInf = new BufferedImageInformation(image);

        //Gets image pixels intensity
        AdditionalMethodsForDebugging.print2DimensionalArray(bufImInf.getGrayImageColorIntensity());

        return true;
    }

    //Test image pixels colors value
    public static boolean testImagePixelsColors(BufferedImage image) {
        //store source image
        BufferedImageInformation bufImInf = new BufferedImageInformation(image);

        //Gets colors of each pixel on the Image
        Color[][] colors = bufImInf.getImagePixelsColors();
        System.out.printf("Color:%n%d\t%d\t%d", colors[0][0].getRed(), colors[0][0].getGreen(), colors[0][0].getBlue());

        return true;
    }

    //Test simple image blurring
    public static BufferedImage testSimpleImageBlurring(BufferedImage sourceImage) {
        SimpleBlur blur = new SimpleBlur();

        return blur.createSimpleBlurredImage(sourceImage, null);
    }

    //Test better version of simple image blurring
    public static BufferedImage testBetterSimpleImageBlurring(BufferedImage sourceImage) {
        SimpleBlur blur = new SimpleBlur();

        return blur.createBetterSimpleBlurredImage(sourceImage, null);
    }
}