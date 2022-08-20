package main.LockdownGameLogic.Entities;

import java.awt.*;

import static main.LockdownGameLogic.Constants.gridHeight;
import static main.LockdownGameLogic.Constants.gridWidth;

public class CharaProjectile{
    Chara parentChara;
    public int projectilePositionX, projectilePositionY;
    public int ovalWidth, ovalHeight;
    public int projectileTileSpeed;

    public boolean destroy = false;

    CharaProjectile(Chara parentChara, int ovalWidth, int ovalHeight, int projectileTileSpeed){
        this.parentChara = parentChara;
        this.ovalWidth = ovalWidth;
        this.ovalHeight = ovalHeight;
        this.projectileTileSpeed = projectileTileSpeed;
        projectilePositionX = parentChara.getPositionX() + gridWidth/2;
        projectilePositionY = parentChara.getPositionY() + gridHeight/2;
    }

    void draw(Graphics g){
        g.setColor(Color.red);
        g.fillOval(projectilePositionX, projectilePositionY, ovalWidth, ovalHeight);
    }

    void update(){
        projectilePositionX += projectileTileSpeed;
    }

    public int getProjectilePositionX() {
        return projectilePositionX;
    }
}
