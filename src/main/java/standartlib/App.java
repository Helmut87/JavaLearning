package standartlib;

import java.util.Scanner;

/**
 * 1. Создан класс  Телевизор;
 * 2. У класса  есть   поля,  свойства и методы. Поля  желательно  сделать private. Задать новые значения полям класса можно через конструктор и setters.
 * 3. В классе переопределен метод toString.
 * 4. Создан класс  App с методом main.
 * 5. В методе  main класса App создано несколько экземпляров классаТелевизор и проверено, как распечатываются заполненные данные обэкземплярах класса.
 * 6. Дополнительно. Задавать параметры класса Телевизор с клавиатурыили случайным числом.
 */

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Television tv1 = new Television("Sony", 1988, 55, true);
        Television tv2 = new Television("Samsung", 1812, 65, false);

        System.out.println("Телевизор 1: " + tv1);
        System.out.println("Телевизор 2: " + tv2);

        System.out.println("Введите новое наименование для телевизора 1: ");
        String brand1 = scanner.nextLine();
        System.out.println("Введите новый год сборки для телевизора 1: ");
        int yearOfProduction1 = scanner.nextInt();
        System.out.println("Введите новый размер экрана для телевизора 1: ");
        int screenSize1 = scanner.nextInt();
        System.out.println("На телевизоре установлено smartTV? (true/false): ");
        boolean isSmart1 = scanner.nextBoolean();

        tv1.setBrand(brand1);
        tv1.setYearOfProduction(yearOfProduction1);
        tv1.setScreenSize(screenSize1);
        tv1.setSmartTV(isSmart1);

        System.out.println("Обновленные параметры для телевизора 1: " + tv1);

        scanner.close();
    }
}