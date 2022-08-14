package entity;

import main.Lockdown_GamePanel;
import main.Lockdown_MouseHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class taxPayer extends Entity{
    Lockdown_GamePanel gp;
    Lockdown_MouseHandler mouseHandler;

    public taxPayer(Lockdown_GamePanel gp, Lockdown_MouseHandler mouseH){
        this.gp = gp;
        this.mouseHandler = mouseH;

//        setDefaultValues();
            getPlayerImage();
    }

    public void setDefaultValues(){
        x = 100;
        y = 100;
        health = 100;
        damage = 0;
        attackSpeed = 1;
    }

    public void getPlayerImage() {
        try{
            taxPayer = ImageIO.read(getClass().getResourceAsStream("/Resources/tax.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void update(){
        x = mouseHandler.lawnX;
        y = mouseHandler.lawnY;
        gridNum = mouseHandler.lawn;
    }

    public void draw(Graphics2D g2){
        BufferedImage image = null;
        g2.fillRect(x, y, gp.UNIT_SIZE, gp.UNIT_SIZE);
        g2.drawImage(taxPayer, x, y, gp.UNIT_SIZE, gp.UNIT_SIZE, null);
    }
}
