/**
 * Panel for the OSnakes_questionFrame
 * where the snake will move around
 *
 * @author  EG Renz Go
 * @author  Thereze Nuelle Roca
 * @author  Erica Talahiban
 * @version 1.0
 */

package main;

import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Random;

@SuppressWarnings("ALL")
public class OSnakes_gamePanel extends JPanel implements ActionListener {
    private final OSnakes_questionFrame questionFrame;
    static final int SCREEN_WIDTH = 525;
    static final int SCREEN_HEIGHT = 400;
    static final int DELAY = 100;
    static final int UNIT_SIZE = 20;
    static final int GAME_UNITS = (SCREEN_WIDTH * SCREEN_HEIGHT) / (UNIT_SIZE * UNIT_SIZE);
    final int[] x = new int[GAME_UNITS];
    final int[] y = new int[GAME_UNITS];
    private int bodyParts = 6;
    private int points;
    private int iosX, iosY;
    private int windowsX, windowsY;
    private int ubuntuX, ubuntuY;
    private int linuxX, linuxY;
    private String choiceIOS;
    private String choiceWindows;
    private String choiceUbuntu;
    private String choiceLinux;
    private String correctAnswer;
    private BufferedImage iosIcon, windowsIcon, ubuntuIcon, linuxIcon;
    private char direction = 'R';
    private boolean running = false;
    private boolean gameOver = false;
    Timer timer;
    Random random;
    Sounds bgMusic;
    Sounds sfx  = new Sounds();
    /**
     * Initialize icon images and panel properties.
     */
    OSnakes_gamePanel(OSnakes_questionFrame questionFrame, int width, int height, Sounds bgm) {
        bgMusic = bgm;
        this.questionFrame = questionFrame;
        try{
            iosIcon = ImageIO.read(getClass().getResourceAsStream("/Resources/OSnakes_iosIcon.png"));
            windowsIcon = ImageIO.read(getClass().getResourceAsStream("/Resources/OSnakes_windowsIcon.png"));
            ubuntuIcon = ImageIO.read(getClass().getResourceAsStream("/Resources/OSnakes_ubuntuIcon.png"));
            linuxIcon = ImageIO.read(getClass().getResourceAsStream("/Resources/OSnakes_linuxIcon.png"));
        } catch(IOException e){
            e.printStackTrace();
        }
        random = new Random();
        this.setBounds(500, 90, SCREEN_WIDTH, SCREEN_HEIGHT);
        this.setBackground(Color.black);
        this.setBorder(BorderFactory.createLineBorder(Color.white, 2));
        this.setFocusable(true);
        this.requestFocusInWindow();
        this.addKeyListener(new MyKeyAdapter());
        startGame();
    }
    public void startGame() {
        newOS();
        running = true;
        timer = new Timer(DELAY,this);
        timer.start();
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }
    /**
     * Draw the snake as it moves in the panel
     */
    public void draw(Graphics g) {
        if(running && !gameOver) {
            g.drawImage(iosIcon, iosX, iosY, null);
            g.drawImage(windowsIcon, windowsX, windowsY, null);
            g.drawImage(ubuntuIcon, ubuntuX, ubuntuY, null);
            g.drawImage(linuxIcon, linuxX, linuxY, null);

            for(int i = 0; i< bodyParts;i++) {
                if(i == 0) {
                    g.setColor(Color.green);
                    g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
                }
                else {
                    g.setColor(new Color(45,180,0));
                    //g.setColor(new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255)));
                    g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
                }
            }
            questionFrame.editPoints(points);
        }
        else {
            gameOver(g);
        }
    }
    /**
     * Generate new random and unique positions for the OS icons.
     */
    public void newOS(){
        iosX = getXValue();
        iosY = getYValue();
        do {
            windowsX = getXValue();
            windowsY = getYValue();
        } while (windowsX == iosX && windowsY == iosY);
        do {
            ubuntuX = getXValue();
            ubuntuY = getYValue();
        } while ((ubuntuX == iosX && ubuntuY == iosY) || (ubuntuX == windowsX && ubuntuY == windowsY));
        do {
            linuxX = getXValue();
            linuxY = getYValue();
        } while ((linuxX == iosX && linuxY == iosY) || (linuxX == windowsX && linuxY == windowsY) || (linuxX == ubuntuX && linuxY == ubuntuY));
    }
    public int getXValue(){
        return random.nextInt(SCREEN_WIDTH/UNIT_SIZE)*UNIT_SIZE;
    }
    public int getYValue(){
        return random.nextInt(SCREEN_HEIGHT/UNIT_SIZE)*UNIT_SIZE;
    }
    /**
     * Allows the snake to move around the panel and
     * change directions
     */
    public void move(){
        for(int i = bodyParts;i>0;i--) {
            x[i] = x[i-1];
            y[i] = y[i-1];
        }
        switch (direction) {
            case 'U' -> y[0] = y[0] - UNIT_SIZE;
            case 'D' -> y[0] = y[0] + UNIT_SIZE;
            case 'L' -> x[0] = x[0] - UNIT_SIZE;
            case 'R' -> x[0] = x[0] + UNIT_SIZE;
        }
    }
    /**
     * Check if the OS icon collided with the head of the snake
     * contains the correct answer to the question
     */
    public void checkOS() throws URISyntaxException {
        if((x[0] == iosX) && (y[0] == iosY)) {
            if(choiceIOS.equals(correctAnswer)){
                try {
                    proceed();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
            else{
                gameOver = true; }
        }
        if((x[0] == windowsX) && (y[0] == windowsY)) {
            if(choiceWindows.equals(correctAnswer)){
                try {
                    proceed();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
            else{
                gameOver = true;
            }
        }
        if((x[0] == ubuntuX) && (y[0] == ubuntuY)) {
            if(choiceUbuntu.equals(correctAnswer)){
                try {
                    proceed();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
            else{
                gameOver = true; }
        }
        if((x[0] == linuxX) && (y[0] == linuxY)) {
            if(choiceLinux.equals(correctAnswer)){
                try {
                    proceed();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
            else{
                gameOver = true; }
        }
    }
    /**
     * If the snake collided with the correct OS icon,
     * the snake will be longer and the game continues
     */
    public void proceed() throws URISyntaxException, FileNotFoundException {
        sfx.soundChoice(10);
        bodyParts++;
        points += 10;
        newOS();
        questionFrame.displayMCQ();
    }
    /**
     * Check if the head of the snake collides with any of its body parts
     * or if it collides with any end side of the panel
     */
    public void checkCollisions() {
        for(int i = bodyParts;i>0;i--) {
            if ((x[0] == x[i]) && (y[0] == y[i])) {
                running = false;
                break;
            }
        }
        if(x[0] < 0) {
            running = false;
        }
        if(x[0] > SCREEN_WIDTH) {
            running = false;
        }
        if(y[0] < 0) {
            running = false;
        }
        if(y[0] > SCREEN_HEIGHT) {
            running = false;
        }
        if(!running) {
            timer.stop();
        }
    }
    public void gameOver(Graphics g) {
        g.setColor(Color.red);
        g.setFont( new Font("Ink Free",Font.BOLD, 75));
        FontMetrics metrics2 = getFontMetrics(g.getFont());
        g.drawString("Game Over", (SCREEN_WIDTH - metrics2.stringWidth("Game Over"))/2, SCREEN_HEIGHT/2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(running){
            move();
            try {
                checkOS();
            } catch (URISyntaxException ex) {
                ex.printStackTrace();
            }
            checkCollisions();
        }
        repaint();
    }
    /**
     * Detect what arrow keys are pressed.
     */
    public class MyKeyAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e){
            switch(e.getKeyCode()){
                case KeyEvent.VK_LEFT:
                    if(direction!='R'){
                        direction='L';
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                    if(direction!='L'){
                        direction='R';
                    }
                    break;
                case KeyEvent.VK_UP:
                    if(direction!='D'){
                        direction='U';
                    }
                    break;
                case KeyEvent.VK_DOWN:
                    if(direction!='U'){
                        direction='D';
                    }
                    break;
            }
        }
    }
    public void setChoices(String choiceIOS, String choiceWindows, String choiceUbuntu, String choiceLinux, String correctAnswer){
        this.choiceIOS = choiceIOS;
        this.choiceWindows = choiceWindows;
        this.choiceUbuntu = choiceUbuntu;
        this.choiceLinux = choiceLinux;
        this.correctAnswer = correctAnswer;
    }
}