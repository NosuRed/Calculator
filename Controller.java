package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller {

    @FXML
    private Label result;
    private String operator = "";
    private long number1 = 0;

    CalcResult calc = new CalcResult();
    private boolean start = true;

    public void numberClicked(ActionEvent actionEvent) {
       if(start){
           result.setText("");
           start = false;
       }
        String value = ((Button)actionEvent.getSource()).getText();
        result.setText(result.getText()+ value);
    }

    public void operatorCllicked(ActionEvent actionEvent) {
        String value = ((Button)actionEvent.getSource()).getText();
        // as long as "=" is not pressed, the number will increase
        if (!value.equals("=")){
            if(!operator.isEmpty())
                return;
            operator = value;
            number1 = Long.parseLong(result.getText());
            result.setText("");
        }else{
            if(operator.isEmpty())
                return;
            long number2 = Long.parseLong(result.getText());
            float output = calc.calculator(number1, number2, operator);
            result.setText(String.valueOf(output));
            start = false;
        }


    }




    public void cleanClicked(ActionEvent actionEvent) {
        start = true;

    }

}

