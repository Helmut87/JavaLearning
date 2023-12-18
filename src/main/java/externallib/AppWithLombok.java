package externallib;
import com.github.javafaker.Faker;
import standartlib.Television;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;
import java.util.Scanner;

public class AppWithLombok {
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

        // Сортировка по номеру канала
        Arrays.sort(televisions, Comparator.comparingInt(Television::getChannelNumber));
        System.out.println("Сортировка телевизоров по номеру канала (по возрастанию):");
        for (Television television : televisions) {
            System.out.println(television);
        }
    }
}