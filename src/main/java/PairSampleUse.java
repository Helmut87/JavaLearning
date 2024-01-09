public class PairSampleUse {
    public static void main(String[] args) {
        Pair<Integer, String> idAndMessage = Pair.of(1, "hello");
        Pair<Integer, String> idAndAnotherMessage = Pair.of(1, "hello");

        boolean mustBeTrue = idAndMessage.equals(idAndAnotherMessage);
        boolean mustAlsoBeTrue = idAndMessage.hashCode() == idAndAnotherMessage.hashCode();

        System.out.println(mustBeTrue);
        System.out.println(mustAlsoBeTrue);
    }
}
