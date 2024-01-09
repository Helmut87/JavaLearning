import java.util.Arrays;

public class Sequence {
    public static int[] filter(int[] array, ByCondition condition) {
        int count = 0;
        for (int num : array) {
            if (condition.isOk(num)) {
                count++;
            }
        }

        int[] result = new int[count];
        int index = 0;

        for (int num : array) {
            if (condition.isOk(num)) {
                result[index++] = num;
            }
        }

        return result;
    }
}
