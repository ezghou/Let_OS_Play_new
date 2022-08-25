/**
 * Initialized constants for Lockdown
 *
 * @author  EG Renz Go
 * @author  Thereze Nuelle Roca
 * @author  Erica Talahiban
 * @version 1.0
 */

package main.LockdownGameLogic;

import main.Lockdown_MainFrame;
import main.Lockdown_QuestionsHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.io.InputStream;

public class Constants {
    public static final int SCREEN_WIDTH = 1060;
    public static final int SCREEN_HEIGHT = 660;
    public static final int paddingLeft = 180;
    public static final int paddingRight = 45;
    public static final int paddingSide= 40;
    public static final int paddingTop = 20;
    public static final int paddingBottom = 140;
    public static final int estTitleHeight = 40;
    public static final int gridRowCount = 9;
    public static final int gridColumnCount = 5;
    public static final int lawnWidth = (Constants.SCREEN_WIDTH - (paddingLeft+paddingRight)); //Subtract the padding then divide by the number of columns
    public static final int lawnHeight = (Constants.SCREEN_HEIGHT - estTitleHeight - (paddingTop+paddingBottom)); //40 is the Title Height, for some reason its taken accounted in 660
    public static final int gridWidth = lawnWidth / gridRowCount;
    public static final int gridHeight = lawnHeight /gridColumnCount;
    public static final int selectorPaddingLeft =  40;
    public static final float enemyMovementSpeed = 0.4f;
    public static final Debug globalDebug = new Debug();

    public static boolean GameOver = false;
    public static BufferedImage testAtlas;
    public static BufferedImage taxPayer;
    public static BufferedImage nurse;
    public static BufferedImage doctor;
    public static BufferedImage soldier;
    public static BufferedImage fire;
    public static BufferedImage testField;
    public static BufferedImage SickDude;
    public static BufferedImage testFieldMiddle;
    public static BufferedImage testFieldBottom;
    public static BufferedImage testFieldLeft;
    public static BufferedImage testFieldRight;
    public static BufferedImage testFieldTopRight;
    public static BufferedImage testFieldTopLeft;
    public static BufferedImage testFieldBottomRight;
    public static BufferedImage testFieldBottomLeft;
    public static BufferedImage background;
    public static Lockdown_MainFrame mgf;
    public static int mouseX, mouseY;
    public static int globalCharaID = -1;
    public static int col1EnemCount = 0,
            col2EnemCount = 0, col3EnemCount = 0,
            col4EnemCount = 0, col5EnemCount = 0;

    public static int Coins = 50;

    public static Lockdown_QuestionsHandler questionsHandler;

    public static void setUp(Lockdown_MainFrame mgf){
        Constants.mgf = mgf;

        try{
            InputStream is = mgf.getClass().getResourceAsStream("/Resources/spriteatlas.png");
            assert is != null;
            testAtlas = ImageIO.read(is);
//            is = mgf.getClass().getResourceAsStream("/Resources/tax.png");
//            taxPayer = ImageIO.read(is);
            is = mgf.getClass().getResourceAsStream("/Resources/nurse.png");
            assert is != null;
            nurse = ImageIO.read(is);
            is = mgf.getClass().getResourceAsStream("/Resources/doctor.png");
            assert is != null;
            doctor = ImageIO.read(is);
            is = mgf.getClass().getResourceAsStream("/Resources/soldier.png");
            assert is != null;
            soldier = ImageIO.read(is);
            is = mgf.getClass().getResourceAsStream("/Resources/Fire.png");
            assert is != null;
            fire = ImageIO.read(is);
            is = mgf.getClass().getResourceAsStream("/Resources/TestFieldTop.png");
            assert is != null;
            testField = ImageIO.read(is);
            is = mgf.getClass().getResourceAsStream("/Resources/TestFieldMiddle.png");
            assert is != null;
            testFieldMiddle = ImageIO.read(is);
            is = mgf.getClass().getResourceAsStream("/Resources/TestFieldBottom.png");
            assert is != null;
            testFieldBottom = ImageIO.read(is);
            is = mgf.getClass().getResourceAsStream("/Resources/Sickdude.png");
            assert is != null;
            SickDude = ImageIO.read(is);
            is = mgf.getClass().getResourceAsStream("/Resources/Background_Lockdown.png");
            assert is != null;
            background = ImageIO.read(is);
            is = mgf.getClass().getResourceAsStream("/Resources/TestFieldLeft.png");
            assert is != null;
            testFieldLeft = ImageIO.read(is);
            is = mgf.getClass().getResourceAsStream("/Resources/TestFieldRight.png");
            assert is != null;
            testFieldRight = ImageIO.read(is);
            is = mgf.getClass().getResourceAsStream("/Resources/TestFieldTopRight.png");
            assert is != null;
            testFieldTopRight = ImageIO.read(is);
            is = mgf.getClass().getResourceAsStream("/Resources/TestFieldTopLeft.png");
            assert is != null;
            testFieldTopLeft = ImageIO.read(is);
            is = mgf.getClass().getResourceAsStream("/Resources/TestFieldBottomRight.png");
            assert is != null;
            testFieldBottomRight = ImageIO.read(is);
            is = mgf.getClass().getResourceAsStream("/Resources/TestFieldBottomLeft.png");
            assert is != null;
            testFieldBottomLeft = ImageIO.read(is);

            is.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public static BufferedImage colorImage(BufferedImage loadImg, Color color) {
        //CLONE
        ColorModel cm = loadImg.getColorModel();
        boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
        WritableRaster raster = loadImg.copyData(null);
        BufferedImage image = new BufferedImage(cm, raster, isAlphaPremultiplied, null);

        //TINT THE CLONE AND RETURN
        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                Color pixelColor = new Color(image.getRGB(x, y), true);
                int r = (pixelColor.getRed() + color.getRed()) / 2;
                int g = (pixelColor.getGreen() + color.getGreen()) / 2;
                int b = (pixelColor.getBlue() + color.getBlue()) / 2;
                int a = pixelColor.getAlpha();
                int rgba = (a << 24) | (r << 16) | (g << 8) | b;
                image.setRGB(x, y, rgba);
            }
        }
        return image;
    }
}
