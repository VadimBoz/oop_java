package model;

public abstract class ModelOperation<E extends Number> {
    OperationType operationType;
    abstract E sum();
    abstract E subtraction();
    abstract E multiplication();
    abstract Double division();
//    String calc();

    public String calc() {
        if (operationType == OperationType.sum)
            return sum().toString();
        else if (operationType == OperationType.subtraction)
            return subtraction().toString();
        else if (operationType == OperationType.division ||
                operationType == OperationType.division2 )
            return division().toString();
        else if (operationType == OperationType.multiplication)
            return multiplication().toString();
        else return "0";
    }

}
