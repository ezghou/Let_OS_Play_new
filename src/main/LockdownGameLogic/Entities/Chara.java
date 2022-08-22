package main.LockdownGameLogic.Entities;

import main.LockdownGameLogic.Constants;
import main.LockdownGameLogic.Debug;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import static main.LockdownGameLogic.Constants.*;
/**
 * A prototype Character class,
 * needs to be refactored
 * only purpose atm, is for debug rendering
 */
public class Chara {
    //This position is relative off of its center
    private int positionX;
    private int positionY;
    private int row = 0, column = 0;
    private BufferedImage img, damagedImage;
    private int id;
    private boolean collidedWithInfected = false;

    public ArrayList<CharaProjectile> charaProjectiles = new ArrayList<>();
    private Debug debug1 = new Debug();
    private Debug debug2 = new Debug();
    public int health, damage;

    private int cost;

    public Chara(int x, int y, int id){
        this.id = id;
        switch (id) {
            case 0 -> {
                img = nurse;
                damage = 1;
                health = 6;
            }
            case 1 -> {
                img = doctor;
                damage = 2;
                health = 8;
            }
            case 2 -> {
                img = soldier;
                health = 15;
            }
            default -> {
                System.out.println("ERROR");
                return;
            }
        }

        damagedImage = Constants.colorImage(img, Color.red);

        assert img != null;
        positionX = x - img.getWidth()/2;
        positionY = y - img.getHeight()/2;

        debug1.elapsedTimeInSecond = 1;
        debug2.elapsedTimeInSecond = 2;
    }

    public void setRowColumn(int row, int column){
        this.row = row;
        this.column = column;
    }

    public int getRow(){
        return row;
    }

    public int getColumn() {
        return column;
    }

    public void render(Graphics g){
        if(collidedWithInfected){
            g.drawImage(damagedImage, positionX, positionY, null);
            debug2.countSeconds();
            if (debug2.elapsedTimeInSecond >= 1.2) {
                collidedWithInfected = false;
                debug2.resetTime();
            }
        }

        else {g.drawImage(img, positionX, positionY, null);}
        g.setColor(Color.red);
        try {
            for (CharaProjectile charaProjectile : charaProjectiles) {
                charaProjectile.draw(g);
            }
        } catch (Exception e){
            System.out.println("Projectile Timing Error");
        }
    }

    public void update(){
        if(id == 0 || id == 1) {
            int targets = 0;
            switch (column){
                case 1 -> targets = col1EnemCount;
                case 2 -> targets = col2EnemCount;
                case 3 -> targets = col3EnemCount;
                case 4 -> targets = col4EnemCount;
                case 5 -> targets = col5EnemCount;
            }
            debug1.countSeconds();
            switch (id){
                case 0 -> {
                    if (debug1.elapsedTimeInSecond >= 1.8 && targets != 0) {
                        debug1.resetTime();
                        charaProjectiles.add(new CharaProjectile(this, 35, 10, 8));
                    }
                }
                case 1 -> {
                    if (debug1.elapsedTimeInSecond >= 2.5 && targets != 0) {
                        debug1.resetTime();
                        charaProjectiles.add(new CharaProjectile(this, 35, 10, 8));
                    }
                }
            }
        }

        for(int i = 0; i < charaProjectiles.size(); i++){
            charaProjectiles.get(i).update();

            if(charaProjectiles.get(i).destroy){
                charaProjectiles.remove(i);
                i--;
            }
        }


    }

    public int getId() {
        return id;
    }

    public void setCollidedWithInfected(boolean collidedWithInfected) {
        this.collidedWithInfected = collidedWithInfected;
    }
    public boolean geCollidedWithInfected(){
        return collidedWithInfected;
    }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }
}



