import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiForm extends JFrame{
    private JButton YesButton;
    private JPanel panel1;
    private JButton NoButton;
    private JTextArea QuestionContents;
    private JButton DalejButton;
    private JProgressBar CorrectBar;
    private JTextField CorrectAnswerCount;
    private JTextField CorrectAnswePercent;

    GuiForm() {
        super("Program do nauki");
        setContentPane(panel1);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);



        YesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        NoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        DalejButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
    }
}
