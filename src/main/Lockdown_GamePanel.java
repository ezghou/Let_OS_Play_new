package main;

import entity.*;
import entity.Button;
import entity.Character;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class Lockdown_GamePanel extends JPanel implements Runnable {
    public static final int SCREEN_WIDTH = 1060;
    public static final int SCREEN_HEIGHT = 660;
    public static final int UNIT_SIZE = 100;
//    static final int GAME_UNITS = (SCREEN_WIDTH*SCREEN_HEIGHT)/UNIT_SIZE;
    Lockdown_MouseHandler mouseHandler = new Lockdown_MouseHandler();

    Background bg = new Background(this);
    Player player = new Player(this,mouseHandler);
    Character Character;
    Cards card = new Cards(this,mouseHandler);
    Button backButton = new Button("Back",5, 550, 100, 45,this,mouseHandler);

    int [] checkLawnOccupied = new int[45];

    Character [] characters = new Character[46];
    Thread gameThread;
    int FPS = 60;

    Lockdown_GamePanel(){
        this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
        this.setBackground(new Color(3,10,33));
        this.setDoubleBuffered(true);

        System.out.println(Arrays.toString(checkLawnOccupied));
//        characters = new Character(this,mouseHandler,mouseHandler.currentCard);


        this.addMouseListener(mouseHandler);
        this.addMouseMotionListener(mouseHandler);
        this.setFocusable(true);
    }

    public void draw(Graphics g){
        for (int i = 0; i < 5000; i++){
            g.setColor(Color.blue);
            g.drawLine(i*UNIT_SIZE,0,i*UNIT_SIZE,5000);
            g.setColor(Color.red);
            g.drawLine(0,i*UNIT_SIZE,5000,i*UNIT_SIZE);
        }
    }
    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;

        while (gameThread != null){

            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if (delta >= 1){
                update();
                repaint();
                delta--;
                drawCount++;
            }


            if (timer >= 1000000000){
//                System.out.println("FPS: " + drawCount);
                drawCount = 0;
                timer = 0;
            }
        }
    }

    public void update(){
        bg.update();
        card.update();
//        Character.update();
        characters[mouseHandler.lawn] = new Character(this,mouseHandler,mouseHandler.currentCard);
        characters[mouseHandler.lawn].update();
//        nurse.update();
        player.update();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        bg.draw(g2);
        card.draw(g2);
        backButton.draw(g2);
//        Character.draw(g2);
        characters[mouseHandler.lawn] = new Character(this,mouseHandler,mouseHandler.currentCard);
        characters[mouseHandler.lawn].draw(g2);
//        nurse.draw(g2);
        player.draw(g2);
        g2.dispose();
    }
}


//        coins = new JLabel();
//                coins.setText(" Coins: " + "10");
//                coins.setForeground(Color.black);
//                coins.setBackground(Color.white);
//                coins.setFont(new Font("Cambria", Font.BOLD, 20));
//                coins.setBounds(5, 5, 105, 60);
//                coins.setFocusable(false);
//                coins.setBorder(BorderFactory.createLineBorder(new Color(236, 189, 57, 255),3));
//                coins.setOpaque(true);
//                coins.setVisible(true);
//
//                score = new JLabel();
//                score.setText(" Score: " + "1000");
//                score.setForeground(Color.black);
//                score.setBackground(Color.white);
//                score.setFont(new Font("Cambria", Font.BOLD, 20));
//                score.setBounds(910, 5, 120, 50);
//                score.setFocusable(false);
//                score.setBorder(BorderFactory.createLineBorder(new Color(236, 189, 57, 255),3));
//                score.setOpaque(true);
//                score.setVisible(true);

//        this.add(coins);
//        this.add(score);
//        this.add(back);
