package stringconcat;

import java.util.Scanner;

/**
 * Напишите Java-программу для объединения данной строки с
 * самим собой заданное количество раз
 */

public class StringConcatenation {
    private static final String BASE_STRING = "Java";

    public static void main(String[] args) {
        Scanner repeatCounter = new Scanner(System.in);
        System.out.print("Сколько раз вывести строку? ");
        int counter = repeatCounter.nextInt();
        repeatCounter.close();
        for (int i = 0; i < counter; i++) {
            System.out.print(BASE_STRING);
        }
    }

}
