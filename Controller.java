package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller {

    @FXML
    private Label result;
    private String operator = "";
    private double number1 = 0;
    private boolean start = true;
    CalcResult calc = new CalcResult();
    Calculator calcThis = new Calculator();

    public void numberClicked(ActionEvent actionEvent) {
       if(start){
           result.setText("");
           start = false;
       }
        String value = ((Button)actionEvent.getSource()).getText();
        result.setText(result.getText()+ value);
    }

    public void operatorClicked(ActionEvent actionEvent) {
        String value = ((Button)actionEvent.getSource()).getText();
        // as long as "=" is not pressed, the number will increase
        if (!value.equals("=")){
            if(!operator.isEmpty())
                return;
            operator = value;
            number1 = Double.parseDouble(result.getText());
            result.setText("");
        }else{
            if(operator.isEmpty())
                return;
            double number2 = Double.parseDouble(result.getText());
            double output = calcThis.calculate(number1, number2, operator);
            result.setText(String.valueOf(output));
            start = false;
        }
    }

    public void cleanClicked(ActionEvent actionEvent) {
        start = true;
        result.setText("");
        operator = "";
    }

}

