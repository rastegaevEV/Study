public class Util {
    public static <K, V> boolean compare(Pair<K, V> first, Pair<K, V> second) {
        return first.getFirst().equals(second.getFirst()) && first.getSecond().equals(second.getSecond());
    }
}
