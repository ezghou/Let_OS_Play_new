package entity;

import main.Lockdown_GamePanel;
import main.Lockdown_MouseHandler;

import java.awt.*;

public class Button extends Entity{
    private int x,y, width, height;
    private String text;
    private Rectangle bounds;
    Lockdown_GamePanel gp;
    Lockdown_MouseHandler mouseHandler;

    public Button(String text, int x, int y, int width, int height, Lockdown_GamePanel gp, Lockdown_MouseHandler mouseH){
        this.text = text;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.gp = gp;
        this.mouseHandler = mouseH;

        initBounds();
    }

    public void initBounds(){
        this.bounds = new Rectangle(x,y,width,height);
    }

    public void draw(Graphics g){

        g.setColor(Color.white);
        g.fillRect(x,y,width,height);

        g.setColor(Color.black);
        g.drawRect(x,y,width,height);

        drawText(g);
    }

    public void drawText(Graphics g){
        int w = g.getFontMetrics().stringWidth(text);
        int h = g.getFontMetrics().getHeight();

        g.drawString(text, x -w/2 + width/2, y + h/2 + height/2);

    }



}
