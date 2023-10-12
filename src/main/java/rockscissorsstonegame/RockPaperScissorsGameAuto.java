package rockscissorsstonegame;

import java.util.Random;

/**
 * Вася и Петя играют в игру “Камень,ножницы,бумага”.
 * Каждый из них показывает свою фигуру
 * камень - 0,ножницы - 1,бумага - 2.
 * Программа определяет, кто из них выиграл.
 * Выбор каждого участника формируется случайным образом.
 * <p>
 * В данной реализации мы играем с компьютером
 */

public class RockPaperScissorsGameAuto {
    public static void main(String[] args) {
        Random random = new Random();
        int firstPlayerChoice = random.nextInt(3);
        int secondPlayerChoice = random.nextInt(3);
        System.out.println("Выбор первого игрока: " + firstPlayerChoice);
        System.out.println("Выбор второго игрока: " + secondPlayerChoice);

        if (firstPlayerChoice == secondPlayerChoice) {
            System.out.println("Ничья!");
        } else if ((firstPlayerChoice == 0 && secondPlayerChoice == 2) || (firstPlayerChoice == 1 && secondPlayerChoice == 0) || (firstPlayerChoice == 2 && secondPlayerChoice == 1)) {
            System.out.println("Победил первый игрок!");
        } else {
            System.out.println("Победил второй игрок!");
        }
    }
}
