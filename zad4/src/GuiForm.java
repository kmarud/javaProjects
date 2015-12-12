import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

public class GuiForm extends JFrame{
    private JButton YesButton;
    private JPanel panel1;
    private JButton NoButton;
    private JTextArea QuestionContents;
    private JButton NextButton;
    private JProgressBar CorrectBar;
    private JTextField CorrectAnswerCount;
    private JTextField CorrectAnswePercent;
    private int validCount=0,invalidCount=0;
    ManageQuestions manager = new ManageQuestions();

    GuiForm() {
        super("Program do nauki");
        setContentPane(panel1);
        pack();
        setSize(600,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        try {
            manager.readFromFile();
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(GuiForm.this, "Brak pliku pytania.txt !");
            System.exit(0);
        }
        manager.randomNewQuestion();
        QuestionContents.setText(manager.getActualQuestionContents());
        YesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(manager.checkActualQuestion(true)) {
                    YesButton.setBackground(Color.GREEN);
                    validCount++;
                } else{
                    YesButton.setBackground(Color.RED);
                    invalidCount++;
                }
                    lockButtons();
            }
        });
        NoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(manager.checkActualQuestion(false)) {
                    NoButton.setBackground(Color.GREEN);
                    validCount++;
                } else{
                    NoButton.setBackground(Color.RED);
                    invalidCount++;
                }
                lockButtons();
            }
        });
        NextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                YesButton.setBackground(Color.LIGHT_GRAY);
                NoButton.setBackground(Color.LIGHT_GRAY);
                manager.randomNewQuestion();
                QuestionContents.setText(manager.getActualQuestionContents());
                YesButton.setEnabled(true);
                NoButton.setEnabled(true);
            }
        });
    }

    void lockButtons(){
        YesButton.setEnabled(false);
        NoButton.setEnabled(false);
        CorrectBar.setBackground(Color.RED);
        CorrectBar.setForeground(Color.GREEN);
        CorrectAnswerCount.setText(Integer.toString(validCount));
        int p = (validCount * 100) / (validCount + invalidCount);
        CorrectBar.setValue(p);
        CorrectAnswePercent.setText(Integer.toString(p));
    }
}
