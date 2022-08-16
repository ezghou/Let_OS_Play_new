package entity;

import main.Lockdown_GamePanel;
import main.Lockdown_MouseHandler;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Cards extends Entity{
    Lockdown_GamePanel gp;
    Lockdown_MouseHandler mouseHandler;

    public Cards(Lockdown_GamePanel gp, Lockdown_MouseHandler mouseH){
        this.gp = gp;
        this.mouseHandler = mouseH;

        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues(){
//        x = 100;
//        y = 100;
    }

    public void getPlayerImage() {
        try{
            taxPayer = ImageIO.read(getClass().getResourceAsStream("/Resources/tax.png"));
            nurse = ImageIO.read(getClass().getResourceAsStream("/Resources/nurse.png"));
            doctor = ImageIO.read(getClass().getResourceAsStream("/Resources/doctor.png"));
            soldier = ImageIO.read(getClass().getResourceAsStream("/Resources/soldier.png"));
        }catch(IOException e){
            e.printStackTrace();
        }

    }

    public void update(){
//        x = mouseHandler.x;
//        y = mouseHandler.y;
    }

    public void draw(Graphics2D g2){
        g2.fillRect(5, 70, 105, 80);
        g2.drawImage(taxPayer, 5, 70, 105, 80, null);
        g2.fillRect(5, 155, 105, 80);
        g2.drawImage(nurse, 5, 155, 105, 80, null);
        g2.fillRect(5, 240, 105, 80);
        g2.drawImage(doctor, 5, 240, 100, 80, null);
        g2.fillRect(5, 325, 105, 80);
        g2.drawImage(soldier, 5, 325, 105, 80, null);
        g2.fillRect(5, 550, 100, 45);
    }
}
