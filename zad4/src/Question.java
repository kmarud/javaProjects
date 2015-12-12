public class Question{
    //private int id;
    // private static int questionCount = 0;
    private String questionContents;
    private boolean answer;
    private int showNumber;
    public Question(String input){
        //id = questionCount++;

        String[] temp = input.split(",");
        questionContents = temp[0];
        answer=((temp[1].indexOf("TAK") != -1)? true : false);
        //or  answer=(temp[1].equals("TAK"))? true : false);
    }
    public String getQuestionContents() {
        showNumber++;
        return questionContents;
    }
    public boolean validateAnswer(boolean clickedYes){
        if(clickedYes&&answer || !clickedYes&&!answer)
            return true;
        return false;
    }
    public int getShowNumber(){return showNumber;}
}
