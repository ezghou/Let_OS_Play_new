import javax.swing.*;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Random;

public class OSnakes_editQuestions {
    OSnakes_questionFrame questionFrame;
    OSnakes_readQuestions readQuestions = new OSnakes_readQuestions();

    ArrayList<String> questions = readQuestions.questions();
    ArrayList<String> choice1 = readQuestions.choice1();
    ArrayList<String> choice2 = readQuestions.choice2();
    ArrayList<String> choice3 = readQuestions.choice3();
    ArrayList<String> choice4 = readQuestions.choice4();
    ArrayList<String> correctAnswer = readQuestions.correctAnswer();
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

    public OSnakes_editQuestions(OSnakes_questionFrame questionFrame) {
        this.questionFrame = questionFrame;
        random = new Random();
        questionSize = questions.size()-1;
        generatedQs = 0;
    }

    public final void getQuestion() throws URISyntaxException, FileNotFoundException {
        if(questions.isEmpty()){
            JOptionPane.showMessageDialog(null, "There are NO Questions to Ask");
            new OSnakes_questionFrame();
            questionFrame.dispose();
        }
        else{
            if(DoneQuestions.size() == 70){
                JOptionPane.showMessageDialog(null, "ALL QUESTIONS HAVE ALREADY BEEN ASKED");
                new OSnakes_questionFrame();
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
    public void getChoices(){
        firstChoice = choice1.get(choice_id);
        secondChoice = choice2.get(choice_id);
        thirdChoice = choice3.get(choice_id);
        fourthChoice = choice4.get(choice_id);
    }
}
