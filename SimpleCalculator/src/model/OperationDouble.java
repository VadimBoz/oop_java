package model;

public class OperationDouble extends ModelOperation<Double> {
    private Double x;
    private Double y;

    public OperationDouble(Double x, Double y, OperationType operationType) {
        this.x = x;
        this.y = y;
        super.operationType = operationType;
    }


    @Override
    public Double sum() {
        return x + y;
    }

    @Override
    public Double subtraction() {
        return x - y;
    }

    @Override
    public Double multiplication() {
        return x * y;
    }

    @Override
    public Double division() {
        if (y == 0) throw new ArithmeticException("на ноль делить нельзя");
        return x / y;
    }


}
