package model;

public enum OperationType {
    sum(".+\\+.+", "\\+"),
    multiplication(".+\\*.+", "\\*"),
    division(".+/.+", "/"),
    division2(".+:.+", ":"),
    subtraction(".+\\-.+", "-"); // должен быть последним

    private String operator;
    private String operatorRegex;

    OperationType(String operatorRegex, String operator) {
        this.operator = operator;
        this.operatorRegex = operatorRegex;
    }

    public String getOperatorRegex() {
        return operatorRegex;
    }
    public String getOperator() {
        return operator;
    }

}
