package generaterandomnum;

/**
 * Составить программу вывода на экран
 * в одну строку четырех любых чисел
 * с тремя пробелами между ними
 * <p>
 * В данной реализации используем класс Math
 */

public class GenerateFourRandomNumbersWithThreeSpacesBetweenIt {
    public static void main(String[] args) {
        for (int i = 0; i <= 3; i++) {
            int a = (int) (Math.random() * 99);
            System.out.print(a + "   ");
        }
    }
}
