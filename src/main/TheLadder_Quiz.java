package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

@SuppressWarnings("ALL")
    public class TheLadder_Quiz extends JFrame implements ActionListener {

        private final JLabel mainLogo;
        private final JButton Peek;
        private final JButton Skip;
        private final JButton Reveal;
        private final JButton Submit;
        private final JButton Next;
        private final JButton Back;
        private final JButton ViewResult;
        private final JTextField Money;
        private final JTextField Position;
        private final JTextField Score;
        JTextArea questionText = new JTextArea();
        JTextArea answer_A = new JTextArea();
        JTextArea answer_B = new JTextArea();
        JTextArea answer_C = new JTextArea();
        JTextArea answer_D = new JTextArea();

        //To lock the user's answer
        JRadioButton rButtonA = new JRadioButton();
        JRadioButton rButtonB = new JRadioButton();
        JRadioButton rButtonC = new JRadioButton();
        JRadioButton rButtonD = new JRadioButton();
        ButtonGroup group = new ButtonGroup();
        int buttonClicksA = 0;
        int buttonClicksB = 0;
        int buttonClicksC = 0;
        int buttonClicksD = 0;

        String guess = "";
        int checkChoiceA;
        int checkChoiceB;
        int checkChoiceC;
        int checkChoiceD;

        Sounds click = new Sounds();

        TheLadder_editQuestions editQuestions;
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
        public int score = 0;

        TheLadder_Quiz() throws FileNotFoundException, URISyntaxException {
            int SCREEN_WIDTH = 1060;
            int SCREEN_HEIGHT = 660;
            URL iconURL = getClass().getResource("/Resources/titleIcon.png");
            assert iconURL != null;
            ImageIcon titleIcon = new ImageIcon(iconURL);

            mainLogo = new JLabel(new ImageIcon(getClass().getResource("/Resources/TheLadder_Quiz.png")), JLabel.CENTER);
            mainLogo.setSize(SCREEN_WIDTH,SCREEN_HEIGHT);
            mainLogo.setVerticalAlignment(JLabel.CENTER);
            mainLogo.setHorizontalAlignment(JLabel.CENTER);
            mainLogo.setLocation(0, -30);
            mainLogo.setVisible(true);

            Peek = new JButton();
            Peek.setText("Peek");
            Peek.setForeground(new Color(230, 244, 251));
            Peek.setBackground(new Color(17, 71, 90));
            Peek.setFont(new Font("Cambria", Font.BOLD, 15));
            Peek.setHorizontalAlignment(SwingConstants.CENTER);
            Peek.setVerticalAlignment(SwingConstants.CENTER);
            Peek.setBounds(20, 20, 120, 30);
            Peek.setContentAreaFilled(false);
            Peek.setFocusable(false);
            Peek.setBorder(BorderFactory.createLineBorder(new Color(113, 192, 250),3));
            Peek.addActionListener(this);

            Skip = new JButton();
            Skip.setText("Skip");
            Skip.setForeground(new Color(230, 244, 251));
            Skip.setBackground(new Color(17, 71, 90));
            Skip.setFont(new Font("Cambria", Font.BOLD, 15));
            Skip.setHorizontalAlignment(SwingConstants.CENTER);
            Skip.setVerticalAlignment(SwingConstants.CENTER);
            Skip.setBounds(20, 60, 120, 30);
            Skip.setContentAreaFilled(false);
            Skip.setFocusable(false);
            Skip.setBorder(BorderFactory.createLineBorder(new Color(113, 192, 250),3));
            Skip.addActionListener(this);

            Reveal = new JButton();
            Reveal.setText("Reveal");
            Reveal.setForeground(new Color(230, 244, 251));
            Reveal.setBackground(new Color(17, 71, 90));
            Reveal.setFont(new Font("Cambria", Font.BOLD, 15));
            Reveal.setHorizontalAlignment(SwingConstants.CENTER);
            Reveal.setVerticalAlignment(SwingConstants.CENTER);
            Reveal.setBounds(20, 100, 120, 30);
            Reveal.setContentAreaFilled(false);
            Reveal.setFocusable(false);
            Reveal.setBorder(BorderFactory.createLineBorder(new Color(113, 192, 250),3));
            Reveal.addActionListener(this);

            Next = new JButton();
            Next.setText("Next");
            Next.setForeground(new Color(230, 244, 251));
            Next.setBackground(new Color(17, 71, 90));
            Next.setFont(new Font("Cambria", Font.BOLD, 15));
            Next.setHorizontalAlignment(SwingConstants.CENTER);
            Next.setVerticalAlignment(SwingConstants.CENTER);
            Next.setBounds(900, 560, 120, 30);
            Next.setContentAreaFilled(false);
            Next.setFocusable(false);
            Next.setBorder(BorderFactory.createLineBorder(new Color(113, 192, 250),3));
            Next.addActionListener(this);

            Back = new JButton();
            Back.setText("Back");
            Back.setForeground(new Color(230, 244, 251));
            Back.setBackground(new Color(17, 71, 90));
            Back.setFont(new Font("Cambria", Font.BOLD, 15));
            Back.setHorizontalAlignment(SwingConstants.CENTER);
            Back.setVerticalAlignment(SwingConstants.CENTER);
            Back.setBounds(20, 560, 120, 30);
            Back.setContentAreaFilled(false);
            Back.setFocusable(false);
            Back.setBorder(BorderFactory.createLineBorder(new Color(113, 192, 250),3));
            Back.addActionListener(this);

            ViewResult = new JButton();
            ViewResult.setText("View Result");
            ViewResult.setForeground(new Color(230, 244, 251));
            ViewResult.setBackground(new Color(17, 71, 90));
            ViewResult.setFont(new Font("Cambria", Font.BOLD, 15));
            ViewResult.setHorizontalAlignment(SwingConstants.CENTER);
            ViewResult.setVerticalAlignment(SwingConstants.CENTER);
            ViewResult.setBounds(900, 560, 120, 30);
            ViewResult.setContentAreaFilled(false);
            ViewResult.setFocusable(false);
            ViewResult.setBorder(BorderFactory.createLineBorder(new Color(113, 192, 250),3));
            ViewResult.addActionListener(this);
            ViewResult.setVisible(false);
            ViewResult.setEnabled(false);

            Submit = new JButton();
            Submit.setText("Submit");
            Submit.setForeground(new Color(230, 244, 251));
            Submit.setBackground(new Color(17, 71, 90));
            Submit.setFont(new Font("Cambria", Font.BOLD, 15));
            Submit.setHorizontalAlignment(SwingConstants.CENTER);
            Submit.setVerticalAlignment(SwingConstants.CENTER);
            Submit.setBounds(900, 520, 120, 30);
            Submit.setContentAreaFilled(false);
            Submit.setFocusable(false);
            Submit.setBorder(BorderFactory.createLineBorder(new Color(113, 192, 250),3));
            Submit.addActionListener(this);

            Money = new JTextField("Money: " + coins);
            Money.setBounds(870, 20, 150, 35);
            Money.setFont(new Font("Cambria", Font.BOLD, 15));
            Money.setHorizontalAlignment(SwingConstants.CENTER);
            Money.setOpaque(false);
            Money.setForeground(new Color(230, 244, 251));
            Money.setBorder(BorderFactory.createLineBorder(new Color(113, 192, 250),3));

            Position = new JTextField("Position: CEO");
            Position.setBounds(870, 65, 150, 35);
            Position.setFont(new Font("Cambria", Font.BOLD, 15));
            Position.setHorizontalAlignment(SwingConstants.CENTER);
            Position.setOpaque(false);
            Position.setForeground(new Color(230, 244, 251));
            Position.setBorder(BorderFactory.createLineBorder(new Color(113, 192, 250),3));

            Score = new JTextField("Score: " + score);
            Score.setBounds(870, 110, 150, 35);
            Score.setFont(new Font("Cambria", Font.BOLD, 15));
            Score.setHorizontalAlignment(SwingConstants.CENTER);
            Score.setOpaque(false);
            Score.setForeground(new Color(230, 244, 251));
            Score.setBorder(BorderFactory.createLineBorder(new Color(113, 192, 250),3));

            questionText.setBounds(200,35,620,170);
            questionText.setForeground(new Color(230, 244, 251));
            questionText.setFont(new java.awt.Font("Tunga", 0, 15));
            questionText.setWrapStyleWord(true);
            questionText.setLineWrap(true);
            questionText.setEditable(false);
            questionText.setOpaque(false);
            questionText.setBorder(BorderFactory.createLineBorder(new Color(113, 192, 250),2));

            answer_A.setBounds(245,215,575,60);
            answer_A.setFont(new java.awt.Font("Tunga", 0, 14));
            answer_A.setForeground(new Color(230, 244, 251));
            answer_A.setWrapStyleWord(true);
            answer_A.setLineWrap(true);
            answer_A.setEditable(false);
            answer_A.setOpaque(false);
            answer_A.setBorder(BorderFactory.createLineBorder(new Color(113, 192, 250),2));

            answer_B.setBounds(245,285,575,60);
            answer_B.setFont(new java.awt.Font("Tunga", 0, 14));
            answer_B.setForeground(new Color(230, 244, 251));
            answer_B.setWrapStyleWord(true);
            answer_B.setLineWrap(true);
            answer_B.setEditable(false);
            answer_B.setOpaque(false);
            answer_B.setBorder(BorderFactory.createLineBorder(new Color(113, 192, 250),2));

            answer_C.setBounds(245,360,575,60);
            answer_C.setFont(new java.awt.Font("Tunga", 0, 14));
            answer_C.setForeground(new Color(230, 244, 251));
            answer_C.setWrapStyleWord(true);
            answer_C.setLineWrap(true);
            answer_C.setEditable(false);
            answer_C.setOpaque(false);
            answer_C.setBorder(BorderFactory.createLineBorder(new Color(113, 192, 250),2));

            answer_D.setBounds(245,435,575,60);
            answer_D.setFont(new java.awt.Font("Tunga", 0, 14));
            answer_D.setForeground(new Color(230, 244, 251));
            answer_D.setWrapStyleWord(true);
            answer_D.setLineWrap(true);
            answer_D.setEditable(false);
            answer_D.setOpaque(false);
            answer_D.setBorder(BorderFactory.createLineBorder(new Color(113, 192, 250),2));

            rButtonA.setBounds(200,215,40,40);
            rButtonA.setFont(new java.awt.Font("Tunga", 0, 12));
            rButtonA.setForeground(new Color(230, 244, 251));
            rButtonA.setFocusable(false);
            rButtonA.setOpaque(false);
            rButtonA.addActionListener(this);
            rButtonA.setText("A.");

            rButtonB.setBounds(200,285,40,40);
            rButtonB.setFont(new java.awt.Font("Tunga", 0, 12));
            rButtonB.setForeground(new Color(230, 244, 251));
            rButtonB.setFocusable(false);
            rButtonB.setOpaque(false);
            rButtonB.addActionListener(this);
            rButtonB.setText("B.");

            rButtonC.setBounds(200,360,40,40);
            rButtonC.setFont(new java.awt.Font("Tunga", 0, 12));
            rButtonC.setForeground(new Color(230, 244, 251));
            rButtonC.setFocusable(false);
            rButtonC.setOpaque(false);
            rButtonC.addActionListener(this);
            rButtonC.setText("C.");

            rButtonD.setBounds(200,435,40,40);
            rButtonD.setFont(new java.awt.Font("Tunga", 0, 12));
            rButtonD.setForeground(new Color(230, 244, 251));
            rButtonD.setFocusable(false);
            rButtonD.setOpaque(false);
            rButtonD.addActionListener(this);
            rButtonD.setText("D.");

            group.add(rButtonA);
            group.add(rButtonB);
            group.add(rButtonC);
            group.add(rButtonD);

            this.setTitle("Let OS Play");
            this.setSize(SCREEN_WIDTH,SCREEN_HEIGHT);
            this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
            this.setLayout(null);
            this.setResizable(false);
            this.setIconImage(titleIcon.getImage());
            this.getContentPane().setBackground(new Color(3,10,33));
            this.setLocationRelativeTo(null);
            this.setVisible(true);

            this.getContentPane().add(Peek);
            this.getContentPane().add(Skip);
            this.getContentPane().add(Reveal);
            this.getContentPane().add(Next);
            this.getContentPane().add(Back);
            this.getContentPane().add(ViewResult);
            this.getContentPane().add(Submit);
            this.getContentPane().add(Money);
            this.getContentPane().add(Position);
            this.getContentPane().add(Score);
            this.getContentPane().add(questionText);
            this.getContentPane().add(answer_A);
            this.getContentPane().add(answer_B);
            this.getContentPane().add(answer_C);
            this.getContentPane().add(answer_D);
            this.getContentPane().add(rButtonA);
            this.getContentPane().add(rButtonB);
            this.getContentPane().add(rButtonC);
            this.getContentPane().add(rButtonD);
            this.getContentPane().add(mainLogo);

            editQuestions = new TheLadder_editQuestions(this);
            getQuestions();
            Next.setEnabled(false);
        }


    public final void getQuestions() throws URISyntaxException, FileNotFoundException {
        editQuestions.getQuestion();
        question = editQuestions.question;
        id = editQuestions.question_id;
        setQuestion();
        setChoices();
    }

    public final void setQuestion(){
        countQs++;
        System.out.println("countQs: " + countQs);
        question = question.replace("\n", " ").replace("\r", " ");
        questionText.setText(question + "\n \n");
        correctAnswer = editQuestions.CorrectAnswer;
        System.out.println(question);
        System.out.println(correctAnswer);
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
        answer_A.setText(choice1);
        answer_B.setText(choice2);
        answer_C.setText(choice3);
        answer_D.setText(choice4);
    }

    /**This method shows the user if the
     * user's answer is correct or not.
     *
     */
    public void displayAnswer(){

        if(guess.equals(correctAnswer)){
            try {
                click.soundChoice(2);
            } catch (Exception ex) {
                Logger.getLogger(MainGameFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            //Adding points and diplaying it.

            //totalPoints++;
            coins = coins +10;
            score++;
            Score.setText("Score: "+ score);
            Money.setText("Coins: " + coins);
        }
        else{

            try {
                click.soundChoice(3);
            } catch (Exception ex) {
                Logger.getLogger(MainGameFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        //Changing the color of the border of the TextArea, red if it is wrong,
        //and green for the right answer.
        if(checkChoiceA == 0){
            rButtonA.setForeground(Color.red);
            answer_A.setBorder(javax.swing.BorderFactory.createLineBorder(Color.red));
        }
        else{
            rButtonA.setForeground(Color.green);
            answer_A.setBorder(javax.swing.BorderFactory.createLineBorder(Color.green));
        }
        if(checkChoiceB == 0){
            rButtonB.setForeground(Color.red);
            answer_B.setBorder(javax.swing.BorderFactory.createLineBorder(Color.red));
        }
        else{
            rButtonB.setForeground(Color.green);
            answer_B.setBorder(javax.swing.BorderFactory.createLineBorder(Color.green));
        }

        if(checkChoiceC == 0){
            rButtonC.setForeground(Color.red);
            answer_C.setBorder(javax.swing.BorderFactory.createLineBorder(Color.red));
        }
        else{
            rButtonC.setForeground(Color.green);
            answer_C.setBorder(javax.swing.BorderFactory.createLineBorder(Color.green));
        }

        if(checkChoiceD == 0){
            rButtonD.setForeground(Color.red);
            answer_D.setBorder(javax.swing.BorderFactory.createLineBorder(Color.red));
        }
        else{
            rButtonD.setForeground(Color.green);
            answer_D.setBorder(javax.swing.BorderFactory.createLineBorder(Color.green));
        }
    }

    /**It will submit the answer of the user
     * so that the game can check it.
     */
    public void submit(){
        if(guess.isEmpty()){
            JOptionPane.showMessageDialog(null, "Please submit an answer, it won't hurt.");
        }

        else{
            if (answer_A.getText().equals(correctAnswer)){
                checkChoiceA = 1;
                System.out.println("checkChoiceA: " + checkChoiceA);
            }
            else{
                checkChoiceA = 0;
                System.out.println("checkChoiceA: " + checkChoiceA);
            }

            if (answer_B.getText().equals(correctAnswer)){
                checkChoiceB = 1;
                System.out.println("checkChoiceB: " + checkChoiceB);
            }
            else{
                checkChoiceB = 0;
                System.out.println("checkChoiceB: " + checkChoiceB);
            }

            if (answer_C.getText().equals(correctAnswer)){
                checkChoiceC = 1;
                System.out.println("checkChoiceC: " + checkChoiceC);
            }
            else{
                checkChoiceC = 0;
                System.out.println("checkChoiceC: " + checkChoiceC);
            }

            if (answer_D.getText().equals(correctAnswer)){
                checkChoiceD = 1;
                System.out.println("checkChoiceD: " + checkChoiceD);
            }
            else{
                checkChoiceD = 0;
                System.out.println("checkChoiceD: " + checkChoiceD);
            }

            displayAnswer();
            rButtonA.setEnabled(false);
            rButtonB.setEnabled(false);
            rButtonC.setEnabled(false);
            rButtonD.setEnabled(false);
            Peek.setEnabled(false);
            Reveal.setEnabled(false);
            Skip.setEnabled(false);
            Next.setEnabled(true);
            ViewResult.setEnabled(true);
            Submit.setEnabled(false);
        }
    }

    public void next() throws FileNotFoundException, URISyntaxException {
        try {
            click.soundChoice(4);
        } catch (Exception ex) {
            Logger.getLogger(TheLadder_Quiz.class.getName()).log(Level.SEVERE, null, ex);
        }
        getQuestions();
        buttonClicksA = 0;
        buttonClicksB = 0;
        buttonClicksC = 0;
        buttonClicksD = 0;

        /*
        if(questionCount == total_questions){
            nextQ.setVisible(false);
            viewResult.setVisible(true);
        }

         */

        //Making the TextArea's border black after running the displayAnswer
        //method.
        rButtonA.setForeground(Color.black);
        answer_A.setBorder(BorderFactory.createLineBorder(new Color(113, 192, 250),2));
        rButtonB.setForeground(Color.black);
        answer_B.setBorder(BorderFactory.createLineBorder(new Color(113, 192, 250),2));
        rButtonC.setForeground(Color.black);
        answer_C.setBorder(BorderFactory.createLineBorder(new Color(113, 192, 250),2));
        rButtonD.setForeground(Color.black);
        answer_D.setBorder(BorderFactory.createLineBorder(new Color(113, 192, 250),2));

        guess = "";

        rButtonA.setEnabled(true);
        rButtonB.setEnabled(true);
        rButtonC.setEnabled(true);
        rButtonD.setEnabled(true);
        Peek.setEnabled(true);
        Reveal.setEnabled(true);
        Skip.setEnabled(true);

        group.clearSelection();
        Submit.setEnabled(true);
        Next.setEnabled(false);
        ViewResult.setEnabled(false);
    }

    public void peek(){
        String ans = correctAnswer;

        if(coins < 40){
            JOptionPane.showMessageDialog(null, "You don't have sufficient coins");
        }

        else{
            //Checking what percentage the user gets [40% - 90%]
            Random rand = new Random();
            int percentage;

            while(true){
                percentage = rand.nextInt(90);

                if(percentage >= 40){
                    break;
                }
            }
            //Checking if the user gets the correct answer or not, and display
            //it.
            int get = rand.nextInt(100);
            if(get <= percentage){
                JOptionPane.showMessageDialog(null, "The answer for this question is " + correctAnswer);
                coins = coins - 40;
                Money.setText("Money: " + coins);
            }
            else{
                //Deciding what choice to display after not getting the right answer
                //by using another random method.
                int wrong = 0;
                while(true){
                    int gett = rand.nextInt(3);

                    if(ans.equals(answer_A.getText()) && gett != 0){
                        wrong = gett;
                        break;
                    }
                    if(ans.equals(answer_B.getText()) && gett != 1){
                        wrong = gett;
                        break;
                    }
                    if(ans.equals(answer_C.getText()) && gett != 2){
                        wrong = gett;
                        break;
                    }
                    if(ans.equals(answer_D.getText()) && gett != 3){
                        wrong = gett;
                        break;
                    }
                }

                switch(wrong){
                    case 0:
                        JOptionPane.showMessageDialog(null, "The answer for this question is " + answer_A.getText());
                        coins = coins - 40;
                        Money.setText("Coins: " + coins);
                        break;
                    case 1:
                        JOptionPane.showMessageDialog(null, "The answer for this question is " + answer_B.getText());
                        coins = coins - 40;
                        Money.setText("Coins: " + coins);
                        break;
                    case 2:
                        JOptionPane.showMessageDialog(null, "The answer for this question is " + answer_C.getText());
                        coins = coins - 40;
                        Money.setText("Coins: " + coins);
                        break;
                    case 3:
                        JOptionPane.showMessageDialog(null, "The answer for this question is " + answer_D.getText());
                        coins = coins - 40;
                        Money.setText("Coins: " + coins);
                        break;
                }
            }
        }
    }
    public void skip() throws FileNotFoundException, URISyntaxException {
        getQuestions();
        if(coins < 60){
            JOptionPane.showMessageDialog(null, "You don'to have sufficient coins");
        }
        else{
            getQuestions();
            coins = coins - 60;
            Money.setText("Coins: " + coins);
        }
    }
    public void reveal(){
        if(coins < 80){
            JOptionPane.showMessageDialog(null, "You don'to have sufficient coins");
        }
        else{
            JOptionPane.showMessageDialog(null, "The answer for this question is " +correctAnswer);
            coins = coins - 80;
            Money.setText("Coins: " + coins);
        }
    }


    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == Peek) {
            click.soundChoice(4);
            peek();
        }

        if (e.getSource() == Skip) {
            try {
                click.soundChoice(4);
                skip();
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            } catch (URISyntaxException ex) {
                throw new RuntimeException(ex);
            }
        }

        if (e.getSource() == Reveal) {
            click.soundChoice(4);
            reveal();
        }

        if (e.getSource() == Next) {
            try {
                next();
                if(countQs == 30){
                    Next.setVisible(false);
                    ViewResult.setVisible(true);
                }
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            } catch (URISyntaxException ex) {
                throw new RuntimeException(ex);
            }
        }

        if (e.getSource() == ViewResult) {
            click.soundChoice(4);
            if(score > 17) {
                new TheLadder_WinFrame(score);
                this.dispose();
            }
            else{
                new TheLadder_LossFrame(score);
                this.dispose();
            }
        }

        if (e.getSource() == Back) {
            click.soundChoice(4);
            countQs = 0;
            MainGameFrame.theLadder_mainFrame.setVisible(true);
            this.dispose();
        }

        if (e.getSource() == Submit) {
            submit();
        }

        if (e.getSource() == rButtonA) {
            buttonClicksA++;
            if (buttonClicksA <= 1) {
                try {
                    click.soundChoice(4);
                } catch (Exception ex) {

                }
                guess = answer_A.getText();
                System.out.println("Guess: " + guess);
            }

            //Button Click variable is created to avoid multiple clicking of the
            //JRadioButton (Creating a bug in the sound)
            buttonClicksB = 0;
            buttonClicksC = 0;
            buttonClicksD = 0;
        }

        if (e.getSource() == rButtonB) {
            buttonClicksB++;
            if (buttonClicksB <= 1) {
                try {
                    click.soundChoice(4);
                } catch (Exception ex) {

                }
                guess = answer_B.getText();
                System.out.println("Guess: " + guess);
            }
            buttonClicksA = 0;
            buttonClicksC = 0;
            buttonClicksD = 0;
        }

        if (e.getSource() == rButtonC) {
            buttonClicksC++;
            if (buttonClicksC <= 1) {
                try {
                    click.soundChoice(4);
                } catch (Exception ex) {

                }
                guess = answer_C.getText();
                System.out.println("Guess: " + guess);
            }
            buttonClicksB = 0;
            buttonClicksA = 0;
            buttonClicksD = 0;
        }

        if (e.getSource() == rButtonD) {
            buttonClicksD++;
            if (buttonClicksD <= 1) {
                try {
                    click.soundChoice(4);
                } catch (Exception ex) {

                }
                guess = answer_D.getText();
                System.out.println("Guess: " + guess);
            }
            buttonClicksB = 0;
            buttonClicksC = 0;
            buttonClicksA = 0;
        }
    }

        /*
        @Override
        public void mouseReleased(MouseEvent e) {}
        @Override
        public void mouseEntered(MouseEvent e) {
            if(e.getSource()==Peek){
                Peek.setBorder(BorderFactory.createLineBorder(new Color(113, 192, 250),4));
                Peek.setFont(new Font("Cambria", Font.BOLD, 18));
            }

            if(e.getSource()==Skip){
                Skip.setBorder(BorderFactory.createLineBorder(new Color(113, 192, 250),4));
                Skip.setFont(new Font("Cambria", Font.BOLD, 18));
            }
            if(e.getSource()==Reveal){
                Reveal.setBorder(BorderFactory.createLineBorder(new Color(113, 192, 250),4));
                Reveal.setFont(new Font("Cambria", Font.BOLD, 18));
            }
            if(e.getSource()==Next){
                Next.setBorder(BorderFactory.createLineBorder(new Color(113, 192, 250),4));
                Next.setFont(new Font("Cambria", Font.BOLD, 18));
            }
            if(e.getSource()== Submit){
                Submit.setBorder(BorderFactory.createLineBorder(new Color(113, 192, 250),4));
                Submit.setFont(new Font("Cambria", Font.BOLD, 18));
            }
        }
        @Override
        public void mouseExited(MouseEvent e) {
            if(e.getSource()==Peek){
                Peek.setBorder(BorderFactory.createLineBorder(new Color(113, 192, 250),3));
                Peek.setFont(new Font("Cambria", Font.BOLD, 15));
            }

            if(e.getSource()==Skip){
                Skip.setBorder(BorderFactory.createLineBorder(new Color(113, 192, 250),3));
                Skip.setFont(new Font("Cambria", Font.BOLD, 15));
            }

            if(e.getSource()==Reveal){
                Reveal.setBorder(BorderFactory.createLineBorder(new Color(113, 192, 250),3));
                Reveal.setFont(new Font("Cambria", Font.BOLD, 15));
            }

            if(e.getSource()==Next){
                Next.setBorder(BorderFactory.createLineBorder(new Color(113, 192, 250),3));
                Next.setFont(new Font("Cambria", Font.BOLD, 15));
            }
            if(e.getSource()==Submit){
                Submit.setBorder(BorderFactory.createLineBorder(new Color(113, 192, 250),3));
                Submit.setFont(new Font("Cambria", Font.BOLD, 15));
            }
        }

         */
    }
