/**
 * Display the multiple-choice question
 * on the bottom of the screen
 *
 * @author  EG Renz Go
 * @author  Thereze Nuelle Roca
 * @author  Erica Talahiban
 * @version 1.0
 */
package main;

import main.LockdownGameLogic.Debug;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static main.LockdownGameLogic.Constants.*;
@SuppressWarnings("ALL")
public class Lockdown_QuestionsHandler implements Runnable {
    Lockdown_editQuestions editQuestions;
    public static String correctAnswer;
    JTextArea questionText = new JTextArea();
    JTextArea answer_A = new JTextArea();
    JTextArea answer_B = new JTextArea();
    JTextArea answer_C = new JTextArea();
    JTextArea answer_D = new JTextArea();
    JTextArea coinsText = new JTextArea();
    JTextArea timeAlive = new JTextArea();
    private final Thread questionThread;
    private final Debug questionTimerRefresh = new Debug();
    private boolean changeQuestion = false;
    Sounds checkAnswer = new Sounds();
    /**
     * All child components should be added in the third panel
     * then the third panel is added to the parent panel.
     */
    public Lockdown_QuestionsHandler(JPanel parent) {
        JPanel thirdPanel = new JPanel();
        thirdPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
        //thirdPanel.setLayout(new GridLayout(3, 1));
        thirdPanel.setBackground(Color.BLACK);
        questionThread = new Thread(this);

        questionText.setBounds(0,0,SCREEN_WIDTH/2,170);
        questionText.setForeground(new Color(230, 244, 251));
        questionText.setFont(new java.awt.Font("Tunga", 0, 15));
        questionText.setWrapStyleWord(true);
        questionText.setLineWrap(true);
        questionText.setEditable(false);
        questionText.setBackground(Color.black);
        questionText.setBorder(BorderFactory.createLineBorder(new Color(113, 192, 250),2));
        questionText.setLayout(new FlowLayout());

        JPanel fourthPanel = new JPanel();
        fourthPanel.setLayout(new GridLayout(2, 2 , 10, 5));
        fourthPanel.setBackground(Color.BLACK);

        JPanel fifthPanel = new JPanel();
        fifthPanel.setLayout(new GridLayout(2, 1 , 10, 5));
        fifthPanel.setBackground(new Color(28, 8, 9));

        setupChoices(answer_A);
        setupChoices(answer_B);
        setupChoices(answer_C);
        setupChoices(answer_D);

        coinsText.setText("Coins : 100");
        coinsText.setForeground(new Color(108, 202, 255));
        coinsText.setFont(new java.awt.Font("Tunga", 0, 15));
        coinsText.setWrapStyleWord(true);
        coinsText.setLineWrap(true);
        coinsText.setEditable(false);
        coinsText.setOpaque(false);
        coinsText.setHighlighter(null);
        coinsText.setBorder(BorderFactory.createLineBorder(new Color(128, 0, 0),3));
        coinsText.setLayout(new BorderLayout());

        timeAlive.setText("Time Alive : 0");
        timeAlive.setForeground(new Color(108, 202, 255));
        timeAlive.setFont(new java.awt.Font("Tunga", 0, 15));
        timeAlive.setWrapStyleWord(true);
        timeAlive.setLineWrap(true);
        timeAlive.setEditable(false);
        timeAlive.setOpaque(false);
        timeAlive.setHighlighter(null);
        timeAlive.setBorder(BorderFactory.createLineBorder(new Color(128, 0, 0),3));
        timeAlive.setLayout(new BorderLayout());

        thirdPanel.add(questionText);
        fourthPanel.add(answer_A);
        fourthPanel.add(answer_B);
        fourthPanel.add(answer_C);
        fourthPanel.add(answer_D);
        thirdPanel.add(fourthPanel);
        fifthPanel.add(coinsText);
        fifthPanel.add(timeAlive);

        editQuestions = new Lockdown_editQuestions();
        displayMCQ();
        //getQuestions(); //setInitial question

        parent.add(thirdPanel);
        parent.add(fifthPanel);
    }
    /**
     * Display the random multiple choice question
     */
    public void displayMCQ(){
        editQuestions.setRandomID();
        questionText.setText(editQuestions.getQuestion());
        String[] choices = editQuestions.getChoices();
        answer_A.setText(choices[0]);
        answer_B.setText(choices[1]);
        answer_C.setText(choices[2]);
        answer_D.setText(choices[3]);
        correctAnswer = editQuestions.getCorrectAnswer();
        System.out.println("answer: "+correctAnswer);
    }

    public void setupChoices(JTextArea jTextArea){
        jTextArea.setForeground(new Color(230, 244, 251));
        jTextArea.setFont(new java.awt.Font("Tunga", 0, 15));
        jTextArea.setWrapStyleWord(true);
        jTextArea.setLineWrap(true);
        jTextArea.setEditable(false);
        jTextArea.setOpaque(false);
        jTextArea.setHighlighter(null);
        jTextArea.setBorder(BorderFactory.createLineBorder(new Color(113, 192, 250),2));
        jTextArea.setLayout(new BorderLayout());
        jTextArea.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                checkAnswer.soundChoice(4);
                jTextArea.setForeground(new Color(207, 54, 66));
                if (changeQuestion)return;
                if (jTextArea.getText().equals(correctAnswer)){
                    Coins += 100;
                    checkAnswer.soundChoice(2);
                    questionText.setBackground(Color.green);
                    return;
                }
                checkAnswer.soundChoice(3);
                questionText.setBackground(Color.RED);
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                jTextArea.setForeground(new Color(230, 244, 251));
                if (changeQuestion)return;
                changeQuestion = true;
            }
        });
    }
    /**
     * Added a semi game loop to have a
     * refresh timer for the questions
     */
    @Override
    public void run() {
        while(!GameOver){
            questionTimerRefresh.countSeconds();
            String c = "Coins : " + Coins;
            String t = "Time Alive : " + globalDebug.returnSeconds() + " seconds";
            coinsText.setText(c);
            timeAlive.setText(t);
            if (questionTimerRefresh.elapsedTimeInSecond >= 8 && changeQuestion) {
                questionTimerRefresh.resetTime();
                changeQuestion = false;
                displayMCQ();
                questionText.setBackground(Color.BLACK);
            }

        }
    }

    public void start(){
        questionThread.start();
    }

    public void restart(){
        questionTimerRefresh.resetTime();
        changeQuestion = false;
        Thread thread = new Thread(this);
        thread.start();
    }
}
