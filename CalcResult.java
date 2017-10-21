package sample;

public class CalcResult {

    public Long calculator(long number1, long number2, String operator){
        switch(operator){

            case "+":
                return number1 + number2;

            case "-":
                return number1 - number2;

            case "*":
                return number1 * number2;

                case "/":
                if (number2 == 0)
                    return 0L;
                return number1 / number2;

            default:
                return 0L;
        }


    }
}
