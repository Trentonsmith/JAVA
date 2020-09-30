package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {
    // @FXML creates association between this nameField and the sample.fxml nameField
    @FXML
    private TextField nameField;
    @FXML
    private Button helloButton;
    @FXML
    private Button byeButton;
    @FXML
    private CheckBox ourCheckBox;
    @FXML
    private Label ourLabel;
    @FXML
    public void initialize(){
        helloButton.setDisable(true);
        byeButton.setDisable(true);
    }

    @FXML
//    ActionEvent gets the actual button that was pressed so if multiple buttons have
//    this method the method can determine which button used it
        public void onButtonClicked(ActionEvent e){
        if(e.getSource().equals(helloButton)) {
            System.out.println("Hello, " + nameField.getText());
        }
        else if(e.getSource().equals(byeButton)){
            System.out.println("Bye, " + nameField.getText());
        }
        System.out.println("The following button was pressed" + e.getSource());
        // creates another background process (thread) thats not the UI process to do the task then it will let the UI thread know
        Runnable task = new Runnable() {
            @Override
            public void run() {
                try{
                    String s = Platform.isFxApplicationThread() ? "UI Thread" : "Background Thread";
                    System.out.println("I'm going to sleep on the " + s);
                    Thread.sleep(10000);
                    // we can't update the UI threads nodes(the label in this case) from here
                    // because then this thread could change something without the UI thread knowing what changed
                    //ourLabel.setText("We did something"); throws exception
                    // this tells the computer to run this Runnable on the UI thread once everything else is done
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            String s = Platform.isFxApplicationThread() ? "UI Thread" : "Background Thread";
                            System.out.println("I'm updating the label on the " + s);
                            ourLabel.setText("We did something");
                        }
                    });
                }catch (InterruptedException event){
                    // we don't care about this
                }
            }
        };
        // starts our runnable called "task"
        new Thread(task).start();


        if(ourCheckBox.isSelected()){
            nameField.clear();
            byeButton.setDisable(true);
            helloButton.setDisable(true);
        }
        }
        @FXML
        public void handleKeyReleased(){
        String text = nameField.getText();
        // checks if either one is true, if either one is true disableButtons becomes true
            // .trim() ignores white space(spaces)
        boolean disableButtons = text.isEmpty() || text.trim().isEmpty();
        helloButton.setDisable(disableButtons);
        byeButton.setDisable(disableButtons);
        }

        public void handleChange(){
            System.out.println("The checkbox is" + (ourCheckBox.isSelected() ? "checked": "unchecked"));
        }

}
