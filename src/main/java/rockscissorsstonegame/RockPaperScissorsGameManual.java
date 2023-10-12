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

        int userChoice = getUserChoice(scanner);
        int computerChoice = random.nextInt(3);

        printChoices(userChoice, computerChoice);
        determineWinner(userChoice, computerChoice);

        scanner.close();
    }

    private static int getUserChoice(Scanner scanner) {
        int choice = -1;
        do {
            System.out.println("Выберите ваш предмет:");
            System.out.println("0 - Камень");
            System.out.println("1 - Бумага");
            System.out.println("2 - Ножницы");
            try {
                choice = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Вы ввели некорректное значение");
                scanner.nextLine(); // Consume invalid input
            }
        } while (choice < 0 || choice > 2);
        return choice;
    }

    private static void printChoices(int userChoice, int computerChoice) {
        System.out.println("Ваш выбор: " + userChoice);
        System.out.println("Выбор компьютера: " + computerChoice);
    }

    private static void determineWinner(int userChoice, int computerChoice) {
        if (userChoice == computerChoice) {
            System.out.println("Ничья!");
        } else {
            switch (userChoice) {
                case 0:
                    if (computerChoice == 2) {
                        System.out.println("Вы победили!");
                    } else {
                        System.out.println("Компьютер победил!");
                    }
                    break;
                case 1:
                    if (computerChoice == 0) {
                        System.out.println("Вы победили!");
                    } else {
                        System.out.println("Компьютер победил!");
                    }
                    break;
                case 2:
                    if (computerChoice == 1) {
                        System.out.println("Вы победили!");
                    } else {
                        System.out.println("Компьютер победил!");
                    }
                    break;
            }
        }
    }
}
