package main.LockdownGameLogic;

import main.LockdownGameLogic.Entities.Chara;
import main.LockdownGameLogic.Entities.CharaProjectile;
import main.LockdownGameLogic.Entities.EnemyChara;
import main.Lockdown_MainFrame;
import main.Lockdown_editQuestions;
import main.TheLadder_editQuestions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Random;

import static main.LockdownGameLogic.Constants.*;


/**
 * This class serves as the Panel for the Lockdown game
 * Contains GameLoop for the rendering and update logic
 */
public class GamePanel extends JPanel implements Runnable{
    public ArrayList<BufferedImage> sprites = new ArrayList<>();
    private ArrayList<GridHandler> grids = new ArrayList<>();
    private ArrayList<Chara> charas = new ArrayList<>();
    private ArrayList<EnemyChara> enemyCharas = new ArrayList<>();
    private ArrayList<SelectorHandler> selectors = new ArrayList<>();

    //Var for displaying question


    private Thread gameThread;
    private Debug debug;
    private Debug spawnerDebug, spawnerDebug2, waveDebug;
    private float timeSpawn = 10;
    private float waveTime = 60;


    private BufferedImage tempImg;
    public GamePanel(){
        setFocusable(true);
        debug = new Debug();
        debug.getSprites(sprites);

        spawnerDebug = new Debug();
        spawnerDebug2 = new Debug();
        waveDebug = new Debug();

        gameThread = new Thread(this);

        for(int x = 0; x < gridRowCount; x++){
            for(int y = 0; y < gridColumnCount; y++){
                grids.add(new GridHandler(x, y));
            }
        }

        for(int x = 0; x < 5; x++){
            selectors.add(new SelectorHandler(x));
        }

        enemySpawnerViaKey();

        addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                mouseX = e.getX();
                mouseY = e.getY();


                if(GameOver){
                    dispose();
                    GamePanel.this.setBackground(Color.WHITE);
                    repaint();
                    Thread newThread = new Thread(GamePanel.this);
                    newThread.start();
                }

                for (SelectorHandler selector : selectors) {
                    selector.setCollision(mouseX, mouseY);
                    if (selector.isClicked()) {
                        globalCharaID = selector.getColumnIndex();
                    }
                }

                ///GRIDS
                for (GridHandler grid : grids) {
                    grid.setCollision(mouseX, mouseY);
                    if (grid.isClicked()) {
                        int rowCount = grid.getRowCount();
                        int columnCount = grid.getColumnCount();
                        //System.out.println("Row: " + rowCount + "| Column: " + columnCount);
                        grid.setCollision(false);

                        if (grid.isOccupied()) {
                            for (int i = 0; i < charas.size(); i++) {
                                if (charas.get(i).getRow() == rowCount && charas.get(i).getColumn() == columnCount && globalCharaID == 3) {
                                    charas.remove(i);
                                    grid.setOccupied(false);
                                    i--;
                                }
                            }
                        } else {
                            if (globalCharaID == 3 || globalCharaID == -1) return;
                            Chara testCharacter = new Chara(grid.getXcenter(), grid.getYcenter(), globalCharaID);
                            testCharacter.setRowColumn(rowCount, columnCount);
                            charas.add(testCharacter);
                            grid.setOccupied(true);
                            globalCharaID = -1;

                            for (SelectorHandler selectorHandler : selectors) {
                                selectorHandler.setCollision(false);
                            }
                        }
                    }
                }
            }
        });



    }


    private void enemySpawnerViaKey(){
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                switch (e.getKeyChar()){
                    case '1' ->{
                        enemyCharas.add(new EnemyChara(1));
                        col1EnemCount++;
                    }
                    case '2' ->{
                        enemyCharas.add(new EnemyChara(2));
                        col2EnemCount++;
                    }
                    case '3' ->{
                        enemyCharas.add(new EnemyChara(3));
                        col3EnemCount++;
                    }
                    case '4' ->{
                        enemyCharas.add(new EnemyChara(4));
                        col4EnemCount++;
                    }
                    case '5' ->{
                        enemyCharas.add(new EnemyChara(5));
                        col5EnemCount++;
                    }
                    //FOR TESTING PURPOSES
                    case 'r' ->{
                        dispose();
                        repaint();
                        Thread newThread = new Thread(GamePanel.this);
                        newThread.start();
                    }
                }

            }
        });
    }

    private void randomEnemySpawner(float decayRate){
        spawnerDebug.countSeconds();
        spawnerDebug2.countSeconds();
        waveDebug.countSeconds();
        if(spawnerDebug.elapsedTimeInSecond >= 20){
            spawnerDebug.resetTime();
            timeSpawn *= decayRate;
        }

        if(waveDebug.elapsedTimeInSecond >= waveTime){
            if(waveTime >= 15) waveTime *= 0.65f; //LIMITER
            waveDebug.resetTime();
            int skipCol = debug.random.nextInt(1, 6);
            for(int i = 1; i <= 5; i++){
                if(i == skipCol) continue;
                enemyCharas.add(new EnemyChara(i));
                switch (i) {
                    case 1 -> col1EnemCount++;
                    case 2 -> col2EnemCount++;
                    case 3 -> col3EnemCount++;
                    case 4 -> col4EnemCount++;
                    case 5 -> col5EnemCount++;
                }
            }
            System.out.println("WAVE");
        }

        if(spawnerDebug2.elapsedTimeInSecond >= timeSpawn){
            spawnerDebug2.resetTime();
            //Spawn an enemy
            int col = debug.random.nextInt(1,6);
            enemyCharas.add(new EnemyChara(col));
            switch (col){
                case 1 -> col1EnemCount++;
                case 2 -> col2EnemCount++;
                case 3 -> col3EnemCount++;
                case 4 -> col4EnemCount++;
                case 5 -> col5EnemCount++;
            }
        }

    }


    public void start(){
        gameThread.start();
    }

    @Override
    public void run() {
        double timePerFrame = 1000000000.0 / 120.0;
        double timePerUpdate = 1000000000.0 / 60.0; //1 Second;
        long lastFrame = System.nanoTime();
        long lastUpdate = System.nanoTime();
        long lastTimeCheck = System.currentTimeMillis();

        int frames = 0;
        int updates = 0;
        while(!GameOver){
            //RENDER
            if (System.nanoTime() - lastFrame >= timePerFrame) {
                repaint();
                lastFrame = System.nanoTime();
                frames++;
            }
            //UPDATE
            if(System.nanoTime() - lastUpdate >= timePerUpdate){
                update();
                lastUpdate = System.nanoTime();
                updates++;
            }

            //CHECKING FPS AND UPS
            if(System.currentTimeMillis() - lastTimeCheck >= 1000){
                //System.out.println("FPS: " + frames + "|" + " UPS: " + updates);
                frames = 0;
                updates = 0;
                lastTimeCheck = System.currentTimeMillis();
            }
        }

        repaint();
        this.setBackground(Color.BLACK);
        System.out.println("GAME OVER!!!");
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        if(GameOver){
            String text = "GAME OVER";
            String retryText = "Click Screen to Retry";
            g.setColor(Color.red);
            g.drawString(text, SCREEN_WIDTH/2 - g.getFontMetrics().stringWidth(text) / 2, SCREEN_HEIGHT/2 - g.getFontMetrics().getHeight() / 2);
            g.setColor(Color.WHITE);
            g.drawString(retryText, SCREEN_WIDTH/2 - g.getFontMetrics().stringWidth(retryText)/2, SCREEN_HEIGHT/2 + g.getFontMetrics().getHeight());
            return;
        }

        drawGrid(g);
        for (Chara chara : charas) {
            chara.render(g);
        }

        for(EnemyChara enemyChara : enemyCharas){
            enemyChara.render(g);
        }
        //SELECTORS
        drawSelector(g);
    }


    public void update(){

        try {
            for (Chara chara : charas) {
                chara.update();
            }

            for (EnemyChara enemyChara : enemyCharas) {
                enemyChara.update();
            }
        } catch (Exception e){
            System.out.println("ENTITY UPDATE/RENDER TIMING ERROR");
        }

        handleEnemyCharaCollision();

        randomEnemySpawner(0.9f);
    }

    public void handleEnemyCharaCollision(){
        for(int i = 0; i < enemyCharas.size(); i++){
            boolean skip = false;
            if(enemyCharas.get(i).shouldDisappear()){
                switch (enemyCharas.get(i).getColumn()){
                    case 1 -> col1EnemCount--;
                    case 2 -> col2EnemCount--;
                    case 3 -> col3EnemCount--;
                    case 4 -> col4EnemCount--;
                    case 5 -> col5EnemCount--;
                }
                enemyCharas.remove(i);
                i--;
                continue;
            }


            for(int j = 0; j < charas.size(); j++) {
                if(charas.get(j).health <= 0){
                    for(GridHandler grid : grids){
                        if(charas.get(j).getColumn() == grid.getColumnCount() && charas.get(j).getRow() == grid.getRowCount()){
                            grid.setOccupied(false);
                        }
                    }
                    charas.remove(j);
                    j--;
                    continue;
                }
                boolean condition1 = charas.get(j).getPositionX() + gridWidth >= enemyCharas.get(i).getPositionX() && charas.get(j).getPositionX() <= enemyCharas.get(i).getPositionX();
                boolean condition2 = charas.get(j).getColumn() == enemyCharas.get(i).getColumn();

                if (condition1 && condition2) {
                    skip = true;

                    if(enemyCharas.get(i).attackAvailable) {
                        charas.get(j).health--;//ENEMY COLLIDED WITH CHARA
                        charas.get(j).setCollidedWithInfected(true);
                        enemyCharas.get(i).attackAvailable = false;
                    }
                }

                if (condition2) {
                    for (CharaProjectile charaProjectile : charas.get(j).charaProjectiles) {
                        boolean condition3 = charaProjectile.projectilePositionX + gridWidth >= enemyCharas.get(i).getPositionX() && charaProjectile.projectilePositionX <= enemyCharas.get(i).getPositionX();
                        if (condition3) {
                            // PROJECTILE COLLIDED WITH ENEMY
                            enemyCharas.get(i).health -= charas.get(j).damage;
                            charaProjectile.destroy = true;
                            enemyCharas.get(i).setCollidedWithProjectile(true);
                        }
                    }
                }
            }


            if(skip) continue;
            enemyCharas.get(i).updatePosition();
        }
    }

    private void drawGrid(Graphics g){
        //MARGIN
        //g.drawRect(paddingLeft, paddingTop, lawnWidth,lawnHeight);
        int initY = paddingTop;
        int initX = paddingLeft;


        //DRAW THE GRID
        g.setColor(Color.BLACK);

        for(int x = 0; x < gridRowCount; x++) {
            for (int y = 0; y < gridColumnCount; y++) {
                //g.drawRect(initX + (x * gridWidth), initY + (y * gridHeight), gridWidth, gridHeight);
                int Xcenter = initX + (x * gridWidth);
                int Ycenter = initY + (y * gridHeight);
                switch (y){
                    case 0 -> g.drawImage(testField,  Xcenter, Ycenter, gridWidth,  gridHeight, null);
                    case gridColumnCount - 1-> g.drawImage(testFieldBottom,  Xcenter, Ycenter, gridWidth, gridHeight, null);
                    default -> g.drawImage(testFieldMiddle,  Xcenter, Ycenter, gridWidth, gridHeight, null);
                }

            }
        }

    }
    public void drawSelector(Graphics g){
        int initY = paddingTop;
        int initX = paddingLeft;
        //SELECTOR
        for(int x = 0; x < 4; x++){

            if(selectors.get(x).isClicked()){
                g.setColor(Color.red);
                g.fillRect( selectorPaddingLeft , initY + (x*gridHeight), gridWidth, gridHeight);
            } else {
                g.setColor(Color.gray);
                g.fillRect(selectorPaddingLeft, initY + (x * gridHeight), gridWidth, gridHeight);
            }
            int Xcenter = selectorPaddingLeft + (gridWidth/2);
            int Ycenter = paddingTop + ((x * gridHeight) + (gridHeight/2));


            switch (x) {
                case 0 -> tempImg = nurse;
                case 1 -> tempImg = doctor;
                case 2 -> tempImg = soldier;
                case 3 -> tempImg = fire;
            }

            g.drawImage(tempImg, Xcenter - (tempImg.getWidth()/2), Ycenter - (tempImg.getHeight()/2), null);
        }
    }

    public void dispose(){
        enemyCharas.clear();
        charas.clear();
        spawnerDebug.resetTime();
        spawnerDebug2.resetTime();
        waveDebug.resetTime();
        waveTime= 60;
        timeSpawn = 10;
        globalCharaID = -1;
        col1EnemCount = 0;
        col2EnemCount = 0;
        col3EnemCount = 0;
        col4EnemCount = 0;
        col5EnemCount = 0;
        for(GridHandler gridHandler : grids){
            gridHandler.setOccupied(false);
        }
        GameOver = false;
    }
}
