package model;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ExpessionCalc {


    private String expression;
    String res;

    public ExpessionCalc(String expression)  {

        if (expression.matches(".*[a-zA-Zzа-яА-Я%&{}@!$?<>\\\\].*") ||
                expression.matches(".*[a-zA-Zzа-яА-Я%&{}@!$?<>\\\\].*"))
            throw new IllegalArgumentException("недопустимые символы в выражении");
        this.expression = expression.replace(" ", "");
    }

    public String CalculateException() {
        int firstSign = 1;
        int secondSign = 1;

        if (expression.startsWith("-")) {
            expression = expression.replaceFirst("-", "");
            firstSign = -1;
        }

        if (expression.matches(".+[*/:-]-+.+")) {
            secondSign = -1;
            expression = expression.replace("-", "");
        }


        OperationType operatorType = null;
        for (OperationType item : OperationType.values()) {
            if (expression.matches(item.getOperatorRegex())) {
                operatorType = item;
                break;
            }
        }


        if (operatorType == null)
            throw new IllegalArgumentException("недопустимый оператор в выражении");

        String[] arguments = expression.split(operatorType.getOperator());
        if (arguments.length != 2) throw new IllegalArgumentException("неверное выражение");

        if (arguments[0].matches(".+\\..+") || arguments[0].matches(".+,+.+") ||
                arguments[1].matches(".+\\..+") || arguments[1].matches(".+,+.+")) {
            Double x = Double.parseDouble(arguments[0]) * firstSign;
            Double y = Double.parseDouble(arguments[1]) * secondSign;
            res = new OperationDouble(x, y, operatorType).calc();
        } else if ((arguments[0].matches("\\d+") &&
                arguments[0].length() < 19 && arguments[0].length() > 9) ||
                (arguments[1].matches("\\d+")
                        && arguments[1].length() < 19 && arguments[1].length() > 9)) {
            Long x = Long.parseLong(arguments[0]) * firstSign;
            Long y = Long.parseLong(arguments[1]) * secondSign;
            res = new OperationLong(x, y, operatorType).calc();
        } else if ((arguments[0].matches("\\d+") && arguments[0].length() < 10 &&
                arguments[1].length() < 10) ) {
            Integer x = Integer.parseInt(arguments[0]) * firstSign;
            Integer y = Integer.parseInt(arguments[1]) * secondSign;
            res = new OperationsInteger(x, y, operatorType).calc();
        } else if (arguments[0].length() >= 19 || arguments[1].length() >= 19)
            throw new IllegalArgumentException("very long number");
        else throw new IllegalArgumentException("формат чисел нераспознан");
        return res;
    }
}
