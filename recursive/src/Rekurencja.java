import java.util.HashMap;
import java.util.Map;

public class Rekurencja {
    private static Map<Integer, Long> fibonacciValues = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(getFibonacci(47));
    }

    public static long getFibonacci(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        if (fibonacciValues.containsKey(n)) {
            return fibonacciValues.get(n);
        }
        long result = getFibonacci(n - 1) + getFibonacci(n - 2);
        fibonacciValues.put(n, result);
        return result;
    }
}
