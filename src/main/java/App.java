import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        // Проверка на четность элемента
        ByCondition evenCondition = number -> number % 2 == 0;
        int[] evenResult = Sequence.filter(array, evenCondition);
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
        int[] digitSumEvenResult = Sequence.filter(array, digitSumEvenCondition);
        System.out.println("Элементы, у которых сумма цифр четна: " + Arrays.toString(digitSumEvenResult));
    }
}
