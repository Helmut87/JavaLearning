public class PairSampleUse {
    public static void main(String[] args) {
        Pair<Integer, String> pair = Pair.of(1, "hello");
        Pair<Integer, String> pair2 = Pair.of(1, "hello");

        boolean mustBeTrue = pair.equals(pair2);
        boolean mustAlsoBeTrue = pair.hashCode() == pair2.hashCode();

        System.out.println(mustBeTrue);
        System.out.println(mustAlsoBeTrue);
    }
}
