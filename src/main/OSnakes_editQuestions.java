package main;
import java.util.ArrayList;
import java.util.Random;

public class OSnakes_editQuestions {
    OSnakes_readQuestions readQuestions;
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

    public OSnakes_editQuestions(){
        readQuestions = new OSnakes_readQuestions();
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
        System.out.println("size: "+doneQuestions.size());
    }

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
}
