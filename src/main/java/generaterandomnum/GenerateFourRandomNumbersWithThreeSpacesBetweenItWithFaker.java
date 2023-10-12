package generaterandomnum;

import com.github.javafaker.Faker;

/**
 * Составить программу вывода на экран
 * в одну строку четырех любых чисел
 * с тремя пробелами между ними
 * <p>
 * В данной реализации используем бибилиотеку Faker
 */

public class GenerateFourRandomNumbersWithThreeSpacesBetweenItWithFaker {
    public static void main(String[] args) {
        Faker generateRndNum = new Faker();
        String spaces = "   ";
        for (int i = 0; i <= 3; i++) {
            int a = generateRndNum.number().numberBetween(0, 9999);
            System.out.print(a + spaces);
        }
    }
}
