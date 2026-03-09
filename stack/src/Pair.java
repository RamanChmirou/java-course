import java.util.Objects;

public record Pair<K, V>(K key, V value) {
    public  Pair {
        Objects.requireNonNull(key);
    }
}
