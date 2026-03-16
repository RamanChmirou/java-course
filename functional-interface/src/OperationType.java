public enum OperationType implements MathOperation<Integer, Integer, Integer> {
    ADD(Integer::sum),
    SUBSTRUCT((a, b) -> a - b),
    MULTIPLY((a, b) -> a * b),
    DIVIDE((a, b) -> {
        if (b == 0) {
            throw new ArithmeticException("Nie można dzielić przez zero.");
        }
        return a / b;
    });

    private final MathOperation<Integer, Integer, Integer> mathOperation;

    OperationType(MathOperation<Integer, Integer, Integer> mathOperation) {
        this.mathOperation = mathOperation;
    }

    @Override
    public Integer operate(Integer a, Integer b) {
        return mathOperation.operate(a, b);
    }
}
