package utils;

public class DataParser {

    // Функция для парсинга строки в целое число
    public static int parseCount(String value) throws IllegalArgumentException {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Невалидное значение");
        }
    }

    // Функция для валидации и парсинга строки в целое число
    public static Integer validateCount(String value) {
        try {
            return parseCount(value);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    // Функция для парсинга строки в число с плавающей точкой
    public static double parseNumber(String value) throws IllegalArgumentException {
        try {
            return Double.parseDouble(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Невалидное значение");
        }
    }

    // Функция для валидации и парсинга строки в число с плавающей точкой
    public static Double validateNumber(String value) {
        try {
            return parseNumber(value);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
