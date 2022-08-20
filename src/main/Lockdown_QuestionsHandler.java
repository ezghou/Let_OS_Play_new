package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Random;

import static main.LockdownGameLogic.Constants.*;

public class Lockdown_QuestionsHandler implements Runnable {
    Lockdown_editQuestions editQuestions;
    ArrayList<String> choiceList = new ArrayList<>();
    public static String question;
    public static String correctAnswer;
    Random random = new Random();
    public String choice1;
    public String choice2;
    public String choice3;
    public String choice4;
    public int id;
    public static int countQs = 0;
    public int coins = 0;
    public int timeAlive = 0;
    JTextArea questionText = new JTextArea();
    JTextArea answer_A = new JTextArea();
    JTextArea answer_B = new JTextArea();
    JTextArea answer_C = new JTextArea();
    JTextArea answer_D = new JTextArea();

    private JPanel parent;
    private final Thread questionThread;

    public Lockdown_QuestionsHandler(JPanel parent) throws FileNotFoundException, URISyntaxException {

        /**
         * All child components should be added in the third panel
         * then the third panel is added to the parent panel.
         */
        this.parent = parent;
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

        setupChoices(answer_A);
        setupChoices(answer_B);
        setupChoices(answer_C);
        setupChoices(answer_D);

        thirdPanel.add(questionText);
        fourthPanel.add(answer_A);
        fourthPanel.add(answer_B);
        fourthPanel.add(answer_C);
        fourthPanel.add(answer_D);
        thirdPanel.add(fourthPanel);

        editQuestions = new Lockdown_editQuestions();
        getQuestions(); //setInitial question

        parent.add(thirdPanel);
    }
    /**
     * Method for setting initial question, need to be called to set new question
     * @throws URISyntaxException
     * @throws FileNotFoundException
     */
    public final void getQuestions() throws URISyntaxException, FileNotFoundException {
        editQuestions.getQuestion();
        question = editQuestions.question;
        id = editQuestions.question_id;
        setQuestion();
        setChoices();
    }

    public final void setQuestion(){
        countQs++;
        //System.out.println("countQs: " + countQs);
        question = question.replace("\n", " ").replace("\r", " ");
        questionText.setText(question + "\n \n"); //Set question in textarea
        correctAnswer = editQuestions.CorrectAnswer;
        //System.out.println(question);
        //System.out.println(correctAnswer);
    }
    public final void setChoices(){
        choice1 = editQuestions.firstChoice;
        choice2 = editQuestions.secondChoice;
        choice3 = editQuestions.thirdChoice;
        choice4 = editQuestions.fourthChoice;
        choiceList.add(choice1);
        choiceList.add(choice2);
        choiceList.add(choice3);
        choiceList.add(choice4);
        int size;
        int index;

        /*
        System.out.println(choice1);
        System.out.println(choice2);
        System.out.println(choice3);
        System.out.println(choice4);

         */

        for(size = choiceList.size(); size > 0; size--){
            index = random.nextInt(size);
            switch (size) {
                case 4 -> choice1 = choiceList.get(index);
                case 3 -> choice2 = choiceList.get(index);
                case 2 -> choice3 = choiceList.get(index);
                case 1 -> choice4 = choiceList.get(index);
                default -> { }
            }
            choiceList.remove(index);
        }
        answer_A.setText(choice1); //set choice in textarea
        answer_B.setText(choice2); //set choice in textarea
        answer_C.setText(choice3); //set choice in textarea
        answer_D.setText(choice4); //set choice in textarea
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
                jTextArea.setForeground(new Color(207, 54, 66));
                if (changeQuestion)return;
                if (jTextArea.getText().equals(correctAnswer)){
                    coins += 100;
                    questionText.setBackground(Color.green);
                    return;
                }

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

    private boolean changeQuestion;
    /**
     * Added a semi game loop to have a
     * refresh timer for the questions
     */
    @Override
    public void run() {
        while(!GameOver){
            globalDebug.countSeconds();
            if (globalDebug.elapsedTimeInSecond >= 8 && changeQuestion) {
                globalDebug.resetTime();
                changeQuestion = false;
                try {
                    getQuestions();
                    questionText.setBackground(Color.BLACK);
                } catch (URISyntaxException | FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }

        }
    }

    public void start(){
        questionThread.start();
    }
}
