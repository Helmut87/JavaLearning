package operations;

import java.util.Scanner;

/**
 * Напишите программу на Java, которая принимает два целых числа от пользователя,
 * а затем печатает сумму, разницу, произведение, среднее значение, расстояние (разница между целыми числами),
 * максимум (большее издвух целых чисел), минимум (меньшее из двух целых чисел)
 */

public class NumberOperations {
    public static void main(String[] args) {
        Scanner number = new Scanner(System.in);
        System.out.print("Введите первое целое число: ");
        int getFirstNumber = number.nextInt();
        System.out.print("Введите второе целое число: ");
        int getSecondNumber = number.nextInt();
        number.close();
        System.out.println(getSum(getFirstNumber, getSecondNumber));
        System.out.println(getDifference(getFirstNumber, getSecondNumber));
        System.out.println(getProduct(getFirstNumber, getSecondNumber));
        System.out.println(getAverage(getFirstNumber, getSecondNumber));
        System.out.println(getDistance(getFirstNumber, getSecondNumber));
        System.out.println(getMaxNumber(getFirstNumber, getSecondNumber));
        System.out.println(getMinNumber(getFirstNumber, getSecondNumber));
    }

    private static int getSum(int firstNum, int secondNum) {
        System.out.print("Сумма двух целых чисел: ");
        return firstNum + secondNum;
    }

    private static int getDifference(int firstNum, int secondNum) {
        System.out.print("Разница двух целых чисел: ");
        return firstNum - secondNum;
    }

    private static int getProduct(int firstNum, int secondNum) {
        System.out.print("Произведение из двух целых чисел: ");
        return firstNum * secondNum;
    }

    private static int getAverage(int firstNum, int secondNum) {
        System.out.print("Среднее из двух целых чисел: ");
        return (firstNum + secondNum) / 2;
    }

    private static int getDistance(int firstNum, int secondNum) {
        System.out.print("Расстояние между двух целых чисел: ");
        return Math.abs(firstNum - secondNum);
    }

    private static int getMaxNumber(int firstNum, int secondNum) {
        System.out.print("Максимальное целое число: ");
        return Math.max(firstNum, secondNum);
    }
    private static int getMinNumber(int firstNum, int secondNum) {
        System.out.print("Минимальное целое число: ");
        return Math.min(firstNum, secondNum);
    }
}
