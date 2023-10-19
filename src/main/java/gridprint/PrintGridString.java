package gridprint;

import java.util.Scanner;

/**
 * Напишите программу на Java для
 * печати сетки из заданных элементов
 */

public class PrintGridString {
    public static void main(String[] args) {
        Scanner numberAndString = new Scanner(System.in);
        System.out.print("Введите число строк и столбцов сетки: ");
        int rowsAndColumns = numberAndString.nextInt();
        System.out.print("Введите повторяемый элемент сетки: ");
        String element = numberAndString.next();
        numberAndString.close();
        printGrid(rowsAndColumns, element);
    }

    public static void printGrid(int rowsAndColumns, String element) {
        for (int i = 0; i < rowsAndColumns; i++) {
            for (int j = 0; j < rowsAndColumns; j++) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}
