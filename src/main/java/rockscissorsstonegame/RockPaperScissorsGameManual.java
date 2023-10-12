package rockscissorsstonegame;

import java.util.Random;
import java.util.Scanner;

/**
 * Вася и Петя играют в игру “Камень,ножницы,бумага”.
 * Каждый из них показывает свою фигуру
 * камень - 0,ножницы - 1,бумага - 2.
 * Программа определяет, кто из них выиграл.
 * Выбор каждого участника формируется случайным образом.
 * <p>
 * В данной реализации мы играем с компьютером
 */

public class RockPaperScissorsGameManual {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Выберите ваш предмет:");
        System.out.println("0 - Камень");
        System.out.println("1 - Бумага");
        System.out.println("2 - Ножницы");
        int userChoice = scanner.nextInt();
        int computerChoice = random.nextInt(3);
        System.out.println("Ваш выбор: " + userChoice);
        System.out.println("Выбор компьютера: " + computerChoice);

        if (userChoice == computerChoice) {
            System.out.println("Ничья!");
        } else if ((userChoice == 0 && computerChoice == 2) || (userChoice == 1 && computerChoice == 0) || (userChoice == 2 && computerChoice == 1)) {
            System.out.println("Вы победили!");
        } else {
            System.out.println("Компьютер победил!");
        }
        scanner.close();
    }
}
