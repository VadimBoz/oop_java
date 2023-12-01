package model;

public class OperationsInteger extends  ModelOperation<Integer> {
    private Integer x;
    private Integer y;

    public OperationsInteger(Integer x, Integer y, OperationType operationType) {
        this.x = x;
        this.y = y;
        super.operationType = operationType;

    }

    @Override
    public Integer sum() {
        return x + y;
    }

    @Override
    public Integer subtraction() {
        return x - y;
    }

    @Override
    public Integer multiplication() {
        return x * y;
    }

    @Override
    public Double division() {
        if (y == 0) throw new ArithmeticException("на ноль делить нельзя");
        return (double)x / (double)y;
    }



}
