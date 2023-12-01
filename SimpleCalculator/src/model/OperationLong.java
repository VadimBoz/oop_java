package model;

public class OperationLong extends ModelOperation<Long> {

    private Long x;
    private Long y;

    public OperationLong(Long x, Long y, OperationType operationType) {
        this.x = x;
        this.y = y;
        super.operationType = operationType;
    }

    @Override
    public Long sum() {
        return x + y;
    }

    @Override
    public Long subtraction() {
        return x - y;
    }

    @Override
    public Long multiplication() {
        return x * y;
    }

    @Override
    public Double division() {
        if (y == 0) throw new ArithmeticException("на ноль делить нельзя");
        return (double)x / (double)y ;
    }


}
