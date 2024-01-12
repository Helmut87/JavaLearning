import utils.ByCondition;

import java.util.Arrays;

public class Sequence {
    // Обобщенный метод для работы с Integer
    public static Integer[] filter(Integer[] array, ByCondition<Integer> condition) {
        return filterGeneric(array, condition);
    }

    // Обобщенный метод для работы с Double
    public static Double[] filter(Double[] array, ByCondition<Double> condition) {
        return filterGeneric(array, condition);
    }

    // Обобщенный метод для работы с массивами любого числового типа
    private static <T extends Number> T[] filterGeneric(T[] array, ByCondition<T> condition) {
        int count = 0;
        for (T num : array) {
            if (condition.isOk(num)) {
                count++;
            }
        }

        T[] result = Arrays.copyOf(array, count);
        int index = 0;

        for (T num : array) {
            if (condition.isOk(num)) {
                result[index++] = num;
            }
        }

        return result;
    }
}
