package entity;

import main.Lockdown_GamePanel;
import main.Lockdown_MouseHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Character extends Entity{
    Lockdown_GamePanel gp;
    Lockdown_MouseHandler mouseHandler;

    public Character(Lockdown_GamePanel gp, Lockdown_MouseHandler mouseH, String type){
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
            nurse = ImageIO.read(getClass().getResourceAsStream("/Resources/nurse.png"));
            doctor = ImageIO.read(getClass().getResourceAsStream("/Resources/doctor.png"));
            soldier = ImageIO.read(getClass().getResourceAsStream("/Resources/soldier.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void update(){
        gridNum = mouseHandler.lawn;
        x = mouseHandler.lawnPositionX[gridNum];
        y = mouseHandler.lawnPositionY[gridNum];
    }

    public void draw(Graphics2D g2){


        BufferedImage image = null;
        if (mouseHandler.currentCard == "taxPayer"){
            image = taxPayer;
        }
        if (mouseHandler.currentCard == "nurse"){
            image = nurse;
        }
        if (mouseHandler.currentCard == "doctor"){
            image = doctor;
        }
        if (mouseHandler.currentCard == "soldier"){
            image = soldier;
        }
        g2.fillRect(x, y, gp.UNIT_SIZE, gp.UNIT_SIZE);
        g2.drawImage(image, x, y, gp.UNIT_SIZE, gp.UNIT_SIZE, null);

        System.out.println(mouseHandler.currentCard);
    }
}
