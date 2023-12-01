package view;

import java.util.Scanner;

public class View implements IView{

     private String expression;
     private String res;
     private String command;
     Scanner scanner = new Scanner(System.in);

     public void printOnConsoleStartMenu() {
          System.out.println();
          System.out.println("-----------------------Simple Calculator------------------------");
          System.out.println();
          System.out.println("Enter an expression like a + b. Acceptable operations: '+', '-', '*', '/', ':'.");
          System.out.print("> ");
          System.out.println();
     }

     public  String getExpressionFromUser() {
          this.expression = scanner.nextLine();
          return expression;
     }


     public void setRes(String res) {
          this.res = res;
     }


     public void printError(String str) {
          System.out.println(str);
     }

     public void printResult() {
          System.out.printf("Результат расчета выражения %s  =  %s \n", expression, res);
          System.out.println("Введите слeдующее выражение или exit  для выхода");
          System.out.print("> ");
     }

     public void printNext() {
          System.out.println("Введите слeдующее выражение или exit  для выхода");
          System.out.print("> ");
     }

}
