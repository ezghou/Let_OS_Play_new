/**
 * The frame where the questions will be displayed
 * and where the OSnakes_gamePanel will be attached
 *
 * @author  EG Renz Go
 * @author  Thereze Nuelle Roca
 * @author  Erica Talahiban
 * @version 1.0
 */

package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.*;

@SuppressWarnings("ALL")
public class OSnakes_questionFrame extends JFrame implements MouseListener {
    private final JLabel pointsLabel;
    private final JTextArea qsTextArea;
    private final JTextArea choiceA;
    private final JTextArea choiceB;
    private final JTextArea choiceC;
    private final JTextArea choiceD;
    private final JButton backButton;
    private final JButton restartButton;
    private final JTextArea answer1;

    OSnakes_editQuestions editQuestions;
    ArrayList<String> choiceList = new ArrayList<>();
    public static String question;
    public static String correctAnswer;
    Random random = new Random();
    public String choice1;
    public String choice2;
    public String choice3;
    public String choice4;
    public int id;
    public static int countQs;
    private final OSnakes_gamePanel gamePanel;
    Sounds bgMusic;
    Sounds click  = new Sounds();

    OSnakes_questionFrame (Sounds bgm) throws URISyntaxException, FileNotFoundException {
        bgMusic = bgm;
        bgMusic.stop();
        bgMusic.soundChoice(8);
        bgMusic.playLoop();
        int SCREEN_WIDTH = 1060;
        int SCREEN_HEIGHT = 660;
        URL iconURL = getClass().getResource("/Resources/titleIcon.png");
        assert iconURL != null;
        ImageIcon titleIcon = new ImageIcon(iconURL);
        gamePanel = new OSnakes_gamePanel(this, SCREEN_WIDTH, SCREEN_HEIGHT, bgMusic);

        JLabel qsLabel = new JLabel();
        qsLabel.setText("Question");
        qsLabel.setBounds((int)Math.round(SCREEN_WIDTH*0.01953125), 50, 250, 100);
        qsLabel.setForeground(new Color(0, 128, 55));
        qsLabel.setFont(new Font("Ink Free", Font.BOLD, 60));
        qsLabel.setFocusable(false);

        pointsLabel = new JLabel();
        pointsLabel.setText("Points: 0");
        pointsLabel.setBounds(500, 50, 300, 50);
        pointsLabel.setForeground(new Color(0, 128, 55));
        pointsLabel.setFont(new Font("Ink Free", Font.BOLD, 35));
        pointsLabel.setFocusable(false);

        JLabel iosLogo = new JLabel(new ImageIcon(getClass().getResource("/Resources/OSnakes_iosLogo.png")), JLabel.CENTER);
        iosLogo.setBounds((int)Math.round(SCREEN_WIDTH*0.01953125), 260,50,30);
        iosLogo.setFocusable(false);

        JLabel windowsLogo = new JLabel(new ImageIcon(getClass().getResource("/Resources/OSnakes_windowsLogo.png")), JLabel.CENTER);
        windowsLogo.setBounds((int)Math.round(SCREEN_WIDTH*0.01953125),320,50,30);
        windowsLogo.setFocusable(false);

        JLabel ubuntuLogo = new JLabel(new ImageIcon(getClass().getResource("/Resources/OSnakes_ubuntuLogo.png")), JLabel.CENTER);
        ubuntuLogo.setBounds((int)Math.round(SCREEN_WIDTH*0.01953125),380,50,30);
        ubuntuLogo.setFocusable(false);

        JLabel linuxLogo = new JLabel(new ImageIcon(getClass().getResource("/Resources/OSnakes_linuxLogo.png")), JLabel.CENTER);
        linuxLogo.setBounds((int)Math.round(SCREEN_WIDTH*0.01953125),440,50,30);
        linuxLogo.setFocusable(false);

        qsTextArea = new JTextArea();
        qsTextArea.setBounds((int)Math.round(SCREEN_WIDTH*0.022786458333),130,450,100);
        qsTextArea.setBackground(new Color(245, 243, 245));
        qsTextArea.setFont(new Font("Verdana", Font.PLAIN, 14));
        qsTextArea.setMargin(new Insets(20,20,20,20));
        qsTextArea.setLineWrap(true);
        qsTextArea.setWrapStyleWord(true);
        qsTextArea.setEditable(false);
        qsTextArea.setFocusable(false);

        choiceA = new JTextArea();
        choiceA.setBounds((int)Math.round(SCREEN_WIDTH*0.09765625),250,370,50);
        choiceA.setBackground(new Color(252, 100, 103));
        choiceA.setFont(new Font("Verdana", Font.PLAIN, 12));
        choiceA.setMargin(new Insets(5,10,5,5));
        choiceA.setLineWrap(true);
        choiceA.setWrapStyleWord(true);
        choiceA.setEditable(false);
        choiceA.setFocusable(false);

        choiceB = new JTextArea();
        choiceB.setBounds((int)Math.round(SCREEN_WIDTH*0.09765625),310,370,50);
        choiceB.setBackground(new Color(129, 195, 201));
        choiceB.setFont(new Font("Verdana", Font.PLAIN, 12));
        choiceB.setMargin(new Insets(5,10,5,5));
        choiceB.setLineWrap(true);
        choiceB.setWrapStyleWord(true);
        choiceB.setEditable(false);
        choiceB.setFocusable(false);

        choiceC = new JTextArea();
        choiceC.setBounds((int)Math.round(SCREEN_WIDTH*0.09765625),370,370,50);
        choiceC.setBackground(new Color(244, 166, 78));
        choiceC.setFont(new Font("Verdana", Font.PLAIN, 12));
        choiceC.setMargin(new Insets(5,10,5,5));
        choiceC.setLineWrap(true);
        choiceC.setWrapStyleWord(true);
        choiceC.setEditable(false);
        choiceC.setFocusable(false);

        choiceD = new JTextArea();
        choiceD.setBounds((int)Math.round(SCREEN_WIDTH*0.09765625),430,370,50);
        choiceD.setBackground(new Color(255, 235, 91));
        choiceD.setFont(new Font("Verdana", Font.PLAIN, 12));
        choiceD.setMargin(new Insets(5,10,5,5));
        choiceD.setLineWrap(true);
        choiceD.setWrapStyleWord(true);
        choiceD.setEditable(false);
        choiceD.setFocusable(false);

        answer1 = new JTextArea();
        answer1.setBounds((int)Math.round(SCREEN_WIDTH*0.09765625),(int)Math.round(SCREEN_HEIGHT*0.9027777777),300,30);
        answer1.setEditable(false);
        answer1.setFocusable(false);

        restartButton = new JButton();
        restartButton.setIcon(new ImageIcon(getClass().getResource("/Resources/OSnakes_restartButton.png")));
        restartButton.setHorizontalAlignment(SwingConstants.CENTER);
        restartButton.setVerticalAlignment(SwingConstants.CENTER);
        restartButton.setBounds(500, 500, 125, 70);
        restartButton.setFocusable(false);
        restartButton.setContentAreaFilled(false);
        restartButton.setBorderPainted(false);
        restartButton.setFocusPainted(false);
        restartButton.addMouseListener(this);

        backButton = new JButton();
        backButton.setIcon(new ImageIcon(getClass().getResource("/Resources/OSnakes_backButton.png")));
        backButton.setHorizontalAlignment(SwingConstants.CENTER);
        backButton.setVerticalAlignment(SwingConstants.CENTER);
        backButton.setBounds(900, 500, 125, 70);
        backButton.setFocusable(false);
        backButton.setContentAreaFilled(false);
        backButton.setBorderPainted(false);
        backButton.setFocusPainted(false);
        backButton.addMouseListener(this);

        this.setTitle("Let OS Play");
        this.setSize(1060,660);
        this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        this.setLayout(null);
        this.setResizable(false);
        this.setIconImage(titleIcon.getImage());
        this.getContentPane().setBackground(new Color(3,10,33));
        this.setLocationRelativeTo(null);
        this.setFocusable(false);
        this.setVisible(true);

        this.getContentPane().add(qsLabel);
        this.getContentPane().add(pointsLabel);
        this.getContentPane().add(iosLogo);
        this.getContentPane().add(windowsLogo);
        this.getContentPane().add(ubuntuLogo);
        this.getContentPane().add(linuxLogo);
        this.add(gamePanel);
        this.getContentPane().add(qsTextArea);
        this.getContentPane().add(choiceA);
        this.getContentPane().add(choiceB);
        this.getContentPane().add(choiceC);
        this.getContentPane().add(choiceD);
        this.getContentPane().add(restartButton);
        this.getContentPane().add(backButton);
        //this.getContentPane().add(answer1);

        editQuestions = new OSnakes_editQuestions();
        displayMCQ();
    }
    /**
     * Display the random multiple choice question
     */
    public void displayMCQ(){
        editQuestions.setRandomID();
        qsTextArea.setText(editQuestions.getQuestion());
        String[] choices = editQuestions.getChoices();
        choiceA.setText(choices[0]);
        choiceB.setText(choices[1]);
        choiceC.setText(choices[2]);
        choiceD.setText(choices[3]);
        gamePanel.setChoices(choices[0], choices[1], choices[2], choices[3], editQuestions.getCorrectAnswer());
        System.out.println("answer: "+editQuestions.getCorrectAnswer());
    }

    public void editPoints(int points){
        pointsLabel.setText("Points: " + points);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()==backButton){
            click.soundChoice(9);
            bgMusic.stop();
            bgMusic.soundChoice(7);
            new OSnakes_MainFrame(bgMusic);
            this.dispose();
        }
        if(e.getSource()==restartButton){
            click.soundChoice(9);
            try {
                new OSnakes_questionFrame(bgMusic);
            } catch (URISyntaxException | FileNotFoundException ex) {
                ex.printStackTrace();
            }
            this.dispose();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getSource()==backButton){
            bgMusic.stop();
            bgMusic.soundChoice(7);
            new OSnakes_MainFrame(bgMusic);
            this.dispose();
        }
        if(e.getSource()==restartButton){
            try {
                new OSnakes_questionFrame(bgMusic);
            } catch (URISyntaxException | FileNotFoundException ex) {
                ex.printStackTrace();
            }
            this.dispose();
        }
    }
    @Override
    public void mouseReleased(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {
        if(e.getSource()==restartButton){
            restartButton.setIcon(new ImageIcon(getClass().getResource("/Resources/OSnakes_restartButtonHL.png")));
        }
        if(e.getSource()==backButton){
            backButton.setIcon(new ImageIcon(getClass().getResource("/Resources/OSnakes_backButtonHL.png")));
        }
    }
    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource()==restartButton){
            restartButton.setIcon(new ImageIcon(getClass().getResource("/Resources/OSnakes_restartButton.png")));
        }
        if(e.getSource()==backButton){
            backButton.setIcon(new ImageIcon(getClass().getResource("/Resources/OSnakes_backButton.png")));
        }
    }
}
