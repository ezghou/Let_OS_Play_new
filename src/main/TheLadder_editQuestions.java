package main;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Random;

    public class TheLadder_editQuestions {
        TheLadder_Quiz questionFrame;
        OSnakes_readQuestions readQuestions = new OSnakes_readQuestions();
        ArrayList<String> questions = readQuestions.getQuestions();
        ArrayList<String> choice1 = readQuestions.getChoice1();
        ArrayList<String> choice2 = readQuestions.getChoice2();
        ArrayList<String> choice3 = readQuestions.getChoice3();
        ArrayList<String> choice4 = readQuestions.getChoice4();
        ArrayList<String> correctAnswer = readQuestions.getCorrectAnswer();
        ArrayList<String> askedQuestions = new ArrayList<>();
        public static ArrayList<String> DoneQuestions = new ArrayList<>();

        Random random;
        public int question_id;
        public int choice_id;
        int questionSize;
        public static int generatedQs;
        public String question;
        public String CorrectAnswer;
        public String firstChoice;
        public String secondChoice;
        public String thirdChoice;
        public String fourthChoice;

        public TheLadder_editQuestions(TheLadder_Quiz questionFrame) {
            this.questionFrame = questionFrame;
            random = new Random();
            questionSize = questions.size()-1;
            generatedQs = 0;
        }

        /**
         * Set question to be displayed in quiz frame
         * @throws URISyntaxException
         * @throws FileNotFoundException
         */

        public final void getQuestion() throws URISyntaxException, FileNotFoundException {
            if(questions.isEmpty()){
                JOptionPane.showMessageDialog(null, "THERE ARE NO Questions TO ASK.");
                new TheLadder_Quiz();
                questionFrame.dispose();
            }
            else{
                if(DoneQuestions.size() == 70){
                    JOptionPane.showMessageDialog(null, "ALL QUESTIONS HAVE ALREADY BEEN ASKED");
                    new TheLadder_Quiz();
                    questionFrame.dispose();
                }
                else{
                    if(generatedQs == 0){
                        generatedQs++;
                        question_id = random.nextInt(questionSize);
                        choice_id = question_id;
                        question = questions.get(choice_id);
                        askedQuestions.add(question);
                    } else{
                        while(askedQuestions.size()>0){
                            question_id = random.nextInt(questionSize);
                            choice_id = question_id;
                            question = questions.get(choice_id);
                            if(askedQuestions.contains(question)){
                                DoneQuestions.add(question);
                                askedQuestions.remove(question);
                            }else{
                                break;
                            }
                        }
                    }
                    CorrectAnswer = correctAnswer.get(choice_id);
                    getChoices();
                    if(DoneQuestions.contains(question)){
                        JOptionPane.showMessageDialog(null, "REPEATED QUESTION");
                    }
                }
            }
        }

        /**
         * Set choices from the questions set in getQuestions()
         */
        public void getChoices(){
            firstChoice = choice1.get(choice_id);
            secondChoice = choice2.get(choice_id);
            thirdChoice = choice3.get(choice_id);
            fourthChoice = choice4.get(choice_id);
        }
    }
