import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Lockdown_GamePanel extends JPanel implements ActionListener {
    static final int SCREEN_WIDTH = 1060;
    static final int SCREEN_HEIGHT = 660;
    static final int UNIT_WIDTH = 87;
    static final int UNIT_HEIGHT = 100;
    static final int GAME_UNITS = (SCREEN_WIDTH*SCREEN_HEIGHT)/(UNIT_WIDTH*UNIT_HEIGHT);
    static final int DELAY = 75;
    boolean running = false;
    Timer timer;
    Random random;

//    private final JButton taxPayer;
//    private final JButton nurse;
//    private final JButton doctor;
//    private final JButton soldier;

    Lockdown_GamePanel(){
        random = new Random();

        this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
//        this.setBackground(new Color(3,10,33));
        this.setBackground(Color.BLACK);
        this.setFocusable(true);


//
//        taxPayer = new JButton();
//        taxPayer.setText("taxPayer");
//        taxPayer.setForeground(Color.white);
//        taxPayer.setFont(new Font("Cambria", Font.BOLD, 25));
//        taxPayer.setHorizontalAlignment(SwingConstants.CENTER);
//        taxPayer.setVerticalAlignment(SwingConstants.CENTER);
//        taxPayer.setBounds(0, 0, 190, 55);
////        taxPayer.setContentAreaFilled(false);
//        taxPayer.setFocusable(false);
//        taxPayer.setBorder(BorderFactory.createLineBorder(new Color(34, 42, 53),4));
//        taxPayer.addMouseListener(this);
//        taxPayer.setVisible(true);

//
//        this.add(taxPayer);
//        this.addMouseListener(this);
        startGame();
    }

    public void startGame(){
        newInfected();
        running = true;
        timer = new Timer(DELAY,this);
        timer.start();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g){
        for (int i = 0; i < 5000; i++){
            g.drawLine(i*UNIT_WIDTH,0,i*UNIT_WIDTH,5000);
            g.drawLine(0,i*UNIT_HEIGHT,5000,i*UNIT_HEIGHT);
        }
    }

    public void newInfected(){

    }

    public void move(){

    }

    public void checkInfected(){

    }

    public void checkCollisions(){

    }

    public void gameOver(Graphics g){

    }









    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
