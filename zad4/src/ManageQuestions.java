import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ManageQuestions {

    private ArrayList<Question> listOfQuestions = new ArrayList<>();
    private Random generator;
    private Question actualQuestion;
    public ManageQuestions(){
        generator = new Random();
    }
    public void readFromFile() throws FileNotFoundException {
        File file = new File("pytania.txt");
        Scanner scanner = new Scanner(file);
        while(scanner.hasNext())
            listOfQuestions.add(new Question(scanner.nextLine()));
    }
    public void randomNewQuestion(){
        actualQuestion = listOfQuestions.get(generator.nextInt(listOfQuestions.size()));
    }
    public String getActualQuestionContents(){

        return actualQuestion.getQuestionContents();
    }
    public boolean checkActualQuestion(boolean clickedYes){
        return actualQuestion.validateAnswer(clickedYes);
    }
    public int getShowNumber(){
        return actualQuestion.getShowNumber();
    }
}
