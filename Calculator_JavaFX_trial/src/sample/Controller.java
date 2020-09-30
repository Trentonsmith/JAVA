package sample;


import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;

public class Controller {
    @FXML
    private TextField firstNum;
    @FXML
    private TextField secondNum;
    @FXML
    private RadioButton add;
    @FXML
    private RadioButton subtract;
    @FXML
    private RadioButton multiply;
    @FXML
    private RadioButton divide;
    @FXML
    private Button compute;
    @FXML
    private Label theAnswer;

    public void computeListener(){
       double first = Double.parseDouble(firstNum.getText());
        double second = Double.parseDouble(secondNum.getText());


        if(add.isSelected()){
            String theAnswerNum = String.valueOf(first+second);
        theAnswer.setText(theAnswerNum);
        }
        if(subtract.isSelected()){
            String theAnswerNum = String.valueOf(first-second);
            theAnswer.setText(theAnswerNum);
        }
        if(multiply.isSelected()){
            String theAnswerNum = String.valueOf(first*second);
            theAnswer.setText(theAnswerNum);
        }
        if(divide.isSelected()){
            String theAnswerNum = String.valueOf(first/second);
            theAnswer.setText(theAnswerNum);
        }
    }





}
