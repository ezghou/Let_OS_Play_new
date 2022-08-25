/**
 * Gets a random and unique question from
 * the fetched questions data.
 *
 * @author  EG Renz Go
 * @author  Thereze Nuelle Roca
 * @author  Erica Talahiban
 * @version 1.0
 */

package main;

import java.util.ArrayList;
import java.util.Random;
@SuppressWarnings("ALL")
public class Lockdown_editQuestions {
    ReadQuestions readQuestions;
    ArrayList<String> questions;
    ArrayList<String> choice1;
    ArrayList<String> choice2;
    ArrayList<String> choice3;
    ArrayList<String> choice4;
    ArrayList<String> correctAnswer;
    ArrayList<Integer> doneQuestions = new ArrayList<>();

    Random random;
    public int question_id;
    ArrayList<Integer> id;
    int questionSize;
    String currentQuestion;
    String answer;
    String[] choices = new String[4];
//    ReadQuestions readQuestions = new ReadQuestions();
//    ArrayList<String> questions = readQuestions.getQuestions();
//    ArrayList<String> choice1 = readQuestions.getChoice1();
//    ArrayList<String> choice2 = readQuestions.getChoice2();
//    ArrayList<String> choice3 = readQuestions.getChoice3();
//    ArrayList<String> choice4 = readQuestions.getChoice4();
//    ArrayList<String> correctAnswer = readQuestions.getCorrectAnswer();
//    ArrayList<String> askedQuestions = new ArrayList<>();
//
//    Random random;
//    public int question_id;
//    public int choice_id;
//    int questionSize;
//    public static int generatedQs;
//    public String question;
//    public String CorrectAnswer;
//    public String firstChoice;
//    public String secondChoice;
//    public String thirdChoice;
//    public String fourthChoice;

    public Lockdown_editQuestions(){
        readQuestions = new ReadQuestions();
        id = readQuestions.getID();
        questions = readQuestions.getQuestions();
        choice1 = readQuestions.getChoice1();
        choice2 = readQuestions.getChoice2();
        choice3 = readQuestions.getChoice3();
        choice4 = readQuestions.getChoice4();
        correctAnswer = readQuestions.getCorrectAnswer();
        random = new Random();
        questionSize = questions.size()-1;
        setRandomID();
    }

    /**
     * Generate random and unique question id.
     * Add each unique question id to doneQuestions arrayList
     */
    public void setRandomID(){
        question_id = random.nextInt(questionSize);
        if(doneQuestions.size()<=0){
            doneQuestions.add(question_id);
            setQuestion(question_id);
        }
        else if(doneQuestions.contains(question_id)){
            do{
                question_id = random.nextInt(questionSize);
            }
            while(doneQuestions.contains(question_id));
            doneQuestions.add(question_id);
            setQuestion(question_id);
        }
        else{
            doneQuestions.add(question_id);
            setQuestion(question_id);
        }
    }
    /**
     * Set the chosen question and its respective data
     * to be displayed in the question frame
     */
    public void setQuestion(int question_id){
        currentQuestion = questions.get(question_id);
        setChoices(question_id);
        setCorrectAnswer(question_id);
    }

    public void setCorrectAnswer(int question_id){
        this.answer = correctAnswer.get(question_id);
    }

    public void setChoices(int question_id){
        ArrayList<String> choiceList = new ArrayList<>();
        choiceList.add(choice1.get(question_id));
        choiceList.add(choice2.get(question_id));
        choiceList.add(choice3.get(question_id));
        choiceList.add(choice4.get(question_id));
        int i = 0;
        int index;

        for(int size = choiceList.size(); size > 0; size--){
            index = random.nextInt(size);
            choices[i] = choiceList.get(index);
            choiceList.remove(index);
            i++;
        }
    }

    public String getQuestion(){
        return currentQuestion;
    }
    public String[] getChoices(){
        return choices;
    }
    public String getCorrectAnswer(){
        return answer;
    }

//    public Lockdown_editQuestions() {
//        random = new Random();
//        questionSize = questions.size()-1;
//        generatedQs = 0;
//    }
//
//    public final void getQuestion(){
//        question_id = random.nextInt(questionSize);
//        choice_id = question_id;
//        question = questions.get(choice_id);
//        askedQuestions.add(question);
//
//        CorrectAnswer = correctAnswer.get(choice_id);
//        getChoices();
//    }
//    public void getChoices(){
//        firstChoice = choice1.get(choice_id);
//        secondChoice = choice2.get(choice_id);
//        thirdChoice = choice3.get(choice_id);
//        fourthChoice = choice4.get(choice_id);
//    }
}
