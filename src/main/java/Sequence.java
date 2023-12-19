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

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        // Проверка на четность элемента
        ByCondition evenCondition = number -> number % 2 == 0;
        int[] evenResult = filter(array, evenCondition);
        System.out.println("Элементы, у которых четные значения: " + Arrays.toString(evenResult));

        // Проверка, является ли сумма цифр элемента четным числом
        ByCondition digitSumEvenCondition = number -> {
            int sum = 0;
            while (number > 0) {
                sum += number % 10;
                number /= 10;
            }
            return sum % 2 == 0;
        };
        int[] digitSumEvenResult = filter(array, digitSumEvenCondition);
        System.out.println("Элементы, у которых сумма цифр четна: " + Arrays.toString(digitSumEvenResult));
    }
}
