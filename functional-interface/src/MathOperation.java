@FunctionalInterface
public interface MathOperation<A, B, C> {
    C operate(A firstNumber, B secondNumber);
}
