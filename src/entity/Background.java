package entity;

import main.Lockdown_GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Background extends Entity {
    Lockdown_GamePanel gp;

    public Background(Lockdown_GamePanel gp){
        this.gp = gp;
        getBackgroundImage();
    }

    public void getBackgroundImage(){
        try {
            backGround = ImageIO.read(getClass().getResourceAsStream("/Resources/Lockdown_Lawn_exact.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setDefaultValues(){

    }

    public void update(){

    }

    public void draw(Graphics2D g2){
        BufferedImage image = backGround;
        g2.drawImage(image, 0,0, 1060,660,null);
    }
}
