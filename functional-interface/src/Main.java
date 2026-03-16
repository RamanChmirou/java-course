public class Main {
    public static void main(String[] args) {
        Integer a1 = 12;
        Integer b1 = 3;
        Integer zero = 0;

        Main.calculateAndPrintResult(a1, b1, OperationType.ADD);
        Main.calculateAndPrintResult(a1, a1, OperationType.MULTIPLY);
        Main.calculateAndPrintResult(zero, b1, OperationType.SUBSTRUCT);
        Main.calculateAndPrintResult(a1, zero, OperationType.DIVIDE);
    }

    public static <A, B, C> void calculateAndPrintResult(A a, B b, MathOperation<A, B, C> mathOperation) {
        try {
            System.out.printf("Operacja na liczbach %s i %s daje wynik %s\n", a, b, mathOperation.operate(a, b));
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }
}
