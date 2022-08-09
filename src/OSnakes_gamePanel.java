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
    static final int DELAY = 170;
    static final int UNIT_SIZE = 20;
    static final int GAME_UNITS = (SCREEN_WIDTH * SCREEN_HEIGHT) / (UNIT_SIZE * UNIT_SIZE);
    final int[] x = new int[GAME_UNITS];
    final int[] y = new int[GAME_UNITS];
    private int bodyParts = 6;
    private int points;
    private int iosX;
    private int iosY;
    private int windowsX;
    private int windowsY;
    private int ubuntuX;
    private int ubuntuY;
    private int linuxX;
    private int linuxY;
    private String choiceIOS;
    private String choiceWindows;
    private String choiceUbuntu;
    private String choiceLinux;
    private String correctAnswer;
    private BufferedImage iosIcon;
    private BufferedImage windowsIcon;
    private BufferedImage ubuntuIcon;
    private BufferedImage linuxIcon;
    private char direction = 'R';
    private boolean running = false;
    private boolean gameOver = false;
    Timer timer;
    Random random;

    OSnakes_gamePanel(OSnakes_questionFrame questionFrame, int width, int height) {
        this.questionFrame = questionFrame;
        try{
            iosIcon = ImageIO.read(getClass().getResourceAsStream("Resources/OSnakes_iosIcon.png"));
            windowsIcon = ImageIO.read(getClass().getResourceAsStream("Resources/OSnakes_windowsIcon.png"));
            ubuntuIcon = ImageIO.read(getClass().getResourceAsStream("Resources/OSnakes_ubuntuIcon.png"));
            linuxIcon = ImageIO.read(getClass().getResourceAsStream("Resources/OSnakes_linuxIcon.png"));
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
            questionFrame.setPoints(points);
        }
        else {
            gameOver(g);
        }
    }
    public void newOS(){
        iosX = random.nextInt(SCREEN_WIDTH/UNIT_SIZE)*UNIT_SIZE;
        iosY = random.nextInt(SCREEN_HEIGHT/UNIT_SIZE)*UNIT_SIZE;
        windowsX = random.nextInt(SCREEN_WIDTH/UNIT_SIZE)*UNIT_SIZE;
        windowsY = random.nextInt(SCREEN_HEIGHT/UNIT_SIZE)*UNIT_SIZE;
        ubuntuX = random.nextInt(SCREEN_WIDTH/UNIT_SIZE)*UNIT_SIZE;
        ubuntuY = random.nextInt(SCREEN_HEIGHT/UNIT_SIZE)*UNIT_SIZE;
        linuxX = random.nextInt(SCREEN_WIDTH/UNIT_SIZE)*UNIT_SIZE;
        linuxY = random.nextInt(SCREEN_HEIGHT/UNIT_SIZE)*UNIT_SIZE;
    }
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
    public void checkOS() throws URISyntaxException {
        if((x[0] == iosX) && (y[0] == iosY)) {
            if(choiceIOS.equals(correctAnswer)){
                try {
                    proceed();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
            else{ gameOver = true; }
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
            else{ gameOver = true; }
        }
        if((x[0] == linuxX) && (y[0] == linuxY)) {
            if(choiceLinux.equals(correctAnswer)){
                try {
                    proceed();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
            else{ gameOver = true; }
        }
    }
    public void proceed() throws URISyntaxException, FileNotFoundException {
        bodyParts++;
        points += 10;
        newOS();
        questionFrame.getQuestions();
    }
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