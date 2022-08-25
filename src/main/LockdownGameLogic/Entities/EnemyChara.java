/**
 * Render enemy charcater
 *
 * @author  EG Renz Go
 * @author  Thereze Nuelle Roca
 * @author  Erica Talahiban
 * @version 1.0
 */

package main.LockdownGameLogic.Entities;

import main.LockdownGameLogic.Constants;
import main.LockdownGameLogic.Debug;

import java.awt.*;
import java.awt.image.BufferedImage;

import static main.LockdownGameLogic.Constants.*;

public class EnemyChara {
    //This position is relative off of its center
    private double positionX;
    private double positionY;
    private int columnCount = 0;
    private BufferedImage img, damagedImage;
    private int id;
    private boolean collidedWithProjectile = false;
    private Debug debug = new Debug();
    private Debug debugDamage = new Debug();
    public boolean attackAvailable = false;
    public int health = 16;
    public EnemyChara(int columnCount){
        this.columnCount = columnCount;
        img = SickDude;
        positionX = 1060; // AT THE END OF THE SCREEN
        positionY = paddingTop + ((columnCount * gridHeight) - (gridHeight/2)) - img.getHeight()/2;
        damagedImage = Constants.colorImage(img, Color.red);
        debugDamage.elapsedTimeInSecond = 1;
    }


    public boolean shouldDisappear(){
        return positionX < paddingLeft - 80 || health <= 0;
    }

    public int getColumn() {
        return columnCount;
    }


    public double getPositionX() {
        return positionX;
    }

    public void updatePosition(){
        positionX -= enemyMovementSpeed;
    }

    public void render(Graphics g){
        debug.countSeconds();
        if (collidedWithProjectile){
            g.drawImage(damagedImage, (int)positionX, (int)positionY, null);
            debug.countSeconds();
            if(debug.elapsedTimeInSecond >= 2.5){
                collidedWithProjectile = false;
                debug.resetTime();
            }
        }
        else g.drawImage(img, (int)positionX, (int)positionY, null);

    }

    public void update(){
        debugDamage.countSeconds();
        if(debugDamage.elapsedTimeInSecond >= 1){
            attackAvailable = true;
            debugDamage.resetTime();
        }

        if(positionX < paddingLeft - 80){
            GameOver = true;
        }
    }

    public int getId() {
        return id;
    }

    public void setCollidedWithProjectile(boolean collidedWithProjectile) {
        this.collidedWithProjectile = collidedWithProjectile;
    }
}
