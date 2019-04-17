public class Main {
    public static void main(String[] args) {
        Pair<String, Integer> pair1 = new Pair<>("строка", 3);
        Pair<String, Integer> pair2 = new Pair<>("строка", 3);

        System.out.println(Util.compare(pair1, pair2));
    }
}
