package standartlib;

import com.github.javafaker.Faker;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;
import java.util.Scanner;

/**
 * Доработать класс Телевизор:
 * 1. В класс Телевизор добавить поля (если не были добавлены ранее):
 * 1) Номер включенного канала — integer;
 * 2) Громкость звука — integer (от 0 до 100);
 * 3) Признак включенного телевизора — boolean.
 * 2. Переопределить метод toString класса Телевизор таким образом, чтобы распечатывались:
 * название класса, все поля класса и их значения.
 * 3. Добавить в класс Телевизор методы equals и hashcode.
 * На вход программы в классе App, методе main подается информация о телевизорах в количестве 10 телевизоров.
 * Считать данные в массив объектов(можно выполнить считывание данных в цикле).
 * В каждом из 10 экземпляров класса должны быть заполнены следующие поля:
 * a. Как минимум, 1 поле по выбору, добавленное студентом в задании 3;
 * b. Номер включенного канала - целое число,
 * c. Громкость звука - целое число;
 * d. Признак включен ли телевизор.
 * Считать с клавиатуры число допустимого значения громкости звука maxVolume (рекомендуется ввести с клавиатуры целое число от 50 до 70).
 * Далее необходимо в цикле вывести только включенные телевизоры, укоторых звук является допустимым (меньшим или равным maxVolume).
 * Дополнительно. Добавить в массив Телевизоров сортировку по номеру канала (по возрастанию).
 */

public class App {
    public static void main(String[] args) {
        Television[] televisions = new Television[10];
        Scanner scanner = new Scanner(System.in);
        Locale locale = new Locale("ru_RU");
        Faker generateRndValue = new Faker(locale);
        for (int i = 0; i < televisions.length; i++) {
            String brand = generateRndValue.company().name();
            int yearOfProduction = generateRndValue.number().numberBetween(1970, 2023);
            int screenSize = generateRndValue.number().numberBetween(20, 50);
            boolean isSmartTV = generateRndValue.bool().bool();
            boolean isTVon = generateRndValue.bool().bool();
            int channelNumber = generateRndValue.number().numberBetween(1, 100);
            int volumeLevel = generateRndValue.number().numberBetween(0, 100);

            televisions[i] = new Television(brand, yearOfProduction, screenSize, isSmartTV, isTVon, channelNumber, volumeLevel);
        }

        System.out.print("Введите максимально допустимую громкость: ");
        int maxVolume = Integer.parseInt(scanner.nextLine());
        scanner.close();

        System.out.println("Включенные телевизоры с громкостью, не превышающей " + maxVolume + ":");
        for (Television television : televisions) {
            if (television.getTVon() && television.getVolumeLevel() <= maxVolume) {
                System.out.println(television);
            }
        }

        Arrays.sort(televisions, Comparator.comparingInt(Television::getChannelNumber));
        System.out.println("Сортировка телевизоров по номеру канала (по возрастанию):");
        for (Television television : televisions) {
            System.out.println(television);
        }
    }
}