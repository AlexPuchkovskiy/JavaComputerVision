package puchok.testingForms;

import puchok.additional.AdditionalMethodsForDebugging;
import puchok.imageProcessing.BufferedImageInformation;

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
        //Creates gray scale image and store it, or just store source image
        this.image = BufferedImageInformation.convertToGrayScale(image);
        BufferedImageInformation bufImInf = new BufferedImageInformation(this.image);

        //Gets image pixels intensity
        AdditionalMethodsForDebugging.print2DimensionalArray(bufImInf.getGrayImageColorIntensity());

        //Gets colors of each pixel on the Image
        Color[][] colors = bufImInf.getImagePixelsColors();
        System.out.printf("Color:%n%d\t%d\t%d", colors[0][0].getRed(), colors[0][0].getGreen(), colors[0][0].getBlue());
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        g2.drawImage(image, null, null);
    }
}