package view;

public interface IView {
    void printOnConsoleStartMenu();
    void printError(String str);
    void printResult();
    void setRes(String res);
    String getExpressionFromUser();
    void printNext();

}
