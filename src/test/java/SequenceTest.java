import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SequenceTest {
    @Test
    public void testFilterWithEmptyIntegerArray() {
        Integer[] emptyArray = new Integer[0];
        Integer[] result = Sequence.filter(emptyArray, number -> number % 2 == 0);
        assertArrayEquals(new Integer[0], result, "The result should be an empty array");
    }

    @Test
    public void testFilterWithIntegerArrayForEvenNumbers() {
        Integer[] array = {1, 2, 3, 4, 5, 6};
        Integer[] result = Sequence.filter(array, number -> number % 2 == 0);
        assertArrayEquals(new Integer[]{2, 4, 6}, result, "Should return only even numbers");
    }

    @Test
    public void testFilterWithDoubleArrayForNumbersGreaterThan() {
        Double[] array = {1.1, 2.2, 3.3, 4.4};
        Double[] result = Sequence.filter(array, number -> number > 2.5);
        assertArrayEquals(new Double[]{3.3, 4.4}, result, "Should return numbers greater than 2.5");
    }
}
