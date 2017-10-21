package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller {

    @FXML
    private Label result;
    private double currentResult = 0.0;
    private String operator = "+";
    Calculator calcThis = new Calculator();
    enum State {STARTED,OPERATORPRESSED,NUMBERPRESSED,EQUALPRESSED, MINUSPRESSED, MINUSNUMBERPRESSED};
    State state = State.STARTED;


    public void numberClicked(ActionEvent actionEvent) {
        String value;
        switch(state){

            case EQUALPRESSED:
               state = State.NUMBERPRESSED;
               value = ((Button)actionEvent.getSource()).getText();
               result.setText(value);
               return;

           case STARTED:
               state = State.NUMBERPRESSED;
               value = ((Button)actionEvent.getSource()).getText();
               result.setText(value);
               return;

           case OPERATORPRESSED:
               state = State.NUMBERPRESSED;
               value = ((Button)actionEvent.getSource()).getText();
               result.setText(value);
               return;

           case NUMBERPRESSED:
               state = State.NUMBERPRESSED;
               value = ((Button)actionEvent.getSource()).getText();
               result.setText(result.getText() + value);
               return;

                case MINUSPRESSED:
                    state = State.MINUSNUMBERPRESSED;
                    value = ((Button)actionEvent.getSource()).getText();
                    result.setText("-" + value);
                break;

                case MINUSNUMBERPRESSED:
                    state = State.NUMBERPRESSED;
                    value = ((Button)actionEvent.getSource()).getText();
                    result.setText(result.getText() + value);
                    break;
        }
    }

    public void operatorClicked(ActionEvent actionEvent) {
        String value = ((Button)actionEvent.getSource()).getText();
        Double newResult;
        Double output;
        switch (state) {

            case STARTED:
                if(value.equals("-")){
                    state = State.MINUSPRESSED;
                }
                break;

            case OPERATORPRESSED:
                if(operator.equals("=")){
                    operator = value;}
                break;

            case NUMBERPRESSED:
                newResult = Double.parseDouble(result.getText());
                output =  calcThis.calculate(currentResult, newResult, operator );
                result.setText(String.valueOf(output));
                operator = value;
                state = State.OPERATORPRESSED;
                currentResult = output;
                break;

            case EQUALPRESSED:
                state = State.OPERATORPRESSED;
                operator = value;
                break;

            case MINUSPRESSED:
                state = State.OPERATORPRESSED;
                operator = value;
                break;

            case MINUSNUMBERPRESSED:
                newResult = Double.parseDouble(result.getText());
                output =  calcThis.calculate(currentResult, newResult, operator );
                result.setText(String.valueOf(output));
                operator = value;
                state = State.OPERATORPRESSED;
                currentResult = output;
                break;
        }
    }

    public void cleanClicked(ActionEvent actionEvent) {
        state = State.STARTED;
        result.setText("");
        operator = "+";
        currentResult = 0.0;
    }

    public void removeClicked(ActionEvent actionEvent) {

    }
}

