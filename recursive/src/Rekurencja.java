import java.util.HashMap;
import java.util.Map;

public class Rekurencja {
    private static Map<Integer, Long> mapOfValues = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(fibonachiRow(6));
    }

    public static long fibonachiRow(int n) {
        if (n == 0 || n == 1) return n;
        if (mapOfValues.containsKey(n)) {
            return mapOfValues.get(n);
        }
        long result = fibonachiRow(n - 1) + fibonachiRow(n - 2);
        mapOfValues.put(n, result);
        return result;
    }
}
