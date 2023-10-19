package covert;

import java.util.Scanner;

/**
 * Напишите Java-программу для преобразования
 * температуры из Фаренгейта в градусы Цельсия.
 */

public class CelsiusToFahrenheit {
    public static void main(String[] args) {
        Scanner temperature = new Scanner(System.in);
        System.out.print("Введите температуру в градусах Фаренгейта: ");
        double getTemperature = temperature.nextDouble();
        temperature.close();
        double temperatureResult = (getTemperature - 32) / 1.8;
        System.out.format("Температура в градусах Цельсия: %.1f",temperatureResult);
    }
}
