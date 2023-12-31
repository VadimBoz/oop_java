package controller;

import model.ExpessionCalc;
import model.IExpressionCalc;
import view.IView;
import view.View;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Controller implements IController {

    private static Logger logger;

    static {
        try  {
            FileHandler fileHandler = new FileHandler("calculator.log");
            logger = Logger.getLogger("/controller/Controller");
            logger.addHandler(fileHandler);
            logger.setLevel(Level.ALL);
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    String expression;
    private final IView view = new View();


    public void startProg() {
        logger.info("Start Program");
        view.printOnConsoleStartMenu();
        int count = 0;
        while (true) {
            expression = view.getExpressionFromUser();
            logger.info("Пользователь ввел выражение:  " + expression);

            if (expression.equals("exit")) {
                logger.info("Программа завершена пользователем");
                break;
            }
            try {
                IExpressionCalc expressionCalc = new ExpessionCalc(expression);
                String res = expressionCalc.CalculateExpession();
                view.setRes(res);
                logger.info("результат выражения:  " + res);
                view.printResult();
            } catch (IllegalArgumentException e) {
                view.printError(e.getMessage());
                logger.log(Level.WARNING, e.getMessage());
                view.printNext();
            } catch (RuntimeException r) {
                view.printError("Неизвестная ошибка");
                logger.log(Level.WARNING, "Неизвестная ошибка");
                view.printNext();
            }
        }
    }

}
